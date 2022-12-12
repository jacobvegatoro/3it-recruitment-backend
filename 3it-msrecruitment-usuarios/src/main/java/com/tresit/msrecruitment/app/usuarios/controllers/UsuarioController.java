package com.tresit.msrecruitment.app.usuarios.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tresit.microservicios.commons.controllers.CommonController;
import com.tresit.msrecruitment.app.usuarios.models.entity.Usuario;
import com.tresit.msrecruitment.app.usuarios.services.UsuarioService;

@RestController
public class UsuarioController extends CommonController<Usuario, UsuarioService>{
		
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Usuario> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuarioDb = o.get();
		usuarioDb.setNombre(usuario.getNombre());
		usuarioDb.setApellido(usuario.getApellido());
		usuarioDb.setCorreo(usuario.getCorreo());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombreOrApellido(term));
	}



}
