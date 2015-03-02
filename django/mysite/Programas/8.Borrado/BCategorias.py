import sys
from pueblos.models import NC
from pueblos.models import Votaciones

def Borrarcategoria(tupla):
	v = Votaciones.objects.filter(id_n = tupla[0],categoria=tupla[1])
	v.delete()
	noticias = NC.objects.filter(noticia = tupla[0],categoria=tupla[1])
	print len(noticias)
	noticias.delete()
	n_noticias = NC.objects.filter(noticia = tupla[0])
	print len(n_noticias)
	if len(n_noticias) == 0:
		c=Categorias_semandal.objects.filter(id=53)[0]
		nueva = NC(noticia=tupla[0],categoria=c,confirmada=Status.objects.filter(id=1)[0])
		nueva.save()

def run():
	noticias = {}
	votos = Votaciones.objects.all();
	for i in votos:
		tupla = (i.id_n,i.categoria)
		try:
			noticias[tupla] = noticias[tupla]+1
		except:
			noticias[tupla] = 1

	noticias = noticias.items()
	noticias.sort()
	noticias.reverse()
	fin =  False
	i = 0
	while fin == False:
		if noticias[i][1] < 10:
			fin = True
		else:
			Borrarcategoria(noticias[i][0])
		i=i+1
		if i >= len(noticias):
			fin = True

