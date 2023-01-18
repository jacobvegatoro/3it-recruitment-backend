package com.tresit.msrecruitment.app.celulas.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tresit.microservicios.commons.services.CommonServiceImpl;
import com.tresit.msrecruitment.app.celulas.models.repository.ClienteRepository;
import com.tresit.msrecruitment.commons.clientes.models.entity.Cliente;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, ClienteRepository> implements ClienteService {

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByNombreOrCasaMatriz(String term) {
		return repository.findByNombreOrCasaMatriz(term);
	}

}
