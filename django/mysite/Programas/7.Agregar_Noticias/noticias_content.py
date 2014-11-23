import urllib2
import modifica_string
from bs4 import BeautifulSoup
from pueblos.models import Categoria
from pueblos.models import Noticias

def get_noticia(url):
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return "N/A"
	soup = BeautifulSoup(respuesta)
	noticias = soup.body.find_all('div', attrs={'id' : 'left_content'})
	if len(noticias) != 0:
		return modifica_string.elimina_comentarios(noticias[0].text)
	else:
		noticias = soup.body.find_all('div', attrs={'id' : 'content_gordo'})
		print type(noticias)
		if len(noticias) != 0:
			return modifica_string.elimina_comentarios(noticias[0].text)
		else:
			return None

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

def extraer(url, nivel, pueblo_id):

	""" 
		Extractor de noticias tipo 3
		Las noticias estan en dos etiquetas div, una de class odd-item y otra de class even-item
	"""
	c = url.split("=")
	categoria = c[-1]
	cat = Categoria.objects.filter(etiqueta = categoria)
	if cat is None:
		cat = Categoria.objects.filter(etiqueta = "sin_categoria")	
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return []
	if "alert.html" in respuesta.geturl():
		return []
	soup = BeautifulSoup(respuesta)
	x = soup.body.find_all('a', attrs={'class' : 'enlace_localizador'})
	noticias_odd = soup.body.find_all('div', attrs={'class' : 'odd-item'})
	if len(noticias_odd) == 0:
		return []
	for element in noticias_odd:
		fecha = None
		titular = None
		enlace = None
		cuerpo = None
		date = element.find('span', attrs={'class' : 'date'})
		if date is not None:
			fecha = date.text
			fecha = format_fecha(fecha)
		titu = element.find('span', attrs={'class' : 'item-title'})
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = titular.replace("\n", "-")
		li = element.find('a')
		if li is not None:
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + li.get('href')
		cuerpo = element.text
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
	noticias_even = soup.body.find_all('div', attrs={'class' : 'even-item'})
	for element in noticias_even:
		fecha = None
		titular = None
		enlace = None
		cuerpo = None
		date = element.find('span', attrs={'class' : 'date'})
		if date is not None:
			fecha = date.text
		titu = element.find('span', attrs={'class' : 'item-title'})
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = titular.replace("\n", "-")
		li = element.find('a')
		if li is not None:
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + li.get('href')
		cuerpo = element.text
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
	digitos = len(str(nivel))
	if nivel == 1:
		nivel = nivel + 1
		url2 = url.split("?")
		url3 = url2[0] + "?pag=" + str(nivel) + "&" + url2[1]
	else:
		nivel = nivel + 1
		url2 = url.split("&")
		url3 = url2[0][:-digitos] + str(nivel) + "&" + url2[1]
	extraer(url3, nivel, pueblo_id)
