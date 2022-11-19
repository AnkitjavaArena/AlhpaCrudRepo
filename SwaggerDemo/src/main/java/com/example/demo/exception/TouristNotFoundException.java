package com.example.demo.exception;

public class TouristNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TouristNotFoundException(String msg) {
		super(msg);
	}

}