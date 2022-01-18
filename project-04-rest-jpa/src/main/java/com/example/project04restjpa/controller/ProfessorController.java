package com.example.project04restjpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project04restjpa.model.Professor;
import com.example.project04restjpa.repository.ProfessorRepository;

@RestController
public class ProfessorController {

	private final ProfessorRepository professorRepository;
	
	public ProfessorController(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}
	
	@PostMapping("/professors")
	public ResponseEntity<Professor> create(@RequestBody Professor professor){
		Professor professorCreated = this.professorRepository.save(professor);
		return new ResponseEntity<Professor>(professorCreated, HttpStatus.CREATED);
	}
	
	@GetMapping("/professors")
	public ResponseEntity<List<Professor>> findAll() {
		List<Professor> professors = this.professorRepository.findAll();
		return new ResponseEntity<>(professors, HttpStatus.OK);
	}
	
}
