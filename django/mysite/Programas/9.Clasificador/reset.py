from pueblos.models import Noticias
from pueblos.models import Classify
from pueblos.models import NC
from pueblos.models import Usuario
from pueblos.models import Categorias_semandal
from django.db.models import Q
from pueblos.models import Status

sin_cat = Categorias_semandal.objects.get(id=53)
status = Status.objects.get(id = 1)
Noti = Classify.objects.filter(Q(id_user=3) | Q(id_user=4) | Q(id_user=5)).values_list('id_n', flat=True).distinct()
for N in Noti:
	Classify.objects.filter(id_n=N).delete()
	NC.objects.filter(noticia_id=N).delete()
	aux = Noticias.objects.get(id = N)
	nueva_nc = NC(noticia = aux, categoria = sin_cat, confirmada = status)
	nueva_nc.save()	
