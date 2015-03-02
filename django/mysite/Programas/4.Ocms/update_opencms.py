#!/usr/bin/env python
# -*- coding: utf-8 -*-

import urllib2
import json
import re

from pueblos.models import Pueblo
from pueblos.models import Provincia
from django.db.models import Q

def tieneopencms(url1):
	excp = False
	try:
		resultado = urllib2.urlopen(url1)
		resultado = resultado.read()
	except:
		excp = True
	if not excp:
		searchhtml = "http[s]?://[www.]*[a-zA-Z0-9\-\.\/\_\-]*"
		lista1 = re.findall(searchhtml,resultado)
		abuscar = ""
		for i in lista1:
			if(url1 not in i):
				abuscar = abuscar+"-"+i
		busqueda = "opencms/opencms/[\w\_\.\/]*"
		lista2 = re.findall(busqueda,resultado)
		lista = []
		for j in lista2:
			if j not in lista and "." not in j and "flash" not in j:
				lista.append(j)
		for i in lista:
			if i in abuscar:
				lista.remove(i)
		if len(lista) == 0:
			return False
		else: 
			return True
	else:
	 return False
	

p = Pueblo.objects.filter(opencms = 0)
f = open("pueblos_opencms.txt",'w')
for i in p:
	print i.dspueblo
	if i.url != '' and i.url != None:
		print "entra"
		pueblo = Pueblo.objects.filter(id=i.id)
		url = pueblo[0].redirec
		if (url != None and url != ''):
			print "Entra por redireccion"
			if tieneopencms(url) == True:
				f.write(pueblo[0].dspueblo+"\n")
		else:
			print "Entra normal"
			url = pueblo[0].url
			if tieneopencms(url) == True:
				f.write(pueblo[0].dspueblo+"\n")
f.close()