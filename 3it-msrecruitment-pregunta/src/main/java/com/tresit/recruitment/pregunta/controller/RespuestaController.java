package com.tresit.recruitment.pregunta.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;
import com.tresit.msrecruitment.commons.clientes.models.entity.Pregunta;
import com.tresit.msrecruitment.commons.clientes.models.entity.Respuesta;
import com.tresit.recruitment.pregunta.service.PreguntaService;
import com.tresit.recruitment.pregunta.service.RespuestaService;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

	@Autowired
	private RespuestaService respuestaService;

	@Autowired
	private PreguntaService preguntaService;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(respuestaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Respuesta> o = respuestaService.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Respuesta respuesta) {
		Respuesta respuestaDb = respuestaService.save(respuesta);
		return ResponseEntity.status(HttpStatus.CREATED).body(respuestaDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Respuesta respuesta, @PathVariable Long id) {
		Optional<Respuesta> o = respuestaService.findById(id);

		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Respuesta respuestaDb = o.get();
		respuestaDb.setDetalle(respuesta.getDetalle());
		respuestaDb.setPuntaje(respuesta.getPuntaje());

		return ResponseEntity.status(HttpStatus.CREATED).body(respuestaService.save(respuestaDb));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		respuestaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{idrespuesta}/pregunta/{idpregunta}/entrevista/{identrevista}")
	public ResponseEntity<?> editarpreguntayentrevista(
			@PathVariable Long idrespuesta, 
			@PathVariable Long idpregunta,
			@PathVariable Long identrevista){
		
		Optional<Pregunta> o = preguntaService.findById(idpregunta);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Pregunta preguntaDb = o.get();

		Entrevista entrevistaDb = respuestaService.obtenerEntrevista(identrevista);

		if (entrevistaDb == null) {
			return ResponseEntity.notFound().build();
		}
				
		Optional<Respuesta> p = respuestaService.findById(idrespuesta);

		if (!p.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Respuesta respuestaDb = p.get();

		respuestaDb.setPregunta(preguntaDb);
		respuestaDb.setEntrevista(entrevistaDb);
		
		return ResponseEntity.status(HttpStatus.OK).body(respuestaService.save(respuestaDb));
	}

	@PostMapping("/pregunta/{idpregunta}/entrevista/{identrevista}")
	public ResponseEntity<?> agregarconentrevistaypregunta(
			@RequestBody Respuesta respuesta, 
			@PathVariable Long idpregunta,
			@PathVariable Long identrevista){
		
		Optional<Pregunta> o = preguntaService.findById(idpregunta);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Pregunta preguntaDb = o.get();

		Entrevista entrevistaDb = respuestaService.obtenerEntrevista(identrevista);

		if (entrevistaDb == null) {
			return ResponseEntity.notFound().build();
		}

		respuesta.setPregunta(preguntaDb);
		respuesta.setEntrevista(entrevistaDb);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(respuestaService.save(respuesta));
	}
}
