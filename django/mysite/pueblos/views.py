from django.template import RequestContext, loader
from django.shortcuts import render
from pueblos.models import Pueblo
from pueblos.models import Provincia
from pueblos.models import Noticias
from pueblos.models import Usuario
from pueblos.models import Comentarios
from pueblos.models import Llamadas
from pueblos.models import Categoria
from pueblos.models import Amigode
from django.http import Http404
from django.http import HttpResponse
import json
from django.db.models import Q
from operator import itemgetter

def index(request):
    return HttpResponse("Bienvenidos a SEMANDAL")
    # pueblos = Pueblo.objects.all().order_by('dspueblo')[:5]
    # c = Context({'pueblos': Pueblo,})
    # return render(request, 'pueblos/index.html', c)

# def nombre_pueblo(request, p_id):
    # pbls = Pueblo.objects.filter(provincia = p_id)
    # output = '</br> '.join([p.dspueblo for p in pbls])
    # return HttpResponse(output)
	
def consultaprovincia(pbls,pr):
	obj=''
	r =''
	for p in pbls:
		if p.url != '' and p.url != None:
			if p.redirec != '' and p.redirec != None:
				url = p.redirec
			else:
				url = p.url

		else:
			url = ''
		opcms = '"false"';
		if p.opencms == 1:
			opcms = '"true"'
		obj = '"id": "'+str(p.id)+'", "nombre" : "'+p.dspueblo+'","coordenadas":{"longitud":"'+str(p.longitud)+'","latitud":"'+str(p.latitud)+'"}, "url":"'+url+'", "opencms":'+opcms+', "habitantes":"'+str(p.habitantes)+'", "deuda":"'+str(p.deuda)+'", "deudaxhab":"'+str(float(p.deuda)/float(p.densidad))+'", "fecha_inscripcion":"'+str(p.fecha_ins)+'", "superficie":"'+str(p.superficie).encode('utf8')+'", "wiki":"'+str(p.wiki)+'"'
		obj = '{'+obj+'},'
		r = r+obj
		obj=''
	r=r[0:len(r)-1]
	r = '{"provincia":"'+pr[0].dsprovincia+'","pueblos":['+r+']}'
	return r

def idpueblo(request, p_id):
	try:
		pbls = Pueblo.objects.filter(id = p_id)
	except:
		raise Http404
	pr = Provincia.objects.filter(id = pbls[0].provincia_id)
	template = loader.get_template('pueblos/nombre_pueblo.html')
	context = RequestContext(request, {'lp':pbls[len(pbls)-1],'pbls': pbls, 'pr':pr[0]})
	return HttpResponse(template.render(context))
	
def nombre_pueblo(request, n_pueblo):
	n_pueblo = n_pueblo.split("-")
	consulta = ""
	for i in range(0,len(n_pueblo)):
		if n_pueblo[i] != "de" and n_pueblo[i] != "del" and n_pueblo[i]!="la" and n_pueblo[i]!="los":
			n_pueblo[i] = n_pueblo[i][0].upper() + n_pueblo[i][1:len(n_pueblo[i])].lower()
	for j in n_pueblo:
		consulta = consulta+j+" "
	consulta = consulta[0:len(consulta)-1]
	consulta = consulta[0].upper() + consulta[1:len(consulta)]
	try:
		pbls = Pueblo.objects.filter(busqueda = consulta)
		for i in pbls:
			i.latitud=str(i.latitud).replace(",",".")
			i.longitud=str(i.longitud).replace(",",".")
		pr = Provincia.objects.filter(id = pbls[0].provincia_id)
	except:
		raise Http404
	template = loader.get_template('pueblos/nombre_pueblo.html')
	context = RequestContext(request, {'lp':pbls[len(pbls)-1],'pbls': pbls, 'pr':pr[0]})
	return HttpResponse(template.render(context))


