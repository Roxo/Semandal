from django.conf.urls import patterns, url

from pueblos import views

urlpatterns = patterns('',
    url(r'^$', views.index, name='index'), #Funciona
    url(r'^api/pueblos/(?P<p_id>\d+)/$', views.idpuebloapi, name='idpuebloapi'), #Funciona|HECHO|MUESTRA EL PUEBLO CON LA ID DADA
    url(r'^api/pueblos/(?P<n_pueblo>[\w\-\_]*)/$', views.nombre_puebloapi, name='nombre_puebloapi'), #Funciona|HECHO|MUESTRA EL PUEBLO CON EL DSPUEBLO CORRESPONDIENTE
    url(r'^api/provincias/(?P<prov_id>\d+)/$', views.idprovinciaapi, name='idprovinciaapi'),   #Funciona|HECHO|MUESTRA TODOS LOS PUEBLOS DE UNA PROVINCIA CON EL ID CORRESPONDIENTE
    url(r'^api/provincias/(?P<n_prov>[\w\-\_]*)/$', views.nombre_provapi, name='nombre_provapi'), #Funciona|HECHO|MUESTRA TODOS LOS PUEBLOS DE UNA PROVINCIA CON EL DSPROVINCIA CORRESPONDIENTE
###################################################################################################
#    url(r'^api/busqueda/(?P<n_pueblo>[\w\-\_]*)/$',views.busq,name='busq'),
    url(r'^api/pueblos/(?P<p_id>\d+]*)/noticias/$', views.noticias, name='noticias'), 
    url(r'^api/usuario/(?P<id_user>\d+)/amigos/$',views.amigos,name='amigos'), #Funciona|
    url(r'^api/usuario/(?P<id_user>\d+)/$',views.getperfil,name='getperfil'), #Funciona
    url(r'^api/noticias/(?P<n_id>\d+]*)/comentarios$', views.getcomentarios, name='getcomentarios'), #Funciona
    url(r'^api/noticias/(?P<n_id>\d+]*)/$', views.getnot, name='getnot'), #Funciona
    url(r'^api/noticias/(?P<id_n>\d+]*)/addcat/(?P<categoria>.*)/$', views.nuevacategoria, name='nuevacategoria'), #Funciona
    url(r'^api/noticias/(?P<id_n>\d+]*)/categorias/$', views.catfromnot, name='catfromnot'), #Funciona
    url(r'^api/(?P<id_u>\d+]*)/noticias/$', views.todosnot, name='todosnot'), #Funciona
    url(r'^api/llamadas/$',views.llamadas, name='llamadas'),    #Funciona   
    url(r'^api/pueblos/$',views.verpueblo, name='verpueblo'),   #Funciona
    url(r'^api/noticias/categorias/$',views.vercategorias, name='vercategorias'), #Funciona
    url(r'^api/noticias/ultima/$',views.lastnot, name='lastnot'),   #Funciona
  # url(r'^api/comentarios/ultimo/$',views.lastcomment, name='lascomment'),
    url(r'^api/busqueda/(?P<datos>[\,s\:\(\w\-\_\d\)]*)/$',views.busqueda, name='busqueda'), #Funciona
    url(r'^api/deuda/(?P<p_id>\d+]*)/$',views.getdeuda, name='getdeuda'), #DEPRECATED #Funciona
    url(r'^api/C_insert/(?P<n_id>\d+]*)/(?P<u_id>\d+]*)/(?P<dsc>.*)$',views.insertcomment, name='insertcomment'), #Funciona
    url(r'^api/logginuser/(?P<id_user>\d+)/$',views.ulog,name='ulog'), #Funciona #NOAPI
    url(r'^api/log/(?P<user>[\w\@\.]*)/(?P<pas>.*)/$',views.log,name='log'), #Funciona #NOAPI
    url(r'^api/register/(?P<user>.*)/(?P<fn>[\w\@\.]*)/(?P<sn>[\w\@\.]*)/(?P<us>[\w\@\.]*)/(?P<pas>.*)/(?P<mail>[\w\@\.]*)/(?P<idpueblo>[\w+\_]*)$',views.register,name='register'), #Funciona #NOAPI
    url(r'^api/usuario/busqueda/(?P<datos>.*)/$',views.userview, name='userview'), #DEPRECATED #Nofunciona
    url(r'^api/usuario/seguimiento/(?P<id_p>\d+)/(?P<id_u>\d+)/$',views.sig, name='sig'), #Funciona
    url(r'^api/usuario/seguimiento/(?P<id_u>\d+)/$',views.siguiendo, name='siguiendo'),   #Funciona
    url(r'^api/addsigue/(?P<id_u>\d+)/(?P<id_p>\d+)/$',views.addsig, name='addsig'),      #Funciona #NOAPI
    url(r'^api/nliked/(?P<id_u>\d+)/(?P<id_n>\d+)/$',views.sign, name='sign'),            #Funciona 
    url(r'^api/addliked/(?P<id_u>\d+)/(?P<id_n>\d+)/$',views.addliked, name='addliked'),  #Funciona #NOAPI
    url(r'^api/votacion/(?P<id_n>\d+)/(?P<id_u>\d+)/(?P<id_c>\d+)/$',views.votaciones, name='votaciones'),          #Funciona #NOAPI
    url(r'^api/categoriza/(?P<id_n>\d+)/(?P<id_cnew>\w+)/(?P<id_u>\d+)/$',views.categorizar, name='categorizar'),   #Funciona #NOAPI
    url(r'^api/denunciar/(?P<id_u>\d+)/(?P<id_c>\d+)/$',views.denuncia, name='denuncia'),  #Funciona #NOAPI
# url(r'^pueblos/(?P<p_id>\d+)/noticias/?P<id_noticia>\d+/$', views.idpueblo, name='idpueblo'),
)
