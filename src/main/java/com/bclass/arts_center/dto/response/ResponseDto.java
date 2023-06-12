package com.bclass.arts_center.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
	private Integer statusCode;
	private String message;
	private T data;
	
	
}
