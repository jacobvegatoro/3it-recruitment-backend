package com.tresit.msrecruitment.app.celulas.controllers;

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

import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.msrecruitment.app.celulas.services.CelulaService;
import com.tresit.msrecruitment.commons.clientes.models.entity.Celula;

@RestController
@RequestMapping("/celulas")
public class CelulaController extends CommonController<Celula, CelulaService> {
	
	@Autowired
	private CelulaService celulaService;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Celula celula, @PathVariable Long id){
		Optional<Celula> o = celulaService.findById(id);
				
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Celula celulaDb = o.get();
		celulaDb.setNombre(celula.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(celulaService.save(celulaDb));
		
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Celula celula){
		return ResponseEntity.status(HttpStatus.CREATED).body(celulaService.save(celula));
	}

	/*
	@PostMapping("/{id}/cliente")
	public ResponseEntity<?> asignarClientes(@RequestBody Cliente cliente, @PathVariable Long id){
		Optional<Celula> o = this.service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Celula celulaDb = o.get();
		
		celulaDb.setCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(celulaDb));
	}

	@PutMapping("/{id}/asignar-clientes")
	public ResponseEntity<?> asignarClientes(@RequestBody Cliente cliente, @PathVariable Long id){
		Optional<Celula> o = this.service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Celula celulaDb = o.get();
		
		celulaDb.addCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(celulaDb));
	}
	
	
	@PutMapping("/{id}/eliminar-cliente")
	public ResponseEntity<?> eliminarCliente(@RequestBody Cliente cliente, @PathVariable Long id){
		Optional<Celula> o = this.service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Celula celulaDb = o.get();
		
		celulaDb.removeCliente(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(celulaDb));

	}
	
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?> buscarPorClienteId (@PathVariable Long id){
		Celula celula = service.findCelulaByClienteId(id);
		return ResponseEntity.ok(celula);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}*/

}

