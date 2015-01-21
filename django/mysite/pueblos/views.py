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
import datetime
import operator
from django.http import HttpResponse
import json
from django.db.models import Q
from operator import itemgetter
from django.db.models import Count
from pueblos.models import SigP
from pueblos.models import T_Liked
from pueblos.models import Classify
from pueblos.models import Categorias_semandal
from pueblos.models import NC
from pueblos.models import Votaciones
from pueblos.models import Status
from pueblos.models import Denuncias_C
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
			url = 'Este pueblo no tiene web'
		opcms = 'false';
		if p.opencms == 1:
			opcms = 'true'
		wiki = 'No existe'
		if p.wiki != None:
			wiki = p.wiki
		obj = '"id": '+str(p.id)+', "dspueblo" : "'+str(p.dspueblo.encode("utf8"))+'","coordenadas":{"longitud":'+str(p.longitud)+',"latitud":'+str(p.latitud)+'}, "url":"'+url.encode("utf8")+'", "opencms":'+opcms+', "habitantes":'+str(p.habitantes)+', "deuda":'+str(p.deuda)+', "deudaxhab":'+str(float(p.deuda)/float(p.densidad))+', "fecha_inscripcion":"'+str(p.fecha_ins)+'", "superficie":'+str(p.superficie).encode('utf8')+', "wiki":"'+str(wiki.encode("utf8"))+'", "cp":'+str(p.cp)
		obj = '{'+obj+'},'
		r = r+obj
		obj=''
	r=r[0:len(r)-1]
	r = '{"id_provincia":'+str(pr[0].id)+',"provincia":"'+pr[0].dsprovincia.encode("utf8")+'","npueblos":"'+str(len(pbls))+'","pueblos":['+r+']}'
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
	pr = Provincia.objects.filter(dsprovincia__icontains=n_prov)
	if len(pr) != 0:
		pbls = Pueblo.objects.filter(provincia__id = pr[0].id)
		for i in pbls:
			i.latitud=str(i.latitud).replace(",",".")
			i.longitud=str(i.longitud).replace(",",".")
		var=consultaprovincia(pbls,pr)
	else:
		var = '{"provincia":"No existe esa provicia"}'
	agregarabd("api/provincias/"+n_prov)
	return HttpResponse(var)


def idprovinciaapi(request, prov_id):
	pbls = Pueblo.objects.filter(provincia__id = prov_id)
	if len(pbls) != 0:
		for i in pbls:
			i.latitud=str(i.latitud).replace(",",".")
			i.longitud=str(i.longitud).replace(",",".")
		pr = Provincia.objects.filter(id = prov_id)
		var=consultaprovincia(pbls,pr)
	else:
		var = '{"provincia":"No existe esa provicia"}'
	agregarabd("api/provincias/"+prov_id)
	return HttpResponse(var)
############################################################################
def busq(request, n_pueblo):
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
#########################################################################

def noticias(request,p_id):
	noticias = Noticias.objects.filter(pueblo__id = p_id)
	var = filternoticia(noticias)
	agregarabd("api/pueblos/"+p_id+"/noticias/")
	var = '{"noticias":['+var+']}'
	return HttpResponse(var);


def amigos(request,id_user):
	id_amigos = Amigode.objects.filter(idamistad = id_user)
	if len(id_amigos) != 0:
		retrieveamigos=""
		for i in id_amigos:
			usuario=i
			ap1=usuario.idamigode.dsapellido1
			if ap1 is None:
				ap1 = ""
			ap2=usuario.idamigode.dsapellido2
			if ap2 is None:
				ap2 = ""
			retrieveamigos=retrieveamigos+'{"id_amigo":'+str(usuario.idamigode.id)+',"amigo":"'+usuario.idamigode.dsusuario+'","nombre":"'+usuario.idamigode.dsnombre+'","ap1":"'+ap1+'","ap2":"'+ap2+'","pueblo":"'+usuario.idamigode.pueblo.dspueblo+'","idpueblo":'+str(usuario.idamigode.pueblo.id)+'},'
		retrieveamigos=retrieveamigos[0:len(retrieveamigos)-1]
		ret='{"namigos":'+str(len(id_amigos))+',"amigos":['+retrieveamigos+']}'
	else:
		ret = '{"namigos":0,"amigos":"este usuario no tiene amigos"}'
	agregarabd("api/usuario/"+id_user+"/amigos/")
	return HttpResponse(ret)

