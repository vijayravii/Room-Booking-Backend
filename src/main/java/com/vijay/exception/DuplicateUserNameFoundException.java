package com.vijay.exception;

public class DuplicateUserNameFoundException extends RuntimeException {
	
	public DuplicateUserNameFoundException(String message) {
		super(message);
	}
	
}
