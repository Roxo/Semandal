#!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib2
import json
import re

from pueblos.models import Pueblo
from pueblos.models import Provincia

def limpiar(urls):
	devolver = ""
	i = 0;
	encontrado = False
	print len(urls)
	while i < len(urls) and encontrado == False:
		print urls[i]
		if "wikipedia" not in urls[i] and "paginasamarillas" not in urls[i] and "maps" not in urls[i] and "irekia" not in urls[i] and "pueblos-" not in urls[i] and "www.dip-badajoz.es" not in urls[i] and "todopueblos" not in urls[i]:
			devolver = urls[i]
			encontrado = True
		i=i+1
	print devolver
	return devolver;

def limpiarurl(url):
	busqueda = "http[s]?://[www.]*[a-zA-Z0-9\-\.\_\-]*"
	html = re.findall(busqueda,url)
	try:
		return html[0]
	except:
		return ""

	
	
###CASO ESPECIAL PARA UNA SERIE DE PRUEBOS COLINDANTES A AÑANA###
# def ifanana(url,pueblo):
	# url = url.lower()
	# url = url.replace("ñ","n")
	# url = url.replace("á","a")
	# url = url.replace("é","e")
	# url = url.replace("í","i")
	# url = url.replace("ó","o")
	# url = url.replace("ú","u")
	# url = url+

def busquedagoogle(nayun,provincia):
	nayun=nayun.replace(" ","+")
	provincia=provincia.replace(" ","+")
	query = "q=ayuntamiento+"+nayun.encode('utf8')+provincia.encode('utf8')
	url = ('https://www.googleapis.com/customsearch/v1?key=AIzaSyCE2yzQc_Fzs_z4qMdUvaa_gEH4njiIitI&cx=011214853824069352339:cj8e-6gpydc&gl=es&googlehost=google.es&lr=lang_es&'+query)#CASTELLANO
	#url = ('https://www.googleapis.com/customsearch/v1?key=AIzaSyCE2yzQc_Fzs_z4qMdUvaa_gEH4njiIitI&cx=011214853824069352339:bwb0bdqdq6u&googlehost=google.es/&'+query)#CATALAN
	print url
	response = urllib2.urlopen(url)
	results = json.load(response)
	devolver = []
	for i in range (0,4):
		devolver.append(results['items'][i]['link'])
	return devolver

p = Pueblo.objects.filter(url=None)
for i in p:
	pueblo = Pueblo.objects.filter(id=i.id)
	provincia = pueblo[0].provincia.dsprovincia
	abuscar = pueblo[0].busqueda
	resultado = busquedagoogle(abuscar,provincia)
	print resultado
	updt = limpiar(resultado)
	print updt
	if updt == "":
		resultado = busquedagoogle(pueblo[0].busquedaop,provincia)
		print resultado
		updt=limpiar(resultado)
	cuad=updt
	if "opencms" not in cuad:
		updt = limpiarurl(updt)
		if "cuadrilladeanana" in updt:
			updt = cuad
		if "www2" in updt:
			updt = ""
	pueblo.update(url = updt)
