package com.tresit.msrecruitment.app.usuarios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tresit.msrecruitment.commons.clientes.models.entity.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	@Query("select a from Usuario a where a.nombre like %?1% or a.apellido like %?1%")
	public List<Usuario> findByNombreOrApellido(String term);
}
