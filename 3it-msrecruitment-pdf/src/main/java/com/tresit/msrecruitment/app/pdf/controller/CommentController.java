package com.tresit.msrecruitment.app.pdf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tresit.msrecruitment.app.pdf.exception.ResourceNotFoundException;
import com.tresit.msrecruitment.app.pdf.model.Comment;
import com.tresit.msrecruitment.app.pdf.model.Tutorial;
import com.tresit.msrecruitment.app.pdf.service.CommentService;
import com.tresit.msrecruitment.app.pdf.service.TutorialService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CommentController {

	  //@Autowired
	  //private TutorialRepository tutorialRepository;

	  //@Autowired
	  //private CommentRepository commentRepository;
	  
	  @Autowired 
	  private TutorialService tutorialService;

	  @Autowired
	  private CommentService commentService;

	  @GetMapping("/tutorials/{tutorialId}/comments")
	  public ResponseEntity<List<Comment>> getAllCommentsByTutorialId(@PathVariable(value = "tutorialId") Long tutorialId) {
	    /*if (!tutorialRepository.existsById(tutorialId)) {
	      throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
	    }*/

	    if (!tutorialService.existsById(tutorialId)) {
		      throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
		    }

	    //List<Comment> comments = commentRepository.findByTutorialId(tutorialId);
	    List<Comment> comments = commentService.getByTutorialId(tutorialId);
	    
	    return new ResponseEntity<>(comments, HttpStatus.OK);
	  }

	  @GetMapping("/comments/{id}")
	  public ResponseEntity<Comment> getCommentsByTutorialId(@PathVariable(value = "id") Long id) {
	    /*Comment comment = commentRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + id));*/

	    Comment comment = commentService.getById(id);
	    
	    if (comment == null) {
	    	throw new ResourceNotFoundException("Not found Comment with id = " + id);
	    }
	    		
	    return new ResponseEntity<>(comment, HttpStatus.OK);
	  }

	  @PostMapping("/tutorials/{tutorialId}/comments")
	  public ResponseEntity<Comment> createComment(@PathVariable(value = "tutorialId") Long tutorialId,
	      @RequestBody Comment commentRequest) {
	    /*
		Comment comment = tutorialRepository.findById(tutorialId).map(tutorial -> {
	      commentRequest.setTutorial(tutorial);
	      return commentRepository.save(commentRequest);
	    }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));*/

	    
	    Tutorial tutorial = tutorialService.getById(tutorialId);
	    
	    if (tutorial == null) {
	    	throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
	    }
	    
	    commentRequest.setTutorial(tutorial);

	    Comment comment = commentService.create(commentRequest);

	    return new ResponseEntity<>(comment, HttpStatus.CREATED);
	  }

	  @PutMapping("/comments/{id}")
	  public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment commentRequest) {
	    /*Comment comment = commentRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));*/
	    
		Comment comment = commentService.getById(id);
		
		if (comment == null) {
			throw new ResourceNotFoundException("CommentId " + id + "not found");
		}
		
	    comment.setContent(commentRequest.getContent());

	    return new ResponseEntity<>(commentService.update(comment), HttpStatus.OK);
	  }

	  @DeleteMapping("/comments/{id}")
	  public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id) {
	    //commentRepository.deleteById(id);
	    commentService.deleteById(id);

	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  
	  @DeleteMapping("/tutorials/{tutorialId}/comments")
	  public ResponseEntity<List<Comment>> deleteAllCommentsOfTutorial(@PathVariable(value = "tutorialId") Long tutorialId) {
	    if (!tutorialService.existsById(tutorialId)) {
	      throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
	    }

	    //commentRepository.deleteByTutorialId(tutorialId);
	    commentService.deleteByTutorialId(tutorialId);
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  
}
