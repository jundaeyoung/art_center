package com.bclass.arts_center.dto;

import lombok.Data;

@Data
public class NaverDto {
	private Integer resultcode;
	private String message;
	private Response response;
	
	
	@Data
	public class Response{
		private String id;
		private String nickname;
		private String gender;
		private String email;
	}
}

