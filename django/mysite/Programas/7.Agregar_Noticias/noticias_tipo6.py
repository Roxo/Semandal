import urllib2
from pueblos.models import Categoria
from pueblos.models import Noticias
from bs4 import BeautifulSoup
from datetime import date
import modifica_string
def get_noticia(url):
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return None
	soup = BeautifulSoup(respuesta)
	noticias = soup.body.find_all('div', attrs={'class' : 'cajaContenidoGenerica'})	
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
		return
	#print respuesta
	soup = BeautifulSoup(respuesta)
	if soup.body is None:
		return 
	if nivel == 0:
		nivel = 1
	noticias = soup.find_all('div', attrs={'class' : 'clearfix'})	
	if len(noticias) == 0:
		return 
	for element in noticias:
		cat = Categoria.objects.filter(etiqueta__exact = "sin_categoria")
		fecha = None
		titular = None
		enlace = None
		cuerpo = None
		if element.text != "":
			cuerpo = element.text
			cuerpo = modifica_string.elimina_blancos(cuerpo)
			cuerpo = modifica_string.elimina_char_especial(cuerpo)
			cuerpo = cuerpo.replace("\n", "-")
		titu = element.find('a')
		fec = element.find('span', attrs={'class' : 'fecha'})		
		if fec is not None:
			fecha = fec.text
		else:
			fecha = None
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = modifica_string.elimina_char_especial(titular)
			titular = titular.replace("\n", "-")
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + titu.get('href')
			enlace2 = titu.get('href')
			if "/actualidad/noticias/index.html" in enlace2:
				return 
		texto_noticia = get_noticia(enlace)
		if texto_noticia == "":
			texto_noticia = None
		texto_noticia = modifica_string.elimina_blancos(texto_noticia)
		texto_noticia = modifica_string.elimina_char_especial(texto_noticia)
		if texto_noticia is not None:
			texto_noticia = texto_noticia.replace("\n", "-")
		if fecha is not None:
			fecha = fecha.split("/")
			dia = date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
		else:
			dia = None
		for e in cat:
			p = Noticias(dstitular = titular, dscuerpo = texto_noticia, resumen = cuerpo, url = enlace, etiqueta = e, fecha = dia, pueblo_id = pueblo_id)
			p.save()
	digitos = len(str(nivel))
	if nivel == 1:
		nivel = 2
		url2 = url + "&page=" + str(nivel)
	else:
		nivel = nivel + 1
		url2 = url[:-digitos]
		url2 = url2 + str(nivel)
	extraer(url2,nivel, pueblo_id)
