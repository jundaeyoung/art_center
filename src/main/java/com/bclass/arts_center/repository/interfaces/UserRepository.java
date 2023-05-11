package com.bclass.arts_center.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.User;

@Mapper
public interface UserRepository {
	
	
	// 로그인, 로그아웃
	public User selectUserByUsernameAndPassword(User user);
	
	
	// 회원가입
	public int insertUser(User User);
	
	//회원정보 수정
	public int updateUserByUsername(User user);
	
	//회원탈퇴
	public int deleteUserByIdAndPassword(User user);
}