def nombre_prov(request, n_prov):
	n_prov = n_prov.split("-")
	consulta = ""
	for i in range(0,len(n_prov)):
		if n_prov[i] != "de" and n_prov[i] != "del" and n_prov[i]!="la" and n_prov[i]!="los":
			n_prov[i] = n_prov[i][0].upper() + n_prov[i][1:len(n_prov[i])].lower()
	for j in n_prov:
		consulta = consulta+j+" "
	consulta = consulta[0:len(consulta)-1]
	consulta = consulta[0].upper() + consulta[1:len(consulta)]
	pr = Provincia.objects.filter(bprov=consulta)
	if len(pr) == 0:
		pr = Provincia.objects.filter(bprovop=consulta)
	pbls = Pueblo.objects.filter(provincia = pr[0].id)
	for i in pbls:
		i.latitud=str(i.latitud).replace(",",".")
		i.longitud=str(i.longitud).replace(",",".")
	template = loader.get_template('pueblos/nombre_pueblo.html')
	context = RequestContext(request, {'lp':pbls[len(pbls)-1],'pbls': pbls, 'pr':pr[0]})
	return HttpResponse(template.render(context))


def idprovincia(request, prov_id):
	pbls = Pueblo.objects.filter(provincia = prov_id)
	pr = Provincia.objects.filter(id = prov_id)
	template = loader.get_template('pueblos/nombre_pueblo.html')
	context = RequestContext(request, {'lp':pbls[len(pbls)-1],'pbls': pbls, 'pr':pr[0]})
	return HttpResponse(template.render(context))
	
##################################################API#############################################################

def idpuebloapi(request, p_id):
	try:
		pbls = Pueblo.objects.filter(id = p_id)
	except:
		raise Http404
	if len(pbls) != 0:
		pr = Provincia.objects.filter(id = pbls[0].provincia_id)
		for i in pbls:
			i.latitud=str(i.latitud).replace(",",".")
			i.longitud=str(i.longitud).replace(",",".")
		var=consultaprovincia(pbls,pr)
	else:
		var = '{"pueblos":"No existe ese pueblo"}'
	agregarabd("api/pueblos/"+p_id)
	return HttpResponse(var)

	
def nombre_puebloapi(request, n_pueblo):
	pueblo = n_pueblo
	n_pueblo = n_pueblo.split("-")
	consulta = ""
	for i in range(0,len(n_pueblo)):
		if n_pueblo[i] != "de" and n_pueblo[i] != "del" and n_pueblo[i]!="la" and n_pueblo[i]!="los":
			n_pueblo[i] = n_pueblo[i][0].upper() + n_pueblo[i][1:len(n_pueblo[i])].lower()
	for j in n_pueblo:
		consulta = consulta+j+" "
	consulta = consulta[0:len(consulta)-1]
	consulta = consulta[0].upper() + consulta[1:len(consulta)]
	pbls = Pueblo.objects.filter(busqueda = consulta)
	if len(pbls) != 0:
		for i in pbls:
			i.latitud=str(i.latitud).replace(",",".")
			i.longitud=str(i.longitud).replace(",",".")
		pr = Provincia.objects.filter(id = pbls[0].provincia_id)
		var=consultaprovincia(pbls,pr)
	else:
		var = '{"pueblos":"No existe ese pueblo"}'
	agregarabd("api/pueblos/"+pueblo)
	return HttpResponse(var)


def nombre_provapi(request, n_prov):
	n_prov = n_prov.split("-")
	consulta = ""
	for i in range(0,len(n_prov)):
		if n_prov[i] != "de" and n_prov[i] != "del" and n_prov[i]!="la" and n_prov[i]!="los":
			n_prov[i] = n_prov[i][0].upper() + n_prov[i][1:len(n_prov[i])].lower()
	for j in n_prov:
		consulta = consulta+j+" "
	consulta = consulta[0:len(consulta)-1]
	consulta = consulta[0].upper() + consulta[1:len(consulta)]
	pr = Provincia.objects.filter(bprov=consulta)
	if len(pr) == 0:
		pbls = Pueblo.objects.filter(provincia = pr[0].id)
		for i in pbls:
			i.latitud=str(i.latitud).replace(",",".")
			i.longitud=str(i.longitud).replace(",",".")
		var=consultaprovincia(pbls,pr)
	else:
		var = '{"provincia":"No existe esa provicia"}'
	agregarabd("api/provincias/"+n_prov)
	return HttpResponse(var)


