import sys
sys.path.insert(0, 'C:/Users/Administrador/Desktop/django/mysite/Programas/10.Update_Noticias/')
import localizador
import noticias_content
import noticias_tipo1
import noticias_tipo2
import noticias_tipo5
import noticias_tipo6
import noticias_tipo7
import urllib2
import time
from pueblos.models import Noticias
from pueblos.models import Pueblo
from pueblos.models import Categoria
from pueblos.models import Categorias_semandal
from pueblos.models import NC
from pueblos.models import Status
from pueblos.models import log_update
from pueblos.models import log_update_web
from pueblos.models import Reglas_Ontologia
import datetime

def aplicar_ontologia(noti, cat_inicio, status):
	abiertos = []
	cerrados = []
	abiertos.append(cat_inicio.etiqueta_padre)
	while len(abiertos) != 0:
		nodo = abiertos.pop(0)
		if nodo not in cerrados:
			try:
				NC.objects.get(noticia=noti, categoria=nodo)
			except NC.DoesNotExist:
				n = NC(noticia = noti, categoria = nodo, confirmada = status)
				n.save()
			rows = Reglas_Ontologia.objects.filter(etiqueta = nodo)
			for row in rows:
				abiertos.append(row.subcategoria_de)
			cerrados.append(nodo)
		try:
			nodo = abiertos[0]
		except:
			nodo = None
