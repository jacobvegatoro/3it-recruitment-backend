package com.tresit.msrecruitment.app.pdf.service;

import java.util.List;

import com.tresit.msrecruitment.app.pdf.model.Template;

public interface TemplateService {

	public List<Template> getAll();

	public Template getById(Long templateId);
	
	public Template create(Template template);
	
	public Template update(Template template);
	
	public void deleteById(Long templateId);
	
	public boolean existsById(Long templateId);
	
}
