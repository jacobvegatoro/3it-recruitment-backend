package com.formacionbdi.microservicios.app.entrevista.controllers;

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

import com.formacionbdi.microservicios.app.entrevista.services.EntrevistaService;
import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.msrecruitment.commons.clientes.models.entity.Celula;
import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;
import com.tresit.msrecruitment.commons.clientes.models.entity.Postulante;
import com.tresit.msrecruitment.commons.clientes.models.entity.Rol;
import com.tresit.msrecruitment.commons.clientes.models.entity.Usuario;

@RestController
@RequestMapping("/entrevistas")
public class EntrevistaController extends CommonController<Entrevista, EntrevistaService> {

	@Autowired
	private EntrevistaService entrevistaService;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Entrevista entrevista, @PathVariable Long id) {
		Optional<Entrevista> o = this.service.findById(id);
		
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Entrevista dbEntrevista = o.get();
		
		dbEntrevista.setCreateAt(entrevista.getCreateAt());
		dbEntrevista.setPerfilBuscado(entrevista.getPerfilBuscado());
		dbEntrevista.setComentariosPrueba(entrevista.getComentariosPrueba());
		dbEntrevista.setComentariosGenerales(entrevista.getComentariosGenerales());
		dbEntrevista.setRecomendaciones(entrevista.getRecomendaciones());
		dbEntrevista.setDescripcionPersonal(entrevista.getDescripcionPersonal());
		dbEntrevista.setPreguntasCandidato(entrevista.getPreguntasCandidato());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entrevistaService.save(dbEntrevista));
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Entrevista entrevista){
		return ResponseEntity.status(HttpStatus.CREATED).body(entrevistaService.save(entrevista));
	}
		
	@PostMapping("/celula/{idcelula}/postulante/{idpostulante}/rol/{idrol}/usuario/{idusuario}")
	public ResponseEntity<?> crearEntrevistaCompleta(
			@RequestBody Entrevista entrevista, 
			@PathVariable Long idcelula,
			@PathVariable Long idpostulante,
			@PathVariable Long idrol,
			@PathVariable Long idusuario){
		
		Celula celulaDb = entrevistaService.ver(idcelula);

		if (celulaDb == null) {
			return ResponseEntity.notFound().build();
		}

		System.out.println(celulaDb);
		entrevista.setCelula(celulaDb);
		Postulante postulanteDb = entrevistaService.obtener(idpostulante);

		if (postulanteDb == null) {
			return ResponseEntity.notFound().build();
		}

		System.out.println(postulanteDb);
		entrevista.setPostulante(postulanteDb);

		Rol rolDb = entrevistaService.obtenerRol(idrol);

		if (rolDb == null) {
			return ResponseEntity.notFound().build();
		}

		System.out.println(rolDb);
		entrevista.setRol(rolDb);
		Usuario usuarioDb = entrevistaService.obtenerUsuario(idusuario);

		if (usuarioDb == null) {
			return ResponseEntity.notFound().build();
		}

		System.out.println(usuarioDb);
		entrevista.setUsuario(usuarioDb);

		return ResponseEntity.status(HttpStatus.CREATED).body(entrevistaService.save(entrevista));
	}

	@GetMapping("/obtener/{id}")
	public ResponseEntity<?> obtenerEntrevista(@PathVariable Long id){
		Optional<Entrevista> o = entrevistaService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
}
