package com.test.nubicall.backendnubi.util;

import com.test.nubicall.exception.UserNotFoundException;

public class ErrorCode {

	public static int ERROR_USER_NOT_FOUND=100;
	public static int ERROR_UUID_NOT_PRESENT=101;
	
	public static String build(int code,String message) {
		return "ERROR IN BACKEND NUBI --- CODE:"+code+" --- DETAIL:"+message;
	}
	
}
