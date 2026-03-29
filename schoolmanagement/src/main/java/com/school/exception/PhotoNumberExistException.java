package com.school.exception;

public class PhotoNumberExistException extends Exception {

	
	private String message="";
	private static final long serialVersionUID = 1L;
	
	public PhotoNumberExistException() {
		
	}
	
	public PhotoNumberExistException(String message) {
		
		super(message);
		this.message=message;
		
		
		
	}

}
