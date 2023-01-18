package com.tresit.recruitment.pregunta.service;

import java.util.Optional;

import com.tresit.msrecruitment.commons.clientes.models.entity.Rol;

public interface RolService {

    public Iterable<Rol> findAll();
	public Optional<Rol>findById(Long id);
	public Rol save(Rol rol);
	public void deleteById(Long id);

}
