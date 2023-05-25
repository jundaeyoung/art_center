package com.bclass.arts_center.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
	private String password;
	@Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
	private String nickname;
	@NotBlank(message = "이메일은 필수 입력 값입니다.")
	private String email;
	private String birthDate;
	@NotNull
	@Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "10 ~ 11 자리의 숫자만 입력 가능합니다.")
	private String tel;
	private String apiId;
	private Integer usernamecheck;
}
