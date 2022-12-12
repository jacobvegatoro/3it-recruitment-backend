package com.tresit.msrecruitment.app.clientes.controllers;

import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.msrecruitment.app.clientes.services.ClienteService;
import com.tresit.msrecruitment.commons.clientes.models.entity.Cliente;


@RestController
public class ClienteController extends CommonController<Cliente, ClienteService> {
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Cliente cliente, @PathVariable Long id){
		Optional<Cliente> o = service.findById(id);
				
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteDb = o.get();
		clienteDb.setNombre(cliente.getNombre());
		clienteDb.setCasaMatriz(cliente.getCasaMatriz());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar (@PathVariable String term){
		return ResponseEntity.ok(service.findByNombreOrCasaMatriz(term));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
