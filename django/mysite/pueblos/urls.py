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
    url(r'^api/busqueda/(?P<datos>[\,\:\(\w\-\_\d\)]*)/$',views.busqueda, name='busqueda'),
   # url(r'^pueblos/(?P<p_id>\d+)/noticias/?P<id_noticia>\d+/$', views.idpueblo, name='idpueblo'),


)
