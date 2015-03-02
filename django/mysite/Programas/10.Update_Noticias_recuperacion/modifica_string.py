#!/usr/bin/env python
import uuid

def elimina_comentarios(html):

	#filename = str(uuid.uuid4())
	#tf = open("./logs/" + filename, 'w')
	#tf.write(html.encode('utf-8'))
	#tf.write("\n")
	#tf.write("-----------------------------------------\n")
	if html is None:
		return ""
	parseado = ""
	i = 0
	while i < len(html):
		if html[i] == "[" or html[i] == "<":
			if html[i] == "<":
				while i < len(html) and html[i] != ">":
						i=i+1
				i = i + 1
				continue
			i = i + 1
			if html[i] == 'i' and html[i+1] == 'f':
				try:
					copiadei = i
					while html[i] != "[":
						i=i+1
				except:
					i = copiadei
					while html[i] != "]":
						i=i+1
					i = i + 1
					continue
				i=i+7
			else:
				i = i + 1
		else:
			parseado += html[i]
			i=i+1
	#tf.write(parseado.encode('utf-8'))
	#tf.close()
	return parseado
def elimina_char_especial(cadena):
	parseado = ""
	lista_negra = [56256, 56441, 159, 8230, 776, 129]
	comillas = [171, 187, 8220, 8221, 34, 8223, 8216, 8217, 8219, 8221, 8242, 8243, 8245, 8246, 8249, 8250]
	if cadena is None:
		return None
	if len(cadena) != 0:
		i = 0
		while i < len(cadena):
			if ord(cadena[i]) in comillas:
				parseado += "'"
				i = i + 1
				continue
			if ord(cadena[i]) in lista_negra:
				i = i + 1
				continue
			try:
				cadena[i].encode('latin-1')
				parseado += cadena[i]
			except:
				pass
			i=i+1

	return parseado
def elimina_blancos(cadena):
	if cadena is not None and len(cadena) != 0:
		inicio = 0
		fin = len(cadena) - 1
		while inicio != fin and not cadena[inicio].isalnum():
			inicio = inicio + 1
		while inicio != fin and not cadena[fin].isalnum():
			fin = fin - 1
		cadena = cadena[inicio:fin+1]
	
	return cadena
