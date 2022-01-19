package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Article;
import com.example.demo.repository.ArticleRepository;

@RestController
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@PostMapping("/articles")
	public ResponseEntity<Article> save(@RequestBody Article article) {
		return new ResponseEntity<Article>(
				this.articleRepository.save(article), HttpStatus.CREATED);
	}
	
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> findById(@PathVariable int id) {
		return new ResponseEntity<Article>(this.articleRepository.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/articles")
	public ResponseEntity<List<Article>> findAll() {
		return new ResponseEntity<List<Article>>(this.articleRepository.findAll(), HttpStatus.OK);
	}
	
	@PatchMapping("/articles/{id}")
	public ResponseEntity<Article> findById(@PathVariable int id, @RequestBody Article article) {
		return new ResponseEntity<Article>(this.articleRepository.update(id, article), HttpStatus.OK);
	}
	
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Article> delete(@PathVariable int id) {
		this.articleRepository.delete(id);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
}
