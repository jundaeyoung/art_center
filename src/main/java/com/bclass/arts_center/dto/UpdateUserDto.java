package com.bclass.arts_center.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserDto {

	private Integer id;
	private String userName;
	//@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
	//@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
	private String password;
	@Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
	private String nickname;
	@NotBlank(message = "email은 필수 입력 값입니다.")
	private String email;
	@Pattern(regexp="^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message="올바른 전화번호를 입력해주세요!!")
	private String tel;
	private String apiId;
}