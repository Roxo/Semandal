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
        print "CONTENT " + url
        return None
    if "actualidad" in url:
        if "noticias" in url:
            if "index.jsp" in url:
                lista = localizador.get_directorios(url)
                if len(lista) == 0:
                    print "TIPO 2 " + url
                    return url
                else:
                    print "TIPO 1 o 4 " + url
                    return None
            else:
                print "TIPO 5 " + url
                return None
        else:
            print "TIPO 1 o 4 " + url
            return
    if "noticias" in url:
        print "TIPO 5 " + url
        return None
    if "noticias.html?general=true" in url:
        print "TIPO 6 " + url
        return None
    if "home.jsp" in url:
        print "TIPO 7 " + url
        return None
	
print "Empezamos!"
f  = open('log.txt','w')
provincias = ["4","11","14","18","21","23","29","41"]
#provincias = ["41"]
for p in provincias:
    cur = Pueblo.objects.filter(provincia_id = p, opencms = 1)
    #cur = Pueblo.objects.filter(id = 6134, opencms = 1)
    for row in cur: 
        if row.url != '' and "trebujena" not in row.url and "cambil" not in row.url:
           aux = extraer(localizador.getURLNoticias(row.url), row.id)
           if aux is not None:
               f.write(aux.encode('utf-8')+"\n")  
print "FIN!"
f.close()
