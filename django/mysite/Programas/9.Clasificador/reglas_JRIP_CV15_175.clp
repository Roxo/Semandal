;; (aceituna >= 0.666667) => @@class@@=municipal (2.0/0.0)
(defrule rule1
	(aceituna)
		=>
	(assert 
		(ETIQUETA_municipal)
	)
)
;; (miembros >= 0.666667) => @@class@@=cont (2.0/0.0)
(defrule rule2
	(miembros)
		=>
	(assert 
		(ETIQUETA_cont)
	)
)
;; (vecinos >= 0.5) => @@class@@=policia (2.0/0.0)
(defrule rule3
	(vecinos)
		=>
	(assert 
		(ETIQUETA_policia)
	)
)
;; (cita >= 0.285714) => @@class@@=guadalinfo (2.0/0.0)
(defrule rule4
	(cita)
		=>
	(assert 
		(ETIQUETA_guadalinfo)
	)
)
;; (proyectos >= 0.5) => @@class@@=Relacionesinstitucionales (4.0/0.0)
(defrule rule5
	(proyectos)
		=>
	(assert 
		(ETIQUETA_Relacionesinstitucionales)
	)
)
;; (estudiantes >= 0.25) => @@class@@=Relacionesinstitucionales (2.0/0.0)
(defrule rule6
	(estudiantes)
		=>
	(assert 
		(ETIQUETA_Relacionesinstitucionales)
	)
)
;; (meses >= 0.5) => @@class@@=patrimonio (5.0/1.0)
(defrule rule7
	(meses)
		=>
	(assert 
		(ETIQUETA_patrimonio)
	)
)
;; (miembros >= 0.166667) => @@class@@=_RSS (2.0/0.0)
(defrule rule8
	(miembros)
		=>
	(assert 
		(ETIQUETA__RSS)
	)
)
;; (alumnado >= 0.166667) => @@class@@=_RSS (2.0/0.0)
(defrule rule9
	(alumnado)
		=>
	(assert 
		(ETIQUETA__RSS)
	)
)
;; (centenario >= 0.166667) => @@class@@=_RSS (2.0/0.0)
(defrule rule10
	(centenario)
		=>
	(assert 
		(ETIQUETA__RSS)
	)
)
;; (horario >= 0.25) and (horario <= 0.25) => @@class@@=_RSS (2.0/0.0)
(defrule rule11
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA__RSS)
	)
)
;; (organizan >= 0.043478) => @@class@@=mayores (2.0/0.0)
(defrule rule12
	(organizan)
		=>
	(assert 
		(ETIQUETA_mayores)
	)
)
;; (convivencia >= 0.043478) and (convivencia <= 0.043478) => @@class@@=mayores (2.0/0.0)
(defrule rule13
	(convivencia)
	(convivencia)
		=>
	(assert 
		(ETIQUETA_mayores)
	)
)
;; (zonas >= 0.421053) => @@class@@=parques (7.0/0.0)
(defrule rule14
	(zonas)
		=>
	(assert 
		(ETIQUETA_parques)
	)
)
;; (costumbres >= 0.157895) => @@class@@=parques (2.0/0.0)
(defrule rule15
	(costumbres)
		=>
	(assert 
		(ETIQUETA_parques)
	)
)
;; (parque >= 0.526316) => @@class@@=parques (4.0/0.0)
(defrule rule16
	(parque)
		=>
	(assert 
		(ETIQUETA_parques)
	)
)
;; (meses >= 0.263158) => @@class@@=parques (2.0/0.0)
(defrule rule17
	(meses)
		=>
	(assert 
		(ETIQUETA_parques)
	)
)
;; (mujeres >= 0.526316) => @@class@@=PIM (5.0/0.0)
(defrule rule18
	(mujeres)
		=>
	(assert 
		(ETIQUETA_PIM)
	)
)
;; (actos >= 0.421053) => @@class@@=PIM (2.0/0.0)
(defrule rule19
	(actos)
		=>
	(assert 
		(ETIQUETA_PIM)
	)
)
;; (pincha >= 0.105263) => @@class@@=PIM (2.0/0.0)
(defrule rule20
	(pincha)
		=>
	(assert 
		(ETIQUETA_PIM)
	)
)
;; (servicio >= 0.47619) => @@class@@=saci (5.0/0.0)
(defrule rule21
	(servicio)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; (caso >= 0.47619) => @@class@@=saci (8.0/1.0)
(defrule rule22
	(caso)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; (necesidades >= 0.190476) => @@class@@=saci (2.0/0.0)
(defrule rule23
	(necesidades)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; (utilizar >= 0.142857) => @@class@@=saci (2.0/0.0)
(defrule rule24
	(utilizar)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; (aportar >= 0.190476) => @@class@@=saci (2.0/0.0)
(defrule rule25
	(aportar)
		=>
	(assert 
		(ETIQUETA_saci)
	)
)
;; (marcha >= 0.228571) => @@class@@=ciudadania (7.0/0.0)
(defrule rule26
	(marcha)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; (periodo >= 0.2) => @@class@@=ciudadania (6.0/0.0)
(defrule rule27
	(periodo)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; (talleres >= 0.342857) => @@class@@=ciudadania (4.0/0.0)
(defrule rule28
	(talleres)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; (personal >= 0.171429) and (personal <= 0.171429) => @@class@@=ciudadania (5.0/0.0)
(defrule rule29
	(personal)
	(personal)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; (plazo >= 0.257143) and (plazo <= 0.257143) => @@class@@=ciudadania (3.0/0.0)
(defrule rule30
	(plazo)
	(plazo)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; (actos >= 0.114286) => @@class@@=ciudadania (2.0/0.0)
(defrule rule31
	(actos)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; (objetivo >= 0.228571) and (objetivo <= 0.228571) => @@class@@=ciudadania (2.0/0.0)
(defrule rule32
	(objetivo)
	(objetivo)
		=>
	(assert 
		(ETIQUETA_ciudadania)
	)
)
;; (establecimientos >= 0.392308) => @@class@@=Comercio (25.0/0.0)
(defrule rule33
	(establecimientos)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; (comercio >= 0.623077) => @@class@@=Comercio (12.0/0.0)
(defrule rule34
	(comercio)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; (productos >= 0.415385) => @@class@@=Comercio (12.0/1.0)
(defrule rule35
	(productos)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; (horario >= 0.276923) => @@class@@=Comercio (5.0/0.0)
(defrule rule36
	(horario)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; (clientes >= 0.107692) => @@class@@=Comercio (5.0/0.0)
(defrule rule37
	(clientes)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; (tarde >= 0.207692) => @@class@@=Comercio (4.0/1.0)
(defrule rule38
	(tarde)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; (serie >= 0.215385) => @@class@@=Comercio (2.0/0.0)
(defrule rule39
	(serie)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; (acto >= 0.2) and (acto <= 0.2) => @@class@@=Comercio (3.0/0.0)
(defrule rule40
	(acto)
	(acto)
		=>
	(assert 
		(ETIQUETA_Comercio)
	)
)
;; (actividad >= 0.209877) => @@class@@=tecnologia (16.0/0.0)
(defrule rule41
	(actividad)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (centros >= 0.234568) => @@class@@=tecnologia (14.0/0.0)
(defrule rule42
	(centros)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (proyecto >= 0.246914) and (proyecto <= 0.246914) => @@class@@=tecnologia (15.0/0.0)
(defrule rule43
	(proyecto)
	(proyecto)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (padres >= 0.197531) => @@class@@=tecnologia (4.0/0.0)
(defrule rule44
	(padres)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (conjuntamente >= 0.074074) => @@class@@=tecnologia (3.0/0.0)
(defrule rule45
	(conjuntamente)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (actividades >= 0.246914) and (actividades <= 0.246914) => @@class@@=tecnologia (5.0/0.0)
(defrule rule46
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (jornadas >= 0.098765) => @@class@@=tecnologia (2.0/0.0)
(defrule rule47
	(jornadas)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (elementos >= 0.08642) => @@class@@=tecnologia (1.0/0.0)
(defrule rule48
	(elementos)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (redes >= 0.135802) => @@class@@=tecnologia (2.0/0.0)
(defrule rule49
	(redes)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (empresa >= 0.135802) and (empresa <= 0.135802) => @@class@@=tecnologia (3.0/0.0)
(defrule rule50
	(empresa)
	(empresa)
		=>
	(assert 
		(ETIQUETA_tecnologia)
	)
)
;; (viviendas >= 0.511905) => @@class@@=Vivienda (38.0/0.0)
(defrule rule51
	(viviendas)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; (superficie >= 0.321429) => @@class@@=Vivienda (19.0/0.0)
(defrule rule52
	(superficie)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; (vivienda >= 0.690476) => @@class@@=Vivienda (8.0/0.0)
(defrule rule53
	(vivienda)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; (precio >= 0.142857) => @@class@@=Vivienda (6.0/0.0)
(defrule rule54
	(precio)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; (mejorar >= 0.178571) => @@class@@=Vivienda (3.0/0.0)
(defrule rule55
	(mejorar)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; (servicio >= 0.22619) and (servicio <= 0.22619) => @@class@@=Vivienda (4.0/0.0)
(defrule rule56
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; (papel >= 0.083333) => @@class@@=Vivienda (1.0/0.0)
(defrule rule57
	(papel)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; (entidades >= 0.119048) => @@class@@=Vivienda (2.0/0.0)
(defrule rule58
	(entidades)
		=>
	(assert 
		(ETIQUETA_Vivienda)
	)
)
;; (agentes >= 0.402062) => @@class@@=trafico (33.0/0.0)
(defrule rule59
	(agentes)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (miembros >= 0.164948) => @@class@@=trafico (11.0/0.0)
(defrule rule60
	(miembros)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (calle >= 0.206186) and (calle <= 0.206186) => @@class@@=trafico (12.0/0.0)
(defrule rule61
	(calle)
	(calle)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (alcaldesa >= 0.134021) => @@class@@=trafico (8.0/0.0)
(defrule rule62
	(alcaldesa)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (hechos >= 0.206186) => @@class@@=trafico (5.0/0.0)
(defrule rule63
	(hechos)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (opositores >= 0.072165) => @@class@@=trafico (4.0/0.0)
(defrule rule64
	(opositores)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (delito >= 0.123711) => @@class@@=trafico (3.0/0.0)
(defrule rule65
	(delito)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (casco >= 0.092784) => @@class@@=trafico (3.0/0.0)
(defrule rule66
	(casco)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (tipo >= 0.082474) and (tipo <= 0.082474) => @@class@@=trafico (3.0/0.0)
(defrule rule67
	(tipo)
	(tipo)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (servicio >= 0.195876) and (servicio <= 0.195876) => @@class@@=trafico (3.0/0.0)
(defrule rule68
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (plazas >= 0.123711) and (plazas <= 0.123711) => @@class@@=trafico (2.0/0.0)
(defrule rule69
	(plazas)
	(plazas)
		=>
	(assert 
		(ETIQUETA_trafico)
	)
)
;; (plazo >= 0.483051) => @@class@@=recursosHumanos (49.0/0.0)
(defrule rule70
	(plazo)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (servicio >= 0.279661) and (servicio <= 0.279661) => @@class@@=recursosHumanos (16.0/0.0)
(defrule rule71
	(servicio)
	(servicio)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (trabajadores >= 0.127119) => @@class@@=recursosHumanos (6.0/0.0)
(defrule rule72
	(trabajadores)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (plazas >= 0.177966) => @@class@@=recursosHumanos (6.0/0.0)
(defrule rule73
	(plazas)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (convocatoria >= 0.440678) => @@class@@=recursosHumanos (7.0/0.0)
(defrule rule74
	(convocatoria)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (solicitudes >= 0.313559) => @@class@@=recursosHumanos (4.0/0.0)
(defrule rule75
	(solicitudes)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (admitidos >= 0.271186) => @@class@@=recursosHumanos (3.0/0.0)
(defrule rule76
	(admitidos)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (servicios >= 0.245763) and (servicios <= 0.245763) => @@class@@=recursosHumanos (5.0/0.0)
(defrule rule77
	(servicios)
	(servicios)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (fotocopia >= 0.127119) => @@class@@=recursosHumanos (2.0/0.0)
(defrule rule78
	(fotocopia)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (empleo >= 0.398305) and (empleo <= 0.398305) => @@class@@=recursosHumanos (3.0/0.0)
(defrule rule79
	(empleo)
	(empleo)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (candidatos >= 0.161017) => @@class@@=recursosHumanos (2.0/0.0)
(defrule rule80
	(candidatos)
		=>
	(assert 
		(ETIQUETA_recursosHumanos)
	)
)
;; (servicio >= 0.294294) => @@class@@=servicios (43.0/1.0)
(defrule rule81
	(servicio)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (play >= 0.156156) => @@class@@=servicios (12.0/0.0)
(defrule rule82
	(play)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (horario >= 0.171171) and (horario <= 0.171171) => @@class@@=servicios (12.0/0.0)
(defrule rule83
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (obras >= 0.256757) and (obras <= 0.256757) => @@class@@=servicios (21.0/0.0)
(defrule rule84
	(obras)
	(obras)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (suministro >= 0.117117) => @@class@@=servicios (7.0/1.0)
(defrule rule85
	(suministro)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (correspondiente >= 0.048048) => @@class@@=servicios (5.0/1.0)
(defrule rule86
	(correspondiente)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (aprobado >= 0.057057) => @@class@@=servicios (3.0/0.0)
(defrule rule87
	(aprobado)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (hechos >= 0.045045) and (hechos <= 0.045045) => @@class@@=servicios (3.0/0.0)
(defrule rule88
	(hechos)
	(hechos)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (urbano >= 0.06006) and (urbano <= 0.06006) => @@class@@=servicios (5.0/0.0)
(defrule rule89
	(urbano)
	(urbano)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (viviendas >= 0.046547) and (viviendas <= 0.046547) => @@class@@=servicios (4.0/0.0)
(defrule rule90
	(viviendas)
	(viviendas)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (cumplimiento >= 0.067568) => @@class@@=servicios (3.0/1.0)
(defrule rule91
	(cumplimiento)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (zonas >= 0.112613) and (zonas <= 0.112613) => @@class@@=servicios (4.0/0.0)
(defrule rule92
	(zonas)
	(zonas)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (previsto >= 0.073574) and (previsto <= 0.073574) => @@class@@=servicios (3.0/0.0)
(defrule rule93
	(previsto)
	(previsto)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (motivo >= 0.111111) and (motivo <= 0.111111) => @@class@@=servicios (3.0/0.0)
(defrule rule94
	(motivo)
	(motivo)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (real >= 0.09009) and (real <= 0.09009) => @@class@@=servicios (2.0/0.0)
(defrule rule95
	(real)
	(real)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (viene >= 0.051051) and (viene <= 0.051051) => @@class@@=servicios (2.0/0.0)
(defrule rule96
	(viene)
	(viene)
		=>
	(assert 
		(ETIQUETA_servicios)
	)
)
;; (equipo >= 0.198464) => @@class@@=Deportes (27.0/0.0)
(defrule rule97
	(equipo)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (participantes >= 0.198944) => @@class@@=Deportes (26.0/0.0)
(defrule rule98
	(participantes)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (deporte >= 0.229422) => @@class@@=Deportes (16.0/0.0)
(defrule rule99
	(deporte)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (deportivo >= 0.188385) => @@class@@=Deportes (7.0/0.0)
(defrule rule100
	(deportivo)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (inscribirse >= 0.042237) and (inscribirse <= 0.042237) => @@class@@=Deportes (6.0/0.0)
(defrule rule101
	(inscribirse)
	(inscribirse)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (final >= 0.142789) => @@class@@=Deportes (6.0/0.0)
(defrule rule102
	(final)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (jornada >= 0.133909) => @@class@@=Deportes (7.0/1.0)
(defrule rule103
	(jornada)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (piscina >= 0.088793) => @@class@@=Deportes (5.0/0.0)
(defrule rule104
	(piscina)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (deportiva >= 0.200864) => @@class@@=Deportes (3.0/0.0)
(defrule rule105
	(deportiva)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (torneo >= 0.12023) => @@class@@=Deportes (4.0/0.0)
(defrule rule106
	(torneo)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (evento >= 0.110871) and (evento <= 0.110871) => @@class@@=Deportes (4.0/0.0)
(defrule rule107
	(evento)
	(evento)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (equipos >= 0.152628) => @@class@@=Deportes (2.0/0.0)
(defrule rule108
	(equipos)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (campeonato >= 0.173746) => @@class@@=Deportes (2.0/0.0)
(defrule rule109
	(campeonato)
		=>
	(assert 
		(ETIQUETA_Deportes)
	)
)
;; (calles >= 0.169177) and (calles <= 0.169177) => @@class@@=festejos (31.0/0.0)
(defrule rule110
	(calles)
	(calles)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (feria >= 0.264558) => @@class@@=festejos (18.0/0.0)
(defrule rule111
	(feria)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (cartel >= 0.126004) => @@class@@=festejos (10.0/0.0)
(defrule rule112
	(cartel)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (tarde >= 0.182731) => @@class@@=festejos (9.0/0.0)
(defrule rule113
	(tarde)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (tradicional >= 0.13504) => @@class@@=festejos (6.0/0.0)
(defrule rule114
	(tradicional)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (premios >= 0.123494) => @@class@@=festejos (7.0/0.0)
(defrule rule115
	(premios)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (noche >= 0.167169) => @@class@@=festejos (6.0/0.0)
(defrule rule116
	(noche)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (celebra >= 0.081325) => @@class@@=festejos (4.0/0.0)
(defrule rule117
	(celebra)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (recorrido >= 0.121486) => @@class@@=festejos (4.0/0.0)
(defrule rule118
	(recorrido)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (fiestas >= 0.273092) => @@class@@=festejos (3.0/0.0)
(defrule rule119
	(fiestas)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (participar >= 0.109438) and (participar <= 0.109438) => @@class@@=festejos (5.0/0.0)
(defrule rule120
	(participar)
	(participar)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (fiesta >= 0.195281) => @@class@@=festejos (3.0/0.0)
(defrule rule121
	(fiesta)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (vecinas >= 0.051205) and (vecinas <= 0.051205) => @@class@@=festejos (3.0/0.0)
(defrule rule122
	(vecinas)
	(vecinas)
		=>
	(assert 
		(ETIQUETA_festejos)
	)
)
;; (actividades >= 0.282264) and (actividades <= 0.282264) => @@class@@=igualdad (50.0/0.0)
(defrule rule123
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (mujeres >= 0.339545) and (mujeres <= 0.339545) => @@class@@=igualdad (25.0/0.0)
(defrule rule124
	(mujeres)
	(mujeres)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (actividad >= 0.189786) => @@class@@=igualdad (12.0/0.0)
(defrule rule125
	(actividad)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (dirigido >= 0.108351) => @@class@@=igualdad (7.0/0.0)
(defrule rule126
	(dirigido)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (organizado >= 0.133195) => @@class@@=igualdad (5.0/0.0)
(defrule rule127
	(organizado)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (oferta >= 0.088337) and (oferta <= 0.088337) => @@class@@=igualdad (7.0/0.0)
(defrule rule128
	(oferta)
	(oferta)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (igualdad >= 0.533471) => @@class@@=igualdad (4.0/0.0)
(defrule rule129
	(igualdad)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (dirigida >= 0.076605) => @@class@@=igualdad (2.0/0.0)
(defrule rule130
	(dirigida)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (entrega >= 0.069013) and (entrega <= 0.069013) => @@class@@=igualdad (6.0/0.0)
(defrule rule131
	(entrega)
	(entrega)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (disfrutar >= 0.071774) and (disfrutar <= 0.071774) => @@class@@=igualdad (5.0/0.0)
(defrule rule132
	(disfrutar)
	(disfrutar)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (organizada >= 0.069013) => @@class@@=igualdad (2.0/0.0)
(defrule rule133
	(organizada)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (aquellos >= 0.056591) and (aquellos <= 0.056591) => @@class@@=igualdad (2.0/0.0)
(defrule rule134
	(aquellos)
	(aquellos)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (horario >= 0.114562) and (horario <= 0.114562) => @@class@@=igualdad (4.0/0.0)
(defrule rule135
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (desarrollo >= 0.198068) and (desarrollo <= 0.198068) => @@class@@=igualdad (2.0/0.0)
(defrule rule136
	(desarrollo)
	(desarrollo)
		=>
	(assert 
		(ETIQUETA_igualdad)
	)
)
;; (actividades >= 0.215639) and (actividades <= 0.215639) => @@class@@=Juventud (29.0/0.0)
(defrule rule137
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (participar >= 0.117293) and (participar <= 0.117293) => @@class@@=Juventud (15.0/0.0)
(defrule rule138
	(participar)
	(participar)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (organiza >= 0.076692) and (organiza <= 0.076692) => @@class@@=Juventud (13.0/0.0)
(defrule rule139
	(organiza)
	(organiza)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (becas >= 0.045714) => @@class@@=Juventud (8.0/1.0)
(defrule rule140
	(becas)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (premio >= 0.055639) and (premio <= 0.055639) => @@class@@=Juventud (5.0/0.0)
(defrule rule141
	(premio)
	(premio)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (organizado >= 0.093233) and (organizado <= 0.093233) => @@class@@=Juventud (6.0/0.0)
(defrule rule142
	(organizado)
	(organizado)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (marcha >= 0.116992) and (marcha <= 0.116992) => @@class@@=Juventud (13.0/0.0)
(defrule rule143
	(marcha)
	(marcha)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (cursos >= 0.070075) and (cursos <= 0.070075) => @@class@@=Juventud (8.0/0.0)
(defrule rule144
	(cursos)
	(cursos)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (participado >= 0.040602) => @@class@@=Juventud (2.0/0.0)
(defrule rule145
	(participado)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (actividad >= 0.153083) and (actividad <= 0.153083) => @@class@@=Juventud (3.0/0.0)
(defrule rule146
	(actividad)
	(actividad)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (solicitudes >= 0.052932) and (solicitudes <= 0.052932) => @@class@@=Juventud (5.0/0.0)
(defrule rule147
	(solicitudes)
	(solicitudes)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (salida >= 0.041203) and (salida <= 0.041203) => @@class@@=Juventud (3.0/0.0)
(defrule rule148
	(salida)
	(salida)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (trabajo >= 0.135639) and (trabajo <= 0.135639) => @@class@@=Juventud (4.0/0.0)
(defrule rule149
	(trabajo)
	(trabajo)
		=>
	(assert 
		(ETIQUETA_Juventud)
	)
)
;; (evento >= 0.135135) => @@class@@=turismo1 (18.0/0.0)
(defrule rule150
	(evento)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (tradicional >= 0.097297) and (tradicional <= 0.097297) => @@class@@=turismo1 (16.0/0.0)
(defrule rule151
	(tradicional)
	(tradicional)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (imagen >= 0.068726) and (imagen <= 0.068726) => @@class@@=turismo1 (13.0/0.0)
(defrule rule152
	(imagen)
	(imagen)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (turismo >= 0.244015) => @@class@@=turismo1 (9.0/0.0)
(defrule rule153
	(turismo)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (horario >= 0.144402) and (horario <= 0.144402) => @@class@@=turismo1 (17.0/0.0)
(defrule rule154
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (noche >= 0.133591) => @@class@@=turismo1 (9.0/0.0)
(defrule rule155
	(noche)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (entrega >= 0.100386) and (entrega <= 0.100386) => @@class@@=turismo1 (9.0/0.0)
(defrule rule156
	(entrega)
	(entrega)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (onubense >= 0.066409) => @@class@@=turismo1 (5.0/0.0)
(defrule rule157
	(onubense)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (visita >= 0.085714) and (visita <= 0.085714) => @@class@@=turismo1 (5.0/0.0)
(defrule rule158
	(visita)
	(visita)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (plaza >= 0.253282) => @@class@@=turismo1 (5.0/1.0)
(defrule rule159
	(plaza)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (delegada >= 0.146718) and (delegada <= 0.146718) => @@class@@=turismo1 (5.0/0.0)
(defrule rule160
	(delegada)
	(delegada)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (cita >= 0.113514) and (cita <= 0.113514) => @@class@@=turismo1 (3.0/0.0)
(defrule rule161
	(cita)
	(cita)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (encuentro >= 0.082625) and (encuentro <= 0.082625) => @@class@@=turismo1 (7.0/0.0)
(defrule rule162
	(encuentro)
	(encuentro)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (recorrido >= 0.088031) and (recorrido <= 0.088031) => @@class@@=turismo1 (4.0/0.0)
(defrule rule163
	(recorrido)
	(recorrido)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (precio >= 0.115058) => @@class@@=turismo1 (2.0/0.0)
(defrule rule164
	(precio)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (prevista >= 0.058687) and (prevista <= 0.058687) => @@class@@=turismo1 (2.0/0.0)
(defrule rule165
	(prevista)
	(prevista)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (presente >= 0.065637) and (presente <= 0.065637) => @@class@@=turismo1 (2.0/0.0)
(defrule rule166
	(presente)
	(presente)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (especial >= 0.08417) and (especial <= 0.08417) => @@class@@=turismo1 (2.0/0.0)
(defrule rule167
	(especial)
	(especial)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (cargo >= 0.094208) and (cargo <= 0.094208) => @@class@@=turismo1 (3.0/0.0)
(defrule rule168
	(cargo)
	(cargo)
		=>
	(assert 
		(ETIQUETA_turismo1)
	)
)
;; (ciudad >= 0.55178) => @@class@@=Grupo_Municipal_PSOE (57.0/0.0)
(defrule rule169
	(ciudad)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; (medios >= 0.47411) => @@class@@=Grupo_Municipal_PSOE (35.0/0.0)
(defrule rule170
	(medios)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; (concejala >= 0.289644) => @@class@@=Grupo_Municipal_PSOE (23.0/0.0)
(defrule rule171
	(concejala)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; (concejal >= 0.44822) => @@class@@=Grupo_Municipal_PSOE (15.0/0.0)
(defrule rule172
	(concejal)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; (forma >= 0.286408) => @@class@@=Grupo_Municipal_PSOE (6.0/0.0)
(defrule rule173
	(forma)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; (seguir >= 0.11165) => @@class@@=Grupo_Municipal_PSOE (3.0/0.0)
(defrule rule174
	(seguir)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; (puntos >= 0.105178) => @@class@@=Grupo_Municipal_PSOE (2.0/0.0)
(defrule rule175
	(puntos)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; (actividades >= 0.234628) and (actividades <= 0.234628) => @@class@@=Grupo_Municipal_PSOE (3.0/0.0)
(defrule rule176
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; (recorrido >= 0.113269) => @@class@@=Grupo_Municipal_PSOE (2.0/0.0)
(defrule rule177
	(recorrido)
		=>
	(assert 
		(ETIQUETA_Grupo_Municipal_PSOE)
	)
)
;; (servicio >= 0.267857) => @@class@@=consumo (38.0/0.0)
(defrule rule178
	(servicio)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (grupos >= 0.165179) => @@class@@=consumo (16.0/0.0)
(defrule rule179
	(grupos)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (salud >= 0.513393) and (salud <= 0.513393) => @@class@@=consumo (22.0/0.0)
(defrule rule180
	(salud)
	(salud)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (serie >= 0.102679) => @@class@@=consumo (10.0/0.0)
(defrule rule181
	(serie)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (consumo >= 0.205357) => @@class@@=consumo (6.0/0.0)
(defrule rule182
	(consumo)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (horario >= 0.214286) => @@class@@=consumo (8.0/1.0)
(defrule rule183
	(horario)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (consultar >= 0.09375) => @@class@@=consumo (5.0/0.0)
(defrule rule184
	(consultar)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (charla >= 0.089286) => @@class@@=consumo (7.0/1.0)
(defrule rule185
	(charla)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (aquellos >= 0.071429) => @@class@@=consumo (4.0/0.0)
(defrule rule186
	(aquellos)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (pone >= 0.066964) and (pone <= 0.066964) => @@class@@=consumo (5.0/0.0)
(defrule rule187
	(pone)
	(pone)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (enfermedad >= 0.075893) and (enfermedad <= 0.075893) => @@class@@=consumo (3.0/0.0)
(defrule rule188
	(enfermedad)
	(enfermedad)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (vecinas >= 0.071429) and (vecinos <= 0.178571) => @@class@@=consumo (3.0/0.0)
(defrule rule189
	(vecinas)
	(vecinos)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (caso >= 0.138393) and (caso <= 0.138393) => @@class@@=consumo (5.0/0.0)
(defrule rule190
	(caso)
	(caso)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (aquellas >= 0.071429) => @@class@@=consumo (2.0/0.0)
(defrule rule191
	(aquellas)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (modo >= 0.111607) and (modo <= 0.111607) => @@class@@=consumo (2.0/0.0)
(defrule rule192
	(modo)
	(modo)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (servicios >= 0.223214) and (servicios <= 0.223214) => @@class@@=consumo (2.0/0.0)
(defrule rule193
	(servicios)
	(servicios)
		=>
	(assert 
		(ETIQUETA_consumo)
	)
)
;; (largo >= 0.091696) and (largo <= 0.091696) => @@class@@=participacion (16.0/0.0)
(defrule rule194
	(largo)
	(largo)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (horario >= 0.133795) and (horario <= 0.133795) => @@class@@=participacion (22.0/0.0)
(defrule rule195
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (acto >= 0.143022) and (acto <= 0.143022) => @@class@@=participacion (18.0/0.0)
(defrule rule196
	(acto)
	(acto)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (deportiva >= 0.060554) => @@class@@=participacion (8.0/0.0)
(defrule rule197
	(deportiva)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (participar >= 0.088812) and (participar <= 0.088812) => @@class@@=participacion (11.0/0.0)
(defrule rule198
	(participar)
	(participar)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (celebra >= 0.053633) and (celebra <= 0.053633) => @@class@@=participacion (5.0/0.0)
(defrule rule199
	(celebra)
	(celebra)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (poder >= 0.068627) and (poder <= 0.068627) => @@class@@=participacion (6.0/0.0)
(defrule rule200
	(poder)
	(poder)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (calle >= 0.141869) and (calle <= 0.141869) => @@class@@=participacion (9.0/0.0)
(defrule rule201
	(calle)
	(calle)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (serie >= 0.05248) and (serie <= 0.05248) => @@class@@=participacion (6.0/0.0)
(defrule rule202
	(serie)
	(serie)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (noche >= 0.05421) and (noche <= 0.05421) => @@class@@=participacion (4.0/0.0)
(defrule rule203
	(noche)
	(noche)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (organizado >= 0.085352) and (organizado <= 0.085352) => @@class@@=participacion (4.0/0.0)
(defrule rule204
	(organizado)
	(organizado)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (club >= 0.061707) and (club <= 0.061707) => @@class@@=participacion (3.0/0.0)
(defrule rule205
	(club)
	(club)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (delegaciones >= 0.064014) => @@class@@=participacion (2.0/0.0)
(defrule rule206
	(delegaciones)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (grupos >= 0.080738) and (grupos <= 0.080738) => @@class@@=participacion (3.0/0.0)
(defrule rule207
	(grupos)
	(grupos)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (general >= 0.080161) and (general <= 0.080161) => @@class@@=participacion (3.0/0.0)
(defrule rule208
	(general)
	(general)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (apoyo >= 0.053633) and (apoyo <= 0.053633) => @@class@@=participacion (3.0/0.0)
(defrule rule209
	(apoyo)
	(apoyo)
		=>
	(assert 
		(ETIQUETA_participacion)
	)
)
;; (cargo >= 0.125) => @@class@@=social (16.0/0.0)
(defrule rule210
	(cargo)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (talleres >= 0.157895) => @@class@@=social (19.0/0.0)
(defrule rule211
	(talleres)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (necesidades >= 0.092105) => @@class@@=social (12.0/0.0)
(defrule rule212
	(necesidades)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (enlace >= 0.098684) and (enlace <= 0.098684) => @@class@@=social (10.0/0.0)
(defrule rule213
	(enlace)
	(enlace)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (servicios >= 0.381579) and (servicios <= 0.381579) => @@class@@=social (8.0/0.0)
(defrule rule214
	(servicios)
	(servicios)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (organiza >= 0.105263) => @@class@@=social (9.0/1.0)
(defrule rule215
	(organiza)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (abre >= 0.039474) => @@class@@=social (4.0/0.0)
(defrule rule216
	(abre)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (ayuda >= 0.157895) => @@class@@=social (7.0/0.0)
(defrule rule217
	(ayuda)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (acceder >= 0.065789) and (acceder <= 0.065789) => @@class@@=social (5.0/0.0)
(defrule rule218
	(acceder)
	(acceder)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (social >= 0.388158) and (social <= 0.388158) => @@class@@=social (6.0/0.0)
(defrule rule219
	(social)
	(social)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (alumnas >= 0.065789) and (alumnas <= 0.065789) => @@class@@=social (5.0/0.0)
(defrule rule220
	(alumnas)
	(alumnas)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (solidaridad >= 0.059211) => @@class@@=social (3.0/0.0)
(defrule rule221
	(solidaridad)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (curso >= 0.164474) and (curso <= 0.164474) => @@class@@=social (5.0/0.0)
(defrule rule222
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (convivencia >= 0.039474) and (convivencia <= 0.039474) => @@class@@=social (3.0/0.0)
(defrule rule223
	(convivencia)
	(convivencia)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (recogida >= 0.078947) and (recogida <= 0.078947) => @@class@@=social (3.0/0.0)
(defrule rule224
	(recogida)
	(recogida)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (discapacitados >= 0.059211) => @@class@@=social (2.0/0.0)
(defrule rule225
	(discapacitados)
		=>
	(assert 
		(ETIQUETA_social)
	)
)
;; (obras >= 0.482213) and (obras <= 0.482213) => @@class@@=infraestructura (59.0/0.0)
(defrule rule226
	(obras)
	(obras)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (vecinos >= 0.363636) => @@class@@=infraestructura (29.0/0.0)
(defrule rule227
	(vecinos)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (cabo >= 0.335968) => @@class@@=infraestructura (19.0/0.0)
(defrule rule228
	(cabo)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (mejora >= 0.383399) => @@class@@=infraestructura (8.0/0.0)
(defrule rule229
	(mejora)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (instalaciones >= 0.26087) => @@class@@=infraestructura (4.0/0.0)
(defrule rule230
	(instalaciones)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (calles >= 0.217391) => @@class@@=infraestructura (5.0/0.0)
(defrule rule231
	(calles)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (calle >= 0.221344) and (calle <= 0.221344) => @@class@@=infraestructura (5.0/0.0)
(defrule rule232
	(calle)
	(calle)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (meses >= 0.237154) => @@class@@=infraestructura (3.0/0.0)
(defrule rule233
	(meses)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (proyecto >= 0.324111) => @@class@@=infraestructura (3.0/0.0)
(defrule rule234
	(proyecto)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (medio >= 0.162055) and (medio <= 0.162055) => @@class@@=infraestructura (3.0/0.0)
(defrule rule235
	(medio)
	(medio)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (torno >= 0.059289) => @@class@@=infraestructura (2.0/0.0)
(defrule rule236
	(torno)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (mantenimiento >= 0.075099) => @@class@@=infraestructura (3.0/1.0)
(defrule rule237
	(mantenimiento)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (aguas >= 0.102767) => @@class@@=infraestructura (2.0/0.0)
(defrule rule238
	(aguas)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (espacios >= 0.063241) and (espacios <= 0.063241) => @@class@@=infraestructura (2.0/0.0)
(defrule rule239
	(espacios)
	(espacios)
		=>
	(assert 
		(ETIQUETA_infraestructura)
	)
)
;; (plazo >= 0.217791) and (plazo <= 0.217791) => @@class@@=asociales (25.0/0.0)
(defrule rule240
	(plazo)
	(plazo)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (taller >= 0.236196) => @@class@@=asociales (18.0/0.0)
(defrule rule241
	(taller)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (delegada >= 0.180982) and (delegada <= 0.180982) => @@class@@=asociales (16.0/0.0)
(defrule rule242
	(delegada)
	(delegada)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (facilitar >= 0.058282) => @@class@@=asociales (7.0/0.0)
(defrule rule243
	(facilitar)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (tema >= 0.04908) => @@class@@=asociales (6.0/0.0)
(defrule rule244
	(tema)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (actividades >= 0.187117) and (actividades <= 0.187117) => @@class@@=asociales (12.0/0.0)
(defrule rule245
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (escolar >= 0.067485) and (escolar <= 0.067485) => @@class@@=asociales (3.0/0.0)
(defrule rule246
	(escolar)
	(escolar)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (vida >= 0.165644) and (vida <= 0.165644) => @@class@@=asociales (5.0/0.0)
(defrule rule247
	(vida)
	(vida)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (edad >= 0.174847) => @@class@@=asociales (2.0/0.0)
(defrule rule248
	(edad)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (esfuerzo >= 0.052147) and (esfuerzo <= 0.052147) => @@class@@=asociales (3.0/0.0)
(defrule rule249
	(esfuerzo)
	(esfuerzo)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (visita >= 0.052147) and (visita <= 0.052147) => @@class@@=asociales (3.0/0.0)
(defrule rule250
	(visita)
	(visita)
		=>
	(assert 
		(ETIQUETA_asociales)
	)
)
;; (informa >= 0.304428) => @@class@@=reginterior (53.0/0.0)
(defrule rule251
	(informa)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (laboral >= 0.284133) => @@class@@=reginterior (21.0/0.0)
(defrule rule252
	(laboral)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (proceso >= 0.343173) => @@class@@=reginterior (18.0/0.0)
(defrule rule253
	(proceso)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (reunido >= 0.201107) => @@class@@=reginterior (18.0/0.0)
(defrule rule254
	(reunido)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (admitidos >= 0.156827) => @@class@@=reginterior (8.0/0.0)
(defrule rule255
	(admitidos)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (alegaciones >= 0.156827) => @@class@@=reginterior (7.0/0.0)
(defrule rule256
	(alegaciones)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (bolsa >= 0.254613) => @@class@@=reginterior (5.0/0.0)
(defrule rule257
	(bolsa)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (requisitos >= 0.130996) and (requisitos <= 0.130996) => @@class@@=reginterior (3.0/0.0)
(defrule rule258
	(requisitos)
	(requisitos)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (bases >= 0.125461) and (bases <= 0.125461) => @@class@@=reginterior (3.0/0.0)
(defrule rule259
	(bases)
	(bases)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (aquellos >= 0.038745) and (aquellos <= 0.038745) => @@class@@=reginterior (2.0/0.0)
(defrule rule260
	(aquellos)
	(aquellos)
		=>
	(assert 
		(ETIQUETA_reginterior)
	)
)
;; (agricultores >= 0.318436) => @@class@@=Agricultura (37.0/0.0)
(defrule rule261
	(agricultores)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (aceituna >= 0.223464) => @@class@@=Agricultura (20.0/0.0)
(defrule rule262
	(aceituna)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (condiciones >= 0.134078) => @@class@@=Agricultura (13.0/1.0)
(defrule rule263
	(condiciones)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (caminos >= 0.111732) => @@class@@=Agricultura (8.0/0.0)
(defrule rule264
	(caminos)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (informado >= 0.067039) and (informado <= 0.067039) => @@class@@=Agricultura (7.0/0.0)
(defrule rule265
	(informado)
	(informado)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (sector >= 0.26257) => @@class@@=Agricultura (5.0/0.0)
(defrule rule266
	(sector)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (servicio >= 0.223464) => @@class@@=Agricultura (7.0/0.0)
(defrule rule267
	(servicio)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (parque >= 0.089385) and (parque <= 0.089385) => @@class@@=Agricultura (10.0/0.0)
(defrule rule268
	(parque)
	(parque)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (realizando >= 0.061453) and (realizando <= 0.061453) => @@class@@=Agricultura (5.0/0.0)
(defrule rule269
	(realizando)
	(realizando)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (distintos >= 0.055866) and (distintos <= 0.055866) => @@class@@=Agricultura (5.0/0.0)
(defrule rule270
	(distintos)
	(distintos)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (marcha >= 0.162011) and (marcha <= 0.162011) => @@class@@=Agricultura (5.0/0.0)
(defrule rule271
	(marcha)
	(marcha)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (responsable >= 0.106145) => @@class@@=Agricultura (3.0/0.0)
(defrule rule272
	(responsable)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (cultivo >= 0.094972) => @@class@@=Agricultura (2.0/0.0)
(defrule rule273
	(cultivo)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (olivar >= 0.111732) => @@class@@=Agricultura (2.0/0.0)
(defrule rule274
	(olivar)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (municipio >= 0.24581) and (municipio <= 0.24581) => @@class@@=Agricultura (6.0/0.0)
(defrule rule275
	(municipio)
	(municipio)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (maquinaria >= 0.061453) => @@class@@=Agricultura (1.0/0.0)
(defrule rule276
	(maquinaria)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (solicitud >= 0.072626) and (solicitud <= 0.072626) => @@class@@=Agricultura (3.0/0.0)
(defrule rule277
	(solicitud)
	(solicitud)
		=>
	(assert 
		(ETIQUETA_Agricultura)
	)
)
;; (obras >= 0.556582) => @@class@@=obras (68.0/0.0)
(defrule rule278
	(obras)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (zonas >= 0.183603) => @@class@@=obras (20.0/0.0)
(defrule rule279
	(zonas)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (parque >= 0.138568) => @@class@@=obras (10.0/1.0)
(defrule rule280
	(parque)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (calles >= 0.193995) => @@class@@=obras (6.0/0.0)
(defrule rule281
	(calles)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (empresa >= 0.210162) => @@class@@=obras (7.0/0.0)
(defrule rule282
	(empresa)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (municipales >= 0.185912) => @@class@@=obras (6.0/0.0)
(defrule rule283
	(municipales)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (vecinos >= 0.232102) and (vecinos <= 0.232102) => @@class@@=obras (7.0/0.0)
(defrule rule284
	(vecinos)
	(vecinos)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (carretera >= 0.084296) => @@class@@=obras (3.0/0.0)
(defrule rule285
	(carretera)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (meses >= 0.227483) => @@class@@=obras (2.0/0.0)
(defrule rule286
	(meses)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (funcionamiento >= 0.048499) => @@class@@=obras (2.0/0.0)
(defrule rule287
	(funcionamiento)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (motivo >= 0.055427) and (motivo <= 0.055427) => @@class@@=obras (3.0/0.0)
(defrule rule288
	(motivo)
	(motivo)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (cantidad >= 0.06582) => @@class@@=obras (2.0/0.0)
(defrule rule289
	(cantidad)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (proyectos >= 0.079677) and (proyectos <= 0.079677) => @@class@@=obras (2.0/0.0)
(defrule rule290
	(proyectos)
	(proyectos)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (urbano >= 0.093533) and (urbano <= 0.093533) => @@class@@=obras (2.0/0.0)
(defrule rule291
	(urbano)
	(urbano)
		=>
	(assert 
		(ETIQUETA_obras)
	)
)
;; (actividades >= 0.233441) and (actividades <= 0.233441) => @@class@@=bienestarsocial (35.0/0.0)
(defrule rule292
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (social >= 0.472536) => @@class@@=bienestarsocial (13.0/0.0)
(defrule rule293
	(social)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (mayores >= 0.252019) and (mayores <= 0.252019) => @@class@@=bienestarsocial (18.0/0.0)
(defrule rule294
	(mayores)
	(mayores)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (alimentos >= 0.060582) and (alimentos <= 0.060582) => @@class@@=bienestarsocial (7.0/0.0)
(defrule rule295
	(alimentos)
	(alimentos)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (participar >= 0.120355) => @@class@@=bienestarsocial (7.0/0.0)
(defrule rule296
	(participar)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (madres >= 0.058966) and (madres <= 0.058966) => @@class@@=bienestarsocial (6.0/0.0)
(defrule rule297
	(madres)
	(madres)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (solicitudes >= 0.088853) and (solicitudes <= 0.088853) => @@class@@=bienestarsocial (8.0/0.0)
(defrule rule298
	(solicitudes)
	(solicitudes)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (tarde >= 0.137318) and (tarde <= 0.137318) => @@class@@=bienestarsocial (4.0/0.0)
(defrule rule299
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (habilidades >= 0.052504) and (habilidades <= 0.052504) => @@class@@=bienestarsocial (4.0/0.0)
(defrule rule300
	(habilidades)
	(habilidades)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (dirigido >= 0.092892) => @@class@@=bienestarsocial (2.0/0.0)
(defrule rule301
	(dirigido)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (necesidades >= 0.063813) and (necesidades <= 0.063813) => @@class@@=bienestarsocial (4.0/0.0)
(defrule rule302
	(necesidades)
	(necesidades)
		=>
	(assert 
		(ETIQUETA_bienestarsocial)
	)
)
;; (cabo >= 0.181132) => @@class@@=medioamb (30.0/0.0)
(defrule rule303
	(cabo)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (municipio >= 0.325472) => @@class@@=medioamb (20.0/1.0)
(defrule rule304
	(municipio)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (residuos >= 0.156604) => @@class@@=medioamb (13.0/0.0)
(defrule rule305
	(residuos)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (forma >= 0.216038) => @@class@@=medioamb (12.0/0.0)
(defrule rule306
	(forma)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (objetivo >= 0.158491) and (objetivo <= 0.158491) => @@class@@=medioamb (15.0/0.0)
(defrule rule307
	(objetivo)
	(objetivo)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (espacio >= 0.084906) => @@class@@=medioamb (6.0/0.0)
(defrule rule308
	(espacio)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (cambio >= 0.062264) => @@class@@=medioamb (3.0/0.0)
(defrule rule309
	(cambio)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (medioambiental >= 0.080189) => @@class@@=medioamb (2.0/0.0)
(defrule rule310
	(medioambiental)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (informa >= 0.061321) and (informa <= 0.061321) => @@class@@=medioamb (5.0/0.0)
(defrule rule311
	(informa)
	(informa)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (zonas >= 0.173585) => @@class@@=medioamb (6.0/0.0)
(defrule rule312
	(zonas)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (valor >= 0.063208) and (valor <= 0.063208) => @@class@@=medioamb (3.0/0.0)
(defrule rule313
	(valor)
	(valor)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (mantenimiento >= 0.070755) => @@class@@=medioamb (2.0/0.0)
(defrule rule314
	(mantenimiento)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (medio >= 0.527358) => @@class@@=medioamb (2.0/0.0)
(defrule rule315
	(medio)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (entorno >= 0.170755) => @@class@@=medioamb (2.0/0.0)
(defrule rule316
	(entorno)
		=>
	(assert 
		(ETIQUETA_medioamb)
	)
)
;; (plazo >= 0.267261) => @@class@@=empleo (34.0/1.0)
(defrule rule317
	(plazo)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (empleo >= 0.454343) => @@class@@=empleo (24.0/0.0)
(defrule rule318
	(empleo)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (listado >= 0.063474) => @@class@@=empleo (11.0/0.0)
(defrule rule319
	(listado)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (trabajo >= 0.273942) => @@class@@=empleo (10.0/0.0)
(defrule rule320
	(trabajo)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (curso >= 0.187082) and (curso <= 0.187082) => @@class@@=empleo (15.0/0.0)
(defrule rule321
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (local >= 0.185969) and (local <= 0.185969) => @@class@@=empleo (10.0/0.0)
(defrule rule322
	(local)
	(local)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (noticia >= 0.05902) => @@class@@=empleo (3.0/0.0)
(defrule rule323
	(noticia)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (laboral >= 0.178174) => @@class@@=empleo (4.0/0.0)
(defrule rule324
	(laboral)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (interesados >= 0.065702) => @@class@@=empleo (8.0/3.0)
(defrule rule325
	(interesados)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (informativa >= 0.04343) and (informativa <= 0.04343) => @@class@@=empleo (3.0/0.0)
(defrule rule326
	(informativa)
	(informativa)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (solicitudes >= 0.155902) => @@class@@=empleo (2.0/0.0)
(defrule rule327
	(solicitudes)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (entrevista >= 0.056793) => @@class@@=empleo (2.0/0.0)
(defrule rule328
	(entrevista)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (puestos >= 0.095768) => @@class@@=empleo (3.0/1.0)
(defrule rule329
	(puestos)
		=>
	(assert 
		(ETIQUETA_empleo)
	)
)
;; (pueblo >= 0.220779) => @@class@@=comunicacion (19.0/0.0)
(defrule rule330
	(pueblo)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (datos >= 0.100649) => @@class@@=comunicacion (13.0/0.0)
(defrule rule331
	(datos)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (mejorar >= 0.159091) => @@class@@=comunicacion (14.0/0.0)
(defrule rule332
	(mejorar)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (puntos >= 0.103896) => @@class@@=comunicacion (15.0/0.0)
(defrule rule333
	(puntos)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (afirmado >= 0.068182) => @@class@@=comunicacion (5.0/0.0)
(defrule rule334
	(afirmado)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (seguir >= 0.081169) => @@class@@=comunicacion (7.0/0.0)
(defrule rule335
	(seguir)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (acceder >= 0.071429) => @@class@@=comunicacion (8.0/1.0)
(defrule rule336
	(acceder)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (pleno >= 0.191558) => @@class@@=comunicacion (6.0/0.0)
(defrule rule337
	(pleno)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (asuntos >= 0.061688) => @@class@@=comunicacion (5.0/0.0)
(defrule rule338
	(asuntos)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (llegar >= 0.058442) => @@class@@=comunicacion (4.0/0.0)
(defrule rule339
	(llegar)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (estado >= 0.097403) and (estado <= 0.097403) => @@class@@=comunicacion (7.0/0.0)
(defrule rule340
	(estado)
	(estado)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (canal >= 0.084416) => @@class@@=comunicacion (3.0/0.0)
(defrule rule341
	(canal)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (online >= 0.051948) => @@class@@=comunicacion (3.0/0.0)
(defrule rule342
	(online)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (celebra >= 0.048701) and (celebra <= 0.048701) => @@class@@=comunicacion (5.0/0.0)
(defrule rule343
	(celebra)
	(celebra)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (ayuntamientos >= 0.045455) => @@class@@=comunicacion (2.0/0.0)
(defrule rule344
	(ayuntamientos)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (noticias >= 0.048701) => @@class@@=comunicacion (2.0/0.0)
(defrule rule345
	(noticias)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (miembros >= 0.055195) and (miembros <= 0.055195) => @@class@@=comunicacion (3.0/0.0)
(defrule rule346
	(miembros)
	(miembros)
		=>
	(assert 
		(ETIQUETA_comunicacion)
	)
)
;; (entrada >= 0.117505) => @@class@@=cultura (21.0/0.0)
(defrule rule347
	(entrada)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (obra >= 0.184242) and (obra <= 0.184242) => @@class@@=cultura (27.0/0.0)
(defrule rule348
	(obra)
	(obra)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (cargo >= 0.111329) => @@class@@=cultura (11.0/0.0)
(defrule rule349
	(cargo)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (disfrutar >= 0.092799) and (disfrutar <= 0.092799) => @@class@@=cultura (11.0/0.0)
(defrule rule350
	(disfrutar)
	(disfrutar)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (historia >= 0.105002) => @@class@@=cultura (8.0/0.0)
(defrule rule351
	(historia)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (cultura >= 0.420759) => @@class@@=cultura (6.0/0.0)
(defrule rule352
	(cultura)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (concurso >= 0.113287) and (concurso <= 0.113287) => @@class@@=cultura (8.0/0.0)
(defrule rule353
	(concurso)
	(concurso)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (celebra >= 0.050166) and (celebra <= 0.050166) => @@class@@=cultura (5.0/0.0)
(defrule rule354
	(celebra)
	(celebra)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (sala >= 0.088882) => @@class@@=cultura (3.0/0.0)
(defrule rule355
	(sala)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (semana >= 0.136035) and (semana <= 0.136035) => @@class@@=cultura (6.0/0.0)
(defrule rule356
	(semana)
	(semana)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (precio >= 0.102591) => @@class@@=cultura (2.0/0.0)
(defrule rule357
	(precio)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (entradas >= 0.085417) => @@class@@=cultura (2.0/0.0)
(defrule rule358
	(entradas)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (presenta >= 0.050015) => @@class@@=cultura (2.0/0.0)
(defrule rule359
	(presenta)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (infantil >= 0.106508) and (infantil <= 0.106508) => @@class@@=cultura (3.0/0.0)
(defrule rule360
	(infantil)
	(infantil)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (participar >= 0.059205) and (participar <= 0.059205) => @@class@@=cultura (3.0/0.0)
(defrule rule361
	(participar)
	(participar)
		=>
	(assert 
		(ETIQUETA_cultura)
	)
)
;; (forma >= 0.207579) => @@class@@=ayuntamiento (30.0/0.0)
(defrule rule362
	(forma)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (palabras >= 0.131306) => @@class@@=ayuntamiento (20.0/0.0)
(defrule rule363
	(palabras)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (importante >= 0.117548) => @@class@@=ayuntamiento (12.0/1.0)
(defrule rule364
	(importante)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (semana >= 0.170167) => @@class@@=ayuntamiento (11.0/0.0)
(defrule rule365
	(semana)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (obra >= 0.105238) and (obra <= 0.105238) => @@class@@=ayuntamiento (12.0/0.0)
(defrule rule366
	(obra)
	(obra)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (equipo >= 0.113927) => @@class@@=ayuntamiento (7.0/0.0)
(defrule rule367
	(equipo)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (delegada >= 0.134926) and (delegada <= 0.134926) => @@class@@=ayuntamiento (6.0/0.0)
(defrule rule368
	(delegada)
	(delegada)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (tradicional >= 0.067825) => @@class@@=ayuntamiento (6.0/0.0)
(defrule rule369
	(tradicional)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (playa >= 0.076273) => @@class@@=ayuntamiento (4.0/0.0)
(defrule rule370
	(playa)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (cita >= 0.0951) and (cita <= 0.0951) => @@class@@=ayuntamiento (5.0/0.0)
(defrule rule371
	(cita)
	(cita)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (pueblo >= 0.158098) => @@class@@=ayuntamiento (5.0/1.0)
(defrule rule372
	(pueblo)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (interesados >= 0.063963) => @@class@@=ayuntamiento (3.0/0.0)
(defrule rule373
	(interesados)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (noche >= 0.067584) and (noche <= 0.067584) => @@class@@=ayuntamiento (4.0/0.0)
(defrule rule374
	(noche)
	(noche)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (presente >= 0.070722) => @@class@@=ayuntamiento (4.0/1.0)
(defrule rule375
	(presente)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (miembros >= 0.084721) and (miembros <= 0.084721) => @@class@@=ayuntamiento (4.0/0.0)
(defrule rule376
	(miembros)
	(miembros)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (sala >= 0.079894) => @@class@@=ayuntamiento (2.0/0.0)
(defrule rule377
	(sala)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (recorrido >= 0.071929) => @@class@@=ayuntamiento (3.0/1.0)
(defrule rule378
	(recorrido)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (puedan >= 0.067584) and (puedan <= 0.067584) => @@class@@=ayuntamiento (3.0/0.0)
(defrule rule379
	(puedan)
	(puedan)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (concejal >= 0.16896) and (concejal <= 0.16896) => @@class@@=ayuntamiento (2.0/0.0)
(defrule rule380
	(concejal)
	(concejal)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (tarde >= 0.09679) and (tarde <= 0.09679) => @@class@@=ayuntamiento (2.0/0.0)
(defrule rule381
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_ayuntamiento)
	)
)
;; (obras >= 0.397751) => @@class@@=urbanismo (59.0/0.0)
(defrule rule382
	(obras)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (proyecto >= 0.231084) => @@class@@=urbanismo (29.0/0.0)
(defrule rule383
	(proyecto)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (calle >= 0.209611) => @@class@@=urbanismo (13.0/1.0)
(defrule rule384
	(calle)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (vecinos >= 0.242331) => @@class@@=urbanismo (10.0/0.0)
(defrule rule385
	(vecinos)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (cabo >= 0.147239) => @@class@@=urbanismo (4.0/0.0)
(defrule rule386
	(cabo)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (zonas >= 0.135992) => @@class@@=urbanismo (6.0/1.0)
(defrule rule387
	(zonas)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (documento >= 0.088957) => @@class@@=urbanismo (7.0/1.0)
(defrule rule388
	(documento)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (calles >= 0.149284) => @@class@@=urbanismo (5.0/1.0)
(defrule rule389
	(calles)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (mejorar >= 0.133947) => @@class@@=urbanismo (4.0/1.0)
(defrule rule390
	(mejorar)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (semanas >= 0.054192) => @@class@@=urbanismo (2.0/0.0)
(defrule rule391
	(semanas)
		=>
	(assert 
		(ETIQUETA_urbanismo)
	)
)
;; (alumnos >= 0.323632) => @@class@@=Educacion (52.0/0.0)
(defrule rule392
	(alumnos)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (curso >= 0.305821) and (curso <= 0.305821) => @@class@@=Educacion (22.0/0.0)
(defrule rule393
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (educativos >= 0.112511) => @@class@@=Educacion (8.0/0.0)
(defrule rule394
	(educativos)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (obras >= 0.095135) and (obras <= 0.095135) => @@class@@=Educacion (8.0/0.0)
(defrule rule395
	(obras)
	(obras)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (clases >= 0.090356) => @@class@@=Educacion (5.0/0.0)
(defrule rule396
	(clases)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (concierto >= 0.061251) => @@class@@=Educacion (5.0/0.0)
(defrule rule397
	(concierto)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (temas >= 0.049522) => @@class@@=Educacion (4.0/0.0)
(defrule rule398
	(temas)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (actos >= 0.076455) and (actos <= 0.076455) => @@class@@=Educacion (5.0/0.0)
(defrule rule399
	(actos)
	(actos)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (horario >= 0.145091) and (horario <= 0.145091) => @@class@@=Educacion (4.0/0.0)
(defrule rule400
	(horario)
	(horario)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (padres >= 0.152476) => @@class@@=Educacion (3.0/0.0)
(defrule rule401
	(padres)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (tarde >= 0.122502) and (tarde <= 0.122502) => @@class@@=Educacion (6.0/0.0)
(defrule rule402
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (actividades >= 0.205474) and (actividades <= 0.205474) => @@class@@=Educacion (5.0/0.0)
(defrule rule403
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (abierto >= 0.094266) and (abierto <= 0.094266) => @@class@@=Educacion (3.0/0.0)
(defrule rule404
	(abierto)
	(abierto)
		=>
	(assert 
		(ETIQUETA_Educacion)
	)
)
;; (salud >= 0.596045) => @@class@@=salud (31.0/0.0)
(defrule rule405
	(salud)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (horario >= 0.173729) => @@class@@=salud (24.0/2.0)
(defrule rule406
	(horario)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (asociaciones >= 0.108757) and (asociaciones <= 0.108757) => @@class@@=salud (16.0/0.0)
(defrule rule407
	(asociaciones)
	(asociaciones)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (sangre >= 0.173729) => @@class@@=salud (9.0/0.0)
(defrule rule408
	(sangre)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (importante >= 0.09887) => @@class@@=salud (8.0/0.0)
(defrule rule409
	(importante)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (urgencias >= 0.069209) => @@class@@=salud (6.0/0.0)
(defrule rule410
	(urgencias)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (cabo >= 0.134181) and (cabo <= 0.134181) => @@class@@=salud (11.0/0.0)
(defrule rule411
	(cabo)
	(cabo)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (cita >= 0.114407) => @@class@@=salud (7.0/1.0)
(defrule rule412
	(cita)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (informativa >= 0.060734) => @@class@@=salud (6.0/1.0)
(defrule rule413
	(informativa)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (calidad >= 0.09887) => @@class@@=salud (3.0/0.0)
(defrule rule414
	(calidad)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (enfermedad >= 0.114407) => @@class@@=salud (3.0/0.0)
(defrule rule415
	(enfermedad)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (serie >= 0.067797) => @@class@@=salud (5.0/0.0)
(defrule rule416
	(serie)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (saludable >= 0.090395) => @@class@@=salud (4.0/0.0)
(defrule rule417
	(saludable)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (riesgo >= 0.110169) => @@class@@=salud (2.0/0.0)
(defrule rule418
	(riesgo)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (asistencia >= 0.063559) => @@class@@=salud (2.0/0.0)
(defrule rule419
	(asistencia)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (proceso >= 0.091808) => @@class@@=salud (2.0/0.0)
(defrule rule420
	(proceso)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (casos >= 0.055085) => @@class@@=salud (2.0/0.0)
(defrule rule421
	(casos)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (actividades >= 0.148305) and (actividades <= 0.148305) => @@class@@=salud (3.0/0.0)
(defrule rule422
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_salud)
	)
)
;; (empresas >= 0.279122) => @@class@@=desarrollo (42.0/0.0)
(defrule rule423
	(empresas)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (empleo >= 0.334229) => @@class@@=desarrollo (21.0/0.0)
(defrule rule424
	(empleo)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (sector >= 0.151434) => @@class@@=desarrollo (13.0/0.0)
(defrule rule425
	(sector)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (trabajo >= 0.198477) => @@class@@=desarrollo (10.0/1.0)
(defrule rule426
	(trabajo)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (horario >= 0.13172) => @@class@@=desarrollo (9.0/0.0)
(defrule rule427
	(horario)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (actividad >= 0.151882) and (actividad <= 0.151882) => @@class@@=desarrollo (8.0/0.0)
(defrule rule428
	(actividad)
	(actividad)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (mejora >= 0.098118) => @@class@@=desarrollo (3.0/0.0)
(defrule rule429
	(mejora)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (plazo >= 0.182796) => @@class@@=desarrollo (5.0/0.0)
(defrule rule430
	(plazo)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (datos >= 0.064068) => @@class@@=desarrollo (5.0/0.0)
(defrule rule431
	(datos)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (empresarios >= 0.12276) => @@class@@=desarrollo (2.0/0.0)
(defrule rule432
	(empresarios)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (alumnos >= 0.099014) and (alumnos <= 0.099014) => @@class@@=desarrollo (5.0/0.0)
(defrule rule433
	(alumnos)
	(alumnos)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (calle >= 0.108423) and (calle <= 0.108423) => @@class@@=desarrollo (3.0/0.0)
(defrule rule434
	(calle)
	(calle)
		=>
	(assert 
		(ETIQUETA_desarrollo)
	)
)
;; (informado >= 0.072127) => @@class@@=generales (11.0/0.0)
(defrule rule435
	(informado)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (acceso >= 0.03705) and (acceso <= 0.03705) => @@class@@=generales (10.0/0.0)
(defrule rule436
	(acceso)
	(acceso)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (orden >= 0.062521) and (orden <= 0.062521) => @@class@@=generales (6.0/0.0)
(defrule rule437
	(orden)
	(orden)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (trabajos >= 0.035935) and (trabajos <= 0.035935) => @@class@@=generales (6.0/0.0)
(defrule rule438
	(trabajos)
	(trabajos)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (trabajadores >= 0.03422) and (trabajadores <= 0.03422) => @@class@@=generales (4.0/0.0)
(defrule rule439
	(trabajadores)
	(trabajadores)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (concurso >= 0.048199) and (concurso <= 0.048199) => @@class@@=generales (7.0/0.0)
(defrule rule440
	(concurso)
	(concurso)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (actividades <= 0.106518) and (actividades >= 0.106518) => @@class@@=generales (10.0/0.0)
(defrule rule441
	(actividades)
	(actividades)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (libre >= 0.038508) and (libre <= 0.038508) => @@class@@=generales (4.0/0.0)
(defrule rule442
	(libre)
	(libre)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (actividades <= 0) and (vida >= 0.056346) and (vida <= 0.056346) => @@class@@=generales (6.0/0.0)
(defrule rule443
	(not (actividades))
	(vida)
	(vida)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (plaza >= 0.097856) and (plaza <= 0.097856) => @@class@@=generales (4.0/0.0)
(defrule rule444
	(plaza)
	(plaza)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (plazo >= 0.101544) and (plazo <= 0.101544) => @@class@@=generales (9.0/0.0)
(defrule rule445
	(plazo)
	(plazo)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (tarde >= 0.135249) and (tarde <= 0.135249) => @@class@@=generales (4.0/0.0)
(defrule rule446
	(tarde)
	(tarde)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (media >= 0.058062) => @@class@@=generales (2.0/0.0)
(defrule rule447
	(media)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (hermandad >= 0.032333) => @@class@@=generales (2.0/0.0)
(defrule rule448
	(hermandad)
		=>
	(assert 
		(ETIQUETA_generales)
	)
)
;; (empresas >= 0.143513) => @@class@@=economia (25.0/0.0)
(defrule rule449
	(empresas)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (plazo >= 0.177956) => @@class@@=economia (12.0/0.0)
(defrule rule450
	(plazo)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (local >= 0.219288) and (local <= 0.219288) => @@class@@=economia (12.0/0.0)
(defrule rule451
	(local)
	(local)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (pago >= 0.140069) => @@class@@=economia (10.0/0.0)
(defrule rule452
	(pago)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (solicitar >= 0.070034) => @@class@@=economia (8.0/0.0)
(defrule rule453
	(solicitar)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (delegado >= 0.057405) and (delegado <= 0.057405) => @@class@@=economia (7.0/0.0)
(defrule rule454
	(delegado)
	(delegado)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (acceso >= 0.06085) and (acceso <= 0.06085) => @@class@@=economia (7.0/0.0)
(defrule rule455
	(acceso)
	(acceso)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (meses >= 0.135476) and (meses <= 0.135476) => @@class@@=economia (7.0/0.0)
(defrule rule456
	(meses)
	(meses)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (curso >= 0.143513) and (curso <= 0.143513) => @@class@@=economia (8.0/0.0)
(defrule rule457
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (ejercicio >= 0.070034) => @@class@@=economia (5.0/0.0)
(defrule rule458
	(ejercicio)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (gracias >= 0.099885) and (gracias <= 0.099885) => @@class@@=economia (4.0/0.0)
(defrule rule459
	(gracias)
	(gracias)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (orden >= 0.064294) => @@class@@=economia (2.0/0.0)
(defrule rule460
	(orden)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (solicitud >= 0.080367) => @@class@@=economia (2.0/0.0)
(defrule rule461
	(solicitud)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (entidades >= 0.079219) => @@class@@=economia (2.0/0.0)
(defrule rule462
	(entidades)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (disfrutar >= 0.053961) and (disfrutar <= 0.053961) => @@class@@=economia (3.0/0.0)
(defrule rule463
	(disfrutar)
	(disfrutar)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (actos >= 0.055109) and (actos <= 0.055109) => @@class@@=economia (3.0/0.0)
(defrule rule464
	(actos)
	(actos)
		=>
	(assert 
		(ETIQUETA_economia)
	)
)
;; (mayores >= 0.308933) => @@class@@=ssociales (41.0/0.0)
(defrule rule465
	(mayores)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (social >= 0.310174) => @@class@@=ssociales (15.0/0.0)
(defrule rule466
	(social)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (plazo >= 0.153846) => @@class@@=ssociales (11.0/0.0)
(defrule rule467
	(plazo)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (familias >= 0.16129) => @@class@@=ssociales (12.0/0.0)
(defrule rule468
	(familias)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (participantes >= 0.111663) and (participantes <= 0.111663) => @@class@@=ssociales (10.0/0.0)
(defrule rule469
	(participantes)
	(participantes)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (talleres >= 0.153846) => @@class@@=ssociales (6.0/0.0)
(defrule rule470
	(talleres)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (familia >= 0.227047) => @@class@@=ssociales (3.0/0.0)
(defrule rule471
	(familia)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (charla >= 0.049628) => @@class@@=ssociales (3.0/0.0)
(defrule rule472
	(charla)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (proyecto >= 0.126551) and (proyecto <= 0.126551) => @@class@@=ssociales (7.0/0.0)
(defrule rule473
	(proyecto)
	(proyecto)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (socios >= 0.047146) => @@class@@=ssociales (2.0/0.0)
(defrule rule474
	(socios)
		=>
	(assert 
		(ETIQUETA_ssociales)
	)
)
;; (agentes >= 0.206675) => @@class@@=seguridadCiudadana (31.0/0.0)
(defrule rule475
	(agentes)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (servicio >= 0.220796) => @@class@@=seguridadCiudadana (28.0/0.0)
(defrule rule476
	(servicio)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (cabo >= 0.139923) => @@class@@=seguridadCiudadana (14.0/0.0)
(defrule rule477
	(cabo)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (seguridad >= 0.455712) => @@class@@=seguridadCiudadana (14.0/0.0)
(defrule rule478
	(seguridad)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (municipio >= 0.284981) => @@class@@=seguridadCiudadana (9.0/0.0)
(defrule rule479
	(municipio)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (bomberos >= 0.14249) => @@class@@=seguridadCiudadana (8.0/0.0)
(defrule rule480
	(bomberos)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (vecinos >= 0.192555) => @@class@@=seguridadCiudadana (9.0/0.0)
(defrule rule481
	(vecinos)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (puesto >= 0.159178) => @@class@@=seguridadCiudadana (6.0/1.0)
(defrule rule482
	(puesto)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (forma >= 0.178434) and (forma <= 0.178434) => @@class@@=seguridadCiudadana (8.0/0.0)
(defrule rule483
	(forma)
	(forma)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (calles >= 0.134788) => @@class@@=seguridadCiudadana (4.0/0.0)
(defrule rule484
	(calles)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (orden >= 0.056483) => @@class@@=seguridadCiudadana (3.0/0.0)
(defrule rule485
	(orden)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (miembros >= 0.092426) => @@class@@=seguridadCiudadana (3.0/0.0)
(defrule rule486
	(miembros)
		=>
	(assert 
		(ETIQUETA_seguridadCiudadana)
	)
)
;; (actividades >= 0.303534) => @@class@@=Mujer (36.0/0.0)
(defrule rule487
	(actividades)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (concejal >= 0.209979) => @@class@@=Mujer (22.0/0.0)
(defrule rule488
	(concejal)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (mujeres >= 0.428274) => @@class@@=Mujer (19.0/0.0)
(defrule rule489
	(mujeres)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (ciudad >= 0.264033) => @@class@@=Mujer (15.0/0.0)
(defrule rule490
	(ciudad)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (taller >= 0.234927) => @@class@@=Mujer (13.0/0.0)
(defrule rule491
	(taller)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (asistir >= 0.070686) => @@class@@=Mujer (5.0/0.0)
(defrule rule492
	(asistir)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (colectivos >= 0.079002) => @@class@@=Mujer (3.0/0.0)
(defrule rule493
	(colectivos)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (acto >= 0.220374) => @@class@@=Mujer (5.0/0.0)
(defrule rule494
	(acto)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (objetivo >= 0.172557) => @@class@@=Mujer (5.0/1.0)
(defrule rule495
	(objetivo)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (talleres >= 0.135135) => @@class@@=Mujer (3.0/0.0)
(defrule rule496
	(talleres)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
;; (curso >= 0.133056) and (curso <= 0.133056) => @@class@@=Mujer (4.0/0.0)
(defrule rule497
	(curso)
	(curso)
		=>
	(assert 
		(ETIQUETA_Mujer)
	)
)
