package com.qa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No id found")

public class GarageNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GarageNotFoundException() {
		super();
	}
	
	public GarageNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writeableStackTrace) {
		super(message, cause, enableSuppression, writeableStackTrace);
		
	}
	
	public GarageNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public GarageNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GarageNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
