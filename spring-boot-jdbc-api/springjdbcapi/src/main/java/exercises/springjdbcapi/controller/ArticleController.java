package exercises.springjdbcapi.controller;

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

import exercises.springjdbcapi.entity.Article;
import exercises.springjdbcapi.repository.ArticleRepository;


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
	public ResponseEntity<Article> getArticleById(@PathVariable int id) {
		Article article =  this.articleRepository.findById(id);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}
	
	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> updateArticlebyId(@PathVariable int id, @RequestBody Article article) {
		Article articleUpdated = this.articleRepository.update(id, article);
		return new ResponseEntity<>(articleUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Article> deleteArticleById(@PathVariable int id) {
		this.articleRepository.delete(id);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
}
