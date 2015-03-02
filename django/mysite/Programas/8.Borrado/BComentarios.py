import sys
from pueblos.models import Comentarios
from pueblos.models import Denuncias_C

def Borrarcomentario(tupla):
	c = Comentarios.objects.filter(id = tupla)
	c.delete()
	d = Denuncias_C.objects.filter(comentario_id__id = tupla)
	d.delete()
	print "comentario borrado"

	
def run():
	denuncias = {}
	votos = Denuncias_C.objects.all();
	for i in votos:
		id_comentario = i.comentario_id
		try:
			denuncias[id_comentario] = denuncias[id_comentario]+1
		except:
			denuncias[id_comentario] = 1

	denuncias = denuncias.items()
	denuncias.sort()
	fin =  False
	i = 0
	while fin == False:
		if denuncias[i][1] < 10:
			fin = True
		else:
			Borrarcomentario(denuncias[i][0])
		i=i+1
		if i >= len(denuncias):
			fin = True