def getperfil(request,id_user):
	user = Usuario.objects.filter(id=id_user)
	if len(user) != 0:
		user = user[0]
		pueblo = Pueblo.objects.filter(id = user.pueblo.id)[0]
		retrievecomentarios=getlastcomentarios(id_user)
		ret = '{"id":'+str(user.id)+',"dsusuario":"'+user.dsusuario+'","dspueblo":"'+pueblo.dspueblo+'","pid":'+str(pueblo.id)+',"busquedaimagenes":"'+pueblo.busqueda.replace(" ","_")+'","puntuacion":"'+retrievecomentarios[0]+'","comentarios_recientes":['+retrievecomentarios[1]+']}'
	else:
		ret = '{"id":0,"dsusuario":"este usuario no existe"}'
	agregarabd("api/usuario/"+id_user)
	return HttpResponse(ret)


def getlastcomentarios(id_usuario):
	array=[]
	rez = Comentarios.objects.filter(id_user=id_usuario)[:5]
	obj=""
	noti=""
	puntuacion = 0;
	for i in rez:
		noticia = Noticias.objects.filter(id=i.id_not.id)[0]
		titular = "Noticia sin Titular"
		if noticia.dstitular is not None:
			titular = noticia.dstitular
		if titular is "":
			titular = "Noticia sin Titular"
		puntuacion = puntuacion + i.puntuacion
		noti = noti+'{"comentario":"'+i.dscomentario.replace(" ","-")+'","idnoticia":'+str(noticia.id)+',"dstitular":"'+titular+'"},'
	obj = obj[0:len(obj)-1]
	noti = noti[0:len(noti)-1]
	array.append(str(puntuacion))
	array.append(noti)
	return array



#####################################################MODIFICAR GET NOTICIAS#############################################
def getcomentarios(request,n_id):
	rez = Comentarios.objects.filter(id_not=n_id)
	if len(rez) != 0:
		obj=""
		for i in rez:
			obj = obj+'{"id_comentario":'+str(i.id)+',"id_user":'+str(i.id_user.id)+',"usuario":"'+i.id_user.dsusuario+'","comentario":"'+i.dscomentario.replace(" ","-")+'","puntuacion":'+str(int(i.puntuacion))+',"fecha":"'+str(i.fecha).split("+")[0]+'"},'
		obj = obj[0:(len(obj)-1)]
		obj = '{"ncomentarios":"'+str(len(rez))+'","comentarios":['+obj+']}'
	else:
		obj = '{"ncomentarios":0,"comentarios":"No existen comentarios en esta noticia"}'
	agregarabd("api/noticias/"+n_id)
	return HttpResponse(obj)


def getnot(request,n_id):
	noticia = Noticias.objects.filter(id=n_id)
	if len(noticia) != 0:
		noticia=noticia[0]
		ncomentarios = Comentarios.objects.filter(id_not = noticia)
		titular ="Noticia sin titular"
		cuerpo = "Noticia sin cuerpo"
		fecha = "Noticia sin fecha"
		if noticia.dstitular is not None:
			titular = noticia.dstitular.replace('"','\"')
		if noticia.dscuerpo is not None:
			cuerpo = noticia.dscuerpo.replace('"','\"')
		if noticia.fecha is not None:
			fecha = str(noticia.fecha)
		if titular == "":
			titular ="Noticia sin titular"
		if cuerpo == "":
			cuerpo = "Noticia sin cuerpo"
		if fecha == "":
			fecha = "Noticia sin fecha"
		obj = ""
		obj = '{"existe":true,"id_noticia":'+str(noticia.id)+',"titular":"'+titular+'","cuerpo":"'+cuerpo+'","fecha":"'+fecha+'","url":"'+noticia.url+'","liked":'+str(noticia.liked)+',"dspueblo":"'+noticia.pueblo.dspueblo+'","ncomentarios":'+str(len(ncomentarios))+',"categoria":['+getcategorias(noticia)+']}'
	else:
		obj = '{"existe":false,"id_noticia":0,"titular":"no existe la noticia"}'
	agregarabd("api/noticias/"+n_id)
	return HttpResponse(obj)

