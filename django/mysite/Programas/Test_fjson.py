import urllib2
import json 

url = "http://localhost:8000/api/pueblos/1766/noticias/"
resultado = urllib2.urlopen(url)
resultado = resultado.read()
sjson = json.loads(resultado)
print sjson
