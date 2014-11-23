#!/usr/bin/env python
# -*- coding: utf-8 -*-
import urllib2
import json
import re

from pueblos.models import Pueblo

k = 0;
p = Pueblo.objects.all()
for i in range(0,len(p)):
	if (i-k != 1):
		print "peta en el pueblo "+i
	k = i