def extraer(url, p_id):
	
	"""
	Funcion que determina el tipo de noticia que se debe extraer
	"""
	
	status = Status.objects.get(id = 1)
	if "content" in url:
		lista = localizador.get_content(url[:-26])
		for element2 in lista:
			url2 = url[:-26] + "content/noticias_list_xmlpage.html?target=" + element2
			print url2
			lista_noticias = noticias_content.extraer(url2, 1, p_id)
			lista_noticias.reverse()
			for element in lista_noticias:
				existe = Noticias.objects.filter(url = element['url'])
				if existe is not None:
					if not existe.exists():
						p = Noticias(dstitular = element['dstitular'], dscuerpo = element['dscuerpo'], resumen = element['resumen'], url = element['url'], fecha = element['fecha'], pueblo_id = element['pueblo_id'], fecha_ins = datetime.datetime.now())
						p.save()
						aplicar_ontologia(p, element['etiqueta'], status)
						# n = NC(noticia = p, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
						# n.save()
					else:
						existe_cat = NC.objects.filter(noticia = existe, categoria = element['etiqueta'].etiqueta_padre)
						if existe_cat is not None:
							if not existe_cat.exists():
								noti = Noticias.objects.get(url = element['url'])
								aplicar_ontologia(noti, element['etiqueta'], status)
								# n = NC(noticia = noti, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
								# n.save()
			print "OK! "+"("+str(lista.index(element2) + 1)+"/"+str(len(lista))+")"
		return
	if "actualidad" in url:
		if "noticias" in url:
			if "index.jsp" in url:
				lista = localizador.get_directorios(url)
				if len(lista) == 0:
					lista_noticias = noticias_tipo2.extraer(url[:-18], 1,p_id)
					lista_noticias.reverse()
					for element in lista_noticias:
						existe = Noticias.objects.filter(url = element['url'])
						if existe is not None:
							if not existe.exists():
								p = Noticias(dstitular = element['dstitular'], dscuerpo = element['dscuerpo'], resumen = element['resumen'], url = element['url'], fecha = element['fecha'], pueblo_id = element['pueblo_id'], fecha_ins = datetime.datetime.now())
								p.save()
								aplicar_ontologia(p, element['etiqueta'], status)
								# n = NC(noticia = p, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
								# n.save()
							else:
								existe_cat = NC.objects.filter(noticia = existe, categoria = element['etiqueta'].etiqueta_padre)
								if existe_cat is not None:
									if not existe_cat.exists():
										noti = Noticias.objects.get(url = element['url'])
										aplicar_ontologia(noti, element['etiqueta'], status)
										# n = NC(noticia = noti, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
										# n.save()
					return
				else:
					for element2 in lista:
						url2 = url[:-9] + element2 + '/'
						lista_noticias = noticias_tipo1.extraer(url2, 1,p_id)
						lista_noticias.reverse()
						for element in lista_noticias:
							existe = Noticias.objects.filter(url = element['url'])
							if existe is not None:
								if not existe.exists():
									p = Noticias(dstitular = element['dstitular'], dscuerpo = element['dscuerpo'], resumen = element['resumen'], url = element['url'], fecha = element['fecha'], pueblo_id = element['pueblo_id'], fecha_ins = datetime.datetime.now())
									p.save()
									aplicar_ontologia(p, element['etiqueta'], status)
									# n = NC(noticia = p, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
									# n.save()
								else:
									existe_cat = NC.objects.filter(noticia = existe, categoria = element['etiqueta'].etiqueta_padre)
									if existe_cat is not None:
										if not existe_cat.exists():
											noti = Noticias.objects.get(url = element['url'])
											aplicar_ontologia(noti, element['etiqueta'], status)
											# n = NC(noticia = noti, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
											# n.save()
					return
			else:
				lista_noticias = noticias_tipo5.extraer(url, 1,p_id)
				lista_noticias.reverse()
				for element in lista_noticias:
					existe = Noticias.objects.filter(url = element['url'])
					if existe is not None:
						if not existe.exists():
							p = Noticias(dstitular = element['dstitular'], dscuerpo = element['dscuerpo'], resumen = element['resumen'], url = element['url'], fecha = element['fecha'], pueblo_id = element['pueblo_id'], fecha_ins = datetime.datetime.now())
							p.save()
							aplicar_ontologia(p, element['etiqueta'], status)
							# n = NC(noticia = p, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
							# n.save()
						else:
							existe_cat = NC.objects.filter(noticia = existe, categoria = element['etiqueta'].etiqueta_padre)
							if existe_cat is not None:
								if not existe_cat.exists():
									noti = Noticias.objects.get(url = element['url'])
									aplicar_ontologia(noti, element['etiqueta'], status)
									# n = NC(noticia = noti, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
									# n.save()
				return
		else:
			lista = localizador.get_directorios(url)
			for element2 in lista:
				url2 = url + element2 + '/'
				lista_noticias = noticias_tipo1.extraer(url2, 0, p_id)
				lista_noticias.reverse()
				for element in lista_noticias:
					existe = Noticias.objects.filter(url = element['url'])
					if existe is not None:
						if not existe.exists():
							p = Noticias(dstitular = element['dstitular'], dscuerpo = element['dscuerpo'], resumen = element['resumen'], url = element['url'], fecha = element['fecha'], pueblo_id = element['pueblo_id'], fecha_ins = datetime.datetime.now())
							p.save()
							aplicar_ontologia(p, element['etiqueta'], status)
							# n = NC(noticia = p, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
							# n.save()
						else:
							existe_cat = NC.objects.filter(noticia = existe, categoria = element['etiqueta'].etiqueta_padre)
							if existe_cat is not None:
								if not existe_cat.exists():
									noti = Noticias.objects.get(url = element['url'])
									aplicar_ontologia(noti, element['etiqueta'], status)
									# n = NC(noticia = noti, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
									# n.save()
			return
	if "noticias" in url:
		lista_noticias = noticias_tipo5.extraer(url, 1, p_id)
		lista_noticias.reverse()
		for element in lista_noticias:
			existe = Noticias.objects.filter(url = element['url'])
			if existe is not None:
				if not existe.exists():
					p = Noticias(dstitular = element['dstitular'], dscuerpo = element['dscuerpo'], resumen = element['resumen'], url = element['url'], fecha = element['fecha'], pueblo_id = element['pueblo_id'], fecha_ins = datetime.datetime.now())
					p.save()
					aplicar_ontologia(p, element['etiqueta'], status)
					# n = NC(noticia = p, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
					# n.save()
				else:
					existe_cat = NC.objects.filter(noticia = existe, categoria = element['etiqueta'].etiqueta_padre)
					if existe_cat is not None:
						if not existe_cat.exists():
							noti = Noticias.objects.get(url = element['url'])
							aplicar_ontologia(noti, element['etiqueta'], status)
							# n = NC(noticia = noti, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
							# n.save()
		return
	if "noticias.html?general=true" in url:
		lista_noticias = noticias_tipo6.extraer(url, 1, p_id)
		lista_noticias.reverse()
		for element in lista_noticias:
			existe = Noticias.objects.filter(url = element['url'])
			if existe is not None:
				if not existe.exists():
					p = Noticias(dstitular = element['dstitular'], dscuerpo = element['dscuerpo'], resumen = element['resumen'], url = element['url'], fecha = element['fecha'], pueblo_id = element['pueblo_id'], fecha_ins = datetime.datetime.now())
					p.save()
					aplicar_ontologia(p, element['etiqueta'], status)
					# n = NC(noticia = p, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
					# n.save()
				else:
					existe_cat = NC.objects.filter(noticia = existe, categoria = element['etiqueta'].etiqueta_padre)
					if existe_cat is not None:
						if not existe_cat.exists():
							noti = Noticias.objects.get(url = element['url'])
							aplicar_ontologia(noti, element['etiqueta'], status)
							# n = NC(noticia = noti, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
							# n.save()
		return
	if "home.jsp" in url:
		lista_noticias = noticias_tipo7.extraer(url, 1, p_id)
		lista_noticias.reverse()
		for element in lista_noticias:
			existe = Noticias.objects.filter(url = element['url'])
			if existe is not None:
				if not existe.exists():
					p = Noticias(dstitular = element['dstitular'], dscuerpo = element['dscuerpo'], resumen = element['resumen'], url = element['url'], fecha = element['fecha'], pueblo_id = element['pueblo_id'], fecha_ins = datetime.datetime.now())
					p.save()
					aplicar_ontologia(p, element['etiqueta'], status)
					# n = NC(noticia = p, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
					# n.save()
				else:
					existe_cat = NC.objects.filter(noticia = existe, categoria = element['etiqueta'].etiqueta_padre)
					if existe_cat is not None:
						if not existe_cat.exists():
							noti = Noticias.objects.get(url = element['url'])
							aplicar_ontologia(noti, element['etiqueta'], status)
							# n = NC(noticia = noti, categoria = element['etiqueta'].etiqueta_padre, confirmada = status)
							# n.save()
		return

def run():
	print "Empezamos!"
	log = log_update(fecha_update = datetime.datetime.now())
	log.save()
	provincias = ["4","11","14","18","21","23","29","41"]
	#provincias = ["4","14","18","21","23","29","41"]
	#provincias = ["41"]
	for p in provincias:
		print "Provincia "+str(p)
		cur = Pueblo.objects.filter(provincia_id = p, opencms = 1)
		#cur = Pueblo.objects.filter(id = 6164, opencms = 1)
		for row in cur: 
			try:
				lw = log_update_web.objects.get(municipio = row)
			except log_update_web.DoesNotExist:
				lw = log_update_web(update = log, municipio = row)
				lw.save()
			else:
				lw.update = log
				lw.resultado = 0
				lw.save()
			print "Fila "+row.url
			if row.url != '' and "trebujena" not in row.url and "cambil" not in row.url:
				extraer(localizador.getURLNoticias(row.url), row.id)
			lw.resultado = 1
			lw.save()
	print "FIN!"

