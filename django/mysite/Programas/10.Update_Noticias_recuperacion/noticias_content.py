import urllib2
import modifica_string
import datetime
import time
from bs4 import BeautifulSoup
from pueblos.models import Categoria
from pueblos.models import Noticias
def get_noticia(url):
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return ""
	soup = BeautifulSoup(respuesta)
	noticias = soup.body.find_all('div', attrs={'id' : 'left_content'})
	if len(noticias) != 0:
		if noticias[0].text.split("\n")[1][:5]== "Fecha":
			if " de " in noticias[0].text.split("\n")[1][7:]:
				fecha = format_fecha(noticias[0].text.split("\n")[1][7:])
				texto = modifica_string.elimina_comentarios(noticias[0].text)
				return [fecha, texto]
			else:
				fecha_aux = noticias[0].text.split("\n")[1][7:].split(" ")
				fecha_aux = fecha_aux[1] + " " + fecha_aux[2] + " " + fecha_aux[5]
				fecha = datetime.datetime.strptime(fecha_aux, "%b %d %Y")
				fecha = fecha.strftime('%d/%m/%Y')
				texto = modifica_string.elimina_comentarios(noticias[0].text)
				return [fecha, texto]
		else:
			return modifica_string.elimina_comentarios(noticias[0].text)
	else:
		noticias = soup.body.find_all('div', attrs={'id' : 'content_gordo'})
		if len(noticias) != 0:
			if noticias[0].text.split("\n")[1][:5]== "Fecha":
				if " de " in noticias[0].text.split("\n")[1][7:]:
					fecha = format_fecha(noticias[0].text.split("\n")[1][7:])
					texto = modifica_string.elimina_comentarios(noticias[0].text)
					return [fecha, texto]
				else:
					fecha_aux = noticias[0].text.split("\n")[1][7:].split(" ")
					fecha_aux = fecha_aux[1] + " " + fecha_aux[2] + " " + fecha_aux[5]
					fecha = datetime.datetime.strptime(fecha_aux, "%b %d %Y")
					fecha = fecha.strftime('%d/%m/%Y')
					texto = modifica_string.elimina_comentarios(noticias[0].text)
					return [fecha, texto]
			else:
				return modifica_string.elimina_comentarios(noticias[0].text)
		else:
			return [None, None]

def format_fecha(fecha):
	meses =["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiempre", "octubre", "noviembre", "diciembre"]
	partes = fecha.split(" de ")
	mes = 1
	for y in range(0,12):
		if partes[1] == meses[y]:
			mes = y + 1
			break
	if  mes  < 10:
		f = str(partes[0]) +'/0'+ str(mes) +'/'+ str(partes[2])
	else:
		f = str(partes[0]) +'/'+ str(mes) +'/'+ str(partes[2])
	return f

