package com.rcx.advice;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rcx.exceptions.EmployeeNotFoundException;
import com.rcx.model.ErrorDetails;

@RestControllerAdvice
public class CrudControllerAdvice {


	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(Exception e) {
		logger.debug("CrudControllerAdvice.handleEmployeeNotFoundException()");
		logger.error("new ErrorDetail object created");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), "500", e.getMessage());
		logger.info("Error Response sent::Internal_Server_Error");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}// end of handler method

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGenericExceptions(Exception e) {
		logger.info("CrudControllerAdvice.handleGenericExceptions()");
		logger.error("new ErrorDetail object created");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), "500", e.getMessage());
		logger.info("Error Response sent::Internal_Server_Error");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}// end of handler method

}// end of class
