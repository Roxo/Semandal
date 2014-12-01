import urllib2
from pueblos.models import Categoria
from pueblos.models import Noticias
from bs4 import BeautifulSoup
from datetime import date
import modifica_string
def format_fecha(fecha):
	meses =["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiempre", "octubre", "noviembre", "diciembre"]
	partes = fecha.split(" de ")
	mes = 1
	for y in range(0,12):
		if partes[1] == meses[y]:
			mes = y + 1
			break	
	f = str(partes[0]) +'/'+ str(mes) +'/'+ str(partes[2])[-2:]
	return f
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
		ret.append(modifica_string.elimina_comentarios(noticias[0].text))
	else:
		ret.append(None)
	noticias = soup.body.find_all('p', attrs={'class' : 'fecha'})	
	if len(noticias) != 0:
		ret.append(noticias[0].text)
	else:
		ret.append(None)
	return ret

def extraer(url, nivel, pueblo_id):
	""" 
		Extractor de noticias tipo 5
		Las noticias estan en un div de class listado noticias
	"""
	try:
		respuesta = urllib2.urlopen(url).read()
	except:
		digitos = len(str(nivel))
		if nivel == 1:
			nivel = 2
			url2 = url + "index.html?pag=" + str(nivel)
		else:
			nivel = nivel + 1
			url2 = url[:-digitos]
			url2 = url2 + str(nivel)
		extraer(url2,nivel, pueblo_id)
	soup = BeautifulSoup(respuesta)
	if soup.body is None:
		return
	if nivel == 0:
		nivel = 1
	noticias = soup.find_all('div', attrs={'class' : 'listado noticias'})	
	if len(noticias) == 0:
		return
	lis = noticias[0].find_all('div')
	for element in lis:
		cat = Categoria.objects.filter(etiqueta__exact = "sin_categoria")
		fecha = None
		titular = None
		enlace = None
		c = element.find('p', attrs={'class' : 'entradilla'})
		cuerpo = None
		if c is not None:
			cuerpo = c.text
			cuerpo = modifica_string.elimina_blancos(cuerpo)
			cuerpo = modifica_string.elimina_char_especial(cuerpo)
			cuerpo = cuerpo.replace("\n", "-")
		titu = element.find('a')
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = modifica_string.elimina_char_especial(titular)
			titular = titular.replace("\n", "-")
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + titu.get('href')
			enlace2 = titu.get('href')
			print "ENLACE " + enlace2
			if "/actualidad/noticias/index.html" in enlace2:
				return
		cosas = get_noticia(enlace)
		if cosas[1] is not None:
			if "/" in cosas[1]:
				fecha = cosas[1].split("/")
			else:
				fecha = format_fecha(cosas[1]).split("/")
			dia = date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
		else:
			dia = None
		texto_noticia = cosas[0]
		if texto_noticia == "":
			texto_noticia = None
		texto_noticia = modifica_string.elimina_blancos(texto_noticia)
		texto_noticia = modifica_string.elimina_char_especial(texto_noticia)
		if texto_noticia is not None:
			texto_noticia = texto_noticia.replace("\n", "-")
		for e in cat:
			p = Noticias(dstitular = titular, dscuerpo = texto_noticia, resumen = cuerpo, url = enlace, etiqueta = e, fecha = dia, pueblo_id = pueblo_id)
			p.save()
	digitos = len(str(nivel))
	if nivel == 1:
		nivel = 2
		url2 = url + "index.html?pag=" + str(nivel)
	else:
		nivel = nivel + 1
		url2 = url[:-digitos]
		url2 = url2 + str(nivel)
	extraer(url2,nivel,pueblo_id)
