import csv
from pueblos.models import Categoria

diccionario={}
reader = csv.reader(open('./documentos/n_Categorias.csv', 'rb'))
for row in enumerate(reader):
	print row
	n = Categoria(dscategoria=row[1][1],etiqueta_padre=row[1][2],etiqueta=row[1][3])
	n.save()