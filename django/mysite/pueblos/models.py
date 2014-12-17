from django.db import models
from mysite import settings
from datetime import date
import datetime

# Create your models here.
class Provincia(models.Model):
	dsprovincia = models.CharField(max_length=200,unique = True)
	dspopcional = models.CharField(max_length=200,unique = True,null=True)
	bprov = models.CharField(max_length=200,unique = True)
	bprovop = models.CharField(max_length=200,unique = True,null=True
)	
	def __str__(self):
		return self.id
			
class Pueblo(models.Model):
	dspueblo = models.CharField(max_length=200)
	dsopcional = models.CharField(max_length=200)
	cp = models.PositiveIntegerField()
	latitud = models.DecimalField(max_digits=11, decimal_places=7, null = True)
	longitud = models.DecimalField(max_digits=11, decimal_places=7, null = True)
	busqueda = models.CharField(max_length=200)
	busquedaop = models.CharField(max_length=200)
	url = models.CharField(max_length=200,null =True)
	opencms = models.BooleanField(default = False)
	redirec = models.CharField(max_length=200,null = True)
	provincia = models.ForeignKey(Provincia)
	habitantes = models.PositiveIntegerField(null = True)
	deuda = models.FloatField(null = True)
	deudaxhab = models.DecimalField(max_digits=11, decimal_places=7, null = True)
	densidad = models.DecimalField(max_digits=7, decimal_places=2, null = True)
	superficie = models.DecimalField(max_digits=7, decimal_places=2, null = True)
	fecha_ins = models.DateField()
	wiki = models.CharField(max_length=300)

	
	def __str__(self):
		return self.busqueda

class Categoria(models.Model):
	dscategoria = models.CharField(max_length=100)
	etiqueta_padre = models.CharField(max_length=100)
	etiqueta = models.CharField(max_length=100)

class Noticias(models.Model):
	pueblo = models.ForeignKey(Pueblo)
	dstitular = models.CharField(max_length=1500,null = True)
	dscuerpo = models.CharField(max_length=50000,null = True)
	fecha = models.DateField(null=True)
	resumen = models.CharField(max_length=2500,null=True)
	url = models.CharField(max_length=300,null=True)
	etiqueta = models.ForeignKey(Categoria,null=True)
	liked = models.PositiveIntegerField(default=0)
	
class Usuario(models.Model):
	dsusuario =  models.CharField(max_length=100,unique=True)
	dsnombre = models.CharField(max_length=100)
	dsapellido1 = models.CharField(max_length=100)
	dsapellido2 = models.CharField(max_length=100)
	pueblo = models.ForeignKey(Pueblo)
	token = models.CharField(max_length=200)
	correo = models.CharField(max_length=100,null=True,unique=True)

class Amigode(models.Model):
	idamistad = models.ForeignKey(Usuario,related_name='soy_amigo')
	idamigode = models.ForeignKey(Usuario,related_name='es_mi_amigo')
	class Meta:
		unique_together = ('idamistad', 'idamigode')

class Comentarios(models.Model):
	dscomentario = models.CharField(max_length=200)
	id_user = models.ForeignKey(Usuario)
	id_not = models.ForeignKey(Noticias)
	puntuacion = models.FloatField(default=0)
	fecha = models.DateTimeField()

class Llamadas(models.Model):
	llamada = models.CharField(max_length=300)
	contabilizacion = models.PositiveIntegerField(default=0)

class SigP(models.Model):
	id_user = models.ForeignKey(Usuario)
	id_p = models.ForeignKey(Pueblo)
	class Meta:
		unique_together = ('id_user', 'id_p')

class SigP(models.Model):
	id_user = models.ForeignKey(Usuario)
	id_p = models.ForeignKey(Pueblo)
	class Meta:
		unique_together = ('id_user', 'id_p')

class Liked(models.Model):
	id_user = models.ForeignKey(Usuario)
	id_n = models.ForeignKey(Noticias)
	class Meta:
		unique_together = ('id_user', 'id_n')
