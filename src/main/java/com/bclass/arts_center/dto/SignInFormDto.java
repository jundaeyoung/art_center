package com.bclass.arts_center.dto;

import lombok.Data;

@Data
public class SignInFormDto {
	private String userName;
	private String password;
	private Integer id;
	private String apiId;
}
