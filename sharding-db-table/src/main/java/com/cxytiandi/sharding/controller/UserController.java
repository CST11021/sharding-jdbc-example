package com.cxytiandi.sharding.controller;

import com.cxytiandi.sharding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cxytiandi.sharding.po.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public Object list() {
		return userRepository.list();
	}
	
	@GetMapping("/add-{value}")
	public Object add(@PathVariable("value") String value) {
		User user = new User();
		user.setCity(value);
		user.setName(value);
		userRepository.addUser(user);
		return "success";
	}
	
	@GetMapping("/users/{id}")
	public Object get(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@GetMapping("/users/query-{name}")
	public Object get(@PathVariable String name) {
		return userRepository.findByName(name);
	}

}
