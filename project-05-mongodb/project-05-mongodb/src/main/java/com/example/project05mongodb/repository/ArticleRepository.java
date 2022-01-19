package com.example.project05mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.project05mongodb.model.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {

}
