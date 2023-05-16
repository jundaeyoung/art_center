package com.bclass.arts_center.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.SignInFormDto;
import com.bclass.arts_center.dto.SignUpFormDto;
import com.bclass.arts_center.repository.model.User;

@Mapper
public interface UserRepository {
	
	
	// 로그인, 로그아웃
	public User selectUserByUsernameAndPassword(SignInFormDto signInFormDto);
	
	// 비밀번호 암호화
	public User selectUserByUsername(SignInFormDto signInFormDto);

	// 회원가입
	public int insertUser(SignUpFormDto signUpFormDto);
	
	//회원정보 수정
	public int updateUserByUsername(SignUpFormDto signUpFormDto);
	
	//회원탈퇴
	public int deleteUserById(SignInFormDto signInFormDto);
	
	//소셜 회원가입 확인
	public User selectByEmailAndProvider(SignUpFormDto signUpFormDto);
}