def nuevacategoria(request,id_n,categoria):
	try:
		categoria = categoria.replace("_"," ")
		c = Categorias_semandal.objects.filter(dscategoria__icontains = categoria)
		if len(c) == 0:
			n=Noticias.objects.filter(id=id_n)[0]
			newcat = Categorias_semandal(dscategoria=categoria)
			newcat.save()
		else:
			newcat = c
		nuevanoticia = NC(noticia = n,categoria=newcat,confirmada=Status.objects.filter(id=1)[0])
		nuevanoticia.save()	
		return HttpResponse('{"agregado":true}')
	except:		
		return HttpResponse('{"agregado":false}')


####################################################MODIFICAR GET CATEGORIAS ###########################################
def get_noticias(noticias):
	obj = ''
	r = ''
	categorias = ''
	titular
	for n in noticias:
		obj = '"id_noticia":'+str(n.id)+',"dstitular":"'+n.dstitular.replace('"','\"')+'","dscuerpo":"'+n.dscuerpo.replace('"','\"')+'","resumen":"'+n.resumen.replace('"','\"')+'","url":"'+n.url+'","fecha": "'+str(n.fecha)+'","Categorias":['+getcategorias(n)+'],"url":"'+n.url+'"'
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
	if len(pueblos) != 0:
		obj=''
		r=''
		for p in pueblos:
			obj='"idpueblo":'+str(p.id)+',"nombre":"'+p.dspueblo+'"'
			obj = '{'+obj+'},'
			r=r+obj
			obj=''
		r=r[0:len(r)-1]
		r='{"npueblos":'+str(len(pueblos))+',"pueblos":['+r+']}'
	else:
		r='{"npueblos"=0}'
	return HttpResponse(r)

def vercategorias(request):
	cat = Categorias_semandal.objects.all()
	r=''
	if len(cat) != 0:
		for c in cat:
			obj = '{"id_categoria":'+str(c.id)+',"dscategoria":"'+c.dscategoria+'"},'
			r = r+obj
		r=r[0:len(r)-1]
		r='{"ncategorias":'+str(len(cat))+',"categorias":['+r+']}'
	else:
		r='{"ncategorias":0}'
	return HttpResponse(r)


def lastnot(request):
	# try:
	# 	n=Noticias.objects.latest("fecha")
	# 	if n.dscuerpo == None:
	# 		x=n.resumen
	# 	else:
	# 		x=n.dscuerpo
	# 	obj='{"existe":true,"notid":'+str(n.id)+',"titular":"'+n.dstitular+'","cuerpo":"'+x+'","fecha":"'+str(n.fecha)+'","dspueblo":"'+n.pueblo.dspueblo+'","id_pueblo":'+str(n.pueblo.id)+'}'
	# except:
	# 	obj='{"existe":false}'
	# return HttpResponse(obj)
	r = ''
	noticias=Noticias.objects.order_by("fecha").reverse()[:5]
	for n in noticias:
 		comentarios = getcoments(n)
  		obj='{"id_noticia":'+str(n.id)+',"titular":"'+n.dstitular.encode('utf-8')+'","fecha":"'+str(n.fecha)+'","dspueblo":"'+n.pueblo.dspueblo.encode('utf-8')+'","id_pueblo":'+str(n.pueblo.id).encode('utf-8')+',"comentarios":['+comentarios+']},'
		r=r+obj
	r = r[0:len(r)-1]
	r ='{"existe":true,"noticias":['+r+']}'
	return HttpResponse(r)

def getcoments(n):
	r =''
	com = Comentarios.objects.filter(id_not = n)[:2]
	for c in com:
		obj='{"comentarioid":"'+str(c.id)+'","idautor":"'+str(c.id_user.id)+'","autor":"'+c.id_user.dsusuario.encode('utf-8')+'","cuerpo":"'+c.dscomentario.replace(" ","-").encode('utf-8')+',"puntuacion":'+str(c.puntuacion)+'},'
		r = r+obj
	r = r[0:len(r)-1]
	return r

def lastcomment(request):
	try:
		co = Comentarios.objects.all().order_by("fecha")[:5]
		r=''
		for c in co:
			obj='{"existe":true,"comentarioid":"'+str(c.id)+'","idautor":"'+str(c.id_user.id)+'","autor":"'+c.id_user.dsusuario+'","cuerpo":"'+c.dscomentario.replace(" ","-")+'","puntuacion":"'+str(c.puntuacion)+'","notid":"'+str(c.id_not.id)+'","fecha":"'+str(c.fecha).split("+")[0]+'","puntuacion":'+str(c.puntuacion)+'},'
			r = r+obj
		r=r[0:len(r)-1]
		r = '{"comentarios":['+r+']}'
		return HttpResponse(r)
	except:
		obj='{"existe":false}'
		return HttpResponse(obj)


