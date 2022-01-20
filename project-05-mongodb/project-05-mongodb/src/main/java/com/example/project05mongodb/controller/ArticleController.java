package com.example.project05mongodb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project05mongodb.model.Article;
import com.example.project05mongodb.repository.ArticleRepository;

@RestController
public class ArticleController {
	
	private ArticleRepository articleRepository;
	public ArticleController(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	@PostMapping("/articles")
	public ResponseEntity<Article> create(@RequestBody Article article) {
		return new ResponseEntity<Article>(
			this.articleRepository.save(article),
			HttpStatus.CREATED
		);
	}
	
	@GetMapping("/articles")
	public ResponseEntity<List<Article>> findAll() {
		return new ResponseEntity<List<Article>>(
			this.articleRepository.findAll(),
			HttpStatus.OK
		);
	}
	
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> findbyId(@PathVariable String id){
		return new ResponseEntity<Article>(
			this.articleRepository.findById(id).orElse(null),
			HttpStatus.OK
		);
	}
	
	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> update(@PathVariable String id, @RequestBody Article article){
		article.setId(id);
		Article articleUpdated = this.articleRepository.save(article);
		return new ResponseEntity<Article>(
			articleUpdated,
			HttpStatus.OK
		);
	}
	
	@DeleteMapping()
	ResponseEntity<Article> deleteById(@PathVariable String id){
		this.articleRepository.deleteById(id);
		return new ResponseEntity<>(
			null,
			HttpStatus.NO_CONTENT
		);
	}
}
