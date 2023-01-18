package com.tresit.msrecruitment.app.pdf.service;

import java.util.List;

import com.tresit.msrecruitment.app.pdf.model.Tutorial;

public interface TutorialService {

	public List<Tutorial> getAll();

	public List<Tutorial> getByTitle(String title);

	public List<Tutorial> getByPublished(Boolean published);

	public Tutorial getById(Long tutorialId);
	
	public Tutorial create(Tutorial tutorial);
	
	public Tutorial update(Tutorial tutorial);
	
	public void deleteById(Long tutorialId);

	public void deleteAll();
	
	public boolean existsById(Long tutorialId);

}
