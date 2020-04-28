package com.example.jpah2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpah2.domain.User;
import com.example.jpah2.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	public ResponseEntity<User> create(@RequestBody User user){
		this.userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable int id){
		Optional<User> optional = this.userRepository.findById(id);
		if(optional.isPresent())
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAll(){
		List<User> users = this.userRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PatchMapping("/users/{id}")
	public ResponseEntity<User> patchUser(@RequestBody User user, @PathVariable int id){
		Optional<User> optional = this.userRepository.findById(id);
		if(optional.isPresent()) {
			User optionalUser = optional.get();
			if(user.getUsername() != null)
				optionalUser.setUsername(user.getUsername());
			if(user.getEmail() != null)
				optionalUser.setUsername(user.getEmail());
			this.userRepository.save(optionalUser);
			return new ResponseEntity<>(optionalUser, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/users")
	public ResponseEntity<?> delete(@PathVariable int id){
		this.userRepository.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
