package com.rcx.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code= HttpStatus.UNPROCESSABLE_ENTITY)
// code for this is 422
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
		super();
	}// end of constructor

	public EmployeeNotFoundException(String message) {
		super(message);
	}// end of constructor
}// end of class