def busqueda(resques,datos):
	kwargs={}
	datos = datos[1:len(datos)-1]
	c=[]
	if datos is not "":
		datos = datos.split(',')
		for i in datos:
			if "id_p" in i :
				p = Pueblo.objects.filter(id=i.split(':')[1])
				kwargs['noticia__pueblo_id'] = p
			elif "id_c" in i:
				kwargs['categoria__id'] = i.split(':')[1]
			elif "_t" in i:
				kwargs['noticia__dstitular__icontains'] = i.split(':')[1]
			elif "_d" in i:
				kwargs['noticia__fecha'] = i.split(':')[1]
			else:
				return HttpResponse('{"ret":false,"comentario":"datos por parametros erroneos"}')
		n = NC.objects.filter(**kwargs).order_by("noticia__fecha").reverse()
		if len(n) is not 0:
			r = filternoticiabusqueda(n)
			r = '{"ret":true,"resultado":['+r+']}'
			return HttpResponse(r)
		else:
			return HttpResponse('{"ret":false,"comentario":"No existe una noticia con esas caracteristicas"}')
	else:
		return HttpResponse('{"ret":false,"comentario":"Debe insertar al menos un campo"}')


def filternoticiabusqueda(n):
	obj = ''
	r = ''
	lista = []
	for noticia in n:
		if noticia.noticia.id not in lista:
			ncomentarios = Comentarios.objects.filter(id_not = noticia.noticia)
			titular =""
			cuerpo = ""
			fecha = ""
			if noticia.noticia.dstitular is not None:
				titular = noticia.noticia.dstitular.replace('"','\"')
			if noticia.noticia.dscuerpo is not None:
				cuerpo = noticia.noticia.dscuerpo.replace('"','\"')
			if noticia.noticia.fecha is not None:
				fecha = str(noticia.noticia.fecha)
			n_categorias = getcategorias(noticia.noticia);
			obj = '{"id_noticia":'+str(noticia.noticia.id)+',"titular":"'+titular+'","fecha":"'+fecha+'","url":"'+noticia.noticia.url+'","liked":'+str(noticia.noticia.liked)+',"dspueblo":"'+noticia.noticia.pueblo.dspueblo+'","ncomentarios":'+str(len(ncomentarios))+',"categoria":['+n_categorias+']},'
			r = r + obj
			lista.append(noticia.noticia.id)
	r = r[0:len(r)-1]
	return r


def filternoticia(n):
	obj = ''
	r = ''
	lista = []
	for noticia in n:
		if noticia.id not in lista:
			ncomentarios = Comentarios.objects.filter(id_not = noticia)
			titular =""
			cuerpo = ""
			fecha = ""
			if noticia.dstitular is not None:
				titular = noticia.dstitular.replace('"','\"')
			if noticia.dscuerpo is not None:
				cuerpo = noticia.dscuerpo.replace('"','\"')
			if noticia.fecha is not None:
				fecha = str(noticia.fecha)
			n_categorias = getcategorias(noticia);
			obj = '{"id_noticia":'+str(noticia.id)+',"titular":"'+titular+'","fecha":"'+fecha+'","url":"'+noticia.url+'","liked":'+str(noticia.liked)+',"dspueblo":"'+noticia.pueblo.dspueblo+'","ncomentarios":"'+str(len(ncomentarios))+'","categoria":['+n_categorias+']},'
			r = r + obj
			lista.append(noticia.id)
	r = r[0:len(r)-1]
	return r

def getcategorias(n):
	n = NC.objects.filter(noticia = n)
	res = ''
	for k in n:
		obj = '{"id_categoria":'+str(k.categoria.id)+',"dscategoria":"'+k.categoria.dscategoria+'"},'
		res = res+obj
	res = res[0:len(res)-1]
	return res



def getdeuda(request,p_id):
	try:
		p = Pueblo.objects.filter(id=p_id)[0]
		obj = '{"id_pueblo":'+str(p.id)+',"deuda":'+str(p.deuda)+',"dspueblo":"'+p.dspueblo+'"}'
	except:
		obj = '{"id_pueblo":0}'
	return HttpResponse(obj)

def insertcomment(request,n_id,dsc,u_id):
	user = Usuario.objects.filter(id=u_id)[0]
	noticia = Noticias.objects.filter(id=n_id)[0]
	p = Comentarios(id_user=user,id_not=noticia,dscomentario=dsc.replace("-"," "),fecha=datetime.datetime.today())
	p.save()
	return HttpResponse("")

