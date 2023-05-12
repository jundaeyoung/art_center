package com.bclass.arts_center.handler.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;


/**
 * 
 * @author 편용림
 *
 */
@Getter
public class CustomRestfullException extends RuntimeException {
	
	private HttpStatus status;
	public CustomRestfullException(String message,HttpStatus status) {
		super(message);
		this.status = status;
	}
	
}
