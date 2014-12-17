from django.conf.urls import patterns, url

from pueblos import views

urlpatterns = patterns('',
    # ex: /polls/
    url(r'^$', views.index, name='index'),
    # ex: /polls/5/
    url(r'^api/pueblos/(?P<p_id>\d+)/$', views.idpuebloapi, name='idpuebloapi'),
	#url(r'^api/pueblos/(?P<n_pueblo>[\w\-\_]*)/$', views.pruebaphp, name='pruebaphp'),
    url(r'^api/pueblos/(?P<n_pueblo>[\w\-\_]*)/$', views.nombre_puebloapi, name='nombre_puebloapi'),
    url(r'^api/provincias/(?P<prov_id>\d+)/$', views.idprovinciaapi, name='idprovinciaapi'),
    url(r'^api/provincias/(?P<n_prov>[\w\-\_]*)/$', views.nombre_provapi, name='nombre_provapi'),
    # url(r'^pueblos/(?P<p_id>\d+)/$', views.idpueblo, name='idpueblo'),
    # url(r'^pueblos/(?P<n_pueblo>[\w\-\_]*)/$', views.nombre_pueblo, name='nombre_pueblo'),
    # url(r'^provincias/(?P<prov_id>\d+)/$', views.idprovincia, name='idprovincia'),
    # url(r'^provincias/(?P<n_prov>[\w\-\_]*)/$', views.nombre_prov, name='nombre_prov'),
    url(r'^api/busqueda/(?P<n_pueblo>[\w\-\_]*)/$',views.busqueda,name='busqueda'),
    url(r'^api/pueblos/(?P<p_id>\d+]*)/noticias/(?P<ind1>\d+)/(?P<ind2>\d+)$', views.noticias, name='noticias'),
    url(r'^api/noticias/(?P<n_id>\d+]*)/comentarios$', views.getcomentarios, name='getcomentarios'),
    url(r'^api/noticias/(?P<n_id>\d+]*)/$', views.getnot, name='getnot'),
    url(r'^api/usuario/(?P<id_user>\d+)/$',views.getperfil,name='getperfil'),
    url(r'^api/usuario/(?P<id_user>\d+)/amigos/$',views.amigos,name='amigos'),
    url(r'^api/llamadas/$',views.llamadas, name='llamadas'),
    url(r'^api/pueblos/$',views.verpueblo, name='verpueblo'),
    url(r'^api/noticias/categorias/$',views.vercategorias, name='vercategorias'),
    url(r'^api/noticias/ultima/$',views.lastnot, name='lastnot'),
    url(r'^api/comentarios/ultimo/$',views.lastcomment, name='lascomment'),
    url(r'^api/busqueda/(?P<datos>[\,s\:\(\w\-\_\d\)]*)/$',views.busqueda, name='busqueda'),
    url(r'^api/deuda/(?P<p_id>\d+]*)/$',views.getdeuda, name='getdeuda'),
    url(r'^api/C_insert/(?P<n_id>\d+]*)/(?P<u_id>\d+]*)/(?P<dsc>.*)$',views.insertcomment, name='insertcomment'),
    url(r'^api/logginuser/(?P<id_user>\d+)/$',views.ulog,name='ulog'),
    url(r'^api/log/(?P<user>[\w\@\.]*)/(?P<pas>.*)/$',views.log,name='log'),
    url(r'^api/register/(?P<user>.*)/(?P<fn>[\w\@\.]*)/(?P<sn>[\w\@\.]*)/(?P<us>[\w\@\.]*)/(?P<pas>.*)/(?P<mail>[\w\@\.]*)/(?P<idpueblo>\d+]*)$',views.register,name='register'),
    url(r'^api/usuario/busqueda/(?P<datos>.*)/$',views.userview, name='userview'),
    url(r'^api/usuario/seguimiento/(?P<id_p>\d+)/(?P<id_u>\d+)/$',views.sig, name='sig'),
    url(r'^api/addsigue/(?P<id_u>\d+)/(?P<id_p>\d+)/$',views.addsig, name='addsig'),
    url(r'^api/nliked/(?P<id_u>\d+)/(?P<id_n>\d+)/$',views.sign, name='sign'),
    url(r'^api/addliked/(?P<id_u>\d+)/(?P<id_n>\d+)/$',views.addliked, name='addliked'),
# url(r'^pueblos/(?P<p_id>\d+)/noticias/?P<id_noticia>\d+/$', views.idpueblo, name='idpueblo'),


)
