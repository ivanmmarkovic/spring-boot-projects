package com.example.project02restjdbctemplateresponseentity.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project02restjdbctemplateresponseentity.model.Article;
import com.example.project02restjdbctemplateresponseentity.repository.ArticleRepository;


@RestController
public class ArticleController {
	
	ArticleRepository articleRepository;
	
	public ArticleController(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@PostMapping("/articles")
	public ResponseEntity<Article> create(@RequestBody Article article) {
		Article createdArticle = this.articleRepository.create(article);
		return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
	} 
	
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> findbyId(@PathVariable int id) {
		Article article = this.articleRepository.findById(id);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}
	
	@GetMapping("/articles")
	public ResponseEntity<List<Article>> findAll(){
		List<Article> articles = this.articleRepository.findAll();
		return new ResponseEntity<>(articles, HttpStatus.OK);
	}
	
	@PatchMapping("/articles/{id}")
	public ResponseEntity<Article> update(@PathVariable int id, @RequestBody Article article) {
		Article updatedArticle = this.articleRepository.update(id, article);
		return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
	}
	
	public ResponseEntity<Article> delete(@PathVariable int id) {
		this.articleRepository.delete(id);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
}
