package com.bclass.arts_center.handler.exception;

import org.springframework.http.HttpStatus;

public class CustomPageExceoption extends RuntimeException{

	private HttpStatus status;
	
	public CustomPageExceoption(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
}
