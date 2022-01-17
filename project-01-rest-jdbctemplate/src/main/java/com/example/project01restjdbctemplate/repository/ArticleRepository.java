package com.example.project01restjdbctemplate.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.project01restjdbctemplate.model.Article;

@Repository
public class ArticleRepository {

	public JdbcTemplate jdbcTemplate;
	
	public ArticleRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Article create(Article article) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(con -> {
			PreparedStatement ps = con.prepareStatement(
			    "INSERT INTO `articles`(`title`, `body`, `created_at`, `updated_at`) VALUES(?, ?, ?, ?)",
			    Statement.RETURN_GENERATED_KEYS
			);
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getBody());
			ps.setTimestamp(3, Timestamp.valueOf(article.getCreatedAt()));
			ps.setTimestamp(4, Timestamp.valueOf(article.getUpdatedAt()));
			return ps;
		}, keyHolder);
		article.setId((int)keyHolder.getKey());
		return article;
		
	}
	
//	public Article find(long id) {
//		String sql = "SELECT * FROM `articles` WHERE `id`=? LIMIT 1";
//		this.jdbcTemplate
//	}
	
	public Article update(int id, Article article) {
		String sql = "UPDATE `articles` SET `title`=?, `body`=?, `updated_at`=? WHERE `id`=?";
		this.jdbcTemplate.update(sql, 
			article.getTitle(), 
			article.getBody(),
			Timestamp.valueOf(article.getUpdatedAt()),
			id
		);
		article.setId(id);
		return article;
	}
}
