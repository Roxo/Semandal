#!/usr/bin/env python
# -*- coding: utf-8 -*-

import urllib2
import json
import re

from pueblos.models import Pueblo
from pueblos.models import Provincia
from django.db.models import Q


p = Pueblo.objects.filter(~Q(dspueblo = "Huelva"),~Q(url = None),redirec = None)
RE_OCMS=("url=/?([\w\/\.\-\_]*)")
RE_OTHERS=("url=[ ]*(http[s]?://[www.]*[a-zA-Z0-9\-\.\/\_\-]*)")
for i in p:
	noroto = True
	pueblo = Pueblo.objects.filter(id=i.id)
	url1 = pueblo[0].url.encode('utf8')
	if(url1 != ''):
		try:
			resultado = urllib2.urlopen(url1)
		except:
			noroto = False
			print pueblo[0].dspueblo + " Esta roto"
		if noroto:
			datos = resultado.read();
			datos = datos.lower();
			print pueblo[0].dspueblo
			if ("http-equiv="+'"'+"refresh"+'"') in datos:
				print "debe tener redireccion"
				url = re.findall(RE_OTHERS,datos)
				if len(url) == 0:
					if ulr1[len(url1)-1] != '/':
						url = url1+'/'+re.findall(RE_OCMS,datos)[0]	
					else:
						url = url+re.findall(RE_OCMS,datos)[0]
				else:
					url = url[0]
				pueblo.update(redirec = url)
			else:
				pueblo.update(redirec = '')		