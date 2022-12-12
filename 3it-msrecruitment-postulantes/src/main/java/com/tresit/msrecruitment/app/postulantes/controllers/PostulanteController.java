package com.tresit.msrecruitment.app.postulantes.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.tresit.msrecruitment.app.postulantes.models.entity.Postulante;
import com.tresit.msrecruitment.app.postulantes.services.PostulanteService;


@RestController
public class PostulanteController {
	
	@Autowired
	private PostulanteService service;
	
	
	@GetMapping
	public ResponseEntity<?> listar(){	
		return ResponseEntity.ok().body(service.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){	
		Optional<Postulante> o = service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
		
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Postulante postulante){
		Postulante postulanteDb = service.save(postulante);
		return ResponseEntity.status(HttpStatus.CREATED).body(postulanteDb);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Postulante postulante, @PathVariable Long id){
		Optional<Postulante> o = service.findById(id);
				
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Postulante postulanteDb =o.get();
		postulanteDb.setNombre(postulante.getNombre());
		postulanteDb.setApellido(postulante.getApellido());
		postulanteDb.setCiudad(postulante.getCiudad());
		postulanteDb.setEnlaceBizneo(postulante.getEnlaceBizneo());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(postulanteDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
