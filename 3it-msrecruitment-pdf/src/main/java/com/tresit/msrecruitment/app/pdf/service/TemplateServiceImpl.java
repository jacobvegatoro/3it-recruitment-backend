package com.tresit.msrecruitment.app.pdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresit.msrecruitment.app.pdf.model.Template;
import com.tresit.msrecruitment.app.pdf.repository.TemplateRepository;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Autowired 
	TemplateRepository templateRepository;
	
	@Override
	public List<Template> getAll() {
		return templateRepository.findAll();
	}

	@Override
	public Template getById(Long templateId) {
		return templateRepository.findById(templateId).get();
	}

	@Override
	public Template create(Template template) {
		return templateRepository.save(template);
	}

	@Override
	public Template update(Template template) {
		return templateRepository.save(template);
	}

	@Override
	public void deleteById(Long templateId) {
		templateRepository.deleteById(templateId);
	}

	@Override
	public boolean existsById(Long templateId) {
		return templateRepository.existsById(templateId);
	}
	
}
