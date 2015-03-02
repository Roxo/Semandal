from pueblos.models import Reglas_Ontologia
from pueblos.models import Categorias_semandal

Reglas_Ontologia.objects.all().delete()
with open("./Programas/11.Reglas_Ontologia/reglas.txt") as f:
    lines = f.readlines()
for l in lines:
	partes = l.split(" -> ")
	try:
		c1 = Categorias_semandal.objects.get(id = int(partes[0]))
	except Categorias_semandal.DoesNotExist:
		print "Error: Categoria "+partes[0]+" no encontrada"
		print " -> Regla (" + l +") ignorada"
		continue
	try:
		c2 = Categorias_semandal.objects.get(id = int(partes[1]))
	except Categorias_semandal.DoesNotExist:
		print "Error: Categoria "+partes[1]+" no encontrada"
		print " -> Regla (" + l +") ignorada"
		continue
	nueva_regla = Reglas_Ontologia(etiqueta = c1, subcategoria_de = c2)
	nueva_regla.save()
	print "Regla ("+l+") aceptada"