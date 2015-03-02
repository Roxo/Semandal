import sys
sys.path.insert(0, 'C:/Users/Administrador/Desktop/django/mysite/Programas/10.Update_Noticias/')
sys.path.insert(0, 'C:/Users/Administrador/Desktop/django/mysite/Programas/9.Clasificador/')
import update
import clasificador
from django.core.management.base import NoArgsCommand

class Command(NoArgsCommand):
    def handle_noargs(self, **options):
		update.run()
		clasificador.run()