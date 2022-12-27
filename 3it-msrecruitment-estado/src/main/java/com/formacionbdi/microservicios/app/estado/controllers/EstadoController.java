package com.formacionbdi.microservicios.app.estado.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.estado.services.EstadoService;
import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.msrecruitment.commons.clientes.models.entity.Estado;

@RestController
public class EstadoController extends CommonController<Estado, EstadoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Estado estado, @PathVariable Long id) {
		Optional<Estado> o = this.service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Estado dbEstado = o.get();
		dbEstado.setNombre(estado.getNombre());
		//dbEstado.setComentario(estado.getComentario());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbEstado));
	}

	/*
	@PutMapping("/{id}/asignar-entrevistas")
	public ResponseEntity<?> asignarEntrevistas(@RequestBody List<Entrevista> entrevistas, @PathVariable Long id) {
		Optional<Estado> o = this.service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Estado dbEstado = o.get();
		
		entrevistas.forEach(a -> {
			dbEstado.addEntrevista(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbEstado));
	}
	
	@PutMapping("/{id}/eliminar-entrevista")
	public ResponseEntity<?> eliminarEntrevista(@RequestBody Entrevista entrevista, @PathVariable Long id) {
		Optional<Estado> o = this.service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Estado dbEstado = o.get();
		
		dbEstado.removeEntrevista(entrevista);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbEstado));
	}
	*/
}