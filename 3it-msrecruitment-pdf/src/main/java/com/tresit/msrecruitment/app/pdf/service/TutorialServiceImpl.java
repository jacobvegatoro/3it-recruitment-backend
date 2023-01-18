package com.tresit.msrecruitment.app.pdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresit.msrecruitment.app.pdf.model.Tutorial;
import com.tresit.msrecruitment.app.pdf.repository.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired 
	TutorialRepository tutorialRepository;
	
	@Override
	public List<Tutorial> getAll() {
		return tutorialRepository.findAll();
	}

	@Override
	public Tutorial getById(Long tutorialId) {
		return tutorialRepository.findById(tutorialId).get();
	}

	@Override
	public Tutorial create(Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}

	@Override
	public Tutorial update(Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}

	@Override
	public void deleteById(Long tutorialId) {
		tutorialRepository.deleteById(tutorialId);
	}

	@Override
	public void deleteAll() {
		tutorialRepository.deleteAll();
	}

	@Override
	public List<Tutorial> getByTitle(String title) {
		return tutorialRepository.findByTitleContaining(title);
	}

	@Override
	public List<Tutorial> getByPublished(Boolean published) {
		return tutorialRepository.findByPublished(published);
	}

	@Override
	public boolean existsById(Long tutorialId) {
		return tutorialRepository.existsById(tutorialId);
	}

}
