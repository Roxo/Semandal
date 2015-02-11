#!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib2
import sys
import json
from pueblos.models import Pueblo
from pueblos.models import Provincia

p = Pueblo.objects.filter(longitud = None)
for i in range(p[0].id,p[len(p)-1].id+1):
	p=Pueblo.objects.filter(id = i)
	pueblo = p[0].busqueda.encode('utf8')
	print pueblo
	provincia = p[0].provincia.dsprovincia.encode('utf8')
	lugar = pueblo+" "+provincia+" "+"España"    # Construímos la búsqueda
	url = 'https://maps.googleapis.com/maps/api/geocode/json?address='
	url += lugar.replace(' ','+')+"&sensor=false"
	resultado = json.load(urllib2.urlopen(url))  # Hacemos la consulta a la api de google maps y obtenemos el resultado en json
	print resultado
	if resultado['results']:
		lat = resultado['results'][0]['geometry']['location']['lat']
		long = resultado['results'][0]['geometry']['location']['lng']
		p.update(longitud=long)
		p.update(latitud=lat)
