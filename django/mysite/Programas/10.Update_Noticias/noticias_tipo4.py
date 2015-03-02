import urllib2
from pueblos.models import Categoria
from pueblos.models import Noticias
from bs4 import BeautifulSoup
from datetime import date
import modifica_string
def format_fecha(fecha):
	meses =["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiempre", "octubre", "noviembre", "diciembre"]
	partes = fecha.split("\n")
	mes = 1
	for y in range(0,12):
		if partes[2] == meses[y]:
			mes = y + 1
			break	
	f = str(partes[1]) +'/'+ str(mes) +'/'+ str(partes[3])
	return f

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
	lista_completa = []
	print url
	p = url.split('/')
	categoria = p[-2]
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
		if cuerpo is not None:
			if cuerpo != "" and len(cuerpo) > 30:
				cuerpo = modifica_string.elimina_blancos(cuerpo)
				cuerpo = modifica_string.elimina_char_especial(cuerpo)
				cuerpo = cuerpo.replace("\n", "-")
			else:
				cuerpo = None
		fech = element.find('strong', attrs={'class' : 'date'})
		if fech is not None:
			fecha = fech.text
		titu = element.find('a')
		if titu is not None:
			titular = titu.text
			titular = modifica_string.elimina_blancos(titular)
			titular = modifica_string.elimina_char_especial(titular)
			titular = titular.replace("\n", "-")
			partes = url.split('/')
			U = partes[0]+'//'+partes[2]
			enlace = U + titu.get('href')
		texto_noticia = get_noticia(enlace)
		if texto_noticia is not None:
			if texto_noticia != "" and len(texto_noticia) > 30:
				texto_noticia = modifica_string.elimina_blancos(texto_noticia)
				texto_noticia = modifica_string.elimina_char_especial(texto_noticia)
				texto_noticia = texto_noticia.replace("\n", "-")
			else:
				texto_noticia = None
		if fecha is not None:
			if '/' not in fecha:
				fecha = format_fecha(fecha)
			fecha = fecha.split("/")
			dia = date(day = int(fecha[0]), month = int(fecha[1]), year = int(fecha[2]))
		else:
			dia = None
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
	print "Nivel " + str(nivel)
	li_final = soup.body.find('li', attrs={'class' : 'last'})
	if li_final is None:
		print "LIMITE " + str(nivel)
		return []
	li_final = li_final.find('a')
	if li_final is None:
		print "LIMITE " + str(nivel)
		return []
	ul_final = soup.body.find('ul', attrs={'class' : 'paginador group'})
	if ul_final is None:
		print "LIMITE " + str(nivel)
		return []
	if ul_final is not None:
		li = ul_final.findAll('li')
		link = li[-1].find('a')
		if link is None:
			print "LIMITE " + str(nivel)
			return []
	if nivel == 1:
		nivel = 2
		url2 = url + "?pagina=" + str(nivel)
	else:
		nivel = nivel + 1
		url2 = url[:-digitos]
		url2 = url2 + str(nivel)
	mas_noticias = extraer(url2, nivel, pueblo_id)
	return lista_completa + mas_noticias
