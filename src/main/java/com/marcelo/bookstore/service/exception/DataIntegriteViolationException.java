package com.marcelo.bookstore.service.exception;

public class DataIntegriteViolationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DataIntegriteViolationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataIntegriteViolationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
