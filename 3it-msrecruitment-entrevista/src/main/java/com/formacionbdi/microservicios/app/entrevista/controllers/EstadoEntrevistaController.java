package com.formacionbdi.microservicios.app.entrevista.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.entrevista.services.EntrevistaService;
import com.formacionbdi.microservicios.app.entrevista.services.EstadoEntrevistaService;
import com.formacionbdi.microservicios.app.entrevista.services.EstadoService;
import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;
import com.tresit.msrecruitment.commons.clientes.models.entity.Estado;
import com.tresit.msrecruitment.commons.clientes.models.entity.EstadoEntrevista;

@RestController
@RequestMapping("/estadosentrevistas")
public class EstadoEntrevistaController extends CommonController<EstadoEntrevista, EstadoEntrevistaService> {

	@Autowired
	private EntrevistaService entrevistaService;
	
	@Autowired
	private EstadoService estadoService;
		
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody EstadoEntrevista estadoentrevista, @PathVariable Long id) {
		Optional<EstadoEntrevista> o = this.service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		EstadoEntrevista dbEstadoEntrevista = o.get();
		
		dbEstadoEntrevista.setComentario(estadoentrevista.getComentario());
		dbEstadoEntrevista.setFecha(estadoentrevista.getFecha());

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbEstadoEntrevista));
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody EstadoEntrevista estadoentrevista){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(estadoentrevista));
	}

	@PutMapping("/{idestadoentrevista}/entrevista/{identrevista}/estado/{idestado}")
	public ResponseEntity<?> asignarentrevistayestado(
			@PathVariable Long idestadoentrevista, 
			@PathVariable Long identrevista, 
			@PathVariable Long idestado){
		Optional<EstadoEntrevista> ee = this.service.findById(idestadoentrevista);

		if (!ee.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		EstadoEntrevista estadoEntrevistaDb = ee.get();

		Optional<Entrevista> en = entrevistaService.findById(identrevista);

		if (!en.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Entrevista entrevistaDb = en.get();

		estadoEntrevistaDb.setEntrevista(entrevistaDb);

		Optional<Estado> es = estadoService.findById(idestado);

		if (!es.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Estado estadoDb = es.get();

		estadoEntrevistaDb.setEstado(estadoDb);
		
		return ResponseEntity.status(HttpStatus.OK).body(this.service.save(estadoEntrevistaDb));
	}

	@PostMapping("/entrevista/{identrevista}/estado/{idestado}")
	public ResponseEntity<?> agregarconentrevistayestado(
			@RequestBody EstadoEntrevista estadoentrevista, 
			@PathVariable Long identrevista, 
			@PathVariable Long idestado){

		Optional<Entrevista> en = entrevistaService.findById(identrevista);

		if (!en.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Entrevista entrevistaDb = en.get();
		
		estadoentrevista.setEntrevista(entrevistaDb);

		Optional<Estado> es = estadoService.findById(idestado);

		if (!es.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Estado estadoDb = es.get();

		estadoentrevista.setEstado(estadoDb);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(estadoentrevista));
	}
}
