#!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib2
import json
import re
import os

from pueblos.models import Pueblo
from pueblos.models import Provincia
from django.db.models import Q

def fixpueblo(des):
	aux = des.split("'")
	nueva=""
	for i in aux:
		nueva = nueva+i
	return nueva
def agregarpueblos(fichero):
	p = Pueblo.objects.filter(~Q(longitud = None))
	for i in p:
		if i.busqueda != p[len(p)-1].busqueda:
			des = i.dspueblo.encode('utf8') + "/"+ i.provincia.dsprovincia.encode('utf8')
			if ("'" in des):
				des = fixpueblo(des)
			lat = i.latitud
			lon = i.longitud
			string = "['"+des+"',"+str(lat)+","+str(lon)+"],\n"
			fichero.write(string+"\n")
	des = p[len(p)-1].dspueblo.encode('utf8') + "/"+ p[len(p)-1].provincia.dsprovincia.encode('utf8')
	lat = p[len(p)-1].latitud
	lon = p[len(p)-1].longitud
	string = "['"+des+"',"+str(lat)+","+str(lon)+"],\n"
	fichero.write(string+"\n")


plantilla = open('./documentos/plantilla_vacia.html','r')
fichero = open('./documentos/pueblos.html','w')

for line in plantilla:
	if "var pueblos" in line:
		fichero.write(line+"\n")
		agregarpueblos(fichero)
	else:
		fichero.write(line+"\n")

fichero.close();
plantilla.close();