package com.bclass.arts_center.handler.exception;

import org.springframework.http.HttpStatus; 

import lombok.Getter;



/**
 * 
 * @author 편용림
 *
 */
@Getter
public class UnAuthorizedException extends RuntimeException {

	private HttpStatus status;
	
	public UnAuthorizedException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
}
