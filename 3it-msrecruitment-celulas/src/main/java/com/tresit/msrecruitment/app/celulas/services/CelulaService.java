package com.tresit.msrecruitment.app.celulas.services;



import com.tresit.microservicios.commons.services.CommonService;
import com.tresit.msrecruitment.app.celulas.models.entity.Celula;


public interface CelulaService extends CommonService<Celula> {
	
	public Celula findCelulaByClienteId(Long id);


}
