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
import com.tresit.msrecruitment.commons.clientes.models.entity.Rol;
import com.tresit.recruitment.pregunta.service.PreguntaService;
import com.tresit.recruitment.pregunta.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private RolService rolService;

	@Autowired
	private PreguntaService preguntaService;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(rolService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerRol(@PathVariable Long id) {
		Optional<Rol> o = rolService.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Rol rol) {
		Rol rolDb = rolService.save(rol);
		return ResponseEntity.status(HttpStatus.CREATED).body(rolDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Rol rol, @PathVariable Long id) {
		Optional<Rol> o = rolService.findById(id);

		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Rol rolDb = o.get();
		rolDb.setDetalle(rol.getDetalle());

		return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rolDb));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		rolService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{idrol}/pregunta/{idpregunta}")
	public ResponseEntity<?> editarpreguntayrol(@PathVariable Long idrol, @PathVariable Long idpregunta){
		Optional<Rol> o = rolService.findById(idrol);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Rol rolDb = o.get();

		Optional<Pregunta> p = preguntaService.findById(idpregunta);

		if (!p.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Pregunta preguntaDb = p.get();

		preguntaDb.setRol(rolDb);
		
		return ResponseEntity.status(HttpStatus.OK).body(preguntaService.save(preguntaDb));
	}

	@PostMapping("/{id}/pregunta")
	public ResponseEntity<?> agregarpreguntayrol(@RequestBody Pregunta pregunta, @PathVariable Long id){
		Optional<Rol> o = rolService.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Rol rolDb = o.get();
		pregunta.setRol(rolDb);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(preguntaService.save(pregunta));
	}
}
