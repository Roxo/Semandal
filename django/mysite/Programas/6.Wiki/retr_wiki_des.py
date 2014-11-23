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


def busquedagoogle(nayun,provincia):
	nayun=nayun.replace(" ","+")
	provincia=provincia.replace(" ","+")
	query = "q=español+wikipedia+"+nayun.encode('utf8')+provincia.encode('utf8')
	url = ('https://www.googleapis.com/customsearch/v1?key=AIzaSyCE2yzQc_Fzs_z4qMdUvaa_gEH4njiIitI&cx=011214853824069352339:6imorhiozck&gl=es&googlehost=google.es&lr=lang_es&'+query)#CASTELLANO
	response = urllib2.urlopen(url)
	results = json.load(response)
	devolver = []
	for i in range (0,4):
		devolver.append(results['items'][i]['link'])
	return devolver

listaprov = [4,11,14,18,21,23,29,41]

n = 0
for j in listaprov:
	p = Pueblo.objects.filter(provincia_id = j,wiki=None)
	for i in p:
		r=""
		pueblo = Pueblo.objects.filter(id = i.id)
		devolver = busquedagoogle(pueblo[0].busqueda,pueblo[0].provincia.dsprovincia)
		consulta = devolver[0]
		print consulta
		if "es.wikipedia.org" in consulta:
			pueblo.update(wiki=consulta)