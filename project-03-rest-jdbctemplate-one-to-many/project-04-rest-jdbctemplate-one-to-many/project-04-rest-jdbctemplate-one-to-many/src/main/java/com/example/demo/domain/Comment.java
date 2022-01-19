package com.example.demo.domain;

import java.time.LocalDateTime;

public class Comment {
	
	private int id;
	private String body;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private int articleId;
	
	public Comment() {
		this.createdAt = LocalDateTime.now();
		this.modifiedAt = this.createdAt;
	}
	public Comment(String body) {
		this();
		this.body = body;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	
}