def ulog(request,id_user):
	user = Usuario.objects.filter(id= id_user)
	if len(user) != 0:
		user = user[0]
		t = user.pueblo.id
		pob = Pueblo.objects.filter(id = t)[0]
		dstitular = ""
		sig = SigP.objects.filter(id_user = user)
		try:
			noticia = Noticias.objects.filter(pueblo = pob).latest("fecha")
			if noticia.dstitular is not "":
				dstitular = noticia.dstitular
			if dstitular == None:
				dstitular = "Esta noticia no tiene titular"
			elif dstitular == "":
				dstitular = "Esta noticia no tiene titular"
			idnot = str(noticia.id)
		except:
			dstitular = "No existen noticias en su municipio"
			idnot = "0"
		seguir = follow(sig)
		ret = '{"id":'+str(user.id)+',"dsusuario":"'+user.dsusuario+'","dspueblo":"'+pob.dspueblo+'","pid":'+str(pob.id)+',"busquedaimagenes":"'+pob.busqueda.replace(" ","_")+'","dstitular":"'+dstitular+'","notid":'+idnot+',"siguiendo":['+seguir+']}'
	else:
		ret = '{"id":"este usuario no existe"}'
	agregarabd("api/usuario/"+id_user)
	return HttpResponse(ret)

def follow(sig):
	r = ""
	for i in sig:
		obj = '{"id_pueblo"='+str(i.id_p.id)+',"dspueblo":"'+i.id_p.dspueblo+'"},'
		r = r+obj
	r = r[0:len(r)-1]
	return r

def log(request,user,pas):
	if "@" in user:
		user = Usuario.objects.filter(correo = user)
	else:
		user = Usuario.objects.filter(dsusuario = user)
	if len(user) == 0:
		return HttpResponse('{"Resultado":false,"Message":"El usuario no existe"}')
	else:
		user = user[0]
		if pas == user.token:
			return HttpResponse('{"Resultado":true,"Message":"Login Correcto","userid":'+str(user.id)+'}')
		else: 
			return HttpResponse('{"Resultado":false,"Message":"password no es correcta"}')

def register(request,user,fn,sn,us,pas,mail,idpueblo):
	p = Pueblo.objects.filter(id=int(idpueblo))[0]
	u = Usuario(dsusuario=user,dsnombre=us,dsapellido1=fn,dsapellido2=sn,token=pas,correo=mail,pueblo=p)
	sigp = SigP(id_user=u,id_p=p)
	sigp.save();
	u.save();
	return HttpResponse("")

def userview(request,datos):
	kwargs={}
	datos = datos[1:len(datos)-1]
	if datos is not "":
		datos = datos.split(',')
		for i in datos:
			if "p" in i :
				kwargs['pueblo'] = i.split(':')[1]
			elif "n" in i:
				kwargs['dsnombre'] = i.split(':')[1]
			elif "u" in i:
				kwargs['dsusuario'] = i.split(':')[1]
			elif "ap1" in i:
				kwargs['dsapellido1'] = i.split(':')[1]
			elif "ap2" in i:
				kwargs['dsapellido2'] = i.split(':')[1]
			else:
				return HttpResponse('{"ret":false,resultado":"datos erroneos"}')
		u = Usuario.objects.filter(**kwargs)
		if len(u) is not 0:
			obj = ''
			r = ''
			for s in u:
				obj='{"id_amigo":"'+str(s.id)+'","amigo":"'+s.dsusuario+'","nombre":"'+s.dsnombre+'","ap1":"'+s.dsapellido1+'","ap2":"'+s.dsapellido2+'","idpueblo":"'+str(s.pueblo.id)+'","pueblo":"'+s.pueblo.dspueblo+'"},'
				r = r + obj
			r = r[0:len(r)-1]
			r = '{"ret":true,"namigos":"'+str(len(u))+'","amigos":['+r+']}'
			return HttpResponse(r)
		else:
			return HttpResponse('{"ret":false,"resultado":"No existe un usuario con esas caracteristicas"}')
	else:
		return HttpResponse('{"ret":false,"resultado":"Debe insertar al menos un campo"}')

