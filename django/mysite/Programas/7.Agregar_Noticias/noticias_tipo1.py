import re
import urllib2
from pueblos.models import Categoria
from pueblos.models import Noticias
from bs4 import BeautifulSoup
from datetime import date
import noticias_tipo4
import modifica_string
def get_noticia(url):
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return None
	soup = BeautifulSoup(respuesta)
	noticias = soup.body.find_all('div', attrs={'class' : 'noticias'})	
	if len(noticias) != 0:
		return modifica_string.elimina_comentarios(noticias[0].text)
	else:
		return None
def extraer(url, nivel, pueblo_id):
	""" 
		Extractor de noticias tipo 1
		Hay dos posibilidades
		Las noticias estan en listas desordenadas <ul>, esta lista tiene como atributo class "noticias"
		Las noticias estan en un div de class content-noticias group"""
	p = url.split('/')
	categoria = p[-2]
	cat = Categoria.objects.filter(etiqueta = categoria)
	if cat is None:
		cat = Categoria.objects.filter(etiqueta = "sin_categoria")
	href= ""
	l = len(p)
	for y in range(3,l-1):
		href += '/' + p[y]
	href = href + '/'	
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return []
	soup = BeautifulSoup(respuesta)
	if soup.body is None:
		return []
	ahref = soup.body.find_all('a')
	paginador = soup.body.find_all('p', attrs={'class' : 'paginador'})
	if len(paginador) != 0: 
		if paginador[0].getText() is 'Mostrando 0 noticias':
			return []
	x = soup.body.find_all('ul', attrs={'class' : 'noticias'})
	if len(x) != 0:
		lis = x[0].find_all('li')
		for element in lis:
			fecha = None
			titular = None
			enlace = None
			cuerpo = None
			dia = element.find('p')
			if dia is not None:
				fecha = dia.getText()
				fecha = fecha[1:]
				fecha = fecha[:-1]
			else:
				nfecha = element.getText()
				fecha = re.findall("\[(.*?)\]", nfecha)
				fecha = fecha[0]
			titu = element.find('a')
			if titu is not None:
				titular = titu.text
				titular = modifica_string.elimina_blancos(titular)
				titular = titular.replace("\n", "-")
				partes = url.split('/')
				U = partes[0]+'//'+partes[2]
				enlace = U + titu.get('href')
			c = element.find('span')
			if c is not None:
				cuerpo = c.text
				cuerpo = modifica_string.elimina_blancos(cuerpo)
				cuerpo = cuerpo.replace("\n", "-")
			texto_noticia = get_noticia(enlace)
			if texto_noticia == "":
				texto_noticia = None
			texto_noticia = modifica_string.elimina_blancos(texto_noticia)
			texto_noticia = texto_noticia.replace("\n", "-")
			fecha = fecha.split("/")
			dia = date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
			p = Noticias(dstitular = titular, dscuerpo = texto_noticia, resumen = cuerpo, url = enlace, etiqueta = cat[0], fecha = dia, pueblo_id = pueblo_id)
			p.save()
		if len(lis) != 0:
			digitos = len(str(nivel))
			nivel = nivel + 10
			if nivel == 10:
				url2 = url + "index.jsp?no=" + str(nivel)
			else:
				url2 = url[:-digitos]
				url2 = url2 + str(nivel)
			extraer(url2,nivel, pueblo_id)
	else:
		noticias_tipo4.extraer(url, nivel, pueblo_id)
