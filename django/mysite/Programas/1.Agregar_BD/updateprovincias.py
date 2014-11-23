# -*- coding: utf-8 -*-
import csv
from pueblos.models import Provincia


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
	if("," in nombre):
		aux = nombre.split(",")
		aux[1].replace(" ","")
		nombre = aux[1]+" "+aux[0]
		if nombre[0] == ' ':
			nombre = actualizar[1:len(nombre)]
	return nombre

pr = Provincia.objects.all()
for i in pr:
	prov = Provincia.objects.filter(id = i.id)
	actualizar = replaceutf(prov[0].dsprovincia.encode('utf8'))
	if actualizar[0] == ' ':
		actualizar = actualizar[1:len(actualizar)]
	new_act = None
	if prov[0].dspopcional != None:
		new_act = replaceutf(prov[0].dspopcional.encode('utf8'))
		if new_act[0] == ' ':
			new_act = actualizar[1:len(new_act)]
		prov.update(bprovop=new_act)
	prov.update(bprov=actualizar,bprovop=new_act)