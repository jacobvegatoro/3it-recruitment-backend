package com.tresit.recruitment.pregunta.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.recruitment.pregunta.model.entity.Pregunta;
import com.tresit.recruitment.pregunta.service.PreguntaService;

@RestController
public class PreguntaController extends CommonController<Pregunta, PreguntaService> {
	//solo no queda implementado el put para modificar
	//SUPER DUDA: metodo de modificar respuestas de preguntas por medio de api serviria para alterar entrevistas?
	
    /*
    @PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody Pregunta pregunta, @PathVariable Long id){
		return null;	
	}	
     */
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@RequestBody Pregunta pregunta, @PathVariable Long id){
		Optional<Pregunta> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Pregunta preguntaDb = o.get();
		preguntaDb.setDetalle(pregunta.getDetalle());
		//getActivo No encontrado ->isActivo
		preguntaDb.setActivo(pregunta.isActivo()); 
		
		//en ejemplo asignatura-examen-pregunta se preocupan de ver que preguntas existen en db pero no en el set enviado
		//en caso rol-pregunta-respuesta al momento de agregar preguntas.. no estariamos
		preguntaDb.getPreguntas()
		.stream()
		.filter(pdb -> !examen.getPreguntas().contains(pdb))
		.forEach(examenDb::removePregunta);
		
		
		return null;
	}

}