def idprovinciaapi(request, prov_id):
	pbls = Pueblo.objects.filter(provincia = prov_id)
	if len(pbls) == 0:
		for i in pbls:
			i.latitud=str(i.latitud).replace(",",".")
			i.longitud=str(i.longitud).replace(",",".")
		pr = Provincia.objects.filter(id = prov_id)
		var=consultaprovincia(pbls,pr)
	else:
		var = '{"provincia":"No existe esa provicia"}'
	agregarabd("api/provincias/"+prov_id)
	return HttpResponse(var)

def busqueda(request, n_pueblo):
	devolver = n_pueblo
	n_pueblo = n_pueblo.split("-")
	consulta = ""
	for i in range(0,len(n_pueblo)):
		if n_pueblo[i] != "de" and n_pueblo[i] != "del" and n_pueblo[i]!="la" and n_pueblo[i]!="los":
			n_pueblo[i] = n_pueblo[i][0].upper() + n_pueblo[i][1:len(n_pueblo[i])].lower()
	for j in n_pueblo:
		consulta = consulta+j+" "
	consulta = consulta[0:len(consulta)-1]
	consulta = consulta[0].upper() + consulta[1:len(consulta)]
	pbls = Pueblo.objects.filter(busqueda__contains=consulta);
	if len(pbls) == 0:
		for i in pbls:
			i.latitud=str(i.latitud).replace(",",".")
			i.longitud=str(i.longitud).replace(",",".")
		var = uri_pueblos(pbls)
	else:
		var = '{"pueblos":"No existe un pueblo parecido"}'
	agregarabd("api/busqueda/"+devolver)
	return HttpResponse(var)

def noticias(request,p_id,ind1,ind2):
	p = Pueblo.objects.filter(id = p_id)
	if len(p) != 0:
		noticias = Noticias.objects.filter(pueblo = p)[ind1:ind2]
		var = get_noticias(noticias)
	else:
		var='{"noticias":"No existen noticias en este pueblo"}'
	agregarabd("api/pueblos/"+p_id+"/noticias/")
	return HttpResponse(var);

def amigos(request,id_user):
	id_amigos = Amigode.objects.filter(id=id_user)
	if len(id_amigos) != 0:
		retrieveamigos=""
		for i in id_amigos:
			usuario=i
			retrieveamigos=retrieveamigos+'{"id_amigo":"'+usuario.id+'","amigo":"'+usuario.dsusuario+'"},'
		retrieveamigos=retrieveamigos[0:len(retrieveamigos)-1]
		ret='{"amigos":['+retrieveamigos+']}'
	else:
		ret = '{"amigos":"este usuario no tiene amigos"}'
	return HttpResponse(ret)

def getperfil(request,id_user):
	user = Usuario.objects.filter(id= id_user)[0]
	if len(user) != 0:
		t = user.pueblo.id
		pueblo = Pueblo.objects.filter(id = t)[0]
		retrievecomentarios=getlastcomentarios(id_user)
		ret = '{"id":"'+user.dsusuario+'","pueblo":"'+pueblo.dspueblo+'","busquedaimagenes":"'+pueblo.busqueda.replace(" ","_")+'","comentarios_recientes":['+retrievecomentarios+']}'
	else:
		ret = '{"id":"este usuario no existe"}'
	agregarabd("api/usuario/"+id_users)
	return HttpResponse(ret)

