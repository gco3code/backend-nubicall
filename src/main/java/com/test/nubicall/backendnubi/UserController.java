package com.test.nubicall.backendnubi;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.test.nubicall.backendnubi.service.IUserService;
import com.test.nubicall.backendnubi.util.Constants;
import com.test.nubicall.backendnubi.util.ErrorCode;
import com.test.nubicall.exception.UserNotFoundException;
import com.test.nubicall.exception.ValidationException;

@RestController
@RequestMapping("/rest")
public class UserController {

	@Autowired
	IUserService service;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) throws ValidationException {		
		return service.saveUser(user);
	}
	
	@RequestMapping("/users/{username}")
	public User getUser(@PathVariable String username) throws ValidationException, UserNotFoundException {		
		User user =  service.getUser(username);
		if(user==null) {
			logger.error(ErrorCode.build(ErrorCode.ERROR_USER_NOT_FOUND,Constants.USER_NOT_FOUND));
			throw new  UserNotFoundException(Constants.USER_NOT_FOUND);
		}
		return user;
	}	
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) throws ValidationException
	{
		if(user.getUuid()==null) {
			logger.error(ErrorCode.build(ErrorCode.ERROR_UUID_NOT_PRESENT, Constants.MENSAJE_UUID_NOT_PRESENT));
			throw new  ValidationException(Constants.MENSAJE_UUID_NOT_PRESENT);
		}
		return service.updateUser(user);
	}	
	
	@DeleteMapping("/users/{username}")
	public boolean deleteUser(@PathVariable String username) throws ValidationException
	{
		if(!service.deleteUser(username))
			throw new  ValidationException(Constants.USER_NOT_FOUND);		
		else {
			return true; 
		}
	}
	
	
	
	
	
}
