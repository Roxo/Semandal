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
	noticias = soup.body.find_all('div', attrs={'class' : 'noticia group'})	
	if len(noticias) != 0:
		return modifica_string.elimina_comentarios(noticias[0].text)
	else:
		return None	
def extraer(url, nivel, pueblo_id):
	""" 
		Extractor de noticias tipo 4
		Las noticias estan en un div de class content-noticias group o module-noticias box group
	"""
	href = ""
	p = url.split('/')
	categoria = p[-2]
	cat = Categoria.objects.filter(etiqueta = categoria)
	if cat is None:
		cat = Categoria.objects.filter(etiqueta = "sin_categoria")
	for y in range(3,len(p)):
		href += '/' + p[y]
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return []
	soup = BeautifulSoup(respuesta)
	if soup.body is None:
		return []

	if nivel == 0:
		nivel = 1
	ahref = soup.body.find_all('a')
	for element in ahref:
		if element.get('href') == href:
			ncategoria = element.text
			break
	noticias = soup.body.find_all('div', attrs={'class' : 'content-noticias group'})	
	if len(noticias) == 0:
		noticias = soup.body.find_all('div', attrs={'class' : 'module-noticias box group'})
		if len(noticias) == 0:
			return []
	lis = noticias[0].find_all('div')
	for element in lis:
		fecha = None
		titular = None
		enlace = None
		cuerpo = element.text
		cuerpo = modifica_string.elimina_blancos(cuerpo)
		cuerpo = cuerpo.replace("\n", "-")
		if cuerpo is "":
			cuerpo = None
		fech = element.find('strong', attrs={'class' : 'date'})
		if fech is not None:
			fecha = fech.text
		titu = element.find('a')
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = titular.replace("\n", "-")
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + titu.get('href')
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
	print "Nivel " + str(nivel)
	li_final = soup.body.find('li', attrs={'class' : 'last'})
	if li_final is None:
		print "LIMITE " + str(nivel)
		return []
	li_final = li_final.find('a')
	if li_final is None:
		print "LIMITE " + str(nivel)
		return []
	if nivel == 1:
		nivel = 2
		url2 = url + "?pagina=" + str(nivel)
	else:
		nivel = nivel + 1
		url2 = url[:-digitos]
		url2 = url2 + str(nivel)
	extraer(url2,nivel, pueblo_id)
