package com.example.jpah2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpah2.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("DELETE FROM User u WHERE u.email LIKE '%gmail.com'")
	public void deleteAllGmailUsers();
	
	@Query("SELECT FROM User u WHERE u.email LIKE '%gmail.com'")
	public List<User> getAllGmailUsers();
	
}
