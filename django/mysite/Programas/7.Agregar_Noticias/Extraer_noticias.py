import sys
sys.path.insert(0, 'C:/Users/Administrador/Desktop/django/mysite/Programas/7.Agregar_Noticias/')
import localizador
import noticias_content
import noticias_tipo1
import noticias_tipo2
import noticias_tipo5
import noticias_tipo6
import noticias_tipo7
import urllib2
import MySQLdb
import time
from pueblos.models import Pueblo
def extraer(url, p_id):
    """
    Funcion que determina el tipo de noticia que se debe extraer
    """
    if "content" in url:
        lista = localizador.get_content(url[:-26])
        for element in lista:
            url2 = url[:-26] + "content/noticias_list_xmlpage.html?target=" + element
            noticias_content.extraer(url2, 1, p_id)
        return
    if "actualidad" in url:
        if "noticias" in url:
            if "index.jsp" in url:
                lista = localizador.get_directorios(url)
                if len(lista) == 0:
                    noticias_tipo2.extraer(url[:-18], 1,p_id)
                    return
                else:
                    for element in lista:
                        url2 = url[:-9] + element + '/'
                        noticias_tipo1.extraer(url2, 1,p_id)
                    return
            else:
                noticias_tipo5.extraer(url, 1,p_id)
                return
        else:
            lista = localizador.get_directorios(url)
            for element in lista:
                url2 = url + element + '/'
                noticias_tipo1.extraer(url2, 0, p_id)
            return
    if "noticias" in url:
        noticias_tipo5.extraer(url, 1, p_id)
        return
    if "noticias.html?general=true" in url:
        noticias_tipo6.extraer(url, 1, p_id)
        return
    if "home.jsp" in url:
        noticias_tipo7.extraer(url, 1, p_id)
        return
	
print "Empezamos!"
#provincias = ["4","11","14","18","21","23","29","41"]
provincias = ["41"]
for p in provincias:
    cur = Pueblo.objects.filter(provincia_id = p, opencms = 1)
    #cur = Pueblo.objects.filter(id = 6135, opencms = 1)
    for row in cur: 
        if row.url != '' and "trebujena" not in row.url and "cambil" not in row.url:
            extraer(localizador.getURLNoticias(row.url), row.id)
print "FIN!"

