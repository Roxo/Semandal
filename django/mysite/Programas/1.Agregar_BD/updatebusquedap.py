# -*- coding: utf-8 -*-
import csv
from pueblos.models import Pueblo

def replaceutf(nombre):
	nombre = nombre.replace("á","a")
	nombre = nombre.replace("é","e")
	nombre = nombre.replace("í","i")
	nombre = nombre.replace("ó","o")
	nombre = nombre.replace("ú","u")
	nombre = nombre.replace("Á","A")
	nombre = nombre.replace("É","E")
	nombre = nombre.replace("Í","I")
	nombre = nombre.replace("Ó","O")
	nombre = nombre.replace("Ú","U")	
	nombre = nombre.replace("ñ","n")
	nombre = nombre.replace("Ñ","N")
	if("," in nombre):
		aux = nombre.split(",")
		nombre = aux[1]+" "+aux[0]
		if nombre[0] == ' ':
			nombre = nombre[1:len(nombre)]
	return nombre

pr = Pueblo.objects.all()
for i in pr:
	prov = Pueblo.objects.filter(id = i.id)
	n1 = prov[0].dspueblo.encode('utf8')
	n2 = prov[0].dsopcional.encode('utf8')
	b1 = replaceutf(n1)
	b2 = replaceutf(n2)
	prov.update(busqueda=b1,busquedaop=b2)