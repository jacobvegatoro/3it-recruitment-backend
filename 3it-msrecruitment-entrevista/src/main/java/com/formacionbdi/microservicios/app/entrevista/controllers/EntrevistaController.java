package com.formacionbdi.microservicios.app.entrevista.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.entrevista.services.EntrevistaService;
import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.msrecruitment.commons.clientes.models.entity.Entrevista;

@RestController
public class EntrevistaController extends CommonController<Entrevista, EntrevistaService> {

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
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbEntrevista));
	}
}
