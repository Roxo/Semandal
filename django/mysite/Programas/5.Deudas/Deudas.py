#!/usr/bin/env python
# -*- coding: utf-8 -*-

import urllib2
import json
import re
import MySQLdb
import xlrd
from pueblos.models import Pueblo
from pueblos.models import Provincia
from django.db.models import Q
from datetime import date

Deuda = xlrd.open_workbook('./documentos/Deuda viva ayuntamientos 2013. Datos brutos Hacienda.xls');

Deuda = Deuda.sheet_by_name(u'Datos')


for i in range(1,Deuda.nrows-3):
	Nombre = Datos.cell_value(i,6).encode('utf8')
	if('/' in Nombre):
		Nombre = Nombre.split('/')[0]
	if('(' in Nombre):
		Nombre = Nombre.split('(')[0]
	print Nombre
	print float(Deuda.cell_value(i,7))
	dda = float(Deuda.cell_value(i,7))
	# Nombre = Deuda.cell_value(i,6).encode('utf8')
	p = Pueblo.objects.filter(dspueblo = Nombre)
	if(len(p)!=0):
		p.update(deuda = dda)
	# if(len(p)!=0):
	# 	fecha = Deuda.cell_value(i,7)
	# 	fecha = fecha.split('/')
	# 	dia = int(fecha[0])
	# 	mes= int(fecha[1])
	# 	anho = int('19'+fecha[2])
	# 	fecha = date(day = dia,month = mes, year = anho)

	# 	superf = Deuda.cell_value(i,8)
	# 	print superf
	# 	print type(superf)
	# 	if(type(superf) == float):
	# 		superf=float(superf)
	# 	else:
	# 		superf = superf.split(',')
	# 		superf= float(superf[0]+'.'+superf[1])		
	# 	hab = int(Deuda.cell_value(i,9))

	# 	dens = Deuda.cell_value(i,10)
	# 	print dens
	# 	print type(superf)
	# 	if(type(dens) == float):
	# 		dens = float(dens)
	# 	else:
	# 		dens=dens.split(',')
	# 		dens= float(dens[0]+'.'+dens[1])
	# 	p.update(fecha_ins=fecha,superficie=superf,habitantes=hab,densidad = dens)