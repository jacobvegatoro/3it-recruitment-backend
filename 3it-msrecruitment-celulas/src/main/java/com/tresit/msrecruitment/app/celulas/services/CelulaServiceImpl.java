package com.tresit.msrecruitment.app.celulas.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tresit.microservicios.commons.services.CommonServiceImpl;
import com.tresit.msrecruitment.app.celulas.models.entity.Celula;
import com.tresit.msrecruitment.app.celulas.models.repository.CelulaRepository;

@Service
public class CelulaServiceImpl extends CommonServiceImpl<Celula, CelulaRepository> implements CelulaService {

	@Override
	@Transactional( readOnly = true)
	public Celula findCelulaByClienteId(Long id) {
		
		return repository.findCelulaByClienteId(id);
	}
	
	


	

}
