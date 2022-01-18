package com.example.project02restjdbctemplateresponseentity.controller;

import java.util.List;

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
	public Article create(@RequestBody Article article) {
		return this.articleRepository.create(article);
	} 
	
	@GetMapping("/articles/{id}")
	public Article findbyId(@PathVariable int id) {
		return this.articleRepository.findById(id);
	}
	
	@GetMapping("/articles")
	public List<Article> findAll(){
		return this.articleRepository.findAll();
	}
	
	@PatchMapping("/articles/{id}")
	public Article update(@PathVariable int id, @RequestBody Article article) {
		return this.articleRepository.update(id, article);
	}
	
	public Article delete(@PathVariable int id) {
		this.articleRepository.delete(id);
		return null;
	}
	
}
