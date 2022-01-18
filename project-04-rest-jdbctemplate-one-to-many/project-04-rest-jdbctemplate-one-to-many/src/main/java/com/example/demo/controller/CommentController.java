package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Comment;
import com.example.demo.repository.CommentRepository;

@RestController
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@PostMapping("/articles//{articleId}/comments")
	public ResponseEntity<Comment> save(@PathVariable int articleId, @RequestBody Comment comment) {
		comment.setArticleId(articleId);
		return new ResponseEntity<Comment>(this.commentRepository.save(comment), HttpStatus.CREATED);
	}
	
	@GetMapping("/articles//{articleId}/comments")
	public ResponseEntity<List<Comment>> findByArticleId(@PathVariable int articleId) {
		return new ResponseEntity<List<Comment>>(this.commentRepository.findByArticleId(articleId), HttpStatus.OK);
	}
	
	@DeleteMapping("/articles/{articleId}/comments/{id}")
	public ResponseEntity<Comment> delete(@PathVariable int id) {
		this.commentRepository.delete(id);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

}
