package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String>{
	
	
}
