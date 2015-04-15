#!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib2
import re
import os

from pueblos.models import Pueblo
from pueblos.models import Provincia
from django.db.models import Q




listaprov = [4,11,14,18,21,23,29,41]

npueblos = 0
ncms = 0
nredir = 0
for j in listaprov:
	p = Pueblo.objects.filter(provincia_id = j)
	print len(p)
	npueblos = npueblos + len(p)
	p = Pueblo.objects.filter(provincia_id = j,opencms = True)
	ncms = ncms + len(p)
	p = Pueblo.objects.filter(~Q(redirec = ""),provincia_id = j)

	nredir = nredir + len(p)

print "npueblos: "+str(npueblos)
print "ncms: " + str(ncms)
print "nredir: "+ str(nredir)