package com.bclass.arts_center.handler.exception;

import org.springframework.http.HttpStatus; 

import lombok.Getter;

@Getter
public class AdminLoginException extends RuntimeException{
	
	private HttpStatus status;
	public AdminLoginException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

}
