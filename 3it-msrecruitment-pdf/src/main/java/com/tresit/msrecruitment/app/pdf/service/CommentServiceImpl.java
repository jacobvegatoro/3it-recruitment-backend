package com.tresit.msrecruitment.app.pdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresit.msrecruitment.app.pdf.model.Comment;
import com.tresit.msrecruitment.app.pdf.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public List<Comment> getAll() {
		return commentRepository.findAll();
	}

	@Override
	public Comment getById(Long commentId) {
		return commentRepository.findById(commentId).get();
	}

	@Override
	public Comment create(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public Comment update(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void deleteById(Long commentId) {
		commentRepository.deleteById(commentId);
	}

	@Override
	public void deleteAll() {
		commentRepository.deleteAll();
	}

	@Override
	public void deleteByTutorialId(Long tutorialId) {
		commentRepository.deleteByTutorialId(tutorialId);
	}

	@Override
	public List<Comment> getByTutorialId(Long tutorialId) {
		return commentRepository.findByTutorialId(tutorialId);
	}

}
