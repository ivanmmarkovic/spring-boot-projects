package com.example.project01restjdbctemplate.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project01restjdbctemplate.model.Article;
import com.example.project01restjdbctemplate.repository.ArticleRepository;

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
	
	@PatchMapping("/articles/{id}")
	public Article update(@PathVariable int id, @RequestBody Article article) {
		return this.articleRepository.update(id, article);
	}
	
}
