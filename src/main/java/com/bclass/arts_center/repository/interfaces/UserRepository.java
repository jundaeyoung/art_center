package com.bclass.arts_center.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.SignInFormDto;
import com.bclass.arts_center.dto.SignUpFormDto;
import com.bclass.arts_center.dto.UpdateUserDto;
import com.bclass.arts_center.repository.model.User;


/**
 * 
 * @author 편용림
 *
 */

@Mapper
public interface UserRepository {
	
	
	// 로그인, 로그아웃
	public User selectUserByUsernameAndPassword(SignInFormDto signInFormDto);
	
	// 소셜로 회원가입 한지 확인
	public User selectUserByApiId(String apiId);
	
	// 닉네임 중복 확인
	public User selectUserBynickname(String nickname);
	
	// 비밀번호 암호화
	public User selectUserByUsername(String userName);

	// 회원가입
	public int insertUser(SignUpFormDto signUpFormDto);
	
	// 회원가입(api)
	public int insertUserByApiid(SignUpFormDto signUpFormDto);
	
	//회원정보 수정
	public int updateUserByUsername(UpdateUserDto updateUserDto);
	
	//회원탈퇴
	public int deleteUserById(SignInFormDto signInFormDto);
}
