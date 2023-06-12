package com.bclass.arts_center.handler.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class CustomPageExceoption extends RuntimeException{

	@Autowired
	private HttpStatus status;
	
	public CustomPageExceoption(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
}
