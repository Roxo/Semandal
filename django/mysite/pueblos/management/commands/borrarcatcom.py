import sys
sys.path.insert(0, 'C:\Users\Administrador\Desktop\Semandal-new_structure\django\mysite\Programas\8.Borrado')

import BComentarios
import BCategorias

from django.core.management.base import NoArgsCommand

class Command(NoArgsCommand):
    def handle_noargs(self, **options):
		BComentarios.run()
		BCategorias.run()