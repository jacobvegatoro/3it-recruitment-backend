package com.tresit.msrecruitment.app.pdf.service;

import java.util.List;

import com.tresit.msrecruitment.app.pdf.model.Comment;

public interface CommentService {

	public List<Comment> getAll();
	
	public Comment getById(Long commentId);
	
	public Comment create(Comment comment);

	public Comment update(Comment comment);

	public void deleteById(Long commentId);

	public void deleteAll();

	public void deleteByTutorialId(Long tutorialId);
	
	public List<Comment> getByTutorialId(Long tutorialId);

}
