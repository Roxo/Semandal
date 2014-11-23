import urllib2
import re
from bs4 import BeautifulSoup
from pueblos.models import Categoria
from pueblos.models import Noticias
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
		Extractor de noticias tipo 2
		Las noticias estan en etiquetas div de class result group
	"""
	p = url.split('/')
	categoria = p[-2]
	cat = Categoria.objects.filter(etiqueta = categoria)
	if cat is None:
		cat = Categoria.objects.filter(etiqueta = "sin_categoria")
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return []
	soup = BeautifulSoup(respuesta)
	noticias = soup.body.find_all('div', attrs={'class' : 'result group'})	
	for element in noticias:
#		fecha = None
		titular = None
		enlace = None
		cuerpo = None
#		fech = element.find('strong', attrs={'class' : 'date'})
#		if fech is not None:
#			fecha = fech.text
#		else:
#			nfecha = element.getText()
#			fecha = re.findall("\[(.*?)\]", nfecha)
#			fecha = fecha[0]
		titu = element.find('a')
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = titular.replace("\n", "-")
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + titu.get('href')
		cuerpo = element.find('span')
		cuerpo = modifica_string.elimina_blancos(cuerpo)
		cuerpo = cuerpo.replace("\n", "-")
		cosas = get_noticia(enlace)
		if cosas[1] is not None:
			fecha = format_fecha(cosas[1]).split("/")
			dia = date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
		else:
			dia = None
		texto_noticia = cosas[0]
		if texto_noticia == "":
			texto_noticia = None
		texto_noticia = modifica_string.elimina_blancos(texto_noticia)
		texto_noticia = texto_noticia.replace("\n", "-")
		p = Noticias(dstitular = titular, dscuerpo = texto_noticia, resumen = cuerpo, url = enlace, etiqueta = cat[0], fecha = dia, pueblo_id = pueblo_id)
		p.save()
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
	extraer(url2,nivel, pueblo_id)
