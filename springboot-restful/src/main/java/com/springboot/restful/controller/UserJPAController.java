package com.springboot.restful.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.restful.dao.UserRepository;
import com.springboot.restful.model.User;

@RestController
public class UserJPAController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/user/{id}")
	public User retrieveUser(@PathVariable int id) 
	{
		Optional<User> user = userRepository.findById(id);
		// if (user.isPresent())
		return user.get();
	}

	@DeleteMapping("/jpa/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		// return user;
	}

	@PostMapping("/jpa/user")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}