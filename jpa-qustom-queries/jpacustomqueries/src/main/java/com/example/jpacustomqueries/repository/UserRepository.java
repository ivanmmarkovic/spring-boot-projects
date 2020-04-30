package com.example.jpacustomqueries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpacustomqueries.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	/*
	@Query("FROM User WHERE username = ?1")
	public User findByUsername(String username);
	*/
	@Query("SELECT o FROM User o WHERE o.username = ?1")
	public User findByUsername(String username);
	
	
	
	@Query("FROM User WHERE email LIKE %?#{[0]}%")
	public List<User> getAllWithEmail(String email);
	
}
