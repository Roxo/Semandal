import urllib2
from pueblos.models import Categoria
from pueblos.models import Noticias
import re
from bs4 import BeautifulSoup
from datetime import date
import modifica_string

def get_noticia(url):
	ret = []
	try:
		respuesta = urllib2.urlopen(url)
	except:
		ret.append(None)
		ret.append(None)
		return ret
	soup = BeautifulSoup(respuesta)
	noticias = soup.body.find_all('div', attrs={'class' : 'cuerpoContenido clearfix'})	
	if len(noticias) != 0:
		return modifica_string.elimina_comentarios(noticias[0].text)
	return  ""

def extraer(url, nivel, pueblo_id):
	""" 
		Extractor de noticias tipo 2
		Las noticias estan en etiquetas div de class result group
	"""
	print url
	lista_completa = []
	cat = Categoria.objects.filter(etiqueta__exact = "sin_categoria")
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return []
	soup = BeautifulSoup(respuesta)
	noticias = soup.body.find_all('div', attrs={'class' : 'result group'})	
	for element in noticias:
		fecha = None
		titular = None
		enlace = None
		cuerpo = None
		fecha = element.text
		fecha = re.findall("\[(.*?)\]", fecha)
		if len(fecha) != 0:
			fecha = fecha[0]
			fecha = fecha.split("/")
			dia = date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
		else:
			dia = None
		titu = element.find('a')
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = modifica_string.elimina_char_especial(titular)
			titular = titular.replace("\n", "-")
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + titu.get('href')
		cuerpo = element.find('span')
		if cuerpo is not None:
			cuerpo = cuerpo.text
		if cuerpo is not None:
			if cuerpo != "" and len(cuerpo) > 30:
				cuerpo = modifica_string.elimina_blancos(cuerpo)
				cuerpo = modifica_string.elimina_char_especial(cuerpo)
				cuerpo = cuerpo.replace("\n", "-")
			else:
				cuerpo = None
		texto_noticia = get_noticia(enlace)
		if texto_noticia is not None:
			if texto_noticia != "" and len(texto_noticia) > 30:
				texto_noticia = modifica_string.elimina_blancos(texto_noticia)
				texto_noticia = modifica_string.elimina_char_especial(texto_noticia)
				texto_noticia = texto_noticia.replace("\n", "-")
			else:
				texto_noticia = None
		for e in cat:
			try:
				existe = Noticias.objects.get(url = enlace)
			except Noticias.DoesNotExist:
				lista_completa.append({'dstitular':titular,'dscuerpo':texto_noticia,'resumen':cuerpo,'url':enlace,'etiqueta':e,'fecha':dia,'pueblo_id':pueblo_id})
			else:
				return lista_completa
			#p = Noticias(dstitular = titular, dscuerpo = texto_noticia, resumen = cuerpo, url = enlace, etiqueta = e, fecha = dia, pueblo_id = pueblo_id)
			#p.save()
	digitos = len(str(nivel))
	li_final = soup.body.find('li', attrs={'class' : 'last'})
	if li_final is None:
		return []
	li_final = li_final.find('a')
	if li_final is None:
		return []
	if nivel == 1:
		nivel = nivel + 1
		url2 = url + "?pagina=" + str(nivel)
	else:
		nivel = nivel + 1
		url2 = url[:-digitos]
		url2 = url2 + str(nivel)
	mas_noticias = extraer(url2, nivel, pueblo_id)
	return lista_completa + mas_noticias
