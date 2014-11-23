import csv
from pueblos.models import Provincia


diccionario={}
reader = csv.reader(open('./documentos/provincias.csv', 'rb'))
for row in enumerate(reader):
	i = int(row[1][0])
	nomb = row[1][1]
	diccionario[i] = nomb

for i in diccionario:
	if("/" in diccionario[i]):
		aux = diccionario[i].split("/")
		dsprov = aux[0]
		if dsprov[0] == ' ':
			dsprov = dsprov[1:len(nombre)]
		dspop = aux[1]
		if dspop[0] == ' ':
			dspop = dspop[1:len(nombre)]
		d = Provincia(dsprovincia = dsprov,dspopcional=dspop)
	else:
		d = Provincia(dsprovincia = diccionario[i])
	try:
		d.save()
	except:
		print "It was an error"
