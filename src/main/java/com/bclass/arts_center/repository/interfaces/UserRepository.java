package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	
	// 아이디 확인
	public User selectUserByUsername(String userName);
	
	// 아이디 중복체크
	public int selectUserCountByUserName(String userName);

	// 회원가입
	public int insertUser(SignUpFormDto signUpFormDto);
	
	// 회원가입(api)
	public int insertUserByApiid(SignUpFormDto signUpFormDto);
	
	//회원정보 수정
	public int updateUserByUsername(UpdateUserDto updateUserDto);
	
	//회원탈퇴
	public int deleteUserById(SignInFormDto signInFormDto);
	
	//유저 리스트 정보
	public List<User> selectUserList();
	
	//매니저 리스트 정보
	public List<User> selectManagerList();
	
	//강사 리스트 정보
	public List<User> selectTeacherList();
	
	//관리자 유저 수정
	public int updateUserById(User user);
	
	// 관리자 유저 삭제
	public int deleteById(String id);
	
	
	/*
	 * email 찾기 전대영
	 */

	public User findUserByUserId(String userEmail);

	
	public int updateUserPassword(@Param("id") String id,@Param("pw") String pw);
	
	/*
	 * email 중복검사 전대영
	 */
	
	
	
}
	
	
	
	