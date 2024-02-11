package exercises.springmongo.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import exercises.springmongo.entity.Article;
import exercises.springmongo.repository.ArticleRepository;

@RestController
public class ArticleController {
	
	ArticleRepository articleRepository;
	
	public ArticleController(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@PostMapping("/articles")
	public ResponseEntity<Article> createArticle(@RequestBody Article article) {
		Article createdArticle = this.articleRepository.save(article);
		return new ResponseEntity<Article>(createdArticle, HttpStatus.CREATED);
	}
	
	@GetMapping("/articles")
	public ResponseEntity<Iterable<Article>> getArticles(){
		Iterable<Article> articles = this.articleRepository.findAll();
		return new ResponseEntity<Iterable<Article>>(articles, HttpStatus.OK);
	}
	
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable String id) {
		Optional<Article> optionalArticle =  this.articleRepository.findById(id);
		if(optionalArticle.isPresent())
			return new ResponseEntity<>(optionalArticle.get(), HttpStatus.OK);
		return null;
	}
	
	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> updateArticlebyId(@PathVariable String id, @RequestBody Article article) {
		Optional<Article> optionalArticle = this.articleRepository.findById(id);
		if(optionalArticle.isPresent()) {
			article.setId(optionalArticle.get().getId());
			return new ResponseEntity<>(this.articleRepository.save(article), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Article> deleteArticleById(@PathVariable String id) {
		this.articleRepository.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
