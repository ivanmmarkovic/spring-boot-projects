package com.example.project04restjpa.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project04restjpa.repository.SubjectRepository;

@RestController
public class SubjectController {
	
	private SubjectRepository subjectRepository;
	
	public SubjectController(SubjectRepository subjectRepository) {
		// TODO Auto-generated constructor stub
		this.subjectRepository = subjectRepository;
	}
	
	//@PostMapping("/subjects/{id}")
	

}
