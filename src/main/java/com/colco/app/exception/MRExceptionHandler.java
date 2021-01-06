package com.colco.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;



@RestController
@ControllerAdvice
public class MRExceptionHandler {
	
	@ExceptionHandler(value = NoMRFoundException.class)
	public ResponseEntity<ApiError> HandleMRFoundException() {
		
		ApiError error= new ApiError(400, "No MR Found", new Date());
		
		return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = MRException.class)
	public ResponseEntity<ApiError> HandleMRException() {
		
		ApiError error= new ApiError(400, "Failed to Register MR ", new Date());
		
		return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
	}

}
