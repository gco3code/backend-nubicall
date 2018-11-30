package com.test.nubicall.backendnubi.service;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.nubicall.backendnubi.entity.User;

public interface IUserService {
	
	public User saveUser(User user);	
	public User getUser(String username);
	public User updateUser(User user);
	public boolean deleteUser(String username);
	
}
