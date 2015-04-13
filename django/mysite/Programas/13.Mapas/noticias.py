#!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib2
import json
import re
import os

from pueblos.models import Pueblo
from pueblos.models import Noticias
from pueblos.models import Provincia
from django.db.models import Q

def fixpueblo(des):
	aux = des.split("'")
	nueva=""
	for i in aux:
		nueva = nueva+i
	return nueva


def agregarpueblos(fichero):
	p = Noticias.objects.all().values_list('pueblo').distinct()
	for t in p:
		i = Pueblo.objects.filter(id = t[0])[0]
		j = Pueblo.objects.filter(id=p[len(p)-1][0])[0]
		print i
		if i.busqueda != j.busqueda:
			des = i.dspueblo.encode('utf8') + "/"+ i.provincia.dsprovincia.encode('utf8')
			if ("'" in des):
				des = fixpueblo(des)
			lat = i.latitud
			lon = i.longitud
			string = "['"+des+"',"+str(lat)+","+str(lon)+"],\n"
			fichero.write(string+"\n")
	des = j.dspueblo.encode('utf8') + "/"+ j.provincia.dsprovincia.encode('utf8')
	lat = j.latitud
	lon = j.longitud
	string = "['"+des+"',"+str(lat)+","+str(lon)+"],\n"
	fichero.write(string+"\n")


plantilla = open('./documentos/plantilla_vacia.html','r')
fichero = open('./documentos/noticias.html','w')

for line in plantilla:
	if "var pueblos" in line:
		fichero.write(line+"\n")
		agregarpueblos(fichero)
	else:
		fichero.write(line+"\n")

fichero.close();
plantilla.close();