from pueblos.models import Reglas_Ontologia
from pueblos.models import Categorias_semandal
from pueblos.models import NC
from pueblos.models import Status


if __name__ == "__main__":
	print "Procesando..."
	status = Status.objects.get(id = 1)
	reglas = Reglas_Ontologia.objects.all()
	for r in reglas:
		print "\t procesando regla.."
		nc = NC.objects.filter(categoria = r.etiqueta)
		for n in nc:
			try:
				NC.objects.get(noticia=n.noticia, categoria=r.subcategoria_de)
			except NC.DoesNotExist:
				aux = NC(noticia=n.noticia, categoria=r.subcategoria_de, confirmada = status)
				aux.save()
	print "FIN!"