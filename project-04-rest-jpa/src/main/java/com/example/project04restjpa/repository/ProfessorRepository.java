package com.example.project04restjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project04restjpa.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
