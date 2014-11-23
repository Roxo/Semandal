#!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib2
import urllib
import MySQLdb
import json
import re
import os
from urllib2 import urlopen
from pueblos.models import Pueblo
from django.db.models import Q




#Abrir el xls

#Insertar en la tabla pueblos, todos los Andaluces.
def getIcons(nombre_pueblo,consulta):
	resultado = urllib2.urlopen(consulta);
	resultado = resultado.read()
	busqueda = "upload.wikimedia.org/wikipedia/commons/thumb/[a-zA-ZñÑ\/\_\.\0-9]*.png"
	html = re.findall(busqueda,resultado);
	print len(html)
	r=[];
	for i in range(0,len(html)-1):
		if "Bandera" in html[i] or "Escudo" in html[i]:
			r.append(html[i])
	Escudo = []
	Bandera = []
	for i in r:
		if " " not in i:
			if "Escudo" in i and len(Escudo) == 0:
				Escudo.append(i)
			if "Bandera" in i and len(Bandera) == 0:
				Bandera.append(i)
	print Escudo
	print Bandera
	if len(Escudo) is not 0 or len(Bandera) is not 0:
		directoryPath=R'./icons/'+nombre_pueblo
		os.mkdir(directoryPath)
	if len(Escudo) is not 0:
		directoryPath=R'./icons/'+nombre_pueblo+'/Escudo'
		os.mkdir(directoryPath)
		r = urlopen('http://'+Escudo[0])
		f = open(directoryPath+'/Escudo.png', "wb")	
		f.write(r.read())
		f.close()
		r.close()
	if len(Bandera) is not 0:
		directoryPath=R'./icons/'+nombre_pueblo+'/Bandera'
		os.mkdir(directoryPath)
		r = urlopen('http://'+Bandera[0])
		f = open(directoryPath+'/Bandera.png', "wb")	
		f.write(r.read())
		f.close()
		r.close()

pueblo = Pueblo.objects.filter(~Q(wiki = None))
for i in pueblo:
	consulta = i.wiki.encode("utf-8")
	nombre_pueblo = i.busqueda.replace(" ","_")
	print nombre_pueblo
	print consulta
	getIcons(nombre_pueblo,consulta)

