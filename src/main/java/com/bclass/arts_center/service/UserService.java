package com.bclass.arts_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.repository.interfaces.UserRepository;
import com.bclass.arts_center.repository.model.User;

/**
 * 
 * @author 편용림
 *
 */

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	// 로그인
	@Transactional
	public User readUser(User user) {
		User userEntity = userRepository.selectUserByUsernameAndPassword(user);
			return userEntity;
		}
	
	// 회원가입
	@Transactional
	public int createUser(User user) {
		
		int result = userRepository.insertUser(user);
		
		return result;
	}
		
	
	// 회원정보 수정
	@Transactional
	public int updateUser(User user) {
		
		int result = userRepository.updateUserByUsername(user);
		
		return result;
	}
	
	//회원 탈퇴
	@Transactional
	public int deleteUser(String userName, String password) {
		
		User userEntity = new User();
		userEntity.setUserName(userName);
		userEntity.setPassword(password);
		
		int result = userRepository.deleteUserByIdAndPassword(userEntity);
		
		return result;
	}
}
