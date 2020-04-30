package com.example.jpacustomqueries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpacustomqueries.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	/*
	@Query("FROM User WHERE username = ?1")
	public User findByUsername(String username);
	
	@Query("SELECT o FROM User o WHERE o.username = ?1")
	public User findByUsername(String username);
	*/
	@Query("SELECT o FROM User o WHERE o.username = :username")
	public User findByUsername(@Param("username") String username);
	
	@Query("FROM User ORDER BY username ASC")
	public List<User> sortUsers();
	
	@Query("FROM User WHERE email LIKE %?#{[0]}%")
	public List<User> getAllWithEmail(String email);
	
	@Query("DELETE User WHERE username = :username")
	@Modifying
	@Transactional
	public void deleteWithUsername(@Param("username") String username);
	/*
	@Query(value = "DELETE FROM user WHERE username = :username", nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteWithUsername(@Param("username") String username);
	*/
}
