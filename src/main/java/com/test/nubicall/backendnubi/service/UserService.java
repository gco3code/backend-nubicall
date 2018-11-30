package com.test.nubicall.backendnubi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nubicall.backendnubi.entity.User;
import com.test.nubicall.backendnubi.repository.UserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository repository;
	
	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public User getUser(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public User updateUser(User user) {
		return repository.save(user);
	}

	@Override
	public boolean deleteUser(String username) {
		if(username.equals(""))
			return false;
		
		User user = repository.findByUsername(username);
		if(user==null) {
			return false;	
		}			
		else {
			repository.delete(user);
		}
			
		return true;		
	}
	
}
