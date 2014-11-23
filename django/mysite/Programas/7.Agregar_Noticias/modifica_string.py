#!/usr/bin/env python
import uuid

def elimina_comentarios(html):

	filename = str(uuid.uuid4())
	tf = open("./logs/" + filename, 'w')
	tf.write(html.encode('utf-8'))
	tf.write("\n")
	tf.write("-----------------------------------------\n")
	parseado = ""
	i = 0
	while i < len(html):
		if html[i] == "[" or html[i] == "<":
			if html[i] == "<":
				while html[i] != ">":
						i=i+1
				i = i + 1
				continue
			i = i + 1
			if html[i] == 'i' and html[i+1] == 'f':
				try:
					while html[i] != "[":
						i=i+1
				except:
					file = open("errorlog.txt", 'w')
					file.write(html.encode('utf-8'))
					file.write("\n")
					file.write("-------------------------------------------------------------\n")
					file.write(parseado.encode('utf-8'))
					file.close()
					raise SystemExit("Error Eliminando comentarios!")
				i=i+7
			else:
				i = i + 1
		else:
			parseado += html[i]
			i=i+1
	tf.write(parseado.encode('utf-8'))
	tf.close()
	return parseado

def elimina_blancos(cadena):
	if cadena is not None and len(cadena) != 0:
		inicio = 0
		fin = len(cadena) - 1
		while not cadena[inicio].isalnum():
			inicio = inicio + 1
		while not cadena[fin].isalnum() and inicio != fin:
			fin = fin - 1
		cadena = cadena[inicio:fin]
	
	return cadena