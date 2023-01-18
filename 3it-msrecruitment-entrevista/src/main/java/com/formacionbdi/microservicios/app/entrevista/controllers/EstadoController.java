package com.formacionbdi.microservicios.app.entrevista.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.entrevista.services.EstadoService;
import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.msrecruitment.commons.clientes.models.entity.Estado;

@RestController
@RequestMapping("/estados")
public class EstadoController extends CommonController<Estado, EstadoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Estado estado, @PathVariable Long id) {
		Optional<Estado> o = this.service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Estado dbEstado = o.get();
		
		dbEstado.setNombre(estado.getNombre());

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbEstado));
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Estado estado){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(estado));
	}
	
}
