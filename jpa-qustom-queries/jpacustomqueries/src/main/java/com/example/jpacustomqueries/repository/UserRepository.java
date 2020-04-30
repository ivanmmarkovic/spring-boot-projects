package com.example.jpacustomqueries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpacustomqueries.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
