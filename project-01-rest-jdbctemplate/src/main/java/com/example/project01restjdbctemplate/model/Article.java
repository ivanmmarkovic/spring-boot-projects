package com.example.project01restjdbctemplate.model;

import java.util.Date;

public class Article {
	
	
	private long id;
	private String title;
	private String body;
	private Date createdAt;
	private Date updatedAt;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(String title, String body, Date createdAt, Date updatedAt) {
		super();
		this.title = title;
		this.body = body;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
