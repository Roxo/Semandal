#t!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib2
import urllib
import MySQLdb
import json
import re
import webbrowser
import urllib2
from pueblos.models import Pueblo
from pueblos.models import Provincia

#Abrir el xls

#Insertar en la tabla pueblos, todos los Andaluces.
listaprov = [4,11,14,18,21,23,29,41]

n = 0
for j in listaprov:
	p = Pueblo.objects.filter(provincia_id = j)
	for i in p:
		r=""
		pueblo = Pueblo.objects.filter(id = i.id)
		nombre = i.dspueblo.split(",")
		if len(nombre) == 2:
			nombre = ""+nombre[1][1:len(nombre[1])]+" "+nombre[0]
		else:
			nombre = ""+nombre[0]
		print nombre
		nombre=nombre.replace(" ","_")
		consulta = "http://es.wikipedia.org/wiki/"+nombre.encode('utf-8')
		print consulta
		resultado = urllib2.urlopen(consulta);
		resultado = resultado.read()
		if "Bandera" in resultado or "Escudo" in resultado:
				pueblo.update(wiki=consulta)
		else:
			print "No Tiene:"
print n
