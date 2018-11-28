package com.test.nubicall.backendnubi;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.nubicall.backendnubi.entity.User;
import com.test.nubicall.backendnubi.repository.UserRepository;

@RestController
@RequestMapping("/rest")
public class UserController {

	@Autowired
	UserRepository repository;
	
	@PostMapping("/users")
	public User postUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	@RequestMapping("/users/{username}")
	public User getUser(@PathVariable String username) {
		return repository.findByUsername(username);
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user)
	{
		return repository.save(user);
	}	
	
	@DeleteMapping("/users/{username}")
	public void deleteUser(@PathVariable String username)
	{
		User user = repository.findByUsername(username);
		repository.delete(user);
	}
	
	
	
	
	
}