def llamadas(request):
	ll = Llamadas.objects.all()
	obj = ""
	for i in ll:
		obj = obj+'{"uri":"'+i.llamada+'","veces":"'+str(i.contabilizacion)+'"},'
	obj = obj[0:len(obj)-1]
	obj = '{"llamadas":['+obj+']}'
	return HttpResponse(obj)

def getlastcomentarios(id_usuario):
	rez = Comentarios.objects.filter(id_user=id_usuario)[:5]
	obj=""
	for i in rez:
		obj = obj+'{"comentario":"'+i.dscomentario+'"},'
	obj = obj[0:len(obj)-1]
	return obj

def getnot(request,n_id):
	noticia = Noticias.objects.filter(id=n_id)
	if len(noticia) != 0:
		noticia=noticia[0]
		obj = ""
		obj = '{"id_noticia"="'+str(noticia.id)+'","titular":"'+noticia.dstitular.replace('"','\"')+'","cuerpo":"'+noticia.dscuerpo.replace('"','\"')+'","fecha":"'+str(noticia.fecha)+'"}'
	else:
		obj = '{"id_noticia"="No existe esta noticia"}'
	agregarabd("api/noticias/"+n_id)
	return HttpResponse(obj)

def getcomentarios(request,n_id):
	rez = Comentarios.objects.filter(id_not=n_id)
	if len(rez) != 0:
		obj=""
		for i in rez:
			obj = obj+'{"id_user":"'+str(i.id_user.id)+'","usuario":"'+i.id_user.dsusuario+'","comentario":"'+i.dscomentario+'","puntuacion":"'+str(int(i.puntuacion))+'"},'
		obj = obj[0:(len(obj)-1)]
		obj = '{"comentarios":['+obj+']}'
	else:
		obj = '{"comentarios":"No existen comentarios en esta noticia"}'
	agregarabd("api/noticias/"+n_id)
	return HttpResponse(obj)

def get_noticias(noticias):
	obj = ''
	r = ''
	categorias = ''
	for n in noticias:
		etiqueta = n.etiqueta
		if etiqueta != None:
			categorias=Categoria.objects.filter(id=etiqueta.id)[0]
			categorias=categorias.dscategoria
		obj = '"id_noticia":"'+str(n.id)+'","dstitular":"'+n.dstitular.replace('"','\"')+'","dscuerpo":"'+n.dscuerpo.replace('"','\"')+'","resumen":"'+n.resumen.replace('"','\"')+'","url":"'+n.url+'","fecha": "'+str(n.fecha)+'","Categorias":"'+categorias+'"'
		obj = '{'+obj+'},'
		r=r+obj
		obj=''
		categorias = ''
	r=r[0:len(r)-1]
	r = '{"noticias":['+r+']}'
	return r



def uri_pueblos(pbls):
	obj=''
	r =''
	for p in pbls:
		if p.url != '' and p.url != None:
			if p.redirec != '' and p.redirec != None:
				url = p.redirec
			else:
				url = p.url
		else:
			url = ''
		opcms = '"false"';
		if p.opencms == 1:
			opcms = '"true"'
		obj = '"nombre" : "'+p.dspueblo+'","uri":"http://opendatalab.uhu.es:8000/api/pueblos/'+str(p.busqueda).replace(" ","-")+'"'
		obj = '{'+obj+'},'
		r = r+obj
		obj=''
	r=r[0:len(r)-1]
	r = '{"pueblos":['+r+']}'
	return r

def agregarabd(uri):
	obj = Llamadas.objects.filter(llamada = uri)
	if len(obj) == 0:
		nueva = Llamadas(llamada=uri)
		nueva.save()
	else:
		obj[0].contabilizacion = obj[0].contabilizacion + 1
		obj[0].save()

def verpueblo(request):
	pueblos = Pueblo.objects.filter(Q(provincia_id=4)|Q(provincia_id=11)|Q(provincia_id=14)|Q(provincia_id=18)|Q(provincia_id=21)|Q(provincia_id=29)|Q(provincia_id=41)).order_by('dspueblo')
	obj=''
	r=''
	for p in pueblos:
		obj='"idpueblo":"'+str(p.id)+'","nombre":"'+p.dspueblo+'"'
		obj = '{'+obj+'},'
		r=r+obj
		obj=''
	r=r[0:len(r)-1]
	r='{"npueblos":"'+str(len(pueblos))+'","pueblos":['+r+']}'
	return HttpResponse(r)


