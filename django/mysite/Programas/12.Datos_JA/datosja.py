from pueblos.models import Pueblo
from pueblos.models import Pueblo_infoExtra
import urllib2
from bs4 import BeautifulSoup

print "Empezamos!"
provincias = ["4","11","14","18","21","23","29","41"]
#provincias = ["21","23","29","41"]
#provincias = ["41"]
for p in provincias:
	print "Provincia "+str(p)
	cur = Pueblo.objects.filter(provincia_id = p)
	#cur = Pueblo.objects.filter(id = 6135, opencms = 1)
	for row in cur: 
		print "Pueblo: "+row.busqueda
		try:
			if p == "4":
				url = "http://www.juntadeandalucia.es/institutodeestadisticaycartografia/sima/htm/sm0"+str(row.cp)+".htm"
			else:
				url = "http://www.juntadeandalucia.es/institutodeestadisticaycartografia/sima/htm/sm"+str(row.cp)+".htm"
			html = urllib2.urlopen(url).read()
		except:
			print row.busqueda + " ERROR!!"
			print url
			continue
		soup = BeautifulSoup(html)
		div = soup.body.find('div', attrs={'id' : 'tblMT'})
		temporales = -1
		indefinidos = -1
		for tr in div.find_all('tr'):
			tds = tr.find_all('td')
			for element in tds:
				a = element.find('a')
				if a is not None:
					# fj06 --> indefinidos
					# fj07 --> temporales
					if "fj06" in a['href']:
						indefinidos = int(tds[tds.index(element)+1].text.replace(".", ""))
					if "fj07" in a['href']:
						temporales = int(tds[tds.index(element)+1].text.replace(".", ""))

		if temporales != -1 and indefinidos != -1:
			dato = Pueblo_infoExtra(url_datos = url, pueblo_id = row.id, contrato_temp = temporales, contrato_indef = indefinidos)
			dato.save()
print "FIN!"