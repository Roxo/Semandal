#!/usr/bin/env python
# Este archivo usa el encoding: utf-8
import urllib2
from pueblos.models import Categoria
from pueblos.models import Noticias
from bs4 import BeautifulSoup
from datetime import date
import modifica_string
import unicodedata
import sys
reload(sys)
sys.setdefaultencoding("utf-8")
def get_noticia(url):
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return None
	soup = BeautifulSoup(respuesta)
	noticias = soup.body.find_all('div', attrs={'id' : 'contenido'})
	if len(noticias) != 0:
		return modifica_string.elimina_comentarios(noticias[0].text)
	else:
		return None

def extraer(url, nivel, pueblo_id):
	""" 
		Extractor de noticias tipo 5
		Las noticias estan en un div de class listado noticias
	"""
	try:
		respuesta = urllib2.urlopen(url).read()
	except:
		return []
	print url
	soup = BeautifulSoup(respuesta, from_encoding="latin-1")
	if soup.body is None:
		return []
	lista_completa = []	
	if nivel == 0:
		nivel = 1
	noticias = soup.find_all('div', attrs={'class' : 'noticias'})	
	if len(noticias) == 0:
		return []
	cat = Categoria.objects.filter(etiqueta__exact = "sin_categoria")
	for element in noticias:
		fecha = None
		titular = None
		enlace = None
		cuerpo = None
		parrafo = element.find_all('p')
		if parrafo[0] is not None:
			titular = parrafo[0].text
			titular = modifica_string.elimina_blancos(titular)
			titular = modifica_string.elimina_char_especial(titular)
			titular = titular.replace("\n", "-")
		if parrafo[1] is not None and parrafo[1] != "":
			fecha = parrafo[1].text
			fecha = fecha.split("-")
			try:
				yr = int(fecha[2])
			except:
				f = open("error.txt",'w')
				print len(noticias)
				f.write(noticias.encode('utf-8'))
				f.close()
				
			if yr < 20:
				yr = 2000 + yr
			if yr < 99:
				yr = 1900 + yr
			dia = date(day = int(fecha[0]), month = int(fecha[1]), year = yr)
		else:
			dia = None
		if parrafo[2] is not None:
			cuerpo = parrafo[2].text
			if cuerpo is not None:
				if cuerpo != "" and len(cuerpo) > 30:
					cuerpo = modifica_string.elimina_blancos(cuerpo)
					cuerpo = modifica_string.elimina_char_especial(cuerpo)
					cuerpo = cuerpo.replace("\n", "-")
					cuerpo = unicodedata.normalize('NFKD', cuerpo).decode('utf-8')
				else:
					cuerpo = None
		enlace = element.find('a')
		url_partes= url.split('/')
		U = url_partes[0]+'//'+url_partes[2]
		if enlace['href'][1] != '/':
			link = U+'/'+enlace['href']
		else:
			link = U + enlace['href']
		texto_noticia = get_noticia(link)
		if texto_noticia is not None:
			if texto_noticia != "" and len(texto_noticia) > 30:
				texto_noticia = modifica_string.elimina_blancos(texto_noticia)
				texto_noticia = modifica_string.elimina_char_especial(texto_noticia)
				texto_noticia = texto_noticia.replace("\n", "-")
			else:
				texto_noticia = None
		for e in cat:
			try:
				existe = Noticias.objects.get(url = link)
			except Noticias.DoesNotExist:
				lista_completa.append({'dstitular':titular,'dscuerpo':texto_noticia,'resumen':cuerpo,'url':link,'etiqueta':e,'fecha':dia,'pueblo_id':pueblo_id})
			else:
				return lista_completa
			#p = Noticias(dstitular = titular, dscuerpo = texto_noticia, resumen = cuerpo, url = link, etiqueta = e, fecha = dia, pueblo_id = pueblo_id)
			#p.save()
	digitos = len(str(nivel))
	if nivel == 1:
		nivel = 2
		if url[-1] == '/':
			url2 = url[:-1] + "?page=" + str(nivel)
		else:
			url2 = url + "?page=" + str(nivel)
	else:
		nivel = nivel + 1
		url2 = url[:-digitos]
		url2 = url2 + str(nivel)
	mas_noticias = extraer(url2, nivel, pueblo_id)
	return lista_completa + mas_noticias