def extraer(url, nivel, pueblo_id):

	""" 
		Extractor de noticias tipo 3
		Las noticias estan en dos etiquetas div, una de class odd-item y otra de class even-item
	"""
	lista_completa = []
	c = url.split("=")
	categoria = c[-1]
	cat = Categoria.objects.filter(etiqueta__exact = categoria)
	if cat is None:
		cat = Categoria.objects.filter(etiqueta__exact = "sin_categoria")
	if not cat.exists():
		cat = Categoria.objects.filter(etiqueta__exact = "sin_categoria")
	with open("./Programas/10.Update_Noticias/categoria_blacklist.txt") as f:
		lines = f.readlines()
	for line in lines:
		if cat[0].etiqueta.lower() in line.lower():
			return []
	try:
		respuesta = urllib2.urlopen(url)
	except:
		return []
	if "alert.html" in respuesta.geturl():
		print "FIN POR alert.html"
		return []
	soup = BeautifulSoup(respuesta)
	noticias_odd = soup.body.find_all('div', attrs={'class' : 'odd-item'})
	if len(noticias_odd) == 0:
		print "FIN POR len(noticias_odd) = 0"
		return []
	for element in noticias_odd:
		fecha = None
		titular = None
		enlace = None
		cuerpo = None
		date2 = element.find('span', attrs={'class' : 'date'})
		if date2 is not None:
			fecha = date2.text
			fecha = format_fecha(fecha)
		titu = element.find('span', attrs={'class' : 'item-title'})
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = modifica_string.elimina_char_especial(titular)
			titular = titular.replace("\n", "-")
		li = element.find('a')
		if li is not None:
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + li.get('href')
		if "content/noticias_list_xmlpage.html" in enlace:
			break
		cuerpo = element.text
		if cuerpo is not None:
			if len(cuerpo) < 2500 and len(cuerpo) > 30:
				cuerpo = modifica_string.elimina_blancos(cuerpo)
				cuerpo = modifica_string.elimina_char_especial(cuerpo)
				cuerpo = cuerpo.replace("\n", "-")
			else:
				cuerpo = None

		texto_noticia = get_noticia(enlace)
		if texto_noticia is str or texto_noticia is unicode:
			if texto_noticia != "" and len(texto_noticia) > 30:
				texto_noticia = modifica_string.elimina_blancos(texto_noticia)
				texto_noticia = modifica_string.elimina_char_especial(texto_noticia)
				texto_noticia = texto_noticia.replace("\n", "-")
			else:
				texto_noticia = None
			if fecha is not None:
				fecha = unicode(fecha)
				fecha = fecha.split("/")
				dia = datetime.date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
			else:
				dia = None
		else:
			if texto_noticia[0] is not None:
				fecha = texto_noticia[0]
				fecha = fecha.split("/")
				dia = datetime.date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
			else:
				dia = None
			if texto_noticia[1] is not None:
				texto_noticia = texto_noticia[1]
				if texto_noticia != "" and len(texto_noticia) > 30:
					texto_noticia = modifica_string.elimina_blancos(texto_noticia)
					texto_noticia = modifica_string.elimina_char_especial(texto_noticia)
					texto_noticia = texto_noticia.replace("\n", "-")
				else:
					texto_noticia = None
			else:
				texto_noticia = None
		for e in cat:
			try:
				existe = Noticias.objects.get(url = enlace)
			except Noticias.DoesNotExist:
				lista_completa.append({'dstitular':titular,'dscuerpo':texto_noticia,'resumen':cuerpo,'url':enlace,'etiqueta':e,'fecha':dia,'pueblo_id':pueblo_id})
			else:
				break
			#p = Noticias(dstitular = titular, dscuerpo = texto_noticia, resumen = cuerpo, url = enlace, etiqueta = e, fecha = dia, pueblo_id = pueblo_id)
			#p.save()
	noticias_even = soup.body.find_all('div', attrs={'class' : 'even-item'})
	for element in noticias_even:
		fecha = None
		titular = None
		enlace = None
		cuerpo = None
		date2 = element.find('span', attrs={'class' : 'date'})
		if date2 is not None:
			fecha = date2.text
			fecha = format_fecha(fecha)
		titu = element.find('span', attrs={'class' : 'item-title'})
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = modifica_string.elimina_char_especial(titular)
			titular = titular.replace("\n", "-")
		li = element.find('a')
		if li is not None:
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + li.get('href')
		if "content/noticias_list_xmlpage.html" in enlace:
			break
		cuerpo = element.text
		if cuerpo is not None:
			if len(cuerpo) < 2500 and len(cuerpo) > 30:
				cuerpo = modifica_string.elimina_blancos(cuerpo)
				cuerpo = modifica_string.elimina_char_especial(cuerpo)
				cuerpo = cuerpo.replace("\n", "-")
			else:
				cuerpo = None
		texto_noticia = get_noticia(enlace)
		if texto_noticia is str or texto_noticia is unicode:
			if texto_noticia != "" and len(texto_noticia) > 30:
				texto_noticia = modifica_string.elimina_blancos(texto_noticia)
				texto_noticia = modifica_string.elimina_char_especial(texto_noticia)
				texto_noticia = texto_noticia.replace("\n", "-")
			else:
				texto_noticia = None
			if fecha is not None:
				fecha = unicode(fecha)
				fecha = fecha.split("/")
				dia = datetime.date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
			else:
				dia = None
		else:
			if texto_noticia[0] is not None:
				fecha = texto_noticia[0]
				fecha = fecha.split("/")
				dia = datetime.date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
			else:
				dia = None
			if texto_noticia[1] is not None:
				texto_noticia = texto_noticia[1]
				if texto_noticia != "" and len(texto_noticia) > 30:
					texto_noticia = modifica_string.elimina_blancos(texto_noticia)
					texto_noticia = modifica_string.elimina_char_especial(texto_noticia)
					texto_noticia = texto_noticia.replace("\n", "-")
				else:
					texto_noticia = None
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
	if nivel == 1:
		nivel = nivel + 1
		url2 = url.split("?")
		url3 = url2[0] + "?pag=" + str(nivel) + "&" + url2[1]
	else:
		nivel = nivel + 1
		url2 = url.split("&")
		url3 = url2[0][:-digitos] + str(nivel) + "&" + url2[1]
	mas_noticias = extraer(url3, nivel, pueblo_id)
	return lista_completa + mas_noticias
