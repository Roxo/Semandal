import urllib2
import json

#response = '{"string":"pru'+"'"+'eba"}'
url = "http://95.39.221.207:8000/api/pueblos/"
response = urllib2.urlopen(url)
#print response.read()[570:580]

json.load(response)

