package com.test.nubicall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{
	
	private static final long serialVersionUID = 6923317765922553343L;	
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
