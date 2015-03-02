from subprocess import Popen, PIPE, STDOUT
import re
from pueblos.models import Noticias
from pueblos.models import Categoria
from pueblos.models import Classify
from pueblos.models import NC
from pueblos.models import Usuario
from pueblos.models import Status
from pueblos.models import Categorias_semandal
from pueblos.models import Reglas_Ontologia
from os import listdir


def aplicar_ontologia(noti, cat_inicio, usuario):
	abiertos = []
	cerrados = []
	abiertos.append(cat_inicio.etiqueta_padre)
	while len(abiertos) != 0:
		nodo = abiertos.pop(0)
		if nodo not in cerrados:
			try:
				Classify.objects.get(id_n=noti, id_user = usuario, c_new=nodo)
			except Classify.DoesNotExist:
				nueva_cat = Classify(id_n = noti, id_user = usuario, c_new = nodo)
				nueva_cat.save()
			rows = Reglas_Ontologia.objects.filter(etiqueta = nodo)
			for row in rows:
				abiertos.append(row.subcategoria_de)
			cerrados.append(nodo)
		try:
			nodo = abiertos[0]
		except:
			nodo = None
	return cerrados
def cargar_prohibidas():
	palabras = open("./Programas/9.Clasificador/Ficheros palabras/spanishSmartmod2.txt",'r')
	linea = palabras.readline()
	palabras_prohibidas = []
	while linea != "":
		palabras_prohibidas.append(linea.split()[0])
		linea = palabras.readline()
	palabras_prohibidas.append("test")
	return palabras_prohibidas


def hasNumbers(inputString):
	return any(char.isdigit() for char in inputString)


def limpiar_str(lp, noticia):
	noticia = noticia.lower()
	noticia = re.sub('[()?!;,.:-_\"\']', '', noticia)
	palabras = noticia.split(" ")
	lista_aux = []
	for element in palabras:
		aux = re.split("\s", element)
		for e in aux:
			if e.isalpha() and len(e) > 3:
				lista_aux.append(e)
	palabras = lista_aux
	for element in lp:
		while element in palabras:
  			palabras.remove(element)
	numeros = []
	if '\xc2\xa0' in palabras:
		palabras.remove('\xc2\xa0')
	return palabras

def run():
	filename = "./Programas/9.Clasificador/temp"
	allFiles = listdir("./Programas/9.Clasificador/")
	fich_reglas = []
	for module in allFiles:
		if ".clp" in module:
			fich_reglas.append(module)
	lista_prohibidas = cargar_prohibidas()
	cur = NC.objects.filter(categoria_id = 53)
	print "Recuperando noticias"
	
	status = Status.objects.get(id = 1)
	for row in cur:
		etiquetas = []
		Noti = Noticias.objects.get(id = row.noticia.id)
		if Noti.dscuerpo is not None:
			#print Noti.dstitular
			if len(Noti.dscuerpo) > 100:
				print "Creando fichero"
				f = open(filename,'w')
				for e in list(set(limpiar_str(lista_prohibidas, Noti.dscuerpo.replace('-', ' ')))):
					f.write(e.encode("utf-8")+"\n")
				f.close()
				print "Determinando categoria"
				for regla in fich_reglas:
					user = Usuario.objects.filter(dsusuario = "System_"+regla)
					print regla
					p = Popen(['java', '-jar', './Programas/9.Clasificador/clasificador.jar',  regla, filename], stdout=PIPE, stderr=STDOUT)
					for line in p.stdout:
						element_aux = "".join(line[9:].split())
						if "RSS" not in element_aux:
							print element_aux
							newCat = Categoria.objects.filter(etiqueta = element_aux.lower())
							etiquetas += aplicar_ontologia(Noti, newCat[0],user[0])
							# nueva_cat = Classify(id_n = Noti, id_user = user[0], c_new = newCat[0].etiqueta_padre)
							# nueva_cat.save()
				lista = list(set(etiquetas))
				for element in lista:
					nueva_nc = NC(noticia = Noti, categoria = element, confirmada = status)
					nueva_nc.save()	
		row.delete()
		print "OK!!"


if __name__ == "__main__":	
	print "Inicializando..."
	run()
	print "Hecho"
