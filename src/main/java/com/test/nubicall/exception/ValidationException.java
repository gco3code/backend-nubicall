package com.test.nubicall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ValidationException extends Exception{
	
	private static final long serialVersionUID = 6923317765922553343L;	
	
	public ValidationException(String message) {
		super(message);
	}
	
}
