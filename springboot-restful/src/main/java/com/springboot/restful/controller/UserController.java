package com.springboot.restful.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.restful.dao.UserDAO;
import com.springboot.restful.model.User;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDAO.findAll();
	}

	@GetMapping("/user/{id}")
	public User retrieveUser(@PathVariable int id) {
		return userDAO.findOne(id);
	}

	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = userDAO.findOne(id);
		// if (user == null)
		// throw new UserNotFoundException("id=-" + id);
		if (user != null)
			userDAO.deleteUserById(id);

		return user;
	}

	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userDAO.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
