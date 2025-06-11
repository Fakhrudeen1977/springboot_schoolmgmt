package com.school.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
		
	
	 @ExceptionHandler(StudentNotFoundException.class)
	  public ResponseEntity<ErrorResponse> studentNotFoundException(StudentNotFoundException ex, WebRequest request) {
		 System.out.println("StudentNotFound Exception Occured");
		 ErrorResponse message = new ErrorResponse(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorResponse>(message, HttpStatus.NOT_FOUND);
	  }
	 
	 
	 @ExceptionHandler(BloodGroupIdNotFoundException.class)
	  public ResponseEntity<ErrorResponse> bloodGroupIdNotFoundException(BloodGroupIdNotFoundException ex, WebRequest request) {
		 System.out.println("BloodGroupIdNotFoundation Exception Occured ");
		 ErrorResponse message = new ErrorResponse(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorResponse>(message, HttpStatus.NOT_FOUND);
	  }
	 
	 
	 @ExceptionHandler(PhotoNumberExistException.class)
	  public ResponseEntity<ErrorResponse> photoNumberExistException(PhotoNumberExistException ex, WebRequest request) {
		 System.out.println("PhotoNumberExistException Exception Occured "+" "+ex.getMessage());
		 ErrorResponse message = new ErrorResponse(
	        HttpStatus.FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorResponse>(message, HttpStatus.FOUND);
	  }
	 
	 
	 
	 @ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception ex, WebRequest request) {
		 ErrorResponse message = new ErrorResponse(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorResponse>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	 @ExceptionHandler(value = TokenRefreshException.class)
	  @ResponseStatus(HttpStatus.FORBIDDEN)
	  public  ResponseEntity<ErrorResponse> handleTokenRefreshException(TokenRefreshException ex, WebRequest request) {
		 
		 ErrorResponse message = new ErrorResponse(
			        HttpStatus.FORBIDDEN.value(),
			        new Date(),
			        ex.getMessage(),
			        request.getDescription(false));
			    
			    return new ResponseEntity<ErrorResponse>(message, HttpStatus.FORBIDDEN);
		
	  }
	 
}
