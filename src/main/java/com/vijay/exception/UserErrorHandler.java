package com.vijay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vijay.model.ErrorResponse;

@ControllerAdvice
public class UserErrorHandler {

	@ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().errorCode(ErrorCode.INVALID_TYPE.name()).errorMessage(exception.getMessage()).build());
	}
	
	@ExceptionHandler({DuplicateUserNameFoundException.class})
	public ResponseEntity<ErrorResponse> handleDuplicateUserNameFoundException(DuplicateUserNameFoundException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponse.builder().errorCode(ErrorCode.INVALID_TYPE.name()).errorMessage(exception.getMessage()).build());
	}
	
}
