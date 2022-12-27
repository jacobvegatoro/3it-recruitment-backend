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
import org.springframework.web.bind.annotation.RestController;

import com.tresit.msrecruitment.commons.clientes.models.entity.Pregunta;
//import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.recruitment.pregunta.service.PreguntaService;

@RestController
public class PreguntaController { //extends CommonController<Pregunta, PreguntaService> {
	/**  Al usar extends CommonController nos ahorramos:
	 *
	 * @Autowired
	 * protected S service;->private PreguntaService service;
	 * 
	 * @GetMapping
	 * public ResponseEntity<?> listar(){
	 * return ResponseEntity.ok().body(service.findAll());}
	 * 
	 *    y los demas metodos* en commonController
	 */
	
	@Autowired
	private PreguntaService service;
	
	@GetMapping
	 public ResponseEntity<?> listar(){
	 return ResponseEntity.ok().body(service.findAll());}
	  

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){	
		Optional<Pregunta> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Pregunta pregunta){
		Pregunta preguntaDb = service.save(pregunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(preguntaDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Pregunta pregunta, @PathVariable Long id){
		Optional<Pregunta> o = service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Pregunta preguntaDb = o.get();
		preguntaDb.setDetalle(pregunta.getDetalle());
		preguntaDb.setActivo(pregunta.isActivo());
		//moddify foreing keys preguntaDb.getRol()?
		//no deberia ser posible modificar las respuestas preguntaDb.getRespuestas()
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(preguntaDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
