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

import com.tresit.msrecruitment.commons.clientes.models.entity.Pregunta;
import com.tresit.recruitment.pregunta.service.PreguntaService;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

	@Autowired
	private PreguntaService preguntaService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(preguntaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Pregunta> o = preguntaService.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Pregunta pregunta) {
		Pregunta preguntaDb = preguntaService.save(pregunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(preguntaDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Pregunta pregunta, @PathVariable Long id) {
		Optional<Pregunta> o = preguntaService.findById(id);

		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Pregunta preguntaDb = o.get();
		preguntaDb.setDetalle(pregunta.getDetalle());
		preguntaDb.setActivo(pregunta.isActivo());

		return ResponseEntity.status(HttpStatus.CREATED).body(preguntaService.save(preguntaDb));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		preguntaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
