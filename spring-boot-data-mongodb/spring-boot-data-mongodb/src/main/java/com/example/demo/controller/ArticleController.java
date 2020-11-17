package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Article;
import com.example.demo.repository.ArticleRepository;



@RestController
@RequestMapping("/api/articles")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	
	@PostMapping("")
	public ResponseEntity<Article> create(@RequestBody Article article) {
		return new ResponseEntity<Article>(
			this.articleRepository.save(article),
			HttpStatus.CREATED
		);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Article>> findAll() {
		return new ResponseEntity<List<Article>>(
			this.articleRepository.findAll(),
			HttpStatus.OK
		);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Article> findbyId(@PathVariable String id){
		return new ResponseEntity<Article>(
			this.articleRepository.findById(id).orElse(null),
			HttpStatus.OK
		);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Article> update(@RequestBody Article article, @PathVariable String id) {
		Optional<Article> dbArticleOptional = this.articleRepository.findById(id);
		Article dbArticle = dbArticleOptional.get();
		if(article.getTitle() != null)
			dbArticle.setTitle(article.getTitle());
		if(article.getBody() != null)
			dbArticle.setBody(article.getBody());
		dbArticle.setModifiedAt(LocalDateTime.now());
		return new ResponseEntity<Article>(
			this.articleRepository.save(dbArticle),
			HttpStatus.OK
		);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Article> delete(@PathVariable String id) {
		this.articleRepository.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
