#!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib2
import urllib
import xlrd 
import MySQLdb
import json
import re
from pueblos.models import Pueblo
from pueblos.models import Provincia

def replaceutf(nombre):
	nombre = nombre.replace("á","a")
	nombre = nombre.replace("é","e")
	nombre = nombre.replace("í","i")
	nombre = nombre.replace("ó","o")
	nombre = nombre.replace("ú","u")
	nombre = nombre.replace("Á","A")
	nombre = nombre.replace("É","E")
	nombre = nombre.replace("Í","I")
	nombre = nombre.replace("Ó","O")
	nombre = nombre.replace("Ú","U")	
	if("," in nombre):
		aux = nombre.split(",")
		nombre = aux[1]+" "+aux[0]
		if nombre[0] == ' ':
			nombre = nombre[1:len(nombre)]
	return nombre



# def busqueda(puebloabuscar):
	# query = urllib.urlencode({'q': "ayuntamiento "+puebloabuscar})
	# url = 'http://ajax.googleapis.com/ajax/services/search/web?v=1.0&%s' % query
	# search_response = urllib.urlopen(url)
	# search_results = search_response.read()
	# results = json.loads(search_results)
	# data = results['responseData']
	# if type(data) is None:
		# print "entraendata"
		# hits = data['results'][0]['url']
	# else: 
		# hits = 403
	# return hits
	
# def limpiaurl(url):
	# if url != 403:
		# busqueda = "(http://[www.]?[\a-zA-zñÑ\-\_\.]*.[a-zA-ZñÑ]*/)"
		# html = re.findall(busqueda,url)
		# try:
			# return html[0]
		# except:
			# return ""
	# else:
		# return 403

# def busquedagoogle(nayun,codProv):
	# nayun = nayun.replace(" ","%20");
	# provincia=provincias.objects.filter(id = codProv)
	# query = "q=ayuntamiento%20"+nayun+"%20"+provincia[0].dsprovincia.encode('utf8').replace(" ","")
	# url = ('https://ajax.googleapis.com/ajax/services/search/web''?v=1.0&'+query+'&userip=USERS-IP-ADDRESS')
	# request = urllib2.Request(url, None, {'Referer': "www.google.es"})
	# response = urllib2.urlopen(request)
	# results = json.load(response)
	# if results['responseData'] is None:
		# return 403
	# else:
		# return results['responseData']['results'][0]['url']


# def busquedabing(nayun,codProv):
	# nayun = nayun.replace(" ","%20");
	# provincia=provincias.objects.filter(id = codProv)
	# query = "q=ayuntamiento%20"+nayun+"%20"+provincia[0].dsprovincia.encode('utf8').replace(" ","")
	# url = "http://www.bing.com/search?"+query
	# response = urllib2.urlopen(url)
	# toSearch = response.read()
	# busqueda = "(http://[www.]?[\w\-\_\.]*.[\w]*/)"
	# html = re.findall(busqueda,toSearch)
	# i = 0
	# while "w3" in html[i] or "schemas" in html[i] or "msn" in html[i] or "microsoft" in html[i] or "wiki" in html[i]:
		# i=i+1
	# if i<len(html):
		# return html[i]
	# else:
		# return ""
	
# Preparar el cursor con los datos de conexión de la db.
# cursor = db.cursor()

#Abrir el xls
doc = xlrd.open_workbook('./documentos/14codmun.xls')
sheet = doc.sheet_by_name(u'dic14')

#Insertar en la tabla pueblos, todos los Andaluces.

for i in range(2,sheet.nrows):
	Nombre = sheet.cell_value(i,3).encode('utf8')
	idprovinc= sheet.cell_value(i,0).encode('utf8')
	cod = sheet.cell_value(i,1).encode('utf8')
	cpl = idprovinc+cod
	nombresintildes = replaceutf(Nombre)
	# if (
	# idprovinc == "04" or #Almería
	# idprovinc == "11" or #Cádiz
	# idprovinc == "14" or #Córdoba
	# idprovinc == "21" or #Huelva
	# idprovinc == "23" or #Jaen
	# idprovinc == "29" or #Málaga
	# idprovinc == "41" or #Sevilla
	# idprovinc == "18"	#Granada
	# ):  
	# a = busquedagoogle(nombresintildes,idprovinc)
	# url = limpiaurl(a)
		# if url == 403:
			# a = busquedabing(nombresintildes,idprovinc)
			# url = limpiaurl(a)
		#Django insert
	if("/" in Nombre):
		aux = Nombre.split("/")
		n1 = aux[0]
		n2 = aux[1]
		b1 = replaceutf(n1)
		# if b1[0] == ' ':
			# b1 = b1[1:len(b1.busqueda)]
		b2 = replaceutf(n2)
		# if b2[0] == ' ':
			# b2 = b2[1:len(b1.busqueda)]
		p = Pueblo(dspueblo=n1,dsopcional=n2,cp=cpl,busqueda=b1,busquedaop=b2,provincia=Provincia.objects.filter(id = idprovinc)[0])
	else:
		p = Pueblo(dspueblo=Nombre,cp=cpl,busqueda=nombresintildes,provincia=Provincia.objects.filter(id = idprovinc)[0])
			#,url=url),latitud=0.0,longitud=0.0)
	p.save()
