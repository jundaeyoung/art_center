package com.bclass.arts_center.handler.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 

import lombok.Getter;

@Getter
public class UnAuthorizedException extends RuntimeException {

	@Autowired
	private HttpStatus status;
	
	public UnAuthorizedException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
}
