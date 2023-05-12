package com.bclass.arts_center.dto;

import lombok.Data;
/**
 * 
 * @author 편용림
 *
 */
@Data
public class SignUpFormDto {

	private Integer id;
	private String userName;
	private String password;
	private String nickname;
	private String email;
	private String birthDate;
	private String tel;
}