def vercategorias(request):
	cat = Categoria.objects.all()
	d = {}
	for p in cat:
		if p.dscategoria not in d:
			d[p.dscategoria]='{"id":"'+str(p.id)+'"}'
		else:
			string = d[p.dscategoria] + ',{"id":"'+str(p.id)+'"}'
			d[p.dscategoria]=string
	dic=sorted(d)
	r=''
	obj=''
	for c in dic:
		obj = '{"categoria":"'+c+'","identificadores":['+d[c]+']},'
		r = r+obj
	r=r[0:len(r)-1]
	r='{"ncategorias":"'+str(len(d))+'","categorias":['+r+']}'
	return HttpResponse(r)

def lastnot(request):
	noti=Noticias.objects.order_by('id').reverse()
	n=noti[0]
	i=1
	while n.dscuerpo == None and n.resumen == "Ampliar Noticias":	
		n=noti[i]
	if n.dscuerpo == None:
		x=n.resumen
	else:
		x=n.dscuerpo
	obj='{"notid":"'+str(n.id)+'","titular":"'+n.dstitular+'","cuerpo":"'+x+'","fecha":"'+str(n.fecha)+'"}'
	return HttpResponse(obj)

def lastcomment(request):
	c = Comentarios.objects.order_by('id').reverse()[0]
	obj='{"comentarioid":"'+str(c.id)+'","idautor":"'+str(c.id_user.id)+'","autor":"'+c.id_user.dsusuario+'","cuerpo":"'+c.dscomentario+'","puntuacion":"'+str(c.puntuacion)+'","notid":"'+str(c.id_not.id)+'"}'
	return HttpResponse(obj)

def busqueda(resques,datos):
	kwargs={}
	datos = datos[1:len(datos)-1]
	if datos is not "":
		datos = datos.split(',')
		for i in datos:
			if "id_p" in i :
				kwargs['pueblo_id'] = i.split(':')[1]
			elif "id_c" in i:
			#	kwargs['etiqueta_id'] = i.split(':')[1]
				a = getcomment(kwargs,i.split(':')[1])#
				return HttpResponse(a)
			elif "_t" in i:
				kwargs['dstitular'] = i.split(':')[1]
			elif "_d" in i:
				kwargs['fecha'] = i.split(':')[1]
			else:
				return HttpResponse('{"Resultado":"datos erroneos"}')
		n = Noticias.objects.filter(**kwargs)
		if len(n) is not 0:
			obj = ''
			r = ''
			for s in n:
				obj='{"noticia_id":"'+str(s.id)+'","titular":"'+s.dstitular+'","fecha":"'+str(s.fecha)+'"},'
				r = r + obj
			r = r[0:len(r)-1]
			r = '{"resultado":['+r+']}'
			return HttpResponse(r)
		else:
			return HttpResponse('{"resultado":"No existe una noticia con esas caracteristicas"}')
	else:
		return HttpResponse('{"resultado":"Debe insertar al menso un campo"}')

def parseanoticias(n):
	r = ''
	if len(n) is not 0:
		obj = ''
		for s in n:
			obj='{"noticia_id":"'+str(s.id)+'","titular":"'+s.dstitular+'","fecha":"'+str(s.fecha)+'"},'
			r = r + obj
	return r	

def getcomment(kwargs,etiquetas):
	t=etiquetas.split('-')
	string = ''
	for k in t:
		kwargs['etiqueta_id']=k
		n = Noticias.objects.filter(**kwargs)
		string = string+parseanoticias(n)
	string =string[0:len(string)-1]
	string = '{"resultado":['+string+']}'
	return string


