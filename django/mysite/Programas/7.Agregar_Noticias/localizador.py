"""Modulo localizador
Encargado de determinar el lugar donde se encuentran las noticias de una URL determinada.
"""
__author__ = "Angel Canto"
__date__ = "26 Abril 2014"
__version__ = "$Revision: 1.0 $"
__credits__ = """SEMANDAL"""

import itertools
import re
import urllib2


def test(url):
    """
    Obtener informacion de la web (Servidor HTTP, SO, URL, redirecciones, etc)
    
    Parametros:
        url - Direccion web
    """
    respuesta = urllib2.urlopen(url)
    print respuesta.geturl();
    print respuesta.getcode();
    print respuesta.info();
    #print respuesta.read();
def get_content(url):
    print url
    respuesta = ""
    try:
        respuesta = urllib2.urlopen(url)
    except:
        return []
    html = respuesta.read()
    partes = url.split('/')
    fin = len(partes)
    http = partes[0] + "//" + partes[2]
    if partes[len(partes) - 1] == '':
        fin = fin - 1
    clave = '/'
    for x in range(3, fin):
        clave = clave + partes[x] + '/'
    clave = clave + "content/"
    clave = clave + "[^/']+"
    urls = re.findall(r'href=[\'"]?([^\'" >]+)', html)
    urls2 = []
    for y in range(0, len(urls)):
        aux = re.findall(clave, urls[y])
        if(len(aux) != 0):
            if not '.' in aux[0]:
                #aux[0] = http + aux[0] + "/index_xmlpage.html"
                l = aux[0].split('/')
                urls2.append(l[-1])
    urls2 = list(set(urls2)) #Elimina repetidos
    return urls2
def get_directorios(url):
    """
    Busca subdirectorios de primer nivel de una web
    
    Parametros:
        url - Direccion web
    """
    print url
    respuesta = ""
    try:
        respuesta = urllib2.urlopen(url)
    except:
        return []
    html = respuesta.read()
    partes = url.split('/')
    http = partes[0] + "//" + partes[2]
    if partes[len(partes) - 1] == '':
        del partes[len(partes) - 1]
    fin = len(partes)
    if '.' in partes[len(partes) - 1]:
        fin = fin - 1
    clave = '/'
    for x in range(3, fin):
        clave = clave + partes[x] + '/'
    clave = clave + "[^/']+"
    urls = re.findall(r'href=[\'"]?([^\'" >]+)', html)
    urls2 = []
    for y in range(0, len(urls)):
        aux = re.findall(clave, urls[y])
        if(len(aux) != 0):
            if not '.' in aux[0]:
                #aux[0] = http + aux[0]
                l = aux[0].split('/')
                aux[0] = l[-1]
                if "content" in aux[0]:
                    aux[0] = aux[0] + "/index_xmlpage.html"
                urls2.append(aux[0])
    urls2 = list(set(urls2)) #Elimina repetidos
    return urls2
def URLCompleta(url):
    """ Obtener URL completa (La ruta con opencms) suponiendo que se usa opencms
        Se cubren tres casos:
            Se obtiene un codigo html que fuerza un refresco de la pagina con una nueva url
            Redireccion automatica
            La pagina principal se encuentra en el directorio raiz (No es necesario hacer redireccion)
        Parametros:
            url - Direccion web
    
    """
    try:
        respuesta = urllib2.urlopen(url)
    except:
        print "URL ERRONEA " + url
        return ""
    print respuesta.geturl()
    if "opencms" in respuesta.geturl():
        if respuesta.geturl()[-1] == '/':
            return respuesta.geturl()
        else:
            return respuesta.geturl() + '/'
    codigo_html = respuesta.read()
    if "HTTP-EQUIV=" in codigo_html:
        nueva_url = re.findall('HTTP-EQUIV="REFRESH" content="0; url=\W((\W|\w)+)"\W*>', codigo_html, re.I)
        if "index" in nueva_url[0][0]:
            opencms = nueva_url[0][0][:-10]
        else:
            opencms = nueva_url[0][0]
        if opencms[-1] != '/':
            opencms = opencms + '/'
        return url + opencms
    else:
        enlaces = re.findall(r'href=[\'"]?([^\'" >]+)', codigo_html)
        enlaces_aux = []
        for X in enlaces:
            if X[0] == '/':
                partes = X.split('/')
                Y = partes[1] + '/' + partes[2] + '/' + partes[3] + '/'
                enlaces_aux.append(Y)
                
        return url + most_common(enlaces_aux)

def most_common(L):
    """ Obtiene el elemento mas comun de una lista 
    
        Parametros:
            L - Lista para analizar 
    """
    groups = itertools.groupby(sorted(L))
    def _auxfun((item, iterable)):
        return len(list(iterable)), -L.index(item)
    return max(groups, key=_auxfun)[0]
def URLNoticias(url):
    """ Obtiene la URL donde se encuentran las noticias partiendo de una URL completa
    
        Parametros:
            url - Direccion web
    
    """
    opciones = ["content/index_xmlpage.html", "actualidad/noticias/index.jsp", "actualidad/noticias/", "actualidad/", "noticias/", "Servicios/noticias/", "noticias.html?general=true"]
    for op in opciones:
        try:
            d = url+op
            urllib2.urlopen(d)
            return d
        except:
            pass
    return url      
def getURLNoticias(url):
    """ Obtiene la URL donde se encuentran las noticias partiendo de una URL simple
    
        Parametros:
            url - Direccion web
    
    """
    return URLNoticias(URLCompleta(url))

