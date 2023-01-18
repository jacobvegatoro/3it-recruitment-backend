package com.tresit.msrecruitment.app.celulas.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.msrecruitment.app.celulas.services.CelulaService;
import com.tresit.msrecruitment.app.celulas.services.ClienteService;
import com.tresit.msrecruitment.commons.clientes.models.entity.Celula;
import com.tresit.msrecruitment.commons.clientes.models.entity.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends CommonController<Cliente, ClienteService> {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private CelulaService celulaService;

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Cliente cliente, @PathVariable Long id){
		Optional<Cliente> o = clienteService.findById(id);
				
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteDb = o.get();
		clienteDb.setNombre(cliente.getNombre());
		clienteDb.setCasaMatriz(cliente.getCasaMatriz());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar (@PathVariable String term){
		return ResponseEntity.ok(clienteService.findByNombreOrCasaMatriz(term));
		
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}

	@PutMapping("/{idcliente}/celula/{idcelula}")
	public ResponseEntity<?> editarcelulaycliente(@PathVariable Long idcliente, @PathVariable Long idcelula){
		Optional<Cliente> o = clienteService.findById(idcliente);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Cliente clienteDb = o.get();

		Optional<Celula> p = celulaService.findById(idcelula);

		if (!p.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Celula celulaDb = p.get();

		celulaDb.setCliente(clienteDb);
		
		return ResponseEntity.status(HttpStatus.OK).body(celulaService.save(celulaDb));
	}

	@PostMapping("/{id}/celula")
	public ResponseEntity<?> agregarcelulaycliente(@RequestBody Celula celula, @PathVariable Long id){
		Optional<Cliente> o = clienteService.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteDb = o.get();
		celula.setCliente(clienteDb);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(celulaService.save(celula));
	}

}
