package com.rcx.exceptions;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
		super();
	}// end of constructor

	public EmployeeNotFoundException(String message) {
		super(message);
	}// end of constructor
}// end of class
