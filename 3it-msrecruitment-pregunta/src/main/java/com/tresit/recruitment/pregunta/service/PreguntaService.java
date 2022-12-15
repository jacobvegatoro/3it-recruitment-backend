package com.tresit.recruitment.pregunta.service;

import java.util.Optional;

/*import com.formacionbdi.microservicios.commons.examenes.models.entity.Asignatura;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.commons.services.CommonService;*/
//import com.tresit.microservicios.commons.services.CommonService;
import com.tresit.recruitment.pregunta.model.entity.Pregunta;
/*
public interface PreguntaService extends CommonService<Pregunta>{
	//public List<Examen> findByNombre(String term);
	//public Iterable<Asignatura> findAllAsignaturas();
}*/

public interface PreguntaService{
    public Iterable<Pregunta> findAll();
	public Optional<Pregunta>findById(Long id);
	public Pregunta save(Pregunta pregunta);
	public void deleteById(Long id);
}