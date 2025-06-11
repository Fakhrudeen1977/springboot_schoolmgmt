package com.school.exception;

public class StudentNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException() {
		super();
		
	}

	public StudentNotFoundException(String message) {
		
		super(message);
		System.out.println("StudentNotFoundException"+" "+message);
		
		
	}
}
