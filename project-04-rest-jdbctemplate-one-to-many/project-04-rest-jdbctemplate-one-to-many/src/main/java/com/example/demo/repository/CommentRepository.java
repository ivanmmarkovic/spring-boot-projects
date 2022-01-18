package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Comment;

@Repository
public class CommentRepository implements CommonRepository<Comment> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Comment> rowMapper = (ResultSet rs, int rowNumber) -> {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setBody(rs.getString("body"));
		comment.setModifiedAt(rs.getTimestamp("modified_at").toLocalDateTime());
		comment.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
		comment.setArticleId(rs.getInt("article_id"));
		return comment;
	};
	
	@Override
	public Comment save(Comment comment) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(con -> {
			PreparedStatement ps = con.prepareStatement(
			    "INSERT INTO `comment`(`body`, `created_at`, `modified_at`, `article_id`) VALUES(?, ?, ?, ?)",
			    Statement.RETURN_GENERATED_KEYS
			);
			ps.setString(1, comment.getBody());
			ps.setTimestamp(2, Timestamp.valueOf(comment.getCreatedAt()));
			ps.setTimestamp(3, Timestamp.valueOf(comment.getModifiedAt()));
			ps.setInt(4, comment.getArticleId());
			return ps;
		}, keyHolder);
		comment.setId((int)keyHolder.getKey());
		return comment;
	}

	@Override
	public Comment findById(int id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM `comment` WHERE `id` = ?", this.rowMapper, id);
	}

	public List<Comment> findByArticleId(int id) {
		return this.jdbcTemplate.query("SELECT * FROM `comment` WHERE `article_id` = ?", this.rowMapper, id);
	}
	
	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment update(int id, Comment t) {
		return null;
	}

	@Override
	public void delete(int id) {
		this.jdbcTemplate.update("DELETE FROM `comment` WHERE `id` = ?", id);
	}

}
