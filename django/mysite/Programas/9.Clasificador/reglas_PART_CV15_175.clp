;; establecimientos > 0 AND establecimientos > 0.061856 : Comercio (25.0) 
(defrule rule1
	(establecimientos)
	(establecimientos)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; agricultores <= 0 AND reunido <= 0 AND obras > 0.147249 AND cancelas <= 0 AND obras > 0.397751 AND obras > 0.482213 : obras (68.0) 
(defrule rule2
	(not (agricultores))
	(not (reunido))
	(obras)
	(not (cancelas))
	(obras)
	(obras)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; agricultores > 0 : Agricultura (38.0/1.0) 
(defrule rule3
	(agricultores)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; reunido <= 0 AND agentes > 0 AND agentes > 0.206675 AND agentes <= 0.402062 : trafico (33.0) 
(defrule rule4
	(not (reunido))
	(agentes)
	(agentes)
	(agentes)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; reunido > 0 : reginterior (29.0/1.0) 
(defrule rule5
	(reunido)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; anuncios > 0 AND anuncios > 0.048998 : recursosHumanos (24.0) 
(defrule rule6
	(anuncios)
	(anuncios)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; selectivo > 0 AND partes <= 0 AND selectivo > 0.169492 : reginterior (32.0) 
(defrule rule7
	(selectivo)
	(not (partes))
	(selectivo)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; agentes > 0 AND agentes > 0.09009 AND agentes <= 0.206675 : seguridadCiudadana (31.0) 
(defrule rule8
	(agentes)
	(agentes)
	(agentes)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; residuos > 0 AND residuos <= 0.156604 : medioamb (19.0) 
(defrule rule9
	(residuos)
	(residuos)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; pago > 0 AND pago <= 0.140069 : economia (20.0) 
(defrule rule10
	(pago)
	(pago)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; obras > 0.145788 AND cancelas <= 0 AND obras <= 0.397751 AND obras > 0.256757 : urbanismo (59.0) 
(defrule rule11
	(obras)
	(not (cancelas))
	(obras)
	(obras)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; superficie > 0 AND superficie > 0.063241 : Vivienda (24.0) 
(defrule rule12
	(superficie)
	(superficie)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; viviendas > 0 AND viviendas > 0.127812 : Vivienda (33.0) 
(defrule rule13
	(viviendas)
	(viviendas)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; sangre > 0 AND sangre > 0.09375 : salud (26.0) 
(defrule rule14
	(sangre)
	(sangre)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; bolsa > 0 AND bolsa > 0.142857 AND bolsa <= 0.254613 : reginterior (20.0) 
(defrule rule15
	(bolsa)
	(bolsa)
	(bolsa)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; aspirantes > 0 AND aspirantes > 0.125 AND aspirantes <= 0.166052 : reginterior (14.0) 
(defrule rule16
	(aspirantes)
	(aspirantes)
	(aspirantes)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; concejala > 0.102679 AND concejala > 0.220374 : Grupo_Municipal_PSOE (47.0) 
(defrule rule17
	(concejala)
	(concejala)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; empresas > 0.103781 AND diez <= 0.057915 AND empresas > 0.151448 AND empresas > 0.2 : desarrollo (43.0/1.0) 
(defrule rule18
	(empresas)
	(diez)
	(empresas)
	(empresas)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; bomberos > 0 AND bomberos <= 0.14249 : seguridadCiudadana (19.0) 
(defrule rule19
	(bomberos)
	(bomberos)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; concejal > 0.129653 AND concejal > 0.181132 AND concejal > 0.272727 AND concejal <= 0.44822 : Grupo_Municipal_PSOE (51.0) 
(defrule rule20
	(concejal)
	(concejal)
	(concejal)
	(concejal)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; aceituna > 0 : Agricultura (21.0/1.0) 
(defrule rule21
	(aceituna)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; comercio > 0 AND comercio > 0.132686 AND comercio > 0.165771 : Comercio (12.0) 
(defrule rule22
	(comercio)
	(comercio)
	(comercio)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; educativos > 0 AND educativos > 0.098765 : Educacion (19.0) 
(defrule rule23
	(educativos)
	(educativos)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; bases > 0.061728 AND partes <= 0 AND bases > 0.125461 AND bases <= 0.25 : empleo (16.0) 
(defrule rule24
	(bases)
	(not (partes))
	(bases)
	(bases)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; mujeres > 0.105263 AND mujeres > 0.230769 AND mujeres <= 0.339545 : igualdad (39.0) 
(defrule rule25
	(mujeres)
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; salud > 0.131902 AND salud <= 0.513393 AND salud > 0.210918 : consumo (26.0) 
(defrule rule26
	(salud)
	(salud)
	(salud)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; informa > 0.069211 AND informa > 0.166667 AND informa <= 0.18018 AND informa > 0.175258 : servicios (16.0) 
(defrule rule27
	(informa)
	(informa)
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; text > 0 AND play > 0.079968 : servicios (16.0) 
(defrule rule28
	(text)
	(play)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; text > 0 AND play <= 0.060743 : festejos (15.0) 
(defrule rule29
	(text)
	(play)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; obras > 0.094972 AND cancelas <= 0 AND obras > 0.210526 AND obras > 0.256757 : infraestructura (59.0) 
(defrule rule30
	(obras)
	(not (cancelas))
	(obras)
	(obras)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; mujer > 0.098684 AND mujer > 0.306418 : Mujer (20.0) 
(defrule rule31
	(mujer)
	(mujer)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; prueba > 0 AND prueba <= 0.057196 AND prueba <= 0.057143 : turismo1 (6.0) 
(defrule rule32
	(prueba)
	(prueba)
	(prueba)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; prueba > 0 AND prueba <= 0.110631 AND prueba > 0.057196 : Deportes (15.0) 
(defrule rule33
	(prueba)
	(prueba)
	(prueba)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; talleres > 0.111607 AND talleres > 0.142857 AND talleres <= 0.153846 : ssociales (26.0) 
(defrule rule34
	(talleres)
	(talleres)
	(talleres)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; salud > 0.111842 AND venta <= 0 AND salud > 0.210918 : salud (25.0) 
(defrule rule35
	(salud)
	(not (venta))
	(salud)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; bases > 0.052867 AND partes <= 0 AND bases > 0.125 AND bases <= 0.25 : reginterior (12.0) 
(defrule rule36
	(bases)
	(not (partes))
	(bases)
	(bases)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; admitidos > 0 AND admitidos > 0.156827 : recursosHumanos (10.0) 
(defrule rule37
	(admitidos)
	(admitidos)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; servicio > 0.166667 AND servicio > 0.22619 AND servicio <= 0.279661 AND servicio <= 0.267857 : consumo (35.0) 
(defrule rule38
	(servicio)
	(servicio)
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; servicio > 0.166667 AND servicio > 0.220796 AND servicio > 0.285714 AND puedan <= 0.092784 AND servicio <= 0.375 : servicios (30.0) 
(defrule rule39
	(servicio)
	(servicio)
	(servicio)
	(puedan)
	(servicio)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; servicio > 0.159434 AND servicio <= 0.211316 AND servicio <= 0.175141 AND servicio > 0.174757 : salud (18.0) 
(defrule rule40
	(servicio)
	(servicio)
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; vecinos > 0.156604 AND agentes <= 0.206675 AND vecinos <= 0.210526 AND vecinos <= 0.174636 AND vecinos <= 0.172339 : ayuntamiento (23.0) 
(defrule rule41
	(vecinos)
	(agentes)
	(vecinos)
	(vecinos)
	(vecinos)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; vivienda > 0 AND vivienda > 0.099182 AND vivienda > 0.113402 : Vivienda (8.0) 
(defrule rule42
	(vivienda)
	(vivienda)
	(vivienda)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; talleres > 0.100162 AND talleres <= 0.121359 AND talleres <= 0.113182 AND talleres > 0.111607 : igualdad (21.0) 
(defrule rule43
	(talleres)
	(talleres)
	(talleres)
	(talleres)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; charla > 0 AND violencia <= 0.067044 AND charla <= 0.080508 AND charla > 0.055901 : salud (9.0) 
(defrule rule44
	(charla)
	(violencia)
	(charla)
	(charla)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; acceder > 0.048998 AND acceder <= 0.071429 AND acceder > 0.065789 : comunicacion (14.0) 
(defrule rule45
	(acceder)
	(acceder)
	(acceder)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; acceder > 0 AND acceder <= 0.071429 AND acceder > 0.048998 : social (10.0) 
(defrule rule46
	(acceder)
	(acceder)
	(acceder)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; enlace > 0.054659 AND enlace > 0.098684 AND enlace <= 0.140312 : empleo (10.0) 
(defrule rule47
	(enlace)
	(enlace)
	(enlace)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; zonas > 0.107143 AND zonas > 0.142857 AND zonas > 0.173585 AND zonas <= 0.183603 : obras (20.0) 
(defrule rule48
	(zonas)
	(zonas)
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; iniciativas > 0 AND municipios <= 0.142857 AND iniciativas <= 0.068548 : desarrollo (10.0) 
(defrule rule49
	(iniciativas)
	(municipios)
	(iniciativas)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; viviendas > 0 AND ingresos <= 0 AND viviendas <= 0.057737 AND viviendas > 0.046547 : obras (6.0) 
(defrule rule50
	(viviendas)
	(not (ingresos))
	(viviendas)
	(viviendas)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; productos > 0 AND productos <= 0.074903 AND productos > 0.049383 : turismo1 (14.0) 
(defrule rule51
	(productos)
	(productos)
	(productos)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; productos > 0 AND productos > 0.103047 AND productos > 0.122905 : Comercio (11.0) 
(defrule rule52
	(productos)
	(productos)
	(productos)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; parques > 0 AND verdes <= 0.061453 AND parques > 0.056604 AND parques > 0.061201 : infraestructura (9.0) 
(defrule rule53
	(parques)
	(verdes)
	(parques)
	(parques)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; apuesta > 0 AND apuesta > 0.066136 AND apuesta <= 0.076923 : Mujer (12.0) 
(defrule rule54
	(apuesta)
	(apuesta)
	(apuesta)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; casco > 0 AND casco <= 0.058891 AND casco > 0.052147 AND casco <= 0.052632 : seguridadCiudadana (7.0) 
(defrule rule55
	(casco)
	(casco)
	(casco)
	(casco)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; zonas > 0.074342 AND encuentran <= 0.061728 AND zonas > 0.135992 AND zonas <= 0.156425 AND zonas > 0.142857 : Agricultura (17.0) 
(defrule rule56
	(zonas)
	(encuentran)
	(zonas)
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; zonas > 0.074342 AND encuentran <= 0.061728 AND zonas > 0.130435 AND zonas <= 0.156425 AND zonas <= 0.135992 : urbanismo (13.0) 
(defrule rule57
	(zonas)
	(encuentran)
	(zonas)
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; labor > 0 AND trabajadores <= 0 AND labor <= 0.063241 AND labor > 0.061617 : infraestructura (6.0) 
(defrule rule58
	(labor)
	(not (trabajadores))
	(labor)
	(labor)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; sistema > 0 AND llevado <= 0 AND sistema > 0.103093 AND sistema <= 0.111111 : tecnologia (9.0) 
(defrule rule59
	(sistema)
	(not (llevado))
	(sistema)
	(sistema)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; profesores > 0 AND profesores > 0.074074 : Educacion (17.0/1.0) 
(defrule rule60
	(profesores)
	(profesores)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; espacios > 0 AND espacios <= 0.076415 AND espacios > 0.063241 : medioamb (11.0) 
(defrule rule61
	(espacios)
	(espacios)
	(espacios)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; explicado > 0 AND explicado <= 0.048701 : comunicacion (10.0) 
(defrule rule62
	(explicado)
	(explicado)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; ciudad > 0.105459 AND ciudad > 0.187545 AND ciudad > 0.285714 : Grupo_Municipal_PSOE (22.0) 
(defrule rule63
	(ciudad)
	(ciudad)
	(ciudad)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; sistema > 0 AND llevado <= 0 AND sistema > 0.111111 : recursosHumanos (9.0) 
(defrule rule64
	(sistema)
	(not (llevado))
	(sistema)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; seguridad > 0.080161 AND seguridad > 0.158103 AND seguridad > 0.350515 : seguridadCiudadana (22.0/1.0) 
(defrule rule65
	(seguridad)
	(seguridad)
	(seguridad)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; proyecto > 0.131403 AND iniciativas <= 0.093851 AND proyecto > 0.183692 AND proyecto <= 0.231084 AND proyecto > 0.207852 : urbanismo (22.0) 
(defrule rule66
	(proyecto)
	(iniciativas)
	(proyecto)
	(proyecto)
	(proyecto)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; curso > 0.150977 AND curso > 0.187082 AND curso > 0.305821 : Formacion (35.0) 
(defrule rule67
	(curso)
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; empleo > 0.130952 AND momentos <= 0 AND disponibles <= 0 AND empleo > 0.300738 AND empleo > 0.398305 : empleo (25.0) 
(defrule rule68
	(empleo)
	(not (momentos))
	(not (disponibles))
	(empleo)
	(empleo)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; empleo > 0.123457 AND momentos <= 0 AND disponibles <= 0 AND empleo <= 0.230769 AND empleo > 0.145809 : Formacion (18.0) 
(defrule rule69
	(empleo)
	(not (momentos))
	(not (disponibles))
	(empleo)
	(empleo)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; solicitudes > 0.081886 AND solicitudes > 0.142857 AND solicitudes > 0.190476 : recursosHumanos (20.0) 
(defrule rule70
	(solicitudes)
	(solicitudes)
	(solicitudes)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; alumnado > 0.05985 AND alumnado > 0.10559 AND alumnado <= 0.130756 : Educacion (12.0) 
(defrule rule71
	(alumnado)
	(alumnado)
	(alumnado)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; alumnado > 0.05985 AND alumnado <= 0.097109 AND alumnado <= 0.067485 : asociales (9.0) 
(defrule rule72
	(alumnado)
	(alumnado)
	(alumnado)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; alumnado > 0.04343 AND alumnado > 0.097109 AND alumnado <= 0.130756 : igualdad (11.0) 
(defrule rule73
	(alumnado)
	(alumnado)
	(alumnado)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; equipo > 0.090615 AND enfocadas <= 0 AND equipo > 0.12253 : Deportes (26.0/1.0) 
(defrule rule74
	(equipo)
	(not (enfocadas))
	(equipo)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; mayores > 0.108936 AND urbano <= 0.124744 AND mayores > 0.211656 AND mayores <= 0.252019 : bienestarsocial (28.0) 
(defrule rule75
	(mayores)
	(urbano)
	(mayores)
	(mayores)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; solicitar > 0.059041 AND solicitar <= 0.070034 : economia (11.0) 
(defrule rule76
	(solicitar)
	(solicitar)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; viviendas > 0 AND ingresos <= 0 AND viviendas <= 0.095238 AND viviendas > 0.057737 : infraestructura (8.0) 
(defrule rule77
	(viviendas)
	(not (ingresos))
	(viviendas)
	(viviendas)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; jurado > 0 AND estudiantes <= 0.055604 AND jurado > 0.052632 : festejos (12.0) 
(defrule rule78
	(jurado)
	(estudiantes)
	(jurado)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; deportivas > 0 AND deportivas > 0.112546 : Deportes (14.0) 
(defrule rule79
	(deportivas)
	(deportivas)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; material > 0 AND calle <= 0.081435 AND material > 0.072368 : consumo (11.0/1.0) 
(defrule rule80
	(material)
	(calle)
	(material)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; mayores > 0.108936 AND urbano <= 0.124744 AND mayores > 0.190476 AND mayores > 0.252019 : ssociales (26.0) 
(defrule rule81
	(mayores)
	(urbano)
	(mayores)
	(mayores)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; seguridad > 0.080161 AND seguridad > 0.102771 AND jornada <= 0.058282 AND seguridad > 0.158103 : trafico (14.0) 
(defrule rule82
	(seguridad)
	(seguridad)
	(jornada)
	(seguridad)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; evitar > 0.046547 AND casos <= 0 AND evitar > 0.080357 AND molestias <= 0 AND evitar <= 0.081132 : medioamb (12.0) 
(defrule rule83
	(evitar)
	(not (casos))
	(evitar)
	(not (molestias))
	(evitar)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; evitar > 0.046547 AND casos <= 0 AND evitar <= 0.076271 AND evitar <= 0.070603 AND evitar > 0.068129 : seguridadCiudadana (9.0) 
(defrule rule84
	(evitar)
	(not (casos))
	(evitar)
	(evitar)
	(evitar)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; evitar > 0.046547 AND casos <= 0 AND evitar <= 0.076271 AND evitar > 0.070603 : infraestructura (7.0) 
(defrule rule85
	(evitar)
	(not (casos))
	(evitar)
	(evitar)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; evitar > 0 AND obras <= 0.11534 AND casos <= 0 AND evitar > 0.105263 AND evitar > 0.119048 : trafico (8.0) 
(defrule rule86
	(evitar)
	(obras)
	(not (casos))
	(evitar)
	(evitar)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; representantes > 0.041203 AND representantes <= 0.066752 AND representantes > 0.053373 : seguridadCiudadana (6.0) 
(defrule rule87
	(representantes)
	(representantes)
	(representantes)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; concejal > 0.129653 AND concejal > 0.176674 AND concejal > 0.181132 AND concejal <= 0.209979 : Mujer (21.0) 
(defrule rule88
	(concejal)
	(concejal)
	(concejal)
	(concejal)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; violencia > 0 AND charla <= 0.089286 AND violencia > 0.147688 : Mujer (10.0) 
(defrule rule89
	(violencia)
	(charla)
	(violencia)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; representantes > 0.041203 AND representantes > 0.067039 AND representantes <= 0.074074 : tecnologia (5.0) 
(defrule rule90
	(representantes)
	(representantes)
	(representantes)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; laboral > 0.092661 AND disponibles <= 0 AND laboral <= 0.142857 AND laboral <= 0.105263 AND laboral <= 0.098684 : social (12.0) 
(defrule rule91
	(laboral)
	(not (disponibles))
	(laboral)
	(laboral)
	(laboral)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; laboral > 0.092661 AND disponibles <= 0 AND laboral > 0.148297 AND laboral > 0.262712 : reginterior (10.0) 
(defrule rule92
	(laboral)
	(not (disponibles))
	(laboral)
	(laboral)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; convocatoria > 0.05594 AND hora <= 0.110169 AND sistema <= 0.04955 AND iniciativa <= 0.296117 AND social <= 0.194175 AND convocatoria > 0.085714 AND convocatoria > 0.25 : recursosHumanos (7.0) 
(defrule rule93
	(convocatoria)
	(hora)
	(sistema)
	(iniciativa)
	(social)
	(convocatoria)
	(convocatoria)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; objeto > 0.037736 AND partes <= 0 AND objeto > 0.077951 AND objeto > 0.106719 AND objeto <= 0.190476 : saci (4.0) 
(defrule rule94
	(objeto)
	(not (partes))
	(objeto)
	(objeto)
	(objeto)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; trabajadores > 0 AND mantenimiento <= 0 AND viene <= 0.063241 AND trabajadores > 0.073497 AND trabajadores > 0.095238 : recursosHumanos (11.0) 
(defrule rule95
	(trabajadores)
	(not (mantenimiento))
	(viene)
	(trabajadores)
	(trabajadores)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; campo > 0 AND campo > 0.071146 AND campo > 0.099592 : Agricultura (9.0/1.0) 
(defrule rule96
	(campo)
	(campo)
	(campo)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; parque > 0.07072 AND parque <= 0.102767 AND parque > 0.072653 AND parque <= 0.089385 : Agricultura (10.0) 
(defrule rule97
	(parque)
	(parque)
	(parque)
	(parque)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; presupuesto > 0 AND proyectos <= 0.142857 AND funcionamiento <= 0.074074 AND presupuesto > 0.078078 AND caso <= 0.021739 AND presupuesto > 0.162055 : obras (6.0/1.0) 
(defrule rule98
	(presupuesto)
	(proyectos)
	(funcionamiento)
	(presupuesto)
	(caso)
	(presupuesto)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; playa > 0 AND playa > 0.076273 : turismo1 (12.0) 
(defrule rule99
	(playa)
	(playa)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; supone > 0.053315 AND crisis <= 0 AND frente <= 0.061453 AND supone > 0.067039 AND supone <= 0.095238 : comunicacion (7.0) 
(defrule rule100
	(supone)
	(not (crisis))
	(frente)
	(supone)
	(supone)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; supone > 0.053315 AND crisis <= 0 AND frente <= 0.061453 AND supone <= 0.064151 AND supone <= 0.056257 : economia (5.0) 
(defrule rule101
	(supone)
	(not (crisis))
	(frente)
	(supone)
	(supone)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; supone > 0.056257 AND crisis <= 0 AND frente <= 0.061453 AND supone > 0.085714 AND supone > 0.119048 : Grupo_Municipal_PSOE (5.0) 
(defrule rule102
	(supone)
	(not (crisis))
	(frente)
	(supone)
	(supone)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; mantenimiento > 0 AND mantenimiento > 0.070156 AND mantenimiento > 0.075058 AND mantenimiento <= 0.075099 : infraestructura (9.0) 
(defrule rule103
	(mantenimiento)
	(mantenimiento)
	(mantenimiento)
	(mantenimiento)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; presupuesto > 0 AND proyectos <= 0.142857 AND funcionamiento <= 0.074074 AND presupuesto <= 0.061728 AND empresa <= 0.062693 AND presupuesto <= 0.04822 : economia (5.0) 
(defrule rule104
	(presupuesto)
	(proyectos)
	(funcionamiento)
	(presupuesto)
	(empresa)
	(presupuesto)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; presupuesto > 0 AND proyectos <= 0.142857 AND funcionamiento <= 0.074074 AND presupuesto > 0.078078 AND caso <= 0.021739 : infraestructura (5.0) 
(defrule rule105
	(presupuesto)
	(proyectos)
	(funcionamiento)
	(presupuesto)
	(caso)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; calle > 0.121359 AND disponen <= 0 AND calle <= 0.154762 AND calle > 0.140961 AND calle <= 0.142857 : participacion (24.0) 
(defrule rule106
	(calle)
	(not (disponen))
	(calle)
	(calle)
	(calle)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; calle > 0.121359 AND disponen <= 0 AND calle <= 0.166881 AND calle <= 0.128958 : turismo1 (14.0) 
(defrule rule107
	(calle)
	(not (disponen))
	(calle)
	(calle)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; calles > 0.086505 AND calles > 0.149284 AND calles > 0.151652 AND calles <= 0.169177 : festejos (24.0) 
(defrule rule108
	(calles)
	(calles)
	(calles)
	(calles)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; calle > 0.113454 AND disponen <= 0 AND calle <= 0.166881 AND calle <= 0.142857 AND calle > 0.128958 : ayuntamiento (12.0) 
(defrule rule109
	(calle)
	(not (disponen))
	(calle)
	(calle)
	(calle)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; actividad > 0.14268 AND proyectos <= 0.142857 AND actividad > 0.153083 AND actividad <= 0.180873 AND actividad > 0.168285 : Mujer (9.0) 
(defrule rule110
	(actividad)
	(proyectos)
	(actividad)
	(actividad)
	(actividad)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; obra > 0.093168 AND oficial <= 0.142857 AND obra > 0.108108 AND obra <= 0.184242 AND obra > 0.126819 : cultura (33.0) 
(defrule rule111
	(obra)
	(oficial)
	(obra)
	(obra)
	(obra)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; palabras > 0.05821 AND palabras > 0.105263 : ayuntamiento (19.0/2.0) 
(defrule rule112
	(palabras)
	(palabras)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; calle > 0.103039 AND disponen <= 0 AND fiesta <= 0.064865 AND calle > 0.189189 AND calle > 0.206186 AND calle <= 0.209611 : urbanismo (12.0) 
(defrule rule113
	(calle)
	(not (disponen))
	(fiesta)
	(calle)
	(calle)
	(calle)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; metros > 0 AND urbano <= 0.124744 AND torno <= 0 AND metros <= 0.064151 AND metros <= 0.052316 : servicios (5.0) 
(defrule rule114
	(metros)
	(urbano)
	(not (torno))
	(metros)
	(metros)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; metros > 0 AND urbano <= 0.124744 AND torno <= 0 AND presupuesto <= 0.061728 AND metros > 0.064151 AND metros <= 0.067825 : ayuntamiento (10.0) 
(defrule rule115
	(metros)
	(urbano)
	(not (torno))
	(presupuesto)
	(metros)
	(metros)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; cita > 0.079002 AND representantes <= 0.067039 AND cita <= 0.0951 AND cita > 0.085714 : ayuntamiento (12.0) 
(defrule rule116
	(cita)
	(representantes)
	(cita)
	(cita)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; organizada > 0 AND organizada > 0.058282 AND organizada > 0.066964 : igualdad (6.0) 
(defrule rule117
	(organizada)
	(organizada)
	(organizada)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; calles > 0.077358 AND calles > 0.134788 AND calles <= 0.169177 AND calles > 0.149284 : servicios (13.0) 
(defrule rule118
	(calles)
	(calles)
	(calles)
	(calles)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; calles > 0.077358 AND calles <= 0.115058 AND calles <= 0.092784 AND calles <= 0.086505 : participacion (9.0) 
(defrule rule119
	(calles)
	(calles)
	(calles)
	(calles)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; necesario > 0 AND partes <= 0 AND orden <= 0.021739 AND necesario <= 0.051125 AND necesario > 0.050173 : urbanismo (7.0) 
(defrule rule120
	(necesario)
	(not (partes))
	(orden)
	(necesario)
	(necesario)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; problemas > 0.051348 AND problemas > 0.0625 AND problemas > 0.077367 : infraestructura (6.0) 
(defrule rule121
	(problemas)
	(problemas)
	(problemas)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; familias > 0.085526 AND familias > 0.125 AND familias <= 0.150485 AND familias <= 0.133279 : bienestarsocial (15.0) 
(defrule rule122
	(familias)
	(familias)
	(familias)
	(familias)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; escolares > 0.045906 AND laboral <= 0.055215 AND escolares > 0.123457 : Educacion (9.0/1.0) 
(defrule rule123
	(escolares)
	(laboral)
	(escolares)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; agua > 0.037564 AND actividad <= 0.058282 AND puntos <= 0.044396 AND agua > 0.142643 AND agua > 0.159353 : infraestructura (6.0/1.0) 
(defrule rule124
	(agua)
	(actividad)
	(puntos)
	(agua)
	(agua)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; entorno > 0.057766 AND seguridad <= 0.048701 AND calles <= 0.058319 AND entorno > 0.071146 : medioamb (10.0/1.0) 
(defrule rule125
	(entorno)
	(seguridad)
	(calles)
	(entorno)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; objeto > 0.037736 AND hora <= 0.110169 AND espacios <= 0 AND objeto > 0.061728 AND objeto <= 0.077951 : empleo (5.0) 
(defrule rule126
	(objeto)
	(hora)
	(not (espacios))
	(objeto)
	(objeto)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; limpieza > 0 AND integral <= 0 AND limpieza > 0.13834 AND limpieza <= 0.15 : medioamb (9.0) 
(defrule rule127
	(limpieza)
	(not (integral))
	(limpieza)
	(limpieza)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; muestra > 0.049383 AND centenario <= 0 AND muestra <= 0.081199 AND muestra <= 0.073377 : ayuntamiento (8.0) 
(defrule rule128
	(muestra)
	(not (centenario))
	(muestra)
	(muestra)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; derechos > 0 AND derechos <= 0.051696 AND derechos > 0.046012 : bienestarsocial (7.0) 
(defrule rule129
	(derechos)
	(derechos)
	(derechos)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; colectivos > 0 AND proyectos <= 0.142857 AND familiares <= 0 AND colectivos > 0.063005 AND colectivos > 0.079002 AND colectivos <= 0.084821 : consumo (8.0) 
(defrule rule130
	(colectivos)
	(proyectos)
	(not (familiares))
	(colectivos)
	(colectivos)
	(colectivos)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; acudir > 0 AND presente <= 0.08686 AND precio <= 0.062857 AND acudir > 0.055901 AND acudir > 0.116071 : salud (4.0) 
(defrule rule131
	(acudir)
	(presente)
	(precio)
	(acudir)
	(acudir)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; entidades > 0 AND proyectos <= 0.142857 AND entidades <= 0.057072 AND entidades <= 0.055215 AND entidades > 0.052632 : asociales (9.0) 
(defrule rule132
	(entidades)
	(proyectos)
	(entidades)
	(entidades)
	(entidades)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; entidades > 0 AND proyectos <= 0.142857 AND entidades <= 0.059041 AND entidades > 0.052632 : ssociales (7.0/1.0) 
(defrule rule133
	(entidades)
	(proyectos)
	(entidades)
	(entidades)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; entidades > 0 AND proyectos <= 0.142857 AND entidades <= 0.061828 AND entidades <= 0.057072 : social (5.0) 
(defrule rule134
	(entidades)
	(proyectos)
	(entidades)
	(entidades)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; entidades > 0 AND proyectos <= 0.142857 AND entidades <= 0.079219 AND entidades > 0.061828 : economia (7.0) 
(defrule rule135
	(entidades)
	(proyectos)
	(entidades)
	(entidades)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; asistentes > 0.047146 AND asistentes > 0.052632 AND asistentes <= 0.079755 : asociales (9.0) 
(defrule rule136
	(asistentes)
	(asistentes)
	(asistentes)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; esfuerzo > 0.05566 AND esfuerzo <= 0.075308 AND esfuerzo > 0.055831 AND esfuerzo <= 0.064294 : economia (5.0) 
(defrule rule137
	(esfuerzo)
	(esfuerzo)
	(esfuerzo)
	(esfuerzo)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; presentado > 0 AND urbano <= 0.124744 AND presentado <= 0.05075 AND presentado <= 0.050166 : cultura (7.0) 
(defrule rule138
	(presentado)
	(urbano)
	(presentado)
	(presentado)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; pueblo > 0.122779 AND pueblo > 0.158098 AND pueblo <= 0.162934 : turismo1 (13.0) 
(defrule rule139
	(pueblo)
	(pueblo)
	(pueblo)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; empresa > 0.107893 AND presente <= 0.08686 AND alcaldesa <= 0.134021 AND empresa <= 0.142857 AND viene <= 0.063241 AND empresa > 0.121359 AND empresa <= 0.129464 : consumo (8.0) 
(defrule rule140
	(empresa)
	(presente)
	(alcaldesa)
	(empresa)
	(viene)
	(empresa)
	(empresa)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; recogida > 0 AND calidad <= 0.065234 AND recogida <= 0.078947 AND recogida > 0.075893 : social (9.0) 
(defrule rule141
	(recogida)
	(calidad)
	(recogida)
	(recogida)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; recogida > 0 AND calidad <= 0.065234 AND recogida <= 0.083004 AND recogida > 0.051963 : infraestructura (5.0/1.0) 
(defrule rule142
	(recogida)
	(calidad)
	(recogida)
	(recogida)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; recogida > 0 AND calidad <= 0.065234 AND recogida > 0.089385 AND recogida > 0.102102 : medioamb (6.0) 
(defrule rule143
	(recogida)
	(calidad)
	(recogida)
	(recogida)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; puntos > 0.065789 AND calle <= 0.075173 AND servicio <= 0.134969 AND comercial <= 0 AND cabo <= 0.116071 AND puntos > 0.086716 : comunicacion (14.0) 
(defrule rule144
	(puntos)
	(calle)
	(servicio)
	(not (comercial))
	(cabo)
	(puntos)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; convocatoria > 0.05594 AND presente <= 0.08686 AND sistema > 0.04955 : trafico (5.0) 
(defrule rule145
	(convocatoria)
	(presente)
	(sistema)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; grupos > 0.079404 AND representantes <= 0.067039 AND grupos <= 0.092445 AND grupos > 0.080738 AND grupos > 0.08642 : ayuntamiento (8.0) 
(defrule rule146
	(grupos)
	(representantes)
	(grupos)
	(grupos)
	(grupos)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; familiar > 0.05314 AND familiar > 0.098684 AND familiar <= 0.141104 : asociales (12.0) 
(defrule rule147
	(familiar)
	(familiar)
	(familiar)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; laboral > 0.092661 AND laboral > 0.142857 AND laboral <= 0.148297 : desarrollo (10.0) 
(defrule rule148
	(laboral)
	(laboral)
	(laboral)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; condiciones > 0 AND precio <= 0.062857 AND urbano <= 0 AND condiciones <= 0.034134 : generales (8.0) 
(defrule rule149
	(condiciones)
	(precio)
	(not (urbano))
	(condiciones)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; pueblo > 0.122779 AND pueblo > 0.162934 AND pueblo > 0.176707 : comunicacion (11.0) 
(defrule rule150
	(pueblo)
	(pueblo)
	(pueblo)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; mujeres > 0.085714 AND mujeres > 0.145396 AND mujeres > 0.230769 AND mujeres <= 0.428274 : Mujer (12.0) 
(defrule rule151
	(mujeres)
	(mujeres)
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; mujeres > 0.066308 AND mujeres > 0.142857 AND mujeres <= 0.145396 : bienestarsocial (12.0) 
(defrule rule152
	(mujeres)
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; proyecto > 0.122153 AND edil <= 0 AND proyecto > 0.14717 AND proyecto > 0.207852 AND proyecto <= 0.25 : tecnologia (17.0) 
(defrule rule153
	(proyecto)
	(not (edil))
	(proyecto)
	(proyecto)
	(proyecto)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; zonas > 0.040223 AND encuentran <= 0.061728 AND zonas <= 0.112613 AND calles <= 0 AND zonas > 0.061856 AND zonas > 0.074342 : servicios (4.0) 
(defrule rule154
	(zonas)
	(encuentran)
	(zonas)
	(not (calles))
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; zonas > 0.040223 AND encuentran <= 0.061728 AND zonas > 0.121951 AND zonas > 0.183603 : parques (7.0) 
(defrule rule155
	(zonas)
	(encuentran)
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_parques)
	)
)
;; enlace > 0 AND millones <= 0 AND enlace > 0.095238 AND enlace <= 0.140312 : social (8.0) 
(defrule rule156
	(enlace)
	(not (millones))
	(enlace)
	(enlace)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; cargo > 0.087379 AND cargo <= 0.096886 AND cargo > 0.088337 AND cargo <= 0.094208 : turismo1 (15.0) 
(defrule rule157
	(cargo)
	(cargo)
	(cargo)
	(cargo)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; ofrece > 0 AND ofrece <= 0.059459 AND ofrece > 0.049689 AND ofrece <= 0.053233 : Juventud (7.0) 
(defrule rule158
	(ofrece)
	(ofrece)
	(ofrece)
	(ofrece)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; ofrece > 0 AND ofrece > 0.06362 AND ofrece <= 0.071429 : comunicacion (5.0) 
(defrule rule159
	(ofrece)
	(ofrece)
	(ofrece)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; ofrece > 0 AND ofrece <= 0.059459 AND servicio <= 0.043478 : igualdad (4.0) 
(defrule rule160
	(ofrece)
	(ofrece)
	(servicio)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; grupos > 0.079404 AND representantes <= 0.067039 AND grupos > 0.095238 AND grupos > 0.134304 : consumo (7.0/1.0) 
(defrule rule161
	(grupos)
	(representantes)
	(grupos)
	(grupos)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; cabo > 0.116071 AND partes <= 0 AND alcaldesa <= 0.134021 AND cabo <= 0.134181 AND cabo <= 0.123711 AND cabo <= 0.122905 : Agricultura (10.0) 
(defrule rule162
	(cabo)
	(not (partes))
	(alcaldesa)
	(cabo)
	(cabo)
	(cabo)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; delegado > 0.076923 AND molestias <= 0 AND delegado > 0.092204 AND delegado > 0.133929 : medioamb (9.0) 
(defrule rule163
	(delegado)
	(not (molestias))
	(delegado)
	(delegado)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; vecinas > 0 AND medio <= 0.142857 AND vecinas <= 0.053373 AND vecinas <= 0.051205 : festejos (10.0) 
(defrule rule164
	(vecinas)
	(medio)
	(vecinas)
	(vecinas)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; vecinas > 0 AND medio <= 0.142857 AND vecinas <= 0.055215 AND vecinas <= 0.051948 : comunicacion (6.0) 
(defrule rule165
	(vecinas)
	(medio)
	(vecinas)
	(vecinas)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; vecinas > 0 AND medio <= 0.142857 AND vecinas > 0.061453 AND vecinas <= 0.062147 : salud (5.0) 
(defrule rule166
	(vecinas)
	(medio)
	(vecinas)
	(vecinas)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; vecinas > 0 AND medio <= 0.142857 AND vecinas <= 0.055215 AND vecinas <= 0.053373 : Formacion (6.0) 
(defrule rule167
	(vecinas)
	(medio)
	(vecinas)
	(vecinas)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; vecinas > 0 AND medio <= 0.142857 AND vecinas > 0.062147 AND vecinos <= 0.210526 : consumo (4.0) 
(defrule rule168
	(vecinas)
	(medio)
	(vecinas)
	(vecinos)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; vecinas > 0 AND medio <= 0.142857 AND vecinas <= 0.055215 : urbanismo (5.0) 
(defrule rule169
	(vecinas)
	(medio)
	(vecinas)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; empleo > 0.095634 AND personal <= 0 AND empleo > 0.230769 AND empleo > 0.285714 AND empleo <= 0.334229 : desarrollo (11.0) 
(defrule rule170
	(empleo)
	(not (personal))
	(empleo)
	(empleo)
	(empleo)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; entidades > 0 AND proyectos <= 0.142857 AND entidades > 0.079219 : Vivienda (5.0) 
(defrule rule171
	(entidades)
	(proyectos)
	(entidades)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; alumnos > 0.109582 AND alumnos <= 0.184581 AND alumnos <= 0.122661 : Juventud (15.0/1.0) 
(defrule rule172
	(alumnos)
	(alumnos)
	(alumnos)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; pone > 0 AND pone <= 0.055195 AND pone <= 0.046053 : social (3.0) 
(defrule rule173
	(pone)
	(pone)
	(pone)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; curso > 0.133056 AND curso > 0.164474 AND curso > 0.228571 : Educacion (25.0) 
(defrule rule174
	(curso)
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; delegada > 0.126817 AND delegada <= 0.161476 AND delegada > 0.146718 : participacion (11.0) 
(defrule rule175
	(delegada)
	(delegada)
	(delegada)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; organizada > 0 AND organizada <= 0.055436 : Deportes (7.0) 
(defrule rule176
	(organizada)
	(organizada)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; pone > 0 AND pone > 0.067457 AND pone <= 0.068659 : bienestarsocial (4.0) 
(defrule rule177
	(pone)
	(pone)
	(pone)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; unidad > 0.06135 AND hora <= 0 AND solicitudes <= 0.039623 AND familiar <= 0.046481 AND unidad <= 0.110398 : seguridadCiudadana (8.0) 
(defrule rule178
	(unidad)
	(not (hora))
	(solicitudes)
	(familiar)
	(unidad)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; mujeres > 0.066308 AND mujeres > 0.095092 AND mujeres <= 0.105263 : social (8.0) 
(defrule rule179
	(mujeres)
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; mujeres > 0.050408 AND mujeres > 0.094293 AND mujeres > 0.15113 AND mujeres > 0.339545 : PIM (5.0) 
(defrule rule180
	(mujeres)
	(mujeres)
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_PIM)
	)
)
;; zonas > 0.040223 AND encuentran <= 0.061728 AND zonas <= 0.074342 AND poder <= 0.061728 AND zonas > 0.049383 AND zonas <= 0.061856 : participacion (5.0) 
(defrule rule181
	(zonas)
	(encuentran)
	(zonas)
	(poder)
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; oficial > 0.046055 AND municipios <= 0.021739 AND obra <= 0.205534 AND oficial > 0.052867 : comunicacion (7.0/1.0) 
(defrule rule182
	(oficial)
	(municipios)
	(obra)
	(oficial)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; zonas > 0.040223 AND encuentran <= 0.061728 AND zonas > 0.121951 AND zonas > 0.156425 : medioamb (5.0) 
(defrule rule183
	(zonas)
	(encuentran)
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; zonas > 0.040223 AND encuentran <= 0.061728 AND poder <= 0.090909 AND zonas <= 0.074342 AND zonas <= 0.053057 : comunicacion (4.0) 
(defrule rule184
	(zonas)
	(encuentran)
	(poder)
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; zonas > 0 AND encuentran <= 0.061728 AND poder <= 0.090909 AND zonas <= 0.074342 AND zonas <= 0.053057 : generales (3.0) 
(defrule rule185
	(zonas)
	(encuentran)
	(poder)
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; zonas > 0 AND encuentran <= 0.061728 AND poder <= 0.090909 AND zonas <= 0.121951 AND zonas > 0.074342 : seguridadCiudadana (5.0) 
(defrule rule186
	(zonas)
	(encuentran)
	(poder)
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; oficial > 0 AND municipios <= 0.021739 AND obra <= 0.185072 AND oficial > 0.046055 AND oficial <= 0.051149 : Formacion (6.0) 
(defrule rule187
	(oficial)
	(municipios)
	(obra)
	(oficial)
	(oficial)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; actuaciones > 0.074454 AND consistorio <= 0.057057 AND entidades <= 0.119048 AND actuaciones <= 0.106145 AND actuaciones <= 0.093373 : festejos (8.0) 
(defrule rule188
	(actuaciones)
	(consistorio)
	(entidades)
	(actuaciones)
	(actuaciones)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; admitidos > 0 AND admitidos > 0.045657 : reginterior (7.0) 
(defrule rule189
	(admitidos)
	(admitidos)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; enfermedad > 0 AND presente <= 0.08686 AND enfermedad > 0.09322 : salud (7.0) 
(defrule rule190
	(enfermedad)
	(presente)
	(enfermedad)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; hechos > 0 AND hechos > 0.094994 : trafico (7.0) 
(defrule rule191
	(hechos)
	(hechos)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; espacios > 0 AND plaza <= 0.15127 AND espacios <= 0.063241 AND espacios > 0.062372 : infraestructura (4.0) 
(defrule rule192
	(espacios)
	(plaza)
	(espacios)
	(espacios)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; acudir > 0 AND presente <= 0.08686 AND precio <= 0.062857 AND acudir > 0.052147 AND acudir <= 0.055901 : igualdad (4.0) 
(defrule rule193
	(acudir)
	(presente)
	(precio)
	(acudir)
	(acudir)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; pone > 0 AND pone <= 0.055195 AND pone <= 0.05452 : igualdad (3.0) 
(defrule rule194
	(pone)
	(pone)
	(pone)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; informado > 0 AND informado > 0.071146 : generales (10.0) 
(defrule rule195
	(informado)
	(informado)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; oficial > 0 AND municipios <= 0.021739 AND obra <= 0.185072 AND oficial > 0.046055 : desarrollo (5.0) 
(defrule rule196
	(oficial)
	(municipios)
	(obra)
	(oficial)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; ofrece > 0 AND ofrece <= 0.071429 AND ofrece > 0.059459 : desarrollo (7.0) 
(defrule rule197
	(ofrece)
	(ofrece)
	(ofrece)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; valores > 0.042945 AND proyectos <= 0.142857 AND valores > 0.05452 : ssociales (7.0) 
(defrule rule198
	(valores)
	(proyectos)
	(valores)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; zonas > 0 AND encuentran <= 0.061728 AND zonas <= 0.098706 : ayuntamiento (4.0/1.0) 
(defrule rule199
	(zonas)
	(encuentran)
	(zonas)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; limpieza > 0 AND servicio <= 0.111842 AND integral <= 0 AND trabajando <= 0.060046 AND limpieza <= 0.04343 : empleo (4.0/1.0) 
(defrule rule200
	(limpieza)
	(servicio)
	(not (integral))
	(trabajando)
	(limpieza)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; colectivos > 0 AND proyectos <= 0.142857 AND seguir <= 0.053118 AND colectivos <= 0.057281 AND colectivos <= 0.05226 : salud (4.0) 
(defrule rule201
	(colectivos)
	(proyectos)
	(seguir)
	(colectivos)
	(colectivos)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; madres > 0.04908 AND madres <= 0.058966 AND madres > 0.053373 : bienestarsocial (7.0) 
(defrule rule202
	(madres)
	(madres)
	(madres)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; alumnas > 0 AND marcha <= 0.135593 AND alumnas > 0.05521 AND alumnas <= 0.065789 : social (7.0) 
(defrule rule203
	(alumnas)
	(marcha)
	(alumnas)
	(alumnas)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; deporte > 0.047072 AND forma <= 0.066421 AND deporte > 0.074342 : Deportes (10.0) 
(defrule rule204
	(deporte)
	(forma)
	(deporte)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; alumnos > 0.098684 AND alumnos > 0.184581 AND iniciativa <= 0.25 AND alumnos <= 0.187702 AND alumnos <= 0.185185 : tecnologia (6.0) 
(defrule rule205
	(alumnos)
	(alumnos)
	(iniciativa)
	(alumnos)
	(alumnos)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; puestos > 0 AND puestos <= 0.072165 AND puestos > 0.051665 : desarrollo (7.0) 
(defrule rule206
	(puestos)
	(puestos)
	(puestos)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; puestos > 0 AND puestos <= 0.072165 AND puestos <= 0.043544 : servicios (4.0) 
(defrule rule207
	(puestos)
	(puestos)
	(puestos)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; muestra > 0.049383 AND centenario <= 0 AND acto <= 0.140681 AND muestra > 0.1 : turismo1 (6.0/1.0) 
(defrule rule208
	(muestra)
	(not (centenario))
	(acto)
	(muestra)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; servicio > 0.134969 AND servicio > 0.195876 AND servicio <= 0.223464 AND servicio <= 0.211316 : obras (8.0/1.0) 
(defrule rule209
	(servicio)
	(servicio)
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; vecinas > 0 AND medio <= 0.080801 AND vecinos <= 0.192555 : Agricultura (4.0) 
(defrule rule210
	(vecinas)
	(medio)
	(vecinos)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; vecinos > 0.151223 AND vecinos <= 0.210526 AND vecinos <= 0.174636 AND vecinos <= 0.156604 : medioamb (5.0) 
(defrule rule211
	(vecinos)
	(vecinos)
	(vecinos)
	(vecinos)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; representantes > 0 AND convenio <= 0 AND representantes <= 0.053373 AND acto <= 0.082474 : Formacion (4.0) 
(defrule rule212
	(representantes)
	(not (convenio))
	(representantes)
	(acto)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; vecinos > 0.111366 AND vecinos > 0.192555 AND municipios <= 0.142857 AND vecinos > 0.25 AND vecinos > 0.289644 : infraestructura (7.0) 
(defrule rule213
	(vecinos)
	(vecinos)
	(municipios)
	(vecinos)
	(vecinos)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; periodo > 0.057405 AND periodo > 0.130952 : ciudadania (6.0) 
(defrule rule214
	(periodo)
	(periodo)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; empresa > 0.097403 AND presente <= 0.08686 AND alcaldesa <= 0.134021 AND empresa > 0.135802 AND empresa <= 0.146245 AND empresa <= 0.143149 : saci (3.0) 
(defrule rule215
	(empresa)
	(presente)
	(alcaldesa)
	(empresa)
	(empresa)
	(empresa)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; empresa > 0.097403 AND presente <= 0.08686 AND alcaldesa <= 0.134021 AND empresa <= 0.121359 AND empresa <= 0.107893 AND empresa <= 0.098113 : medioamb (4.0) 
(defrule rule216
	(empresa)
	(presente)
	(alcaldesa)
	(empresa)
	(empresa)
	(empresa)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; empresa > 0.107893 AND presente <= 0.08686 AND alcaldesa <= 0.134021 AND empresa > 0.135802 AND empresa <= 0.166667 AND empresa > 0.146245 : servicios (10.0) 
(defrule rule217
	(empresa)
	(presente)
	(alcaldesa)
	(empresa)
	(empresa)
	(empresa)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; pleno > 0.05767 AND pleno > 0.103604 AND pleno > 0.105626 : comunicacion (6.0) 
(defrule rule218
	(pleno)
	(pleno)
	(pleno)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; parque > 0.052632 AND parque > 0.132221 AND parque <= 0.138568 : obras (4.0) 
(defrule rule219
	(parque)
	(parque)
	(parque)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; parque > 0.052632 AND parque > 0.09407 AND parque > 0.25 : parques (4.0) 
(defrule rule220
	(parque)
	(parque)
	(parque)
		=>
	(assert 
		(ETIQUETA_parques)
	)
)
;; distintos > 0.049522 AND centenario <= 0 AND trabajos <= 0.064591 AND distintos > 0.068182 AND cabo <= 0.061728 : turismo1 (6.0) 
(defrule rule221
	(distintos)
	(not (centenario))
	(trabajos)
	(distintos)
	(cabo)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; distintos > 0.049522 AND centenario <= 0 AND trabajos <= 0.064591 AND distintos <= 0.0594 AND distintos <= 0.055866 : Agricultura (4.0) 
(defrule rule222
	(distintos)
	(not (centenario))
	(trabajos)
	(distintos)
	(distintos)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; cultura > 0.171128 AND cultura > 0.197505 AND cultura > 0.375 : cultura (9.0) 
(defrule rule223
	(cultura)
	(cultura)
	(cultura)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; historia > 0 AND oferta <= 0.040317 AND historia > 0.081081 : cultura (10.0) 
(defrule rule224
	(historia)
	(oferta)
	(historia)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; calles > 0.050517 AND calles > 0.115058 AND calles <= 0.134788 : seguridadCiudadana (6.0) 
(defrule rule225
	(calles)
	(calles)
	(calles)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; mujeres > 0.066308 AND mujeres <= 0.094293 AND mujeres > 0.087379 : ssociales (6.0) 
(defrule rule226
	(mujeres)
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; mujeres > 0.050408 AND especial <= 0.052147 AND mujeres > 0.105263 AND mujeres <= 0.15113 : salud (7.0) 
(defrule rule227
	(mujeres)
	(especial)
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; informa > 0.046012 AND informa <= 0.069211 AND trabajo <= 0 AND informa <= 0.059977 AND informa > 0.055866 : participacion (6.0) 
(defrule rule228
	(informa)
	(informa)
	(not (trabajo))
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; informa > 0.046012 AND informa <= 0.070789 AND trabajo <= 0 AND informa <= 0.063559 AND informa > 0.055866 : medioamb (6.0) 
(defrule rule229
	(informa)
	(informa)
	(not (trabajo))
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; informa > 0.046012 AND informa > 0.076923 AND informa > 0.166667 AND informa > 0.18018 : reginterior (7.0) 
(defrule rule230
	(informa)
	(informa)
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; informa > 0.046012 AND trabajo <= 0 AND informa > 0.076923 AND informa <= 0.142857 : seguridadCiudadana (4.0/1.0) 
(defrule rule231
	(informa)
	(not (trabajo))
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; informa > 0.046012 AND trabajo <= 0 AND informa <= 0.070789 AND informa > 0.061321 AND informa <= 0.069211 : generales (4.0) 
(defrule rule232
	(informa)
	(not (trabajo))
	(informa)
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; informa > 0 AND trabajo <= 0 AND informa > 0.070789 AND informa > 0.084724 AND informa <= 0.166667 : Vivienda (4.0) 
(defrule rule233
	(informa)
	(not (trabajo))
	(informa)
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; municipios > 0.049435 AND valor <= 0 AND mejorar <= 0.064361 AND municipios <= 0.05248 AND municipios <= 0.052147 : asociales (6.0) 
(defrule rule234
	(municipios)
	(not (valor))
	(mejorar)
	(municipios)
	(municipios)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; dirigida > 0 AND dirigida > 0.046701 AND dirigida <= 0.058282 : asociales (6.0) 
(defrule rule235
	(dirigida)
	(dirigida)
	(dirigida)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; ayuda > 0.088957 AND ayuda <= 0.109181 AND ayuda > 0.095768 : ssociales (8.0) 
(defrule rule236
	(ayuda)
	(ayuda)
	(ayuda)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; mejorar > 0.09767 AND mejorar > 0.142857 AND mejorar <= 0.160508 AND mejorar > 0.15415 : comunicacion (10.0) 
(defrule rule237
	(mejorar)
	(mejorar)
	(mejorar)
	(mejorar)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; esfuerzo > 0 AND fase <= 0.039597 AND esfuerzo <= 0.083333 AND esfuerzo <= 0.043677 : Deportes (3.0) 
(defrule rule238
	(esfuerzo)
	(fase)
	(esfuerzo)
	(esfuerzo)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; esfuerzo > 0 AND fase <= 0.039597 AND esfuerzo > 0.091476 : ciudadania (7.0/2.0) 
(defrule rule239
	(esfuerzo)
	(fase)
	(esfuerzo)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; informa > 0 AND trabajo <= 0 AND informa <= 0.061321 AND informa <= 0.046012 : asociales (3.0) 
(defrule rule240
	(informa)
	(not (trabajo))
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; informa > 0 AND trabajo <= 0 AND informa <= 0.070789 AND informa <= 0.061321 : Agricultura (3.0) 
(defrule rule241
	(informa)
	(not (trabajo))
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; mejora > 0.047072 AND mejora <= 0.05226 AND mejora <= 0.048184 : Formacion (9.0) 
(defrule rule242
	(mejora)
	(mejora)
	(mejora)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; solicitudes > 0.073388 AND desempleados <= 0 AND disponen <= 0 AND solicitudes <= 0.088853 AND solicitudes > 0.082437 : bienestarsocial (7.0) 
(defrule rule243
	(solicitudes)
	(not (desempleados))
	(not (disponen))
	(solicitudes)
	(solicitudes)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; necesidades > 0 AND necesidades <= 0.063813 AND necesidades > 0.049654 : bienestarsocial (6.0/1.0) 
(defrule rule244
	(necesidades)
	(necesidades)
	(necesidades)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; necesidades > 0 AND necesidades > 0.067485 AND necesidades <= 0.092105 : social (7.0) 
(defrule rule245
	(necesidades)
	(necesidades)
	(necesidades)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; necesidades > 0 AND necesidades <= 0.051225 AND necesidades <= 0.048057 : urbanismo (3.0) 
(defrule rule246
	(necesidades)
	(necesidades)
	(necesidades)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; datos > 0 AND motivo <= 0.05985 AND datos > 0.073574 : comunicacion (7.0/1.0) 
(defrule rule247
	(datos)
	(motivo)
	(datos)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; empleo > 0.095634 AND personal <= 0 AND mujeres <= 0.085714 AND marcha <= 0.172052 AND plaza <= 0.116816 AND empleo > 0.142857 AND empleo <= 0.257143 : economia (6.0) 
(defrule rule248
	(empleo)
	(not (personal))
	(mujeres)
	(marcha)
	(plaza)
	(empleo)
	(empleo)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; mejora > 0.047072 AND necesidades <= 0 AND mejora <= 0.087736 AND mejora <= 0.048998 AND mejora > 0.048387 : empleo (5.0) 
(defrule rule249
	(mejora)
	(not (necesidades))
	(mejora)
	(mejora)
	(mejora)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; proyectos > 0.038765 AND entidades <= 0.119048 AND municipios <= 0.049435 AND proyectos <= 0.05283 AND proyectos <= 0.046015 : Juventud (6.0) 
(defrule rule250
	(proyectos)
	(entidades)
	(municipios)
	(proyectos)
	(proyectos)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; proyectos > 0 AND entidades <= 0.119048 AND municipios <= 0.067194 AND proyectos <= 0.058442 AND proyectos <= 0.038765 : generales (4.0) 
(defrule rule251
	(proyectos)
	(entidades)
	(municipios)
	(proyectos)
	(proyectos)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; mejora > 0.047072 AND necesidades <= 0 AND mejora <= 0.098118 AND calidad <= 0.071774 AND mejora <= 0.087736 : ssociales (4.0/1.0) 
(defrule rule252
	(mejora)
	(not (necesidades))
	(mejora)
	(calidad)
	(mejora)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; proyectos > 0 AND entidades <= 0.119048 AND municipios <= 0.049435 AND proyectos <= 0.058442 AND proyectos > 0.05283 : comunicacion (4.0) 
(defrule rule253
	(proyectos)
	(entidades)
	(municipios)
	(proyectos)
	(proyectos)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; proyectos > 0 AND entidades <= 0.119048 AND municipios <= 0.049435 AND proyecto <= 0.14717 AND proyectos > 0.079677 : ciudadania (4.0/1.0) 
(defrule rule254
	(proyectos)
	(entidades)
	(municipios)
	(proyecto)
	(proyectos)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; proyectos > 0 AND entidades <= 0.119048 AND municipios <= 0.049435 AND proyectos <= 0.058442 : Formacion (3.0) 
(defrule rule255
	(proyectos)
	(entidades)
	(municipios)
	(proyectos)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; proyectos > 0 AND entidades <= 0.119048 AND municipios <= 0.049435 AND proyectos <= 0.08642 : obras (3.0) 
(defrule rule256
	(proyectos)
	(entidades)
	(municipios)
	(proyectos)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; necesario > 0 AND hora <= 0.110169 AND estado <= 0.099057 AND plazo <= 0.105263 AND necesario <= 0.051125 : participacion (3.0) 
(defrule rule257
	(necesario)
	(hora)
	(estado)
	(plazo)
	(necesario)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; mejora > 0 AND necesidades <= 0 AND forma <= 0.066421 AND mejora <= 0.05226 AND curso <= 0.070353 AND mejora <= 0.047072 : generales (4.0) 
(defrule rule258
	(mejora)
	(not (necesidades))
	(forma)
	(mejora)
	(curso)
	(mejora)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; mejora > 0.048998 AND necesidades <= 0 AND forma <= 0.066421 AND mejora <= 0.115616 AND calidad <= 0.046053 : desarrollo (4.0) 
(defrule rule259
	(mejora)
	(not (necesidades))
	(forma)
	(mejora)
	(calidad)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; mejora > 0 AND curso <= 0.070353 AND necesidades <= 0 AND forma <= 0.066421 AND mejora <= 0.157895 AND mejora <= 0.098118 : salud (3.0) 
(defrule rule260
	(mejora)
	(curso)
	(not (necesidades))
	(forma)
	(mejora)
	(mejora)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; mejora > 0 AND curso <= 0.070353 AND necesidades <= 0 AND forma <= 0.066421 AND mejora <= 0.25 : Vivienda (4.0/1.0) 
(defrule rule261
	(mejora)
	(curso)
	(not (necesidades))
	(forma)
	(mejora)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; mejora > 0 AND curso <= 0.070353 AND interior <= 0 AND necesidades <= 0 : infraestructura (4.0/1.0) 
(defrule rule262
	(mejora)
	(curso)
	(not (interior))
	(not (necesidades))
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; importante > 0.096998 AND momentos <= 0 AND presencia <= 0.055363 AND importante <= 0.117548 AND importante <= 0.103093 : participacion (7.0) 
(defrule rule263
	(importante)
	(not (momentos))
	(presencia)
	(importante)
	(importante)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; convocatoria > 0.055195 AND presente <= 0.08686 AND laboral <= 0.069703 AND iniciativa <= 0.25 AND solicitud <= 0.095238 AND convocatoria <= 0.073801 : Juventud (5.0/1.0) 
(defrule rule264
	(convocatoria)
	(presente)
	(laboral)
	(iniciativa)
	(solicitud)
	(convocatoria)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; presentes > 0.036106 AND partes <= 0 AND tradicional <= 0 AND presentes <= 0.04908 AND presentes > 0.044679 : asociales (3.0) 
(defrule rule265
	(presentes)
	(not (partes))
	(not (tradicional))
	(presentes)
	(presentes)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presentar > 0 AND presente <= 0.08686 AND calle <= 0.07072 AND finaliza <= 0 AND interesados <= 0.06138 AND presentar <= 0.035763 : generales (4.0) 
(defrule rule266
	(presentar)
	(presente)
	(calle)
	(not (finaliza))
	(interesados)
	(presentar)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presentar > 0 AND presente <= 0.08686 AND calle <= 0.07072 AND finaliza > 0 : asociales (4.0) 
(defrule rule267
	(presentar)
	(presente)
	(calle)
	(finaliza)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presentar > 0 AND presente <= 0.08686 AND calle <= 0.07072 AND requisitos <= 0 AND interesados <= 0.06138 : social (3.0) 
(defrule rule268
	(presentar)
	(presente)
	(calle)
	(not (requisitos))
	(interesados)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; cultura > 0.171128 AND cultura <= 0.19305 : Formacion (6.0/1.0) 
(defrule rule269
	(cultura)
	(cultura)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; convocatoria > 0 AND presente <= 0.08686 AND laboral <= 0.069703 AND centros <= 0.107143 AND convocatoria <= 0.067039 AND convocatoria <= 0.045283 : generales (3.0) 
(defrule rule270
	(convocatoria)
	(presente)
	(laboral)
	(centros)
	(convocatoria)
	(convocatoria)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; convocatoria > 0.048387 AND presente <= 0.08686 AND laboral <= 0.069703 AND iniciativa <= 0.25 AND convocatoria <= 0.082474 : Formacion (4.0/1.0) 
(defrule rule271
	(convocatoria)
	(presente)
	(laboral)
	(iniciativa)
	(convocatoria)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; convocatoria > 0 AND presente <= 0.08686 AND laboral <= 0.069703 AND entrega <= 0 AND convocatoria <= 0.25 : empleo (3.0/1.0) 
(defrule rule272
	(convocatoria)
	(presente)
	(laboral)
	(not (entrega))
	(convocatoria)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; convocatoria > 0 AND presente <= 0.08686 AND laboral <= 0.069703 AND convocatoria <= 0.25 : desarrollo (3.0) 
(defrule rule273
	(convocatoria)
	(presente)
	(laboral)
	(convocatoria)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; acceso > 0.046015 AND actividades <= 0.058442 AND centros <= 0.142857 AND acceso <= 0.072383 AND acceso <= 0.06085 AND acceso > 0.055866 : economia (7.0) 
(defrule rule274
	(acceso)
	(actividades)
	(centros)
	(acceso)
	(acceso)
	(acceso)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; acceso > 0.046015 AND actividades <= 0.058442 AND centros <= 0.142857 AND acceso > 0.093533 AND acceso <= 0.101695 : recursosHumanos (6.0) 
(defrule rule275
	(acceso)
	(actividades)
	(centros)
	(acceso)
	(acceso)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; laboral > 0.055215 AND laboral > 0.112266 AND laboral <= 0.148297 : ciudadania (4.0) 
(defrule rule276
	(laboral)
	(laboral)
	(laboral)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; mujeres > 0 AND especial <= 0.052147 AND mujeres > 0.087379 AND mujeres <= 0.105263 : asociales (4.0) 
(defrule rule277
	(mujeres)
	(especial)
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; acuerdo > 0 AND presente <= 0.08686 AND acuerdo <= 0.04822 AND acuerdo > 0.046053 : economia (5.0) 
(defrule rule278
	(acuerdo)
	(presente)
	(acuerdo)
	(acuerdo)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; valor > 0 AND destacar <= 0 AND municipales <= 0.049273 AND valor <= 0.062724 AND valor > 0.055866 : desarrollo (5.0) 
(defrule rule279
	(valor)
	(not (destacar))
	(municipales)
	(valor)
	(valor)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; concejal > 0.09375 AND servicio <= 0.110187 AND concejal <= 0.144661 AND concejal <= 0.09991 : turismo1 (7.0) 
(defrule rule280
	(concejal)
	(servicio)
	(concejal)
	(concejal)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; concejal > 0.126761 AND servicio <= 0.110187 AND concejal <= 0.16896 AND concejal <= 0.144661 : economia (6.0) 
(defrule rule281
	(concejal)
	(servicio)
	(concejal)
	(concejal)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; obras > 0.093555 AND ayudas <= 0.060134 AND obras <= 0.11404 AND obras <= 0.095135 : Educacion (10.0) 
(defrule rule282
	(obras)
	(ayudas)
	(obras)
	(obras)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; charla > 0 AND cargo <= 0 AND charla > 0.055901 : consumo (6.0) 
(defrule rule283
	(charla)
	(not (cargo))
	(charla)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; presentar > 0 AND presente <= 0.08686 AND solicitudes <= 0.088853 : recursosHumanos (3.0/1.0) 
(defrule rule284
	(presentar)
	(presente)
	(solicitudes)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; proyectos > 0 AND entidades <= 0.119048 AND municipios > 0.049435 : medioamb (3.0/1.0) 
(defrule rule285
	(proyectos)
	(entidades)
	(municipios)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; condiciones > 0 AND precio <= 0.062857 AND urbano <= 0 AND condiciones > 0.101695 : Agricultura (3.0/1.0) 
(defrule rule286
	(condiciones)
	(precio)
	(not (urbano))
	(condiciones)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; necesidades > 0 AND necesidades > 0.092105 : saci (4.0/1.0) 
(defrule rule287
	(necesidades)
	(necesidades)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; conocimiento > 0 AND participantes <= 0.056497 AND acto <= 0.082474 AND conocimiento <= 0.114286 : desarrollo (3.0/2.0) 
(defrule rule288
	(conocimiento)
	(participantes)
	(acto)
	(conocimiento)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; conocimiento > 0 AND trabajo <= 0.103321 AND conocimiento > 0.114286 : patrimonio (3.0) 
(defrule rule289
	(conocimiento)
	(trabajo)
	(conocimiento)
		=>
	(assert 
		(ETIQUETA_patrimonio)
	)
)
;; clases > 0.064417 AND clases <= 0.071905 : Formacion (5.0) 
(defrule rule290
	(clases)
	(clases)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; interesadas > 0 AND precio <= 0.062857 AND organizan <= 0 AND participar <= 0.021739 : empleo (3.0) 
(defrule rule291
	(interesadas)
	(precio)
	(not (organizan))
	(participar)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; clausura > 0 AND grupos <= 0 AND clausura > 0.071429 : ciudadania (4.0) 
(defrule rule292
	(clausura)
	(not (grupos))
	(clausura)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; colectivos > 0 AND proyectos <= 0.142857 AND colectivos > 0.063005 : Mujer (5.0/1.0) 
(defrule rule293
	(colectivos)
	(proyectos)
	(colectivos)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; mujeres > 0 AND especial <= 0.052147 AND mujeres > 0.066308 AND mujeres <= 0.105263 : Grupo_Municipal_PSOE (4.0) 
(defrule rule294
	(mujeres)
	(especial)
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; familiar > 0 AND personal <= 0 AND recursos <= 0 AND familiar <= 0.098684 : ssociales (4.0/1.0) 
(defrule rule295
	(familiar)
	(not (personal))
	(not (recursos))
	(familiar)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; medidas > 0 AND zona <= 0.086022 AND ciudadanos <= 0.066528 AND medidas <= 0.046053 : social (4.0) 
(defrule rule296
	(medidas)
	(zona)
	(ciudadanos)
	(medidas)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; piscina > 0 AND enfocadas <= 0 AND medidas <= 0.053961 AND piscina <= 0.04059 : Juventud (4.0) 
(defrule rule297
	(piscina)
	(not (enfocadas))
	(medidas)
	(piscina)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; piscina > 0 AND enfocadas <= 0 AND medidas <= 0.053961 AND piscina > 0.050173 : Deportes (4.0) 
(defrule rule298
	(piscina)
	(not (enfocadas))
	(medidas)
	(piscina)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; horario > 0.131579 AND horario <= 0.157895 AND horario <= 0.133795 AND horario > 0.13172 : participacion (12.0) 
(defrule rule299
	(horario)
	(horario)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; horario > 0.131579 AND horario <= 0.171171 AND horario > 0.144402 AND horario <= 0.157895 : Educacion (6.0) 
(defrule rule300
	(horario)
	(horario)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; resto > 0.05421 AND delegada <= 0.062264 AND puedan <= 0 AND resto > 0.057143 AND resto > 0.061728 : infraestructura (4.0/1.0) 
(defrule rule301
	(resto)
	(delegada)
	(not (puedan))
	(resto)
	(resto)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; vecinos > 0.142068 AND proyecto <= 0.083333 AND vecinos > 0.178571 AND vecinos <= 0.232102 AND vecinos > 0.210526 : obras (6.0) 
(defrule rule302
	(vecinos)
	(proyecto)
	(vecinos)
	(vecinos)
	(vecinos)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; pleno > 0 AND tipo <= 0 AND pleno > 0.091238 : servicios (6.0) 
(defrule rule303
	(pleno)
	(not (tipo))
	(pleno)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; madres > 0.048387 AND seguir <= 0 AND madres <= 0.072368 AND madres > 0.04908 : Formacion (3.0) 
(defrule rule304
	(madres)
	(not (seguir))
	(madres)
	(madres)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; celebrado > 0 AND celebrado > 0.054114 : Deportes (6.0/1.0) 
(defrule rule305
	(celebrado)
	(celebrado)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; calle > 0.089623 AND enfocadas <= 0 AND fiesta <= 0.064865 AND calle <= 0.128958 AND calle > 0.103039 AND calle > 0.108423 : economia (5.0) 
(defrule rule306
	(calle)
	(not (enfocadas))
	(fiesta)
	(calle)
	(calle)
	(calle)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; valor > 0 AND destacar <= 0 AND municipales <= 0.049273 AND valor > 0.063208 : turismo1 (4.0/1.0) 
(defrule rule307
	(valor)
	(not (destacar))
	(municipales)
	(valor)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; marcha > 0.128062 AND marcha <= 0.158602 AND marcha <= 0.135593 AND marcha > 0.130189 : salud (9.0) 
(defrule rule308
	(marcha)
	(marcha)
	(marcha)
	(marcha)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; aquellas > 0.053633 AND aquellas > 0.06659 AND aquellas <= 0.071429 : consumo (7.0/1.0) 
(defrule rule309
	(aquellas)
	(aquellas)
	(aquellas)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; igualdad > 0.059303 AND libre <= 0 AND igualdad > 0.357588 : igualdad (6.0) 
(defrule rule310
	(igualdad)
	(not (libre))
	(igualdad)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; muestra > 0 AND centenario <= 0 AND acto <= 0.078947 AND muestra <= 0.08316 : Mujer (4.0/1.0) 
(defrule rule311
	(muestra)
	(not (centenario))
	(acto)
	(muestra)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; sociedad > 0 AND proyectos <= 0.142857 AND momentos <= 0 AND participantes <= 0.046053 AND marcha <= 0.055438 AND actividades <= 0.12983 : consumo (3.0/1.0) 
(defrule rule312
	(sociedad)
	(proyectos)
	(not (momentos))
	(participantes)
	(marcha)
	(actividades)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; feria > 0 AND actividad <= 0.047189 AND punto <= 0 AND feria > 0.153846 : festejos (6.0) 
(defrule rule313
	(feria)
	(actividad)
	(not (punto))
	(feria)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; fase > 0 AND concejala <= 0 AND fase <= 0.084867 : infraestructura (5.0/1.0) 
(defrule rule314
	(fase)
	(not (concejala))
	(fase)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; inscribirse > 0 AND organiza <= 0 AND organizan <= 0 : Deportes (5.0) 
(defrule rule315
	(inscribirse)
	(not (organiza))
	(not (organizan))
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; ambiente > 0.044812 AND ambiente > 0.076923 AND ambiente <= 0.088957 : turismo1 (3.0) 
(defrule rule316
	(ambiente)
	(ambiente)
	(ambiente)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; ambiente > 0.044812 AND ambiente <= 0.056517 AND ambiente > 0.055723 : participacion (4.0) 
(defrule rule317
	(ambiente)
	(ambiente)
	(ambiente)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; serie > 0.047035 AND importante <= 0 AND serie <= 0.056483 AND serie <= 0.05248 : participacion (6.0) 
(defrule rule318
	(serie)
	(not (importante))
	(serie)
	(serie)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; serie > 0 AND importante <= 0 AND serie > 0.063005 AND serie <= 0.067797 : salud (6.0) 
(defrule rule319
	(serie)
	(not (importante))
	(serie)
	(serie)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; jornadas > 0 AND temas <= 0 AND jornadas <= 0.058687 AND jornadas <= 0.052632 : social (4.0) 
(defrule rule320
	(jornadas)
	(not (temas))
	(jornadas)
	(jornadas)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; consistorio > 0.074627 AND ciudadanos > 0.038937 : obras (3.0/1.0) 
(defrule rule321
	(consistorio)
	(ciudadanos)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; dicha > 0 AND objeto <= 0 AND dicha > 0.046312 AND dicha <= 0.055336 : asociales (5.0) 
(defrule rule322
	(dicha)
	(not (objeto))
	(dicha)
	(dicha)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; pueblo > 0.108316 AND municipales <= 0.060886 AND acto <= 0.143857 AND pueblo > 0.139723 AND pueblo <= 0.162934 : ayuntamiento (7.0) 
(defrule rule323
	(pueblo)
	(municipales)
	(acto)
	(pueblo)
	(pueblo)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; iniciativa > 0.102679 AND convocatoria <= 0.25 AND espacio <= 0.056473 AND iniciativa <= 0.118606 : Juventud (14.0/2.0) 
(defrule rule324
	(iniciativa)
	(convocatoria)
	(espacio)
	(iniciativa)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; medios > 0.06953 AND usuarios <= 0.067194 AND medios > 0.114144 AND medios <= 0.338877 AND medios > 0.119479 : Mujer (4.0) 
(defrule rule325
	(medios)
	(usuarios)
	(medios)
	(medios)
	(medios)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; medios > 0.051429 AND palabras <= 0 AND usuarios <= 0.067194 AND medios <= 0.101617 : economia (7.0/2.0) 
(defrule rule326
	(medios)
	(not (palabras))
	(usuarios)
	(medios)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; medios > 0 AND palabras <= 0 AND usuarios <= 0.067194 AND medios <= 0.114144 : Juventud (4.0/1.0) 
(defrule rule327
	(medios)
	(not (palabras))
	(usuarios)
	(medios)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; medios > 0 AND palabras <= 0 AND usuarios <= 0.067194 AND medios > 0.119479 : Grupo_Municipal_PSOE (4.0) 
(defrule rule328
	(medios)
	(not (palabras))
	(usuarios)
	(medios)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; espacio > 0.043085 AND delegado <= 0.042031 AND proyecto <= 0.052632 AND asociaciones <= 0.074074 AND espacio <= 0.077922 : turismo1 (4.0/1.0) 
(defrule rule329
	(espacio)
	(delegado)
	(proyecto)
	(asociaciones)
	(espacio)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; familiar > 0 AND personal <= 0 AND recursos <= 0 : saci (3.0) 
(defrule rule330
	(familiar)
	(not (personal))
	(not (recursos))
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; espacio > 0.043085 AND delegado <= 0.042031 AND proyecto <= 0.052632 AND asociaciones <= 0.074074 AND espacio <= 0.084906 : medioamb (4.0) 
(defrule rule331
	(espacio)
	(delegado)
	(proyecto)
	(asociaciones)
	(espacio)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; espacio > 0 AND delegado <= 0.042031 AND acto <= 0.078947 AND proyecto <= 0.052632 AND asociaciones <= 0.074074 : Grupo_Municipal_PSOE (4.0/1.0) 
(defrule rule332
	(espacio)
	(delegado)
	(acto)
	(proyecto)
	(asociaciones)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; limpieza > 0 AND calidad <= 0.065234 AND empresa <= 0.098113 : urbanismo (4.0/1.0) 
(defrule rule333
	(limpieza)
	(calidad)
	(empresa)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; caso > 0.089385 AND orden <= 0.021739 AND caso <= 0.115616 AND caso <= 0.093169 AND caso > 0.090069 : ayuntamiento (4.0) 
(defrule rule334
	(caso)
	(orden)
	(caso)
	(caso)
	(caso)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; caso > 0.089385 AND orden <= 0.021739 AND caso > 0.138393 AND serie <= 0.102679 AND caso <= 0.166667 : trafico (5.0/1.0) 
(defrule rule335
	(caso)
	(orden)
	(caso)
	(serie)
	(caso)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; caso > 0.089385 AND orden <= 0.021739 AND serie <= 0.102679 AND caso > 0.115616 AND caso <= 0.157895 : consumo (4.0) 
(defrule rule336
	(caso)
	(orden)
	(serie)
	(caso)
	(caso)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; sala > 0 AND sala <= 0.045414 : Juventud (6.0) 
(defrule rule337
	(sala)
	(sala)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; fomentar > 0.049628 AND grupo <= 0 AND fomentar <= 0.063241 : bienestarsocial (4.0) 
(defrule rule338
	(fomentar)
	(not (grupo))
	(fomentar)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; grupo > 0.113182 AND grupo <= 0.133775 AND grupo > 0.122008 : cultura (11.0) 
(defrule rule339
	(grupo)
	(grupo)
	(grupo)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; interesadas > 0 AND precio <= 0.062857 AND participar > 0.057143 : asociales (3.0) 
(defrule rule340
	(interesadas)
	(precio)
	(participar)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; disfrutar > 0.069774 AND disfrutar <= 0.091119 AND disfrutar <= 0.071774 : igualdad (9.0) 
(defrule rule341
	(disfrutar)
	(disfrutar)
	(disfrutar)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; cartel > 0 AND cartel > 0.087659 : festejos (8.0) 
(defrule rule342
	(cartel)
	(cartel)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; sociedad > 0 AND proyectos <= 0.142857 AND momentos <= 0 AND participantes <= 0.046053 AND actividades <= 0.246914 : desarrollo (2.0/1.0) 
(defrule rule343
	(sociedad)
	(proyectos)
	(not (momentos))
	(participantes)
	(actividades)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; seguir > 0 AND noticias <= 0 AND seguir <= 0.053118 : social (7.0) 
(defrule rule344
	(seguir)
	(not (noticias))
	(seguir)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; clientes <= 0 AND forma > 0.140138 AND presencial <= 0 AND forma <= 0.178434 AND tipo <= 0 AND forma <= 0.155466 AND forma <= 0.152124 : economia (6.0) 
(defrule rule345
	(not (clientes))
	(forma)
	(not (presencial))
	(forma)
	(not (tipo))
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; clientes <= 0 AND forma > 0.140138 AND presencial <= 0 AND forma <= 0.198052 AND forma > 0.166282 AND forma <= 0.178434 : seguridadCiudadana (7.0/1.0) 
(defrule rule346
	(not (clientes))
	(forma)
	(not (presencial))
	(forma)
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; clientes <= 0 AND alcaldesa > 0 AND salud <= 0.021739 : trafico (5.0/1.0) 
(defrule rule347
	(not (clientes))
	(alcaldesa)
	(salud)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; clientes <= 0 AND actuaciones > 0.061685 AND proyectos <= 0.142857 AND objeto <= 0.037736 AND realizando <= 0 AND caso <= 0.040826 AND grupo <= 0 AND actuaciones <= 0.074454 AND actuaciones <= 0.066964 : consumo (5.0) 
(defrule rule348
	(not (clientes))
	(actuaciones)
	(proyectos)
	(objeto)
	(not (realizando))
	(caso)
	(not (grupo))
	(actuaciones)
	(actuaciones)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; clientes > 0 : Comercio (5.0) 
(defrule rule349
	(clientes)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; actuaciones > 0.068607 AND proyectos <= 0.142857 AND objeto <= 0.037736 AND realizando <= 0 AND caso <= 0.040826 AND actuaciones <= 0.074454 AND actuaciones <= 0.070571 : participacion (3.0) 
(defrule rule350
	(actuaciones)
	(proyectos)
	(objeto)
	(not (realizando))
	(caso)
	(actuaciones)
	(actuaciones)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; actuaciones > 0.070571 AND proyectos <= 0.142857 AND objeto <= 0.037736 AND realizando <= 0 AND caso <= 0.040826 AND actuaciones <= 0.100324 AND actuaciones > 0.074454 : turismo1 (4.0) 
(defrule rule351
	(actuaciones)
	(proyectos)
	(objeto)
	(not (realizando))
	(caso)
	(actuaciones)
	(actuaciones)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; forma > 0.136476 AND presencial <= 0 AND mundo <= 0 AND forma > 0.203742 AND forma <= 0.215385 AND forma <= 0.207579 : ayuntamiento (6.0) 
(defrule rule352
	(forma)
	(not (presencial))
	(not (mundo))
	(forma)
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; forma > 0.136476 AND presencial <= 0 AND mundo <= 0 AND forma <= 0.198052 AND forma > 0.152124 AND forma <= 0.155466 : desarrollo (6.0) 
(defrule rule353
	(forma)
	(not (presencial))
	(not (mundo))
	(forma)
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; forma > 0.136476 AND presencial <= 0 AND mundo <= 0 AND forma > 0.203742 AND forma <= 0.215385 : Comercio (4.0/1.0) 
(defrule rule354
	(forma)
	(not (presencial))
	(not (mundo))
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; gracias > 0.055215 AND recursos <= 0 AND puedan <= 0 AND gracias > 0.06582 AND gracias <= 0.099885 : economia (6.0) 
(defrule rule355
	(gracias)
	(not (recursos))
	(not (puedan))
	(gracias)
	(gracias)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; gracias > 0.055215 AND recursos <= 0 AND puedan <= 0 AND importante <= 0.107692 AND gracias <= 0.0625 : urbanismo (4.0/1.0) 
(defrule rule356
	(gracias)
	(not (recursos))
	(not (puedan))
	(importante)
	(gracias)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; representantes > 0 AND representantes > 0.090615 : Comercio (4.0) 
(defrule rule357
	(representantes)
	(representantes)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; equipo > 0.058282 AND equipo > 0.095238 AND equipo > 0.105626 : ayuntamiento (7.0/1.0) 
(defrule rule358
	(equipo)
	(equipo)
	(equipo)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; familias > 0 AND delegada > 0.101695 AND delegada <= 0.146718 : ayuntamiento (2.0) 
(defrule rule359
	(familias)
	(delegada)
	(delegada)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; cabo > 0.119048 AND calidad <= 0.050868 AND cabo > 0.134181 AND cabo <= 0.147239 AND cabo <= 0.135956 : igualdad (5.0) 
(defrule rule360
	(cabo)
	(calidad)
	(cabo)
	(cabo)
	(cabo)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; familias > 0 AND familias > 0.099792 AND delegada <= 0.086158 : ssociales (6.0/1.0) 
(defrule rule361
	(familias)
	(familias)
	(delegada)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; familias > 0 AND delegada <= 0.126817 AND familias <= 0.069505 : igualdad (5.0/1.0) 
(defrule rule362
	(familias)
	(delegada)
	(familias)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; precio > 0.046185 AND recoge <= 0 AND marcha <= 0.072165 AND precio > 0.077721 AND precio <= 0.083799 : participacion (6.0) 
(defrule rule363
	(precio)
	(not (recoge))
	(marcha)
	(precio)
	(precio)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; honor > 0 AND honor > 0.105924 : Relacionesinstitucionales (3.0) 
(defrule rule364
	(honor)
	(honor)
		=>
	(assert 
		(ETIQUETA_Relacionesinstitucionales)
	)
)
;; correo > 0 : Juventud (7.0/1.0) 
(defrule rule365
	(correo)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; asistencia > 0 AND hijos <= 0 AND asistencia <= 0.063559 : salud (3.0) 
(defrule rule366
	(asistencia)
	(not (hijos))
	(asistencia)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; inicio > 0 AND inicio <= 0.061527 AND inicio > 0.053118 : Formacion (3.0) 
(defrule rule367
	(inicio)
	(inicio)
	(inicio)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; precio > 0.046185 AND recoge <= 0 AND marcha <= 0.072165 AND precio > 0.083799 : cultura (4.0) 
(defrule rule368
	(precio)
	(not (recoge))
	(marcha)
	(precio)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; proyecto > 0.117594 AND proyecto > 0.133279 AND proyecto <= 0.183692 AND zona <= 0.043008 : medioamb (5.0) 
(defrule rule369
	(proyecto)
	(proyecto)
	(proyecto)
	(zona)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; proyecto > 0.117594 AND proyecto > 0.131403 AND proyecto <= 0.14717 : bienestarsocial (8.0) 
(defrule rule370
	(proyecto)
	(proyecto)
	(proyecto)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; cabo > 0.119048 AND calidad <= 0.050868 AND cabo <= 0.133634 AND cabo > 0.123711 AND cabo <= 0.130977 : Mujer (4.0) 
(defrule rule371
	(cabo)
	(calidad)
	(cabo)
	(cabo)
	(cabo)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; cabo > 0.108376 AND mantenimiento <= 0 AND desarrollo <= 0.053915 AND cabo > 0.123711 AND cabo <= 0.135956 AND cabo <= 0.133634 : servicios (3.0) 
(defrule rule372
	(cabo)
	(not (mantenimiento))
	(desarrollo)
	(cabo)
	(cabo)
	(cabo)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; cabo > 0.108376 AND mantenimiento <= 0 AND desarrollo <= 0.053915 AND proyecto <= 0.088957 AND cabo > 0.123711 AND cabo <= 0.147239 AND cabo > 0.135956 : seguridadCiudadana (5.0) 
(defrule rule373
	(cabo)
	(not (mantenimiento))
	(desarrollo)
	(proyecto)
	(cabo)
	(cabo)
	(cabo)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; lectura > 0 AND obra <= 0 AND lectura > 0.068202 : cultura (7.0/1.0) 
(defrule rule374
	(lectura)
	(not (obra))
	(lectura)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; gracias > 0.054735 AND recursos <= 0 AND puedan <= 0 AND importante <= 0.107692 AND gracias > 0.090909 : tecnologia (4.0) 
(defrule rule375
	(gracias)
	(not (recursos))
	(not (puedan))
	(importante)
	(gracias)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; importancia > 0 AND tipo <= 0 AND participantes <= 0 AND importancia > 0.074074 : Agricultura (4.0/1.0) 
(defrule rule376
	(importancia)
	(not (tipo))
	(not (participantes))
	(importancia)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; meses > 0.133885 AND ciudad <= 0.061688 AND meses <= 0.145194 AND meses > 0.135476 : empleo (6.0/1.0) 
(defrule rule377
	(meses)
	(ciudad)
	(meses)
	(meses)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; caso > 0.076613 AND orden <= 0.021739 AND caso <= 0.1 AND caso > 0.089385 AND caso > 0.093169 : medioamb (3.0) 
(defrule rule378
	(caso)
	(orden)
	(caso)
	(caso)
	(caso)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; caso > 0.076613 AND orden <= 0.021739 AND largo <= 0 AND caso > 0.108414 AND caso <= 0.148909 : servicios (3.0) 
(defrule rule379
	(caso)
	(orden)
	(not (largo))
	(caso)
	(caso)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; entrada > 0.056604 AND entrada > 0.077811 AND entrada > 0.094595 AND entrada <= 0.117505 : cultura (5.0) 
(defrule rule380
	(entrada)
	(entrada)
	(entrada)
	(entrada)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; recorrido > 0 AND recorrido > 0.077274 AND recorrido <= 0.088031 : turismo1 (4.0) 
(defrule rule381
	(recorrido)
	(recorrido)
	(recorrido)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; hora > 0.060794 AND taller <= 0.105791 AND actividad <= 0.121469 AND hora <= 0.070034 AND hora <= 0.069498 : turismo1 (5.0/1.0) 
(defrule rule382
	(hora)
	(taller)
	(actividad)
	(hora)
	(hora)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; obra > 0.057633 AND obra <= 0.082971 AND obra <= 0.081892 : Formacion (7.0/1.0) 
(defrule rule383
	(obra)
	(obra)
	(obra)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; forma > 0.136476 AND presencial <= 0 AND mundo <= 0 AND forma <= 0.198052 AND forma <= 0.150402 : servicios (4.0) 
(defrule rule384
	(forma)
	(not (presencial))
	(not (mundo))
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; obra > 0.057633 AND puesto <= 0 AND obra <= 0.094972 AND obra <= 0.082971 : Educacion (7.0) 
(defrule rule385
	(obra)
	(not (puesto))
	(obra)
	(obra)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; iniciativa > 0.083333 AND social <= 0.152542 AND empresas <= 0 AND iniciativa <= 0.102857 AND participantes <= 0 : asociales (5.0) 
(defrule rule386
	(iniciativa)
	(social)
	(not (empresas))
	(iniciativa)
	(not (participantes))
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; padres > 0.076687 AND familias <= 0.03321 AND padres > 0.105263 AND padres > 0.152476 : tecnologia (5.0) 
(defrule rule387
	(padres)
	(familias)
	(padres)
	(padres)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; plazo > 0.140747 AND precio <= 0.062857 AND necesario <= 0 AND plazo > 0.182796 AND plazo <= 0.257143 AND plazo <= 0.22619 : asociales (8.0) 
(defrule rule388
	(plazo)
	(precio)
	(not (necesario))
	(plazo)
	(plazo)
	(plazo)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; alegaciones > 0 : reginterior (4.0) 
(defrule rule389
	(alegaciones)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; interesadas > 0 AND precio <= 0.062857 : mayores (2.0) 
(defrule rule390
	(interesadas)
	(precio)
		=>
	(assert 
		(ETIQUETA_mayores)
	)
)
;; prueba <= 0 AND bomberos <= 0 AND tribunal > 0 : recursosHumanos (5.0/1.0) 
(defrule rule391
	(not (prueba))
	(not (bomberos))
	(tribunal)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; prueba > 0 : trafico (5.0/1.0) 
(defrule rule392
	(prueba)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; bomberos > 0 : trafico (4.0) 
(defrule rule393
	(bomberos)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; funcionamiento > 0 AND municipales <= 0.118619 : obras (3.0/1.0) 
(defrule rule394
	(funcionamiento)
	(municipales)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; realizando > 0 AND zonas <= 0.061856 AND casco <= 0.058891 : obras (2.0) 
(defrule rule395
	(realizando)
	(zonas)
	(casco)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; muestra > 0 AND centenario <= 0 AND acto <= 0.078947 : ciudadania (2.0) 
(defrule rule396
	(muestra)
	(not (centenario))
	(acto)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; sociedad > 0 AND naturaleza <= 0 AND actividades <= 0.12983 : bienestarsocial (2.0) 
(defrule rule397
	(sociedad)
	(not (naturaleza))
	(actividades)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; objeto > 0 AND objeto <= 0.061728 : tecnologia (3.0/1.0) 
(defrule rule398
	(objeto)
	(objeto)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; enlace > 0 AND acceder <= 0.071429 AND enlace > 0.042477 : comunicacion (3.0/1.0) 
(defrule rule399
	(enlace)
	(acceder)
	(enlace)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; clases > 0 : Educacion (6.0/1.0) 
(defrule rule400
	(clases)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; alumnado > 0 AND alumnado <= 0.10559 : Juventud (2.0/1.0) 
(defrule rule401
	(alumnado)
	(alumnado)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; materia > 0.047884 AND servicio <= 0.110187 AND materia <= 0.062276 : ssociales (3.0) 
(defrule rule402
	(materia)
	(servicio)
	(materia)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; convivencia > 0 AND tipo <= 0 AND mayores <= 0.064516 AND convivencia <= 0.039474 : social (3.0) 
(defrule rule403
	(convivencia)
	(not (tipo))
	(mayores)
	(convivencia)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; municipios > 0.041938 AND iniciativa > 0.054192 : medioamb (3.0/1.0) 
(defrule rule404
	(municipios)
	(iniciativa)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; puntos > 0 AND cargo <= 0 AND puntos <= 0.040223 : generales (4.0) 
(defrule rule405
	(puntos)
	(not (cargo))
	(puntos)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; asociaciones > 0.058313 AND encuentro <= 0.065595 AND salida <= 0.021739 AND actividades <= 0.084746 AND asociaciones <= 0.085714 : bienestarsocial (4.0) 
(defrule rule406
	(asociaciones)
	(encuentro)
	(salida)
	(actividades)
	(asociaciones)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; teatro > 0.055831 AND cargo <= 0 AND obra <= 0.070423 AND teatro <= 0.082406 : Juventud (6.0) 
(defrule rule407
	(teatro)
	(not (cargo))
	(obra)
	(teatro)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; taller > 0.181141 AND taller <= 0.234927 : Mujer (10.0/1.0) 
(defrule rule408
	(taller)
	(taller)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; forma > 0.113872 AND presencial <= 0 AND persona <= 0 AND mundo <= 0 AND forma > 0.198052 AND forma <= 0.207579 : Mujer (5.0) 
(defrule rule409
	(forma)
	(not (presencial))
	(not (persona))
	(not (mundo))
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; alumnado > 0.067485 AND alumnado <= 0.157895 : PIM (2.0) 
(defrule rule410
	(alumnado)
	(alumnado)
		=>
	(assert 
		(ETIQUETA_PIM)
	)
)
;; listado > 0 AND listado > 0.046053 : empleo (5.0/1.0) 
(defrule rule411
	(listado)
	(listado)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; forma > 0.107431 AND presencial <= 0 AND persona <= 0 AND mundo <= 0 AND forma > 0.178434 AND forma <= 0.203742 : comunicacion (3.0) 
(defrule rule412
	(forma)
	(not (presencial))
	(not (persona))
	(not (mundo))
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; horario > 0.125472 AND horario <= 0.145091 AND horario <= 0.129736 AND horario <= 0.128955 : cultura (7.0) 
(defrule rule413
	(horario)
	(horario)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; horario > 0.129736 AND marcha <= 0 AND horario <= 0.173729 AND horario <= 0.136971 AND horario <= 0.131579 : social (4.0) 
(defrule rule414
	(horario)
	(not (marcha))
	(horario)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; horario > 0.123586 AND horario > 0.173729 AND horario <= 0.214286 AND horario > 0.190476 : consumo (5.0) 
(defrule rule415
	(horario)
	(horario)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; organizada > 0 AND organizada <= 0.058282 : asociales (3.0) 
(defrule rule416
	(organizada)
	(organizada)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; forma > 0.107431 AND presencial <= 0 AND semana <= 0.021739 AND persona <= 0 AND mundo <= 0 AND forma <= 0.166282 : Formacion (3.0/1.0) 
(defrule rule417
	(forma)
	(not (presencial))
	(semana)
	(not (persona))
	(not (mundo))
	(forma)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; horario > 0.116564 AND horario <= 0.145091 AND cabo <= 0.108376 AND horario > 0.129736 AND horario <= 0.133795 : desarrollo (4.0) 
(defrule rule418
	(horario)
	(horario)
	(cabo)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; disfrutar > 0.067195 AND disfrutar <= 0.074129 AND disfrutar > 0.071774 : Formacion (5.0) 
(defrule rule419
	(disfrutar)
	(disfrutar)
	(disfrutar)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; meses > 0.11039 AND acto <= 0.220374 AND meses <= 0.133929 AND meses > 0.125802 : consumo (4.0/1.0) 
(defrule rule420
	(meses)
	(acto)
	(meses)
	(meses)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; meses > 0.11039 AND acto <= 0.186591 AND meses <= 0.145194 AND meses > 0.125802 : economia (4.0) 
(defrule rule421
	(meses)
	(acto)
	(meses)
	(meses)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; meses > 0.11039 AND acto <= 0.186591 AND meses <= 0.155018 AND meses <= 0.118606 : Formacion (3.0) 
(defrule rule422
	(meses)
	(acto)
	(meses)
	(meses)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; meses > 0.11039 AND acto <= 0.186591 AND meses <= 0.165254 AND proyecto <= 0 : ssociales (3.0/1.0) 
(defrule rule423
	(meses)
	(acto)
	(meses)
	(not (proyecto))
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; meses > 0.107362 AND acto <= 0.186591 AND meses > 0.168821 : infraestructura (4.0/2.0) 
(defrule rule424
	(meses)
	(acto)
	(meses)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; instancia > 0 AND instancia <= 0.095238 : saci (2.0) 
(defrule rule425
	(instancia)
	(instancia)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; abre <= 0 AND horario > 0.116564 AND horario > 0.171171 AND forma <= 0.066421 AND horario <= 0.228571 AND horario > 0.190476 : ciudadania (5.0) 
(defrule rule426
	(not (abre))
	(horario)
	(horario)
	(forma)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; abre > 0 : social (5.0) 
(defrule rule427
	(abre)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; acceder > 0 AND acceder <= 0.095238 : empleo (2.0/1.0) 
(defrule rule428
	(acceder)
	(acceder)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; proceso > 0 AND calidad <= 0 AND disfrutar <= 0 : empleo (4.0/2.0) 
(defrule rule429
	(proceso)
	(not (calidad))
	(not (disfrutar))
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; principal > 0 AND objetivo <= 0.077922 AND principal > 0.057547 : turismo1 (3.0/1.0) 
(defrule rule430
	(principal)
	(objetivo)
	(principal)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; delegado > 0 AND horario <= 0 AND delegado > 0.065261 AND delegado <= 0.092204 : participacion (3.0) 
(defrule rule431
	(delegado)
	(not (horario))
	(delegado)
	(delegado)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; entrada > 0.052997 AND pueblo <= 0.057143 AND entrada > 0.077811 AND entrada <= 0.117505 : servicios (3.0/1.0) 
(defrule rule432
	(entrada)
	(pueblo)
	(entrada)
	(entrada)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; trabajo > 0.135639 AND trabajo <= 0.192855 AND trabajo <= 0.148909 : obras (4.0) 
(defrule rule433
	(trabajo)
	(trabajo)
	(trabajo)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; forma > 0.103194 AND presencial <= 0 AND persona <= 0 AND general <= 0 AND forma <= 0.107431 AND forma > 0.104294 : Juventud (3.0) 
(defrule rule434
	(forma)
	(not (presencial))
	(not (persona))
	(not (general))
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; local > 0.143988 AND jefe <= 0 AND local <= 0.178651 AND local <= 0.167925 : participacion (3.0) 
(defrule rule435
	(local)
	(not (jefe))
	(local)
	(local)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; local > 0.143988 AND jefe <= 0 AND local <= 0.185969 AND local > 0.178651 : empleo (11.0) 
(defrule rule436
	(local)
	(not (jefe))
	(local)
	(local)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; curso > 0.125 AND curso > 0.150977 AND curso > 0.164474 : empleo (12.0) 
(defrule rule437
	(curso)
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; forma > 0.103194 AND presencial <= 0 AND persona <= 0 AND general <= 0 AND forma <= 0.155466 : asociales (3.0/1.0) 
(defrule rule438
	(forma)
	(not (presencial))
	(not (persona))
	(not (general))
	(forma)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; municipales > 0.092025 AND funcionamiento <= 0.074074 AND objetivo <= 0.077922 AND participantes <= 0.051149 AND municipales <= 0.118619 : Agricultura (4.0/1.0) 
(defrule rule439
	(municipales)
	(funcionamiento)
	(objetivo)
	(participantes)
	(municipales)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; municipales > 0.077992 AND funcionamiento <= 0.074074 AND participantes <= 0.051149 AND plan <= 0.046012 AND municipales <= 0.13372 AND municipales > 0.112264 : ayuntamiento (3.0) 
(defrule rule440
	(municipales)
	(funcionamiento)
	(participantes)
	(plan)
	(municipales)
	(municipales)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; municipales > 0.077992 AND funcionamiento <= 0.074074 AND participantes <= 0.051149 AND plan <= 0.046012 AND instalaciones <= 0 : asociales (3.0/1.0) 
(defrule rule441
	(municipales)
	(funcionamiento)
	(participantes)
	(plan)
	(not (instalaciones))
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; municipales > 0.077992 AND funcionamiento <= 0.074074 AND objetivo <= 0.077922 AND participantes <= 0.051149 : urbanismo (3.0/1.0) 
(defrule rule442
	(municipales)
	(funcionamiento)
	(objetivo)
	(participantes)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; curso > 0.125 AND curso <= 0.143921 AND curso > 0.133056 AND curso <= 0.143513 : economia (7.0) 
(defrule rule443
	(curso)
	(curso)
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; enlace > 0 AND acceder <= 0.071429 : Deportes (2.0) 
(defrule rule444
	(enlace)
	(acceder)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; escuela > 0.03705 AND actividad <= 0.069042 AND escuela > 0.04822 : participacion (3.0/1.0) 
(defrule rule445
	(escuela)
	(actividad)
	(escuela)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; entrada > 0.048542 AND tarde <= 0 AND entrada > 0.073171 AND entrada <= 0.094595 : festejos (2.0) 
(defrule rule446
	(entrada)
	(not (tarde))
	(entrada)
	(entrada)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; entrada > 0.048542 AND tarde <= 0 AND entrada <= 0.056604 : Juventud (3.0/1.0) 
(defrule rule447
	(entrada)
	(not (tarde))
	(entrada)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; entrada > 0 AND tarde <= 0 AND cargo <= 0 AND entrada <= 0.094595 : ayuntamiento (2.0) 
(defrule rule448
	(entrada)
	(not (tarde))
	(not (cargo))
	(entrada)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; participantes > 0.096931 AND participantes <= 0.123457 AND participantes > 0.111663 AND participantes <= 0.122406 : Juventud (10.0) 
(defrule rule449
	(participantes)
	(participantes)
	(participantes)
	(participantes)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; interesados > 0.039474 AND proyecto <= 0.052632 AND interesados > 0.063963 : empleo (3.0/1.0) 
(defrule rule450
	(interesados)
	(proyecto)
	(interesados)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; oferta > 0 AND oferta <= 0.048722 : Juventud (4.0/1.0) 
(defrule rule451
	(oferta)
	(oferta)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; meses > 0.098684 AND acto <= 0.186591 AND proyecto <= 0 AND meses > 0.107362 : bienestarsocial (3.0/1.0) 
(defrule rule452
	(meses)
	(acto)
	(not (proyecto))
	(meses)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; requisitos > 0 AND requisitos <= 0.055866 : generales (5.0/1.0) 
(defrule rule453
	(requisitos)
	(requisitos)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; requisitos > 0 AND requisitos <= 0.095238 : ssociales (4.0) 
(defrule rule454
	(requisitos)
	(requisitos)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; gobierno > 0.090738 AND cargo <= 0 AND gobierno <= 0.133117 : comunicacion (4.0/1.0) 
(defrule rule455
	(gobierno)
	(not (cargo))
	(gobierno)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; ayuda > 0.034048 AND ayuda > 0.123586 : social (4.0) 
(defrule rule456
	(ayuda)
	(ayuda)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; actuaciones > 0.051665 AND objeto <= 0.037736 AND importante <= 0.050526 AND actuaciones <= 0.074454 : generales (6.0) 
(defrule rule457
	(actuaciones)
	(objeto)
	(importante)
	(actuaciones)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; actuaciones > 0.061685 AND objeto <= 0.037736 AND actuaciones > 0.133947 : _RSS (3.0/1.0) 
(defrule rule458
	(actuaciones)
	(objeto)
	(actuaciones)
		=>
	(assert 
		(ETIQUETA__RSS)
	)
)
;; actuaciones > 0.04391 AND objeto <= 0.037736 AND importante <= 0 AND actuaciones <= 0.106145 : Agricultura (2.0/1.0) 
(defrule rule459
	(actuaciones)
	(objeto)
	(not (importante))
	(actuaciones)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; actuaciones > 0 AND objeto <= 0.037736 AND semana <= 0.049383 : Comercio (3.0/1.0) 
(defrule rule460
	(actuaciones)
	(objeto)
	(semana)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; acuerdo > 0 AND acuerdo <= 0.037993 : generales (3.0) 
(defrule rule461
	(acuerdo)
	(acuerdo)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; consistorio > 0.04 AND vecinos <= 0 AND consistorio <= 0.080161 : consumo (3.0/2.0) 
(defrule rule462
	(consistorio)
	(not (vecinos))
	(consistorio)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; consistorio > 0 AND vecinos <= 0 AND consistorio <= 0.059211 : generales (3.0/1.0) 
(defrule rule463
	(consistorio)
	(not (vecinos))
	(consistorio)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; consistorio > 0 AND vecinos <= 0 : infraestructura (3.0/1.0) 
(defrule rule464
	(consistorio)
	(not (vecinos))
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; empresa > 0.062693 AND aquellos <= 0 AND evento <= 0 AND instalaciones <= 0 AND empresa > 0.121359 : tecnologia (4.0/1.0) 
(defrule rule465
	(empresa)
	(not (aquellos))
	(not (evento))
	(not (instalaciones))
	(empresa)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; precio > 0.034991 AND marcha <= 0.079074 AND precio <= 0.062857 AND precio > 0.046185 : Juventud (3.0) 
(defrule rule466
	(precio)
	(marcha)
	(precio)
	(precio)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; acceso > 0.046015 AND marcha <= 0 AND acceso <= 0.073574 : comunicacion (5.0/1.0) 
(defrule rule467
	(acceso)
	(not (marcha))
	(acceso)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; meses > 0.095639 AND actividades <= 0.084746 AND acto > 0.186591 : patrimonio (3.0/1.0) 
(defrule rule468
	(meses)
	(actividades)
	(acto)
		=>
	(assert 
		(ETIQUETA_patrimonio)
	)
)
;; obras > 0.082762 AND cargo <= 0 AND obras > 0.095135 AND obras <= 0.11534 : cultura (5.0) 
(defrule rule469
	(obras)
	(not (cargo))
	(obras)
	(obras)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; convivencia > 0 AND tipo <= 0 AND convivencia <= 0.043478 : mayores (2.0) 
(defrule rule470
	(convivencia)
	(not (tipo))
	(convivencia)
		=>
	(assert 
		(ETIQUETA_mayores)
	)
)
;; celebrado > 0 AND celebrado <= 0.046481 : Educacion (3.0) 
(defrule rule471
	(celebrado)
	(celebrado)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; obras > 0.082762 AND cargo <= 0 AND obras <= 0.088803 : medioamb (3.0/1.0) 
(defrule rule472
	(obras)
	(not (cargo))
	(obras)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; tradicional > 0 AND tradicional <= 0.105178 AND tradicional > 0.067825 : turismo1 (3.0) 
(defrule rule473
	(tradicional)
	(tradicional)
	(tradicional)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; presencia > 0.040797 AND semana <= 0.067039 AND cabo <= 0.055195 AND presencia <= 0.055363 : Educacion (4.0) 
(defrule rule474
	(presencia)
	(semana)
	(cabo)
	(presencia)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; precio > 0 AND organiza <= 0 AND marcha <= 0 AND precio > 0.046185 : ayuntamiento (3.0) 
(defrule rule475
	(precio)
	(not (organiza))
	(not (marcha))
	(precio)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencia > 0.05335 AND actividades <= 0.084746 AND cabo <= 0.055195 AND presencia <= 0.082474 : comunicacion (2.0/1.0) 
(defrule rule476
	(presencia)
	(actividades)
	(cabo)
	(presencia)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; recorrido > 0 AND recorrido <= 0.053057 : cultura (3.0) 
(defrule rule477
	(recorrido)
	(recorrido)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; mejorar > 0.074074 AND calidad <= 0 AND iniciativa <= 0.102857 AND objetivo <= 0.121163 AND mejorar <= 0.07748 : Educacion (4.0/1.0) 
(defrule rule478
	(mejorar)
	(not (calidad))
	(iniciativa)
	(objetivo)
	(mejorar)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; libro > 0 AND libro <= 0.05821 : Educacion (3.0) 
(defrule rule479
	(libro)
	(libro)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; mejorar > 0.085526 AND iniciativa <= 0.054192 AND objetivo > 0.077922 : medioamb (4.0/1.0) 
(defrule rule480
	(mejorar)
	(iniciativa)
	(objetivo)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; interesados > 0 AND proyecto <= 0.052632 AND interesados > 0.04428 : ayuntamiento (3.0/1.0) 
(defrule rule481
	(interesados)
	(proyecto)
	(interesados)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; distintas > 0.051729 AND distintas <= 0.056591 AND distintas > 0.053432 : igualdad (3.0) 
(defrule rule482
	(distintas)
	(distintas)
	(distintas)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; participantes > 0.096931 AND participantes > 0.126874 AND participantes > 0.153846 : Deportes (9.0) 
(defrule rule483
	(participantes)
	(participantes)
	(participantes)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; centros > 0.032075 AND centros > 0.081921 AND municipio <= 0.065217 AND centros > 0.169418 : tecnologia (4.0) 
(defrule rule484
	(centros)
	(centros)
	(municipio)
	(centros)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; gobierno > 0 AND actividad <= 0.021739 AND gobierno > 0.133117 : ciudadania (3.0/2.0) 
(defrule rule485
	(gobierno)
	(actividad)
	(gobierno)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; final > 0.06135 AND final <= 0.072765 AND final > 0.068627 : festejos (3.0) 
(defrule rule486
	(final)
	(final)
	(final)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; final > 0.043609 AND final <= 0.072765 : participacion (3.0/1.0) 
(defrule rule487
	(final)
	(final)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; trabajos > 0 AND caso <= 0.021739 AND acto <= 0 : cultura (4.0/1.0) 
(defrule rule488
	(trabajos)
	(caso)
	(not (acto))
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; tipo > 0.053866 AND general <= 0 AND concurso <= 0.048199 AND municipio <= 0.114944 AND tipo <= 0.079051 : igualdad (5.0/1.0) 
(defrule rule489
	(tipo)
	(not (general))
	(concurso)
	(municipio)
	(tipo)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; celebra > 0.042477 AND acto <= 0.078947 AND celebra <= 0.052632 AND celebra <= 0.050166 : comunicacion (5.0) 
(defrule rule490
	(celebra)
	(acto)
	(celebra)
	(celebra)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; celebra > 0.042477 AND acto <= 0.078947 AND celebra <= 0.053633 AND celebra > 0.052632 : participacion (4.0) 
(defrule rule491
	(celebra)
	(acto)
	(celebra)
	(celebra)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; presente > 0.039194 AND presente <= 0.052632 AND presente <= 0.040663 : festejos (3.0) 
(defrule rule492
	(presente)
	(presente)
	(presente)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presente > 0.040663 AND presente <= 0.052632 AND presente <= 0.049023 : Juventud (3.0) 
(defrule rule493
	(presente)
	(presente)
	(presente)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; presente > 0.040663 AND presente <= 0.061856 : Agricultura (4.0/1.0) 
(defrule rule494
	(presente)
	(presente)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; presente > 0.050391 AND presente <= 0.062284 : participacion (2.0) 
(defrule rule495
	(presente)
	(presente)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; largo > 0.048309 AND provincial <= 0 AND tarde <= 0 AND largo <= 0.07298 : medioamb (2.0) 
(defrule rule496
	(largo)
	(not (provincial))
	(not (tarde))
	(largo)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; centros > 0.032075 AND centros <= 0.079411 AND centros > 0.041428 : asociales (4.0/1.0) 
(defrule rule497
	(centros)
	(centros)
	(centros)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; centros > 0.032075 AND municipio <= 0.065217 AND centros <= 0.058442 : cultura (3.0) 
(defrule rule498
	(centros)
	(municipio)
	(centros)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; centros > 0 AND personal <= 0 AND municipio > 0.065217 : Juventud (3.0) 
(defrule rule499
	(centros)
	(not (personal))
	(municipio)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; centros > 0 AND personal <= 0 AND centros <= 0.086957 : salud (2.0) 
(defrule rule500
	(centros)
	(not (personal))
	(centros)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; realiza > 0 AND social <= 0.048358 : consumo (3.0/2.0) 
(defrule rule501
	(realiza)
	(social)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; forma > 0 AND presencial <= 0 AND general > 0 AND persona <= 0 : bienestarsocial (2.0/1.0) 
(defrule rule502
	(forma)
	(not (presencial))
	(general)
	(not (persona))
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; acuerdo > 0 AND acuerdo <= 0.055215 : comunicacion (2.0) 
(defrule rule503
	(acuerdo)
	(acuerdo)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; forma > 0 AND presencial <= 0 AND general <= 0 AND forma <= 0.07461 AND marcha <= 0.055438 : festejos (3.0) 
(defrule rule504
	(forma)
	(not (presencial))
	(not (general))
	(forma)
	(marcha)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; forma > 0 AND presencial <= 0 AND general <= 0 AND forma <= 0.147321 AND caso <= 0.021739 : empleo (2.0) 
(defrule rule505
	(forma)
	(not (presencial))
	(not (general))
	(forma)
	(caso)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; forma > 0 AND presencial <= 0 AND general <= 0 AND forma <= 0.147321 : generales (2.0) 
(defrule rule506
	(forma)
	(not (presencial))
	(not (general))
	(forma)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; forma > 0.066421 AND presencial <= 0 AND persona <= 0 AND forma <= 0.22619 : medioamb (2.0) 
(defrule rule507
	(forma)
	(not (presencial))
	(not (persona))
	(forma)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; forma > 0.066421 AND presencial <= 0 AND persona <= 0 : Grupo_Municipal_PSOE (2.0) 
(defrule rule508
	(forma)
	(not (presencial))
	(not (persona))
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; forma > 0.066421 AND presencial <= 0 : ssociales (2.0) 
(defrule rule509
	(forma)
	(not (presencial))
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; familias > 0.03321 : Mujer (4.0/1.0) 
(defrule rule510
	(familias)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; seguridad > 0.048701 AND servicios <= 0.083799 AND seguridad <= 0.089385 : servicios (3.0/1.0) 
(defrule rule511
	(seguridad)
	(servicios)
	(seguridad)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; obras > 0.043308 AND cargo <= 0 AND proyecto <= 0.064972 AND obras <= 0.089552 : economia (4.0/1.0) 
(defrule rule512
	(obras)
	(not (cargo))
	(proyecto)
	(obras)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; miembros > 0.04822 AND tarde <= 0 AND curso <= 0 AND grupo <= 0.050111 AND miembros <= 0.092426 : asociales (2.0/1.0) 
(defrule rule513
	(miembros)
	(not (tarde))
	(not (curso))
	(grupo)
	(miembros)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; comienzo > 0.03928 AND jornada <= 0.058282 AND comienzo <= 0.042945 : cultura (2.0) 
(defrule rule514
	(comienzo)
	(jornada)
	(comienzo)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; delegada > 0 AND delegada <= 0.101695 : Juventud (4.0/1.0) 
(defrule rule515
	(delegada)
	(delegada)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; zona > 0.066955 AND cabo <= 0 AND participantes <= 0 AND zona <= 0.196406 : servicios (3.0) 
(defrule rule516
	(zona)
	(not (cabo))
	(not (participantes))
	(zona)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; obras > 0 AND seguridad <= 0 AND proyecto <= 0.064972 AND obras > 0.061617 : Grupo_Municipal_PSOE (3.0/1.0) 
(defrule rule517
	(obras)
	(not (seguridad))
	(proyecto)
	(obras)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; pincha <= 0 AND final > 0.054534 AND puesto <= 0.101272 : Deportes (3.0/1.0) 
(defrule rule518
	(not (pincha))
	(final)
	(puesto)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; pincha <= 0 AND celebra > 0.042477 AND acto <= 0.078947 AND celebra <= 0.053633 : social (3.0) 
(defrule rule519
	(not (pincha))
	(celebra)
	(acto)
	(celebra)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; pincha <= 0 AND celebra > 0.042477 AND acto <= 0.078947 AND celebra <= 0.070686 : Mujer (3.0) 
(defrule rule520
	(not (pincha))
	(celebra)
	(acto)
	(celebra)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; pincha <= 0 AND curso > 0.098765 AND curso <= 0.143921 AND curso > 0.125 AND curso <= 0.133056 : Mujer (5.0) 
(defrule rule521
	(not (pincha))
	(curso)
	(curso)
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; pincha <= 0 AND talleres > 0.054787 AND talleres <= 0.070552 AND talleres <= 0.068199 : Formacion (3.0) 
(defrule rule522
	(not (pincha))
	(talleres)
	(talleres)
	(talleres)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; pincha <= 0 AND talleres > 0.054787 AND talleres <= 0.076923 AND talleres <= 0.069173 : Juventud (3.0) 
(defrule rule523
	(not (pincha))
	(talleres)
	(talleres)
	(talleres)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; pincha <= 0 AND zona > 0.066955 AND cabo > 0 : desarrollo (3.0/1.0) 
(defrule rule524
	(not (pincha))
	(zona)
	(cabo)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; pincha <= 0 AND talleres > 0.054787 AND talleres > 0.113182 AND talleres > 0.142857 : social (4.0/1.0) 
(defrule rule525
	(not (pincha))
	(talleres)
	(talleres)
	(talleres)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; pincha <= 0 AND talleres > 0 AND curso <= 0 AND talleres > 0.070552 : Mujer (3.0/1.0) 
(defrule rule526
	(not (pincha))
	(talleres)
	(not (curso))
	(talleres)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; pincha <= 0 AND semana > 0.130631 AND semana <= 0.140845 AND semana > 0.136035 AND semana <= 0.138985 : participacion (4.0) 
(defrule rule527
	(not (pincha))
	(semana)
	(semana)
	(semana)
	(semana)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; pincha <= 0 AND semana > 0.130631 AND semana <= 0.146226 AND semana > 0.140845 : festejos (4.0) 
(defrule rule528
	(not (pincha))
	(semana)
	(semana)
	(semana)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; pincha > 0 : PIM (3.0/1.0) 
(defrule rule529
	(pincha)
		=>
	(assert 
		(ETIQUETA_PIM)
	)
)
;; miembros > 0.039108 AND tarde <= 0 AND miembros <= 0.076923 AND miembros <= 0.046053 : cultura (2.0) 
(defrule rule530
	(miembros)
	(not (tarde))
	(miembros)
	(miembros)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; miembros > 0.039108 AND tarde <= 0 AND miembros > 0.092426 AND miembros <= 0.135922 : recursosHumanos (2.0) 
(defrule rule531
	(miembros)
	(not (tarde))
	(miembros)
	(miembros)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; presencial <= 0 AND consultar <= 0 AND sociedad <= 0 AND asistir <= 0 AND requisitos <= 0.055866 AND imagen <= 0 AND mano <= 0 AND evitar > 0 : consumo (3.0/2.0) 
(defrule rule532
	(not (presencial))
	(not (consultar))
	(not (sociedad))
	(not (asistir))
	(requisitos)
	(not (imagen))
	(not (mano))
	(evitar)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; presencial <= 0 AND consultar <= 0 AND sociedad <= 0 AND asistir <= 0 AND requisitos <= 0.055866 AND imagen <= 0 AND mano > 0 : turismo1 (3.0/1.0) 
(defrule rule533
	(not (presencial))
	(not (consultar))
	(not (sociedad))
	(not (asistir))
	(requisitos)
	(not (imagen))
	(mano)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; presencial <= 0 AND consultar <= 0 AND sociedad <= 0 AND asistir <= 0 AND imagen <= 0 AND requisitos > 0.055866 : reginterior (3.0/1.0) 
(defrule rule534
	(not (presencial))
	(not (consultar))
	(not (sociedad))
	(not (asistir))
	(not (imagen))
	(requisitos)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; presencial <= 0 AND consultar <= 0 AND sociedad <= 0 AND asistir <= 0 AND imagen > 0 : turismo1 (3.0) 
(defrule rule535
	(not (presencial))
	(not (consultar))
	(not (sociedad))
	(not (asistir))
	(imagen)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; presencial <= 0 AND consultar <= 0 AND sociedad <= 0 AND asistir > 0 : Mujer (3.0) 
(defrule rule536
	(not (presencial))
	(not (consultar))
	(not (sociedad))
	(asistir)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; presencial <= 0 AND consultar <= 0 AND sociedad > 0 : igualdad (3.0/1.0) 
(defrule rule537
	(not (presencial))
	(not (consultar))
	(sociedad)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; presencial <= 0 AND consultar > 0 : consumo (3.0) 
(defrule rule538
	(not (presencial))
	(consultar)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; presencial <= 0 AND presente > 0.050391 AND presente <= 0.065637 : turismo1 (2.0) 
(defrule rule539
	(not (presencial))
	(presente)
	(presente)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; presencial <= 0 AND alumnas > 0 AND alumnas <= 0.050408 : Formacion (2.0) 
(defrule rule540
	(not (presencial))
	(alumnas)
	(alumnas)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND mantenimiento > 0 AND servicios <= 0 : parques (2.0/1.0) 
(defrule rule541
	(not (presencial))
	(mantenimiento)
	(not (servicios))
		=>
	(assert 
		(ETIQUETA_parques)
	)
)
;; presencial <= 0 AND feria > 0 AND actividad <= 0.047189 : Formacion (2.0) 
(defrule rule542
	(not (presencial))
	(feria)
	(actividad)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND delegado > 0 AND delegado <= 0.092204 : seguridadCiudadana (2.0/1.0) 
(defrule rule543
	(not (presencial))
	(delegado)
	(delegado)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; presencial <= 0 AND charla > 0 AND cargo > 0 : igualdad (3.0/1.0) 
(defrule rule544
	(not (presencial))
	(charla)
	(cargo)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; presencial <= 0 AND necesidad > 0 AND personal <= 0 : Agricultura (2.0) 
(defrule rule545
	(not (presencial))
	(necesidad)
	(not (personal))
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; presencial <= 0 AND noticia <= 0 AND puestos > 0 AND puestos <= 0.09322 : recursosHumanos (3.0/1.0) 
(defrule rule546
	(not (presencial))
	(not (noticia))
	(puestos)
	(puestos)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; presencial <= 0 AND noticia <= 0 AND tramo > 0 : servicios (3.0/1.0) 
(defrule rule547
	(not (presencial))
	(not (noticia))
	(tramo)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; presencial <= 0 AND noticia > 0 : empleo (3.0) 
(defrule rule548
	(not (presencial))
	(noticia)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; presencial <= 0 AND bases > 0.040051 AND organiza <= 0 : recursosHumanos (2.0) 
(defrule rule549
	(not (presencial))
	(bases)
	(not (organiza))
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; presencial <= 0 AND tema > 0 : asociales (3.0/1.0) 
(defrule rule550
	(not (presencial))
	(tema)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND actuaciones > 0 AND objeto <= 0.037736 : cultura (2.0/1.0) 
(defrule rule551
	(not (presencial))
	(actuaciones)
	(objeto)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND previsto > 0 AND previsto > 0.072626 : servicios (3.0/1.0) 
(defrule rule552
	(not (presencial))
	(previsto)
	(previsto)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; presencial <= 0 AND nivel > 0 AND entrega <= 0 : participacion (2.0) 
(defrule rule553
	(not (presencial))
	(nivel)
	(not (entrega))
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; presencial <= 0 AND ayuda > 0 AND ayuda > 0.088957 : empleo (3.0) 
(defrule rule554
	(not (presencial))
	(ayuda)
	(ayuda)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; presencial <= 0 AND miembros > 0.039108 AND tarde <= 0 AND miembros > 0.076923 : _RSS (3.0/1.0) 
(defrule rule555
	(not (presencial))
	(miembros)
	(not (tarde))
	(miembros)
		=>
	(assert 
		(ETIQUETA__RSS)
	)
)
;; presencial <= 0 AND sesiones > 0.021739 : ssociales (3.0/1.0) 
(defrule rule556
	(not (presencial))
	(sesiones)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; presencial <= 0 AND puesta > 0 AND puesta <= 0.046053 : Formacion (2.0/1.0) 
(defrule rule557
	(not (presencial))
	(puesta)
	(puesta)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND horario > 0.116564 AND horario <= 0.145091 AND horario > 0.123586 : medioamb (3.0/1.0) 
(defrule rule558
	(not (presencial))
	(horario)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; presencial <= 0 AND laboral > 0 AND laboral <= 0.112266 : Educacion (3.0/2.0) 
(defrule rule559
	(not (presencial))
	(laboral)
	(laboral)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; presencial <= 0 AND laboral <= 0.088997 AND horario > 0.116564 AND horario <= 0.171171 AND horario > 0.145091 : servicios (3.0) 
(defrule rule560
	(not (presencial))
	(laboral)
	(horario)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; presencial <= 0 AND departamento <= 0 AND laboral <= 0.088997 AND zona > 0 AND obras <= 0 : ayuntamiento (3.0/2.0) 
(defrule rule561
	(not (presencial))
	(not (departamento))
	(laboral)
	(zona)
	(not (obras))
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencial <= 0 AND departamento <= 0 AND laboral <= 0.088997 AND semana > 0.110429 AND semana > 0.136035 AND semana <= 0.146226 : Formacion (3.0) 
(defrule rule562
	(not (presencial))
	(not (departamento))
	(laboral)
	(semana)
	(semana)
	(semana)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND laboral > 0.088997 : empleo (3.0) 
(defrule rule563
	(not (presencial))
	(not (departamento))
	(laboral)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; presencial <= 0 AND departamento <= 0 AND distintas > 0 AND actividades <= 0.166049 AND distintas <= 0.046053 : festejos (2.0) 
(defrule rule564
	(not (presencial))
	(not (departamento))
	(distintas)
	(actividades)
	(distintas)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND distintas > 0 AND actividades <= 0.084746 : Educacion (2.0/1.0) 
(defrule rule565
	(not (presencial))
	(not (departamento))
	(distintas)
	(actividades)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND servicio > 0.088957 AND horario <= 0.043478 AND servicio <= 0.111842 AND servicio > 0.101033 : social (4.0) 
(defrule rule566
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(servicio)
	(horario)
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND servicio > 0.088957 AND horario <= 0.043478 AND servicio <= 0.115385 AND servicio > 0.090437 AND servicio <= 0.101033 : turismo1 (3.0) 
(defrule rule567
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(servicio)
	(horario)
	(servicio)
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND servicio > 0.088957 AND horario <= 0.043478 AND servicio <= 0.123077 AND servicio > 0.101033 : ssociales (3.0/1.0) 
(defrule rule568
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(servicio)
	(horario)
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND servicio > 0.088957 AND horario <= 0.043478 AND servicio <= 0.166667 AND servicio > 0.115385 : comunicacion (3.0) 
(defrule rule569
	(not (presencial))
	(not (departamento))
	(servicio)
	(horario)
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND obra > 0 AND acto <= 0 : generales (5.0/1.0) 
(defrule rule570
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(obra)
	(not (acto))
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND salida > 0 AND salida > 0.06006 : Deportes (4.0/1.0) 
(defrule rule571
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(salida)
	(salida)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND puesto > 0.067368 AND final <= 0.033791 AND grupo <= 0 : ayuntamiento (3.0/2.0) 
(defrule rule572
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(puesto)
	(final)
	(not (grupo))
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND empresa > 0 AND empresa > 0.097403 : empleo (4.0/1.0) 
(defrule rule573
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(empresa)
	(empresa)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND registro <= 0 AND plaza > 0.102767 AND especial > 0 : cultura (3.0/1.0) 
(defrule rule574
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(not (registro))
	(plaza)
	(especial)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND registro <= 0 AND puesto > 0 AND final <= 0.033791 AND puesto <= 0.067368 : generales (3.0/1.0) 
(defrule rule575
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(not (registro))
	(puesto)
	(final)
	(puesto)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND registro <= 0 AND play <= 0 AND puesto > 0 AND puesto > 0.09375 : turismo1 (3.0/1.0) 
(defrule rule576
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(not (registro))
	(not (play))
	(puesto)
	(puesto)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND registro <= 0 AND play <= 0 AND especial > 0.043225 AND actividad <= 0.021739 AND tarde <= 0 AND fiesta <= 0 : Educacion (3.0/1.0) 
(defrule rule577
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(not (registro))
	(not (play))
	(especial)
	(actividad)
	(not (tarde))
	(not (fiesta))
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND registro <= 0 AND play > 0 : bienestarsocial (3.0) 
(defrule rule578
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(not (registro))
	(play)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia <= 0 AND registro > 0 : Formacion (3.0/1.0) 
(defrule rule579
	(not (presencial))
	(not (departamento))
	(not (importancia))
	(registro)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND importancia > 0 : Formacion (3.0/1.0) 
(defrule rule580
	(not (presencial))
	(not (departamento))
	(importancia)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial > 0.043225 AND actividad <= 0.021739 AND tarde <= 0 : Juventud (2.0) 
(defrule rule581
	(not (presencial))
	(not (departamento))
	(especial)
	(actividad)
	(not (tarde))
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND salida > 0 : Juventud (3.0) 
(defrule rule582
	(not (presencial))
	(not (departamento))
	(salida)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial > 0.0569 AND actividad <= 0.021739 : festejos (2.0/1.0) 
(defrule rule583
	(not (presencial))
	(not (departamento))
	(especial)
	(actividad)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND cita > 0 AND actos <= 0.021739 AND cita <= 0.058282 : asociales (3.0/1.0) 
(defrule rule584
	(not (presencial))
	(not (departamento))
	(cita)
	(actos)
	(cita)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND cita > 0 AND actos <= 0.021739 : saci (2.0/1.0) 
(defrule rule585
	(not (presencial))
	(not (departamento))
	(cita)
	(actos)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; presencial <= 0 AND departamento <= 0 AND servicio > 0.040826 AND responsable <= 0 AND servicio <= 0.134969 AND servicio <= 0.074534 : Juventud (3.0/1.0) 
(defrule rule586
	(not (presencial))
	(not (departamento))
	(servicio)
	(not (responsable))
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND servicio > 0.088957 AND horario <= 0.043478 AND servicio <= 0.134969 : Formacion (2.0) 
(defrule rule587
	(not (presencial))
	(not (departamento))
	(servicio)
	(horario)
	(servicio)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND cabo > 0.078645 AND cabo <= 0.11147 AND cabo > 0.108376 : bienestarsocial (4.0) 
(defrule rule588
	(not (presencial))
	(not (departamento))
	(cabo)
	(cabo)
	(cabo)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND taller > 0.051029 AND taller <= 0.181141 : bienestarsocial (3.0/2.0) 
(defrule rule589
	(not (presencial))
	(not (departamento))
	(taller)
	(taller)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND inscripciones > 0 AND liga <= 0 : Deportes (3.0/2.0) 
(defrule rule590
	(not (presencial))
	(not (departamento))
	(inscripciones)
	(not (liga))
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; presencial <= 0 AND departamento <= 0 AND horario > 0.083033 AND participantes <= 0.076415 AND horario <= 0.116564 AND horario > 0.101412 : generales (4.0/1.0) 
(defrule rule591
	(not (presencial))
	(not (departamento))
	(horario)
	(participantes)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND horario > 0 AND caso <= 0.021739 AND participantes <= 0.051149 AND horario <= 0.103087 AND horario > 0.083033 : seguridadCiudadana (3.0) 
(defrule rule592
	(not (presencial))
	(not (departamento))
	(horario)
	(caso)
	(participantes)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; presencial <= 0 AND departamento <= 0 AND horario > 0 AND caso <= 0.021739 AND participantes <= 0.051149 AND horario <= 0.145091 AND horario <= 0.056582 : obras (2.0) 
(defrule rule593
	(not (presencial))
	(not (departamento))
	(horario)
	(caso)
	(participantes)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; presencial <= 0 AND departamento <= 0 AND horario > 0.076807 AND caso <= 0.021739 AND participantes <= 0.051149 AND horario <= 0.190476 AND horario <= 0.145091 : ayuntamiento (2.0) 
(defrule rule594
	(not (presencial))
	(not (departamento))
	(horario)
	(caso)
	(participantes)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencial <= 0 AND departamento <= 0 AND ciudadanos > 0.04822 AND servicios <= 0.068726 : comunicacion (2.0/1.0) 
(defrule rule595
	(not (presencial))
	(not (departamento))
	(ciudadanos)
	(servicios)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND horario > 0 AND caso <= 0.021739 AND participantes <= 0.051149 AND horario <= 0.190476 AND horario <= 0.123586 : festejos (2.0) 
(defrule rule596
	(not (presencial))
	(not (departamento))
	(horario)
	(caso)
	(participantes)
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND horario > 0 AND caso <= 0.021739 AND participantes <= 0.051149 AND horario <= 0.25 : salud (3.0/1.0) 
(defrule rule597
	(not (presencial))
	(not (departamento))
	(horario)
	(caso)
	(participantes)
	(horario)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND horario > 0 AND caso <= 0.021739 AND participantes <= 0.051149 AND horario <= 0.254237 : recursosHumanos (2.0) 
(defrule rule598
	(not (presencial))
	(not (departamento))
	(horario)
	(caso)
	(participantes)
	(horario)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND horario > 0 AND caso <= 0.021739 AND participantes <= 0.051149 : Comercio (2.0) 
(defrule rule599
	(not (presencial))
	(not (departamento))
	(horario)
	(caso)
	(participantes)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; presencial <= 0 AND departamento <= 0 AND celebra > 0 : festejos (4.0/1.0) 
(defrule rule600
	(not (presencial))
	(not (departamento))
	(celebra)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND servicio > 0 AND responsable <= 0 AND servicio <= 0.134969 : festejos (3.0/1.0) 
(defrule rule601
	(not (presencial))
	(not (departamento))
	(servicio)
	(not (responsable))
	(servicio)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND servicio > 0.043478 AND responsable <= 0 : trafico (3.0/1.0) 
(defrule rule602
	(not (presencial))
	(not (departamento))
	(servicio)
	(not (responsable))
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; presencial <= 0 AND departamento <= 0 AND horario > 0 AND caso <= 0.021739 : ssociales (2.0) 
(defrule rule603
	(not (presencial))
	(not (departamento))
	(horario)
	(caso)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND padres > 0 AND actividad <= 0.047189 : Educacion (2.0/1.0) 
(defrule rule604
	(not (presencial))
	(not (departamento))
	(padres)
	(actividad)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND actividad > 0.118919 AND actividad > 0.148113 AND actividad > 0.180873 : tecnologia (3.0) 
(defrule rule605
	(not (presencial))
	(not (departamento))
	(actividad)
	(actividad)
	(actividad)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; presencial <= 0 AND departamento <= 0 AND evento > 0 AND evento <= 0.076923 AND evento > 0.057348 : festejos (4.0) 
(defrule rule606
	(not (presencial))
	(not (departamento))
	(evento)
	(evento)
	(evento)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND evento > 0 AND acto <= 0 AND evento > 0.040602 : Deportes (3.0/1.0) 
(defrule rule607
	(not (presencial))
	(not (departamento))
	(evento)
	(not (acto))
	(evento)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; presencial <= 0 AND departamento <= 0 AND evento > 0 AND evento <= 0.076923 : Juventud (2.0) 
(defrule rule608
	(not (presencial))
	(not (departamento))
	(evento)
	(evento)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acto > 0.119107 AND acto <= 0.143022 AND acto <= 0.125144 : turismo1 (6.0/1.0) 
(defrule rule609
	(not (presencial))
	(not (departamento))
	(acto)
	(acto)
	(acto)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; presencial <= 0 AND departamento <= 0 AND calles > 0 AND calles <= 0.058319 AND calles <= 0.050517 : cultura (3.0) 
(defrule rule610
	(not (presencial))
	(not (departamento))
	(calles)
	(calles)
	(calles)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND calles > 0 AND actividades <= 0 AND calles <= 0.134788 : generales (3.0/1.0) 
(defrule rule611
	(not (presencial))
	(not (departamento))
	(calles)
	(not (actividades))
	(calles)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND calles > 0.048184 AND actividades <= 0 : obras (3.0) 
(defrule rule612
	(not (presencial))
	(not (departamento))
	(calles)
	(not (actividades))
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; presencial <= 0 AND departamento <= 0 AND personal > 0.046125 AND personal > 0.070603 : ayuntamiento (3.0/2.0) 
(defrule rule613
	(not (presencial))
	(not (departamento))
	(personal)
	(personal)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencial <= 0 AND departamento <= 0 AND empresas > 0.056517 AND empresas <= 0.093555 : Agricultura (2.0/1.0) 
(defrule rule614
	(not (presencial))
	(not (departamento))
	(empresas)
	(empresas)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND acto > 0.119107 AND acto <= 0.143857 AND acto <= 0.140681 : desarrollo (3.0/1.0) 
(defrule rule615
	(not (presencial))
	(not (departamento))
	(not (documento))
	(acto)
	(acto)
	(acto)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND acto > 0.108951 AND actividad <= 0.058282 AND acto <= 0.143857 AND acto <= 0.129653 : ssociales (3.0/1.0) 
(defrule rule616
	(not (presencial))
	(not (departamento))
	(not (documento))
	(acto)
	(actividad)
	(acto)
	(acto)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND acto > 0.119107 AND actividad <= 0.058282 AND acto <= 0.143857 AND acto <= 0.143022 : participacion (3.0) 
(defrule rule617
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(acto)
	(actividad)
	(acto)
	(acto)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND acto > 0.119107 AND actividad <= 0.058282 AND acto <= 0.161344 AND acto <= 0.143857 : ayuntamiento (3.0) 
(defrule rule618
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(acto)
	(actividad)
	(acto)
	(acto)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND plaza > 0 AND plaza <= 0.136101 : generales (2.0) 
(defrule rule619
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(plaza)
	(plaza)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND desarrollo > 0.087662 AND desarrollo > 0.161883 AND desarrollo <= 0.281553 : igualdad (3.0/1.0) 
(defrule rule620
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(desarrollo)
	(desarrollo)
	(desarrollo)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND desarrollo > 0.087662 AND desarrollo > 0.142857 : desarrollo (3.0/1.0) 
(defrule rule621
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(desarrollo)
	(desarrollo)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND desarrollo > 0 AND actividades <= 0.079336 AND desarrollo <= 0.116602 : Agricultura (2.0/1.0) 
(defrule rule622
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(desarrollo)
	(actividades)
	(desarrollo)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND acuerdo <= 0 AND numerosas <= 0 AND desarrollo > 0 AND actividades <= 0.079336 : ayuntamiento (2.0) 
(defrule rule623
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(not (acuerdo))
	(not (numerosas))
	(desarrollo)
	(actividades)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND acuerdo <= 0 AND numerosas <= 0 AND acto > 0.129653 AND actividad <= 0.058282 AND acto <= 0.161344 : cultura (3.0) 
(defrule rule624
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(not (acuerdo))
	(not (numerosas))
	(acto)
	(actividad)
	(acto)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND acuerdo <= 0 AND numerosas <= 0 AND liga <= 0 AND premio <= 0 AND concejal > 0 : asociales (5.0/2.0) 
(defrule rule625
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(not (acuerdo))
	(not (numerosas))
	(not (liga))
	(not (premio))
	(concejal)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND acuerdo <= 0 AND numerosas <= 0 AND premio > 0 : generales (4.0/1.0) 
(defrule rule626
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(not (acuerdo))
	(not (numerosas))
	(premio)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND documento <= 0 AND especial <= 0.052147 AND acuerdo <= 0 AND numerosas <= 0 AND alumnos > 0.050517 AND alumnos <= 0.068659 AND alumnos <= 0.061321 : medioamb (3.0/1.0) 
(defrule rule627
	(not (presencial))
	(not (departamento))
	(not (documento))
	(especial)
	(not (acuerdo))
	(not (numerosas))
	(alumnos)
	(alumnos)
	(alumnos)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial <= 0.052147 AND documento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND alumnos > 0.049676 AND alumnos <= 0.068659 : Agricultura (4.0/1.0) 
(defrule rule628
	(not (presencial))
	(not (departamento))
	(especial)
	(not (documento))
	(not (acuerdo))
	(not (numerosas))
	(alumnos)
	(alumnos)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND taller > 0 : asociales (4.0/1.0) 
(defrule rule629
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(taller)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND visita > 0 AND visita > 0.069811 : mayores (3.0/2.0) 
(defrule rule630
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(visita)
	(visita)
		=>
	(assert 
		(ETIQUETA_mayores)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND liga <= 0 AND general > 0 AND general <= 0.080161 AND general > 0.067368 : bienestarsocial (3.0) 
(defrule rule631
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(not (liga))
	(general)
	(general)
	(general)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND liga > 0 : participacion (3.0/1.0) 
(defrule rule632
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(liga)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND general > 0 AND general <= 0.067368 : Deportes (2.0/1.0) 
(defrule rule633
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(general)
	(general)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND general > 0 AND general <= 0.083333 : salud (2.0) 
(defrule rule634
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(general)
	(general)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND sociales > 0 AND plazo <= 0.105263 : medioamb (3.0/1.0) 
(defrule rule635
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(sociales)
	(plazo)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND valor <= 0 AND jornadas <= 0.047658 AND servicios > 0 AND ciudadanos <= 0 AND servicios <= 0.177122 : Comercio (3.0/2.0) 
(defrule rule636
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(not (valor))
	(jornadas)
	(servicios)
	(not (ciudadanos))
	(servicios)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND jornadas <= 0.047658 AND valor <= 0 AND servicios > 0.068726 AND ciudadanos <= 0 : social (3.0/1.0) 
(defrule rule637
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(jornadas)
	(not (valor))
	(servicios)
	(not (ciudadanos))
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND jornadas <= 0.047658 AND valor <= 0 AND premios > 0 AND actos <= 0.049743 AND premios <= 0.079693 : generales (3.0) 
(defrule rule638
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(jornadas)
	(not (valor))
	(premios)
	(actos)
	(premios)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND premios > 0 AND actos <= 0.049743 : festejos (2.0) 
(defrule rule639
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(premios)
	(actos)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND valor <= 0 AND jornadas <= 0.047658 AND infantil > 0 : participacion (4.0/2.0) 
(defrule rule640
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(not (valor))
	(jornadas)
	(infantil)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND valor <= 0 AND jornadas <= 0.047658 AND alumnos > 0 AND edad <= 0 : desarrollo (3.0/1.0) 
(defrule rule641
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(not (valor))
	(jornadas)
	(alumnos)
	(not (edad))
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND valor <= 0 AND jornadas <= 0.047658 AND tipo > 0 AND tipo > 0.061728 : ayuntamiento (3.0/2.0) 
(defrule rule642
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(not (valor))
	(jornadas)
	(tipo)
	(tipo)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND jornadas <= 0.047658 AND valor > 0 : medioamb (3.0/1.0) 
(defrule rule643
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(jornadas)
	(valor)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND proyecto > 0 AND proyecto <= 0.094156 AND proyecto <= 0.07216 : salud (2.0) 
(defrule rule644
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(jornadas)
	(hombres)
	(proyecto)
	(proyecto)
	(proyecto)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND proyecto > 0.090309 AND proyecto > 0.115986 : igualdad (3.0/1.0) 
(defrule rule645
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(jornadas)
	(hombres)
	(proyecto)
	(proyecto)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND cabo > 0.061728 AND cabo <= 0.078645 AND cabo <= 0.076448 : turismo1 (2.0) 
(defrule rule646
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(cabo)
	(cabo)
	(cabo)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND cabo > 0.078645 AND cabo <= 0.122977 : social (3.0/1.0) 
(defrule rule647
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(cabo)
	(cabo)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada > 0 AND jornada <= 0.058282 AND jornada > 0.047691 : social (3.0) 
(defrule rule648
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(jornada)
	(jornada)
	(jornada)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada > 0 AND jornada > 0.071887 AND jornada > 0.10888 : Deportes (3.0) 
(defrule rule649
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(jornada)
	(jornada)
	(jornada)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada > 0 AND jornada <= 0.052632 : cultura (2.0/1.0) 
(defrule rule650
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(jornada)
	(jornada)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada > 0 AND jornada <= 0.071887 : salud (2.0) 
(defrule rule651
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(jornada)
	(jornada)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND experiencia > 0.043675 AND experiencia <= 0.076923 : Deportes (2.0/1.0) 
(defrule rule652
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(experiencia)
	(experiencia)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND acto > 0 AND tarde <= 0 AND cargo <= 0 : Comercio (2.0/1.0) 
(defrule rule653
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(acto)
	(not (tarde))
	(not (cargo))
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND actos > 0.021739 AND actos > 0.062901 : Educacion (3.0/2.0) 
(defrule rule654
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(actos)
	(actos)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND calles <= 0.048184 AND jornadas <= 0.047658 AND fiestas > 0 AND fiestas <= 0.089965 : generales (2.0) 
(defrule rule655
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(hombres)
	(calles)
	(jornadas)
	(fiestas)
	(fiestas)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND calles <= 0.048184 AND jornadas <= 0.047658 AND organiza > 0.04908 AND organiza > 0.076692 : social (7.0/2.0) 
(defrule rule656
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(hombres)
	(calles)
	(jornadas)
	(organiza)
	(organiza)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND calles <= 0.048184 AND jornadas <= 0.047658 AND encuentro > 0 AND participar <= 0.021739 AND encuentro <= 0.088089 : social (2.0/1.0) 
(defrule rule657
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(hombres)
	(calles)
	(jornadas)
	(encuentro)
	(participar)
	(encuentro)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND calles <= 0.048184 AND jornadas <= 0.047658 AND encuentro > 0 AND encuentro <= 0.058282 : generales (2.0) 
(defrule rule658
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(hombres)
	(calles)
	(jornadas)
	(encuentro)
	(encuentro)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND social > 0 AND participar <= 0.021739 AND social <= 0.111111 : Educacion (2.0/1.0) 
(defrule rule659
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(encuentro)
	(calles)
	(hombres)
	(jornadas)
	(social)
	(participar)
	(social)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND documento <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND social > 0 AND participar <= 0.021739 : ayuntamiento (2.0/1.0) 
(defrule rule660
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(not (documento))
	(encuentro)
	(calles)
	(hombres)
	(jornadas)
	(social)
	(participar)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND encuentro <= 0.038851 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND interesados <= 0 AND tiempo > 0.061728 AND tiempo > 0.076378 : asociales (3.0/1.0) 
(defrule rule661
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(encuentro)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(not (interesados))
	(tiempo)
	(tiempo)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND especial <= 0.052147 AND encuentro <= 0.038851 AND documento <= 0 AND calles <= 0.048184 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND interesados <= 0 AND mayores > 0 AND mayores > 0.079096 : asociales (3.0/2.0) 
(defrule rule662
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(especial)
	(encuentro)
	(not (documento))
	(calles)
	(hombres)
	(jornadas)
	(not (interesados))
	(mayores)
	(mayores)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND especial <= 0.052147 AND calles <= 0.048184 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND interesados <= 0 AND largo <= 0 AND entrevista <= 0 AND vida > 0 AND grupo <= 0 : cultura (4.0/2.0) 
(defrule rule663
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(especial)
	(calles)
	(not (documento))
	(hombres)
	(jornadas)
	(not (interesados))
	(not (largo))
	(not (entrevista))
	(vida)
	(not (grupo))
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND especial <= 0.052147 AND calles <= 0.048184 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND noche > 0 AND noche > 0.067457 AND noche <= 0.094908 : ayuntamiento (2.0/1.0) 
(defrule rule664
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(especial)
	(calles)
	(not (documento))
	(hombres)
	(jornadas)
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(noche)
	(noche)
	(noche)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND jornada <= 0 AND noche > 0 AND noche > 0.055338 AND noche <= 0.094908 : Formacion (2.0) 
(defrule rule665
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(especial)
	(not (documento))
	(hombres)
	(jornadas)
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (jornada))
	(noche)
	(noche)
	(noche)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND largo <= 0 AND jornada <= 0 AND interesados <= 0 AND entrevista <= 0 AND solicitud > 0.057444 AND solicitud <= 0.069681 : asociales (3.0/1.0) 
(defrule rule666
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(especial)
	(not (documento))
	(hombres)
	(jornadas)
	(not (largo))
	(not (jornada))
	(not (interesados))
	(not (entrevista))
	(solicitud)
	(solicitud)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND cursos > 0 AND abierto <= 0 : economia (2.0/1.0) 
(defrule rule667
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(especial)
	(not (documento))
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(cursos)
	(not (abierto))
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND solicitud > 0 AND solicitud <= 0.072626 : bienestarsocial (3.0/1.0) 
(defrule rule668
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(especial)
	(not (documento))
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(solicitud)
	(solicitud)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND municipio > 0.14433 AND municipio <= 0.15804 AND municipio > 0.152476 : igualdad (3.0) 
(defrule rule669
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(especial)
	(not (documento))
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(municipio)
	(municipio)
	(municipio)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND casa > 0 AND casa <= 0.077702 : asociales (2.0/1.0) 
(defrule rule670
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(especial)
	(not (documento))
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(casa)
	(casa)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND local <= 0 AND disfrutar > 0.049628 AND plazo <= 0 AND disfrutar <= 0.056543 : economia (4.0/1.0) 
(defrule rule671
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(especial)
	(not (documento))
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(not (local))
	(disfrutar)
	(not (plazo))
	(disfrutar)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND especial <= 0.052147 AND documento <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND local <= 0 AND locales <= 0 AND provincia <= 0.021739 AND poder > 0 AND plazo <= 0 : bienestarsocial (3.0/2.0) 
(defrule rule672
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(especial)
	(not (documento))
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(not (local))
	(not (locales))
	(provincia)
	(poder)
	(not (plazo))
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND aquellas <= 0 AND local <= 0 AND locales <= 0 AND provincia <= 0.021739 AND medio > 0 AND medio > 0.07298 : Juventud (3.0/2.0) 
(defrule rule673
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(not (aquellas))
	(not (local))
	(not (locales))
	(provincia)
	(medio)
	(medio)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND aquellas <= 0 AND local <= 0 AND locales <= 0 AND provincia <= 0.021739 AND grupo > 0 AND grupo > 0.080367 : asociales (3.0/2.0) 
(defrule rule674
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(not (aquellas))
	(not (local))
	(not (locales))
	(provincia)
	(grupo)
	(grupo)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND aquellas <= 0 AND local <= 0 AND locales <= 0 AND provincia <= 0.021739 AND grupos > 0.05521 : economia (3.0/2.0) 
(defrule rule675
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(not (aquellas))
	(not (local))
	(not (locales))
	(provincia)
	(grupos)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND entrevista <= 0 AND edad <= 0 AND aquellas <= 0 AND local <= 0 AND locales <= 0 AND provincia > 0.021739 : economia (3.0/2.0) 
(defrule rule676
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (entrevista))
	(not (edad))
	(not (aquellas))
	(not (local))
	(not (locales))
	(provincia)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND aquellas <= 0 AND caso > 0.021739 : Deportes (3.0/1.0) 
(defrule rule677
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(not (aquellas))
	(caso)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND marcha > 0 AND marcha <= 0.111111 : cultura (2.0/1.0) 
(defrule rule678
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(marcha)
	(marcha)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND aquellas <= 0 AND libre > 0 AND libre <= 0.047443 : generales (2.0) 
(defrule rule679
	(not (presencial))
	(not (departamento))
	(especial)
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(local)
	(not (aquellas))
	(libre)
	(libre)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND aquellas <= 0 AND participantes > 0.056497 AND participantes > 0.076415 AND participantes <= 0.096931 : festejos (2.0) 
(defrule rule680
	(not (presencial))
	(not (departamento))
	(especial)
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(local)
	(not (aquellas))
	(participantes)
	(participantes)
	(participantes)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND aquellas <= 0 AND participantes > 0.056497 AND participantes > 0.071183 : consumo (3.0/2.0) 
(defrule rule681
	(not (presencial))
	(not (departamento))
	(especial)
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(local)
	(not (aquellas))
	(participantes)
	(participantes)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND aquellas <= 0 AND solicitud <= 0 AND trabajo > 0.088957 AND trabajo <= 0.126641 : bienestarsocial (2.0/1.0) 
(defrule rule682
	(not (presencial))
	(not (departamento))
	(especial)
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(local)
	(not (aquellas))
	(not (solicitud))
	(trabajo)
	(trabajo)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND aquellas <= 0 AND solicitud <= 0 AND plazo > 0.105263 AND plazo > 0.153473 AND plazo <= 0.158672 : ssociales (3.0) 
(defrule rule683
	(not (presencial))
	(not (departamento))
	(especial)
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(local)
	(not (aquellas))
	(not (solicitud))
	(plazo)
	(plazo)
	(plazo)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND aquellas <= 0 AND solicitud <= 0 AND plazo > 0.105263 AND plazo > 0.147321 AND plazo > 0.158672 : empleo (3.0/1.0) 
(defrule rule684
	(not (presencial))
	(not (departamento))
	(especial)
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(local)
	(not (aquellas))
	(not (solicitud))
	(plazo)
	(plazo)
	(plazo)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND jornadas <= 0.047658 AND entrevista <= 0 AND jornada <= 0 AND largo <= 0 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND aquellas <= 0 AND materia <= 0 AND entrega <= 0.056175 AND plazo > 0.105263 AND plazo <= 0.147321 : Formacion (3.0/2.0) 
(defrule rule685
	(not (presencial))
	(not (departamento))
	(especial)
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(jornadas)
	(not (entrevista))
	(not (jornada))
	(not (largo))
	(not (interesados))
	(not (edad))
	(local)
	(not (aquellas))
	(not (materia))
	(entrega)
	(plazo)
	(plazo)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND especial <= 0.052147 AND documento <= 0 AND calles <= 0.048184 AND encuentro <= 0.038851 AND acuerdo <= 0 AND numerosas <= 0 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND aquellas <= 0 AND materia <= 0 AND entrega <= 0.056175 AND proyecto <= 0.041997 AND semana > 0.021739 AND semana <= 0.087662 : generales (3.0/1.0) 
(defrule rule686
	(not (presencial))
	(not (departamento))
	(especial)
	(not (documento))
	(calles)
	(encuentro)
	(not (acuerdo))
	(not (numerosas))
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(local)
	(not (aquellas))
	(not (materia))
	(entrega)
	(proyecto)
	(semana)
	(semana)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND aquellas <= 0 AND materia <= 0 AND semana > 0.021739 AND semana <= 0.130631 : bienestarsocial (2.0/1.0) 
(defrule rule687
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(local)
	(not (aquellas))
	(not (materia))
	(semana)
	(semana)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND aquellas <= 0 AND local <= 0.108757 AND semana <= 0.067039 AND materia <= 0 AND proyecto <= 0.041997 AND entrega > 0 AND actividad <= 0.047189 : generales (2.0/1.0) 
(defrule rule688
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(not (aquellas))
	(local)
	(semana)
	(not (materia))
	(proyecto)
	(entrega)
	(actividad)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND local <= 0.108757 AND materia <= 0 AND proyecto <= 0.041997 AND fiestas <= 0.089965 AND honor <= 0 AND puedan > 0 AND puedan <= 0.049369 : generales (2.0/1.0) 
(defrule rule689
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(not (aquellas))
	(semana)
	(local)
	(not (materia))
	(proyecto)
	(fiestas)
	(not (honor))
	(puedan)
	(puedan)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND puedan <= 0 AND local <= 0.108757 AND materia <= 0 AND proyecto <= 0.041997 AND calle > 0 : generales (4.0/2.0) 
(defrule rule690
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(not (aquellas))
	(semana)
	(not (puedan))
	(local)
	(not (materia))
	(proyecto)
	(calle)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND edad <= 0 AND semana <= 0.067039 AND aquellas <= 0 AND puedan <= 0 AND local <= 0.108757 AND materia <= 0 AND proyecto <= 0.041997 AND disfrutar > 0 AND disfrutar > 0.074129 : cultura (3.0/1.0) 
(defrule rule691
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (edad))
	(semana)
	(not (aquellas))
	(not (puedan))
	(local)
	(not (materia))
	(proyecto)
	(disfrutar)
	(disfrutar)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND semana <= 0.067039 AND edad <= 0 AND aquellas <= 0 AND puedan <= 0 AND local <= 0.108757 AND materia <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND proyecto <= 0.041997 AND noche > 0 AND noche > 0.05283 : festejos (3.0/1.0) 
(defrule rule692
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(semana)
	(not (edad))
	(not (aquellas))
	(not (puedan))
	(local)
	(not (materia))
	(fiestas)
	(not (honor))
	(proyecto)
	(noche)
	(noche)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND semana <= 0.067039 AND edad <= 0 AND aquellas <= 0 AND puedan <= 0 AND local <= 0.108757 AND materia <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND proyecto <= 0.041997 AND plazo > 0 AND solicitudes <= 0 : bienestarsocial (3.0/1.0) 
(defrule rule693
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(semana)
	(not (edad))
	(not (aquellas))
	(not (puedan))
	(local)
	(not (materia))
	(fiestas)
	(not (honor))
	(proyecto)
	(plazo)
	(not (solicitudes))
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND edad <= 0 AND puedan <= 0 AND local <= 0.108757 AND materia <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND proyecto <= 0.041997 AND participantes <= 0 AND plazo <= 0 AND abierto <= 0 AND organiza > 0 AND organiza <= 0.04908 : generales (3.0/1.0) 
(defrule rule694
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (aquellas))
	(semana)
	(not (edad))
	(not (puedan))
	(local)
	(not (materia))
	(fiestas)
	(not (honor))
	(proyecto)
	(not (participantes))
	(not (plazo))
	(not (abierto))
	(organiza)
	(organiza)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND edad <= 0 AND puedan <= 0 AND local <= 0.108757 AND materia <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND plazas <= 0 AND participantes <= 0 AND proyecto <= 0.041997 AND organiza > 0 AND organiza <= 0.061728 : Formacion (2.0/1.0) 
(defrule rule695
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (aquellas))
	(semana)
	(not (edad))
	(not (puedan))
	(local)
	(not (materia))
	(fiestas)
	(not (honor))
	(not (plazas))
	(not (participantes))
	(proyecto)
	(organiza)
	(organiza)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND edad <= 0 AND puedan <= 0 AND local <= 0.108757 AND materia <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND plazas <= 0 AND participantes <= 0 AND proyecto <= 0.041997 AND plazo > 0 : generales (3.0/1.0) 
(defrule rule696
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (aquellas))
	(semana)
	(not (edad))
	(not (puedan))
	(local)
	(not (materia))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (plazas))
	(not (participantes))
	(proyecto)
	(plazo)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND edad <= 0 AND local <= 0.108757 AND puedan <= 0 AND materia <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND abierto <= 0 AND actividad > 0.08344 AND entrega <= 0 AND actividad > 0.142857 : Juventud (3.0/1.0) 
(defrule rule697
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (aquellas))
	(semana)
	(not (edad))
	(local)
	(not (puedan))
	(not (materia))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (abierto))
	(actividad)
	(not (entrega))
	(actividad)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND edad <= 0 AND puedan <= 0 AND local <= 0.108757 AND organiza <= 0 AND materia <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND abierto > 0 : Educacion (3.0/2.0) 
(defrule rule698
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (aquellas))
	(semana)
	(not (edad))
	(not (puedan))
	(local)
	(not (organiza))
	(not (materia))
	(fiestas)
	(not (honor))
	(abierto)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND edad <= 0 AND puedan <= 0 AND local <= 0.108757 AND organiza <= 0 AND materia <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND actividad > 0.08344 AND entrega <= 0 AND actividad <= 0.121469 : economia (2.0/1.0) 
(defrule rule699
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (aquellas))
	(semana)
	(not (edad))
	(not (puedan))
	(local)
	(not (organiza))
	(not (materia))
	(fiestas)
	(not (honor))
	(actividad)
	(not (entrega))
	(actividad)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND edad <= 0 AND local <= 0.108757 AND puedan <= 0 AND organiza <= 0 AND materia <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND actividades > 0.143513 AND actividades <= 0.166667 : festejos (5.0/2.0) 
(defrule rule700
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(not (aquellas))
	(semana)
	(not (edad))
	(local)
	(not (puedan))
	(not (organiza))
	(not (materia))
	(fiestas)
	(not (honor))
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND interesados <= 0 AND semana <= 0.067039 AND aquellas <= 0 AND edad <= 0 AND local <= 0.108757 AND puedan <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND organiza <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND actividad > 0.021739 AND tarde <= 0 AND actividad > 0.08344 : bienestarsocial (3.0/1.0) 
(defrule rule701
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (interesados))
	(semana)
	(not (aquellas))
	(not (edad))
	(local)
	(not (puedan))
	(fiestas)
	(not (honor))
	(not (organiza))
	(not (materia))
	(proyecto)
	(actividad)
	(not (tarde))
	(actividad)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND largo <= 0 AND entrevista <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND puedan <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND organiza <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND actividad > 0.021739 AND tarde <= 0 : empleo (2.0/1.0) 
(defrule rule702
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (largo))
	(not (entrevista))
	(not (aquellas))
	(semana)
	(not (interesados))
	(not (edad))
	(local)
	(not (puedan))
	(fiestas)
	(not (honor))
	(not (organiza))
	(not (materia))
	(proyecto)
	(actividad)
	(not (tarde))
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND puedan <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND organiza <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND municipio > 0.065217 AND municipio <= 0.14433 : Juventud (3.0/1.0) 
(defrule rule703
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(semana)
	(not (interesados))
	(not (edad))
	(local)
	(not (puedan))
	(fiestas)
	(not (honor))
	(not (organiza))
	(not (materia))
	(proyecto)
	(municipio)
	(municipio)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND vecinos > 0.04782 AND vecinos <= 0.111366 : comunicacion (2.0/1.0) 
(defrule rule704
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(semana)
	(not (interesados))
	(not (edad))
	(local)
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(vecinos)
	(vecinos)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND cargo > 0 AND cargo <= 0.055556 AND cargo > 0.045657 : generales (3.0) 
(defrule rule705
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(semana)
	(not (interesados))
	(not (edad))
	(local)
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(cargo)
	(cargo)
	(cargo)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND edad <= 0 AND local <= 0.108757 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND cargo > 0 AND cargo <= 0.060734 : comunicacion (3.0/2.0) 
(defrule rule706
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(semana)
	(not (interesados))
	(not (edad))
	(local)
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(cargo)
	(cargo)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND cargo > 0 AND cargo <= 0.088337 : Educacion (2.0/1.0) 
(defrule rule707
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(semana)
	(not (interesados))
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(cargo)
	(cargo)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND tarde > 0.118123 AND tarde <= 0.135249 AND tarde > 0.122502 : social (3.0/1.0) 
(defrule rule708
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(semana)
	(not (interesados))
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(not (miembros))
	(tarde)
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND interesados <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND motivo > 0.044396 AND motivo <= 0.067333 : generales (4.0/2.0) 
(defrule rule709
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (interesados))
	(not (aquellas))
	(semana)
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(not (miembros))
	(motivo)
	(motivo)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND interesados <= 0 AND semana <= 0.067039 AND aquellas <= 0 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND motivo > 0 AND motivo <= 0.092272 : bienestarsocial (3.0/2.0) 
(defrule rule710
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (interesados))
	(semana)
	(not (aquellas))
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(not (miembros))
	(motivo)
	(motivo)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND interesados <= 0 AND semana <= 0.067039 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND motivo <= 0.052147 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND vecinos <= 0.058075 AND cargo <= 0.052316 AND casa <= 0.053961 AND ciudad <= 0.074642 AND tarde > 0.100451 AND tarde <= 0.12837 AND tarde > 0.106145 : Educacion (3.0/1.0) 
(defrule rule711
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(not (interesados))
	(semana)
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(motivo)
	(not (materia))
	(proyecto)
	(not (miembros))
	(vecinos)
	(cargo)
	(casa)
	(ciudad)
	(tarde)
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND hombres <= 0.050889 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND interesados <= 0 AND semana <= 0.067039 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND motivo <= 0.052147 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND vecinos <= 0.058075 AND cargo <= 0.052316 AND casa <= 0.053961 AND ciudad <= 0.074642 AND organizado > 0.040738 AND organizado > 0.073414 : cultura (3.0/2.0) 
(defrule rule712
	(not (presencial))
	(not (departamento))
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(hombres)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(not (interesados))
	(semana)
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(motivo)
	(not (materia))
	(proyecto)
	(not (miembros))
	(vecinos)
	(cargo)
	(casa)
	(ciudad)
	(organizado)
	(organizado)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND motivo <= 0.052147 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND vecinos <= 0.058075 AND cargo <= 0.052316 AND casa <= 0.053961 AND ciudad <= 0.074642 AND actividad <= 0.021739 AND tarde > 0 AND tarde <= 0.102102 AND tarde <= 0.09816 : asociales (3.0/1.0) 
(defrule rule713
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(semana)
	(not (interesados))
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(motivo)
	(not (materia))
	(proyecto)
	(not (miembros))
	(vecinos)
	(cargo)
	(casa)
	(ciudad)
	(actividad)
	(tarde)
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND motivo > 0.052147 : Comercio (3.0/2.0) 
(defrule rule714
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(semana)
	(not (interesados))
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(motivo)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND largo <= 0 AND aquellas <= 0 AND semana <= 0.067039 AND interesados <= 0 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND vecinos <= 0.058075 AND cargo <= 0.052316 AND casa <= 0.053961 AND ciudad <= 0.074642 AND actividad <= 0.021739 AND tarde > 0 AND tarde > 0.137318 AND tarde <= 0.139952 : cultura (2.0) 
(defrule rule715
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(not (largo))
	(not (aquellas))
	(semana)
	(not (interesados))
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(not (miembros))
	(vecinos)
	(cargo)
	(casa)
	(ciudad)
	(actividad)
	(tarde)
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND semana <= 0.067039 AND largo <= 0 AND aquellas <= 0 AND interesados <= 0 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND vecinos <= 0.058075 AND cargo <= 0.052316 AND casa <= 0.053961 AND ciudad <= 0.074642 AND participar <= 0.021739 AND actividad <= 0.021739 AND tarde > 0 AND tarde <= 0.119691 : comunicacion (3.0/2.0) 
(defrule rule716
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(semana)
	(not (largo))
	(not (aquellas))
	(not (interesados))
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(not (miembros))
	(vecinos)
	(cargo)
	(casa)
	(ciudad)
	(participar)
	(actividad)
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND semana <= 0.067039 AND largo <= 0 AND aquellas <= 0 AND interesados <= 0 AND local <= 0.108757 AND edad <= 0 AND puedan <= 0 AND organiza <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND vecinos <= 0.058075 AND cargo <= 0.052316 AND casa <= 0.053961 AND ciudad <= 0.074642 AND participar <= 0.021739 AND actividad <= 0.021739 AND tarde <= 0.067929 AND municipio <= 0.065217 AND solicitudes <= 0 AND instalaciones <= 0 AND mayores <= 0 AND actividades > 0.114286 AND actividades > 0.158301 : asociales (3.0/2.0) 
(defrule rule717
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(semana)
	(not (largo))
	(not (aquellas))
	(not (interesados))
	(local)
	(not (edad))
	(not (puedan))
	(not (organiza))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(not (miembros))
	(vecinos)
	(cargo)
	(casa)
	(ciudad)
	(participar)
	(actividad)
	(tarde)
	(municipio)
	(not (solicitudes))
	(not (instalaciones))
	(not (mayores))
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; presencial <= 0 AND departamento <= 0 AND hombres <= 0.050889 AND acuerdo <= 0 AND numerosas <= 0 AND encuentro <= 0.038851 AND calles <= 0.048184 AND documento <= 0 AND especial <= 0.052147 AND jornadas <= 0.047658 AND jornada <= 0 AND entrevista <= 0 AND semana <= 0.067039 AND largo <= 0 AND aquellas <= 0 AND interesados <= 0 AND local <= 0.108757 AND edad <= 0 AND organiza <= 0 AND puedan <= 0 AND fiestas <= 0.089965 AND honor <= 0 AND materia <= 0 AND proyecto <= 0.041997 AND miembros <= 0 AND vecinos <= 0.058075 AND cargo <= 0.052316 AND casa <= 0.053961 AND ciudad <= 0.074642 AND participar <= 0.021739 AND actividad <= 0.021739 AND tarde <= 0.067929 AND municipio <= 0.065217 AND solicitudes <= 0 AND instalaciones <= 0 AND mayores <= 0 : generales (441.0/399.0) 
(defrule rule718
	(not (presencial))
	(not (departamento))
	(hombres)
	(not (acuerdo))
	(not (numerosas))
	(encuentro)
	(calles)
	(not (documento))
	(especial)
	(jornadas)
	(not (jornada))
	(not (entrevista))
	(semana)
	(not (largo))
	(not (aquellas))
	(not (interesados))
	(local)
	(not (edad))
	(not (organiza))
	(not (puedan))
	(fiestas)
	(not (honor))
	(not (materia))
	(proyecto)
	(not (miembros))
	(vecinos)
	(cargo)
	(casa)
	(ciudad)
	(participar)
	(actividad)
	(tarde)
	(municipio)
	(not (solicitudes))
	(not (instalaciones))
	(not (mayores))
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; presencial <= 0 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND edad <= 0 AND provincial <= 0 AND departamento <= 0 AND aquellas <= 0 AND entrevista <= 0 AND materia <= 0 AND miembros <= 0 AND ciudad <= 0.074642 AND especial <= 0.052147 AND local <= 0.108757 AND proyecto <= 0.041997 AND tarde > 0 AND tarde <= 0.139952 : consumo (3.0/1.0) 
(defrule rule719
	(not (presencial))
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (edad))
	(not (provincial))
	(not (departamento))
	(not (aquellas))
	(not (entrevista))
	(not (materia))
	(not (miembros))
	(ciudad)
	(especial)
	(local)
	(proyecto)
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; aquellas <= 0 AND presencial <= 0 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND edad <= 0 AND provincial <= 0 AND departamento <= 0 AND entrevista <= 0 AND materia <= 0 AND miembros <= 0 AND ciudad <= 0.074642 AND especial <= 0.052147 AND local <= 0.108757 AND proyecto <= 0.041997 AND documento <= 0 AND calles <= 0.048184 AND semana <= 0.067039 AND organiza <= 0 AND solicitudes <= 0 AND participar <= 0.021739 AND encuentro <= 0.038851 AND tarde <= 0.075682 AND puedan <= 0 AND acuerdo <= 0 AND numerosas <= 0 AND vecinos <= 0.058075 AND fiestas <= 0.089965 AND honor <= 0 AND cargo <= 0.052316 AND casa <= 0.053961 AND instalaciones <= 0.055085 : Juventud (5.0/3.0) 
(defrule rule720
	(not (aquellas))
	(not (presencial))
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (edad))
	(not (provincial))
	(not (departamento))
	(not (entrevista))
	(not (materia))
	(not (miembros))
	(ciudad)
	(especial)
	(local)
	(proyecto)
	(not (documento))
	(calles)
	(semana)
	(not (organiza))
	(not (solicitudes))
	(participar)
	(encuentro)
	(tarde)
	(not (puedan))
	(not (acuerdo))
	(not (numerosas))
	(vecinos)
	(fiestas)
	(not (honor))
	(cargo)
	(casa)
	(instalaciones)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; aquellas <= 0 AND presencial <= 0 AND aquellos <= 0 AND puedan <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND edad <= 0 AND provincial <= 0 AND departamento <= 0 AND organiza <= 0 AND solicitudes <= 0 AND participar <= 0.021739 AND entrevista <= 0 AND materia <= 0 AND miembros <= 0 AND ciudad <= 0.074642 AND instalaciones <= 0 AND municipio <= 0.136842 AND local <= 0.108757 AND proyecto <= 0.041997 AND documento <= 0 AND semana <= 0.021739 AND tarde <= 0.075682 AND casa <= 0.053961 AND cargo <= 0.087379 AND fiestas <= 0.089965 AND honor <= 0 : Agricultura (9.0/4.0) 
(defrule rule721
	(not (aquellas))
	(not (presencial))
	(not (aquellos))
	(not (puedan))
	(jornadas)
	(hombres)
	(not (edad))
	(not (provincial))
	(not (departamento))
	(not (organiza))
	(not (solicitudes))
	(participar)
	(not (entrevista))
	(not (materia))
	(not (miembros))
	(ciudad)
	(not (instalaciones))
	(municipio)
	(local)
	(proyecto)
	(not (documento))
	(semana)
	(tarde)
	(casa)
	(cargo)
	(fiestas)
	(not (honor))
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; aquellas <= 0 AND presencial <= 0 AND aquellos <= 0 AND puedan <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND edad <= 0 AND provincial <= 0 AND departamento <= 0 AND organiza <= 0 AND solicitudes <= 0 AND participar <= 0.021739 AND entrevista <= 0 AND materia <= 0 AND miembros <= 0 AND proyecto <= 0.041997 AND ciudad <= 0.074642 AND instalaciones <= 0 AND municipio <= 0.136842 AND local <= 0.108757 AND semana <= 0.113662 AND documento <= 0 AND tarde <= 0.075682 AND casa <= 0.053961 AND cargo <= 0.087379 : festejos (5.0/1.0) 
(defrule rule722
	(not (aquellas))
	(not (presencial))
	(not (aquellos))
	(not (puedan))
	(jornadas)
	(hombres)
	(not (edad))
	(not (provincial))
	(not (departamento))
	(not (organiza))
	(not (solicitudes))
	(participar)
	(not (entrevista))
	(not (materia))
	(not (miembros))
	(proyecto)
	(ciudad)
	(not (instalaciones))
	(municipio)
	(local)
	(semana)
	(not (documento))
	(tarde)
	(casa)
	(cargo)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND presencial <= 0 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND documento <= 0 AND edad <= 0 AND semana <= 0.067039 AND tarde > 0 AND actividad <= 0.021739 : Comercio (3.0/2.0) 
(defrule rule723
	(not (aquellas))
	(not (gracias))
	(not (presencial))
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (documento))
	(not (edad))
	(semana)
	(tarde)
	(actividad)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND presencial <= 0 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND documento <= 0 AND edad <= 0 AND semana <= 0.067039 AND provincial <= 0 AND departamento <= 0 AND organiza <= 0 AND solicitudes <= 0 AND participar <= 0.021739 AND entrevista <= 0 AND materia <= 0 AND actividad <= 0.021739 AND ciudad <= 0.074642 AND instalaciones <= 0 AND local <= 0.108757 AND proyecto <= 0.041997 AND cargo <= 0.052316 AND casa <= 0.053961 : economia (2.0/1.0) 
(defrule rule724
	(not (aquellas))
	(not (gracias))
	(not (presencial))
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (documento))
	(not (edad))
	(semana)
	(not (provincial))
	(not (departamento))
	(not (organiza))
	(not (solicitudes))
	(participar)
	(not (entrevista))
	(not (materia))
	(actividad)
	(ciudad)
	(not (instalaciones))
	(local)
	(proyecto)
	(cargo)
	(casa)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND presencial <= 0 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND documento <= 0 AND edad <= 0 AND semana <= 0.067039 AND proyecto <= 0.041997 AND provincial <= 0 AND departamento <= 0 AND organiza <= 0 AND solicitudes <= 0 AND participar <= 0.021739 AND entrevista <= 0 AND materia <= 0 AND actividad <= 0.021739 AND local <= 0.108757 AND ciudad <= 0.074642 : social (6.0/3.0) 
(defrule rule725
	(not (aquellas))
	(not (gracias))
	(not (presencial))
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (documento))
	(not (edad))
	(semana)
	(proyecto)
	(not (provincial))
	(not (departamento))
	(not (organiza))
	(not (solicitudes))
	(participar)
	(not (entrevista))
	(not (materia))
	(actividad)
	(local)
	(ciudad)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND presencial <= 0 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND documento <= 0 AND edad <= 0 AND ciudad <= 0.074642 AND semana <= 0.067039 AND proyecto <= 0.041997 AND provincial <= 0 AND departamento <= 0 AND organiza <= 0 AND solicitudes <= 0 AND participar <= 0.021739 AND entrevista <= 0 AND materia <= 0 : seguridadCiudadana (4.0/1.0) 
(defrule rule726
	(not (aquellas))
	(not (gracias))
	(not (presencial))
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (documento))
	(not (edad))
	(ciudad)
	(semana)
	(proyecto)
	(not (provincial))
	(not (departamento))
	(not (organiza))
	(not (solicitudes))
	(participar)
	(not (entrevista))
	(not (materia))
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND presencial <= 0 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND documento <= 0 AND proyecto <= 0.041997 AND edad <= 0 AND ciudad <= 0.074642 AND semana <= 0.067039 AND provincial <= 0 AND departamento <= 0 AND organiza <= 0 AND solicitudes <= 0 AND participar <= 0.021739 : empleo (4.0/1.0) 
(defrule rule727
	(not (aquellas))
	(not (gracias))
	(not (presencial))
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (documento))
	(proyecto)
	(not (edad))
	(ciudad)
	(semana)
	(not (provincial))
	(not (departamento))
	(not (organiza))
	(not (solicitudes))
	(participar)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND presencial <= 0 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND documento <= 0 AND proyecto <= 0.041997 AND edad <= 0 AND ciudad <= 0.074642 AND semana <= 0.067039 AND provincial <= 0 AND departamento <= 0 : Juventud (6.0/3.0) 
(defrule rule728
	(not (aquellas))
	(not (gracias))
	(not (presencial))
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (documento))
	(proyecto)
	(not (edad))
	(ciudad)
	(semana)
	(not (provincial))
	(not (departamento))
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND presencial <= 0 AND semana <= 0.067039 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND documento <= 0 AND proyecto <= 0.041997 AND provincial <= 0 AND departamento <= 0 : participacion (4.0/2.0) 
(defrule rule729
	(not (aquellas))
	(not (gracias))
	(not (presencial))
	(semana)
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (documento))
	(proyecto)
	(not (provincial))
	(not (departamento))
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND presencial <= 0 AND semana <= 0.067039 AND aquellos <= 0 AND jornadas <= 0.047658 AND hombres <= 0.050889 AND documento <= 0 AND proyecto <= 0.041997 : asociales (4.0/2.0) 
(defrule rule730
	(not (aquellas))
	(not (gracias))
	(not (presencial))
	(semana)
	(not (aquellos))
	(jornadas)
	(hombres)
	(not (documento))
	(proyecto)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND tarde <= 0.075682 AND presencial <= 0 AND semana <= 0.067039 AND aquellos <= 0 AND jornadas <= 0.047658 AND documento <= 0 : economia (2.0/1.0) 
(defrule rule731
	(not (aquellas))
	(not (gracias))
	(tarde)
	(not (presencial))
	(semana)
	(not (aquellos))
	(jornadas)
	(not (documento))
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND tarde <= 0.075682 AND presencial <= 0 AND semana <= 0.067039 AND aquellos <= 0 AND jornadas <= 0.047658 : urbanismo (2.0) 
(defrule rule732
	(not (aquellas))
	(not (gracias))
	(tarde)
	(not (presencial))
	(semana)
	(not (aquellos))
	(jornadas)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND tarde <= 0.075682 AND presencial <= 0 AND semana <= 0.067039 AND aquellos <= 0 : tecnologia (2.0) 
(defrule rule733
	(not (aquellas))
	(not (gracias))
	(tarde)
	(not (presencial))
	(semana)
	(not (aquellos))
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND tarde <= 0.075682 AND presencial <= 0 AND semana <= 0.067039 : Formacion (2.0/1.0) 
(defrule rule734
	(not (aquellas))
	(not (gracias))
	(tarde)
	(not (presencial))
	(semana)
		=>
	(assert 
		(ETIQUETA_Formacion)
	)
)
;; aquellas <= 0 AND gracias <= 0 AND tarde <= 0.075682 AND presencial <= 0 : cultura (2.0/1.0) 
(defrule rule735
	(not (aquellas))
	(not (gracias))
	(tarde)
	(not (presencial))
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; aquellas <= 0 AND tarde <= 0.075682 : saci (3.0/1.0) 
(defrule rule736
	(not (aquellas))
	(tarde)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; aquellas <= 0 : igualdad (3.0/1.0) 
(defrule rule737
	(not (aquellas))
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
