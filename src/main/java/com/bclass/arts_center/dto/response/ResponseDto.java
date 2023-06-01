package com.bclass.arts_center.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

	private Integer statusCode;
	private String code;
	private String message;
	private String resultCode;
	private T data;
	
	
}