def sig(request,id_p,id_u):
	ret = "false"
	devolver='{"sigue":'+ret+'}'
	sigue = SigP.objects.filter(id_user=id_u,id_p = id_p)
	if len(sigue) != 0:
		ret = "true"
		devolver='{"sigue":'+ret+'}'
	else:
		ret = "false"
		devolver='{"sigue":'+ret+'}'
	return HttpResponse(devolver)

def siguiendo(request,id_u):
	pueblos = SigP.objects.filter(id_user__id = id_u)
	r=''
	obj=''
	for p in pueblos:
		obj = '{"id_pueblo"='+str(p.id_p.id)+',"dspueblo":"'+p.id_p.dspueblo+'"},'
		r = r + obj
	r = r[0:len(r)-1]
	devolver = '{"npueblos":'+str(len(pueblos))+',pueblos":['+r+']}'
	return HttpResponse(devolver)

def addsig(request,id_p,id_u):
	usuario = Usuario.objects.filter(id=id_u)[0]
	pueblo = Pueblo.objects.filter(id=id_p)[0]
	u = SigP(id_user=usuario,id_p=pueblo)
	u.save()
	return HttpResponse("agregado")

def addliked(request,id_u,id_n):
	try:
		usuario = Usuario.objects.filter(id=id_u)[0]
		noticia = Noticias.objects.filter(id=id_n)
		u = T_Liked(id_user=usuario,id_n=noticia[0])
		u.save()
		a = noticia[0].liked+1
		noticia.update(liked = a)
	except:
		return HttpResponse("no agregado")
	return HttpResponse("agregado")

def sign(request,id_n,id_u):
	sigue = T_Liked.objects.filter(id_user=id_u,id_n = id_n)
	if len(sigue) != 0:
		ret = "true"
		devolver='{"sigue":'+ret+'}'
	else:
		ret = "false"
		devolver='{"sigue":'+ret+'}'
	return HttpResponse(devolver)


#######################################################Cambiar posiblemente##############################################
def categorizar(request,id_n,id_cnew,id_u):
	n = Noticias.objects.filter(id = id_n)[0]
	cnew = Categorias_semandal.objects.filter(id = id_cnew)[0]
	u = Usuario.objects.filter(id = id_u)
	#c = Classify(id_n=n[0],id_user=u[0],c_ant=cact[0],c_new=cnew[0])
	c = NC(noticia=n,categoria=cnew,confirmada=Status.objects.filter(id=1)[0])
	c.save()
	return HttpResponse('{"agregado":true}')

def votaciones(request,id_n,id_u,id_c):
	try:
		n=Noticias.objects.filter(id=id_n)[0]
		u=Usuario.objects.filter(id=id_u)[0]
		c=Categorias_semandal.objects.filter(id=id_c)[0]
		v = Votaciones(id_n=n,id_user=u,categoria=c,votacion=True)
		v.save()
	except:
		return HttpResponse('{"agregado":false}')
	return HttpResponse('{"agregado":true}')

def catfromnot(request,id_n):
	try:
		n=Noticias.objects.filter(id = id_n)
		r = getcategorias(n)
		return HttpResponse('{"categorias":['+r+']}')
	except:
		return HttpResponse('{"categorias":[]}')



def denuncia(resquest,id_u,id_c):
	try:
		u = Usuario.objects.filter(id=id_u)[0]
		c = Comentarios.objects.filter(id=id_c)[0]
		d = Denuncias_C(comentario=c,id_user=u)
		d.save()
	except:
		return HttpResponse('{"agregado":false}')
	return HttpResponse('{"agregado":true}')

#####################EXPERIMENTO 20 NOTICIAS DE TODOS LOS PUEBLOS QUE SIGO

def todosnot(request,id_u):
	consultas = []
	sigo = SigP.objects.filter(id_user__id = id_u)
	for i in sigo:
		tupla = ('pueblo_id__id',str(i.id_p.id))
		consultas.append(tupla)
	mylist = [Q(x) for x in consultas]
	n = Noticias.objects.filter(reduce(operator.or_, mylist)).order_by("fecha").reverse()[:20]
	r = filternoticia(n)
	r = '{"ret":true,"resultado":['+r+']}'
	return HttpResponse(r)


def llamadas(request):
	ll = Llamadas.objects.all()
	obj = ""
	for i in ll:
		obj = obj+'{"uri":"'+i.llamada+'","veces":"'+str(i.contabilizacion)+'"},'
	obj = obj[0:len(obj)-1]
	obj = '{"llamadas":['+obj+']}'
	agregarabd("api/busqueda")
	return HttpResponse(obj)
