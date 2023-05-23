package com.bclass.arts_center.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.bclass.arts_center.dto.SignInFormDto;
import com.bclass.arts_center.dto.SignUpFormDto;
import com.bclass.arts_center.dto.UpdateUserDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.interfaces.UserRepository;
import com.bclass.arts_center.repository.model.User;

import lombok.AllArgsConstructor;

/** 
 * @author 편용림
 *
 */

@Service
@AllArgsConstructor
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	// 회원가입
	@Transactional
	public void createUser(SignUpFormDto signUpFormDto) {

		String rawPwd = signUpFormDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		signUpFormDto.setPassword(hashPwd);
		
		User selectUser = userRepository.selectUserByUsername(signUpFormDto.getUserName());
		
		User selectNickName = userRepository.selectUserBynickname(signUpFormDto.getNickname());
		
		if (selectUser != null) {
			throw new CustomRestfullException("중복된 아이디가 있습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (selectNickName != null) {
			throw new CustomRestfullException("중복된 닉네임이 있습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		int result = userRepository.insertUser(signUpFormDto);
		
	}



	// 로그인
	@Transactional
	public User readUser(SignInFormDto signInFormDto) {

		User userEntity = userRepository.selectUserByUsername(signInFormDto.getUserName());
		
		if (userEntity == null || userEntity.getUserName().equals(signInFormDto.getUserName()) == false) {
			throw new CustomRestfullException("존재하지 않는 계정입니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		boolean isPwdMatched = passwordEncoder.matches(signInFormDto.getPassword(), userEntity.getPassword());
		
		if (isPwdMatched == false) {
			throw new CustomRestfullException("비밀번호가 틀렸습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return userEntity;
	}
	
	// api id로 유저정보 조회
	public User readUserByApiId(String apiId) {
		User userEntity = userRepository.selectUserByApiId(apiId);
		return userEntity;
	}
	
	
	//내 정보
	@Transactional
	public User readUserByUserName(String userName) {
		User user = userRepository.selectUserByUsername(userName);
		return user;
	}
	

	// 회원정보 수정
	@Transactional
	public int updateUser(UpdateUserDto updateUserDto) {
		String rawPwd = updateUserDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		updateUserDto.setPassword(hashPwd);
		int result = userRepository.updateUserByUsername(updateUserDto);
		return result;
	}

	// 회원 탈퇴
	@Transactional
	public int deleteUser(SignInFormDto signInFormDto) {
		
		User userEntity = userRepository.selectUserByUsername(signInFormDto.getUserName());
		
		if (userEntity.getApiId() != null) {
			int result = userRepository.deleteUserById(signInFormDto);
			return result;
		}else {
			
			boolean isPwdMatched = passwordEncoder.matches(signInFormDto.getPassword(), userEntity.getPassword());
			
			if (isPwdMatched == false) {
				throw new CustomRestfullException("비밀번호가 틀렸습니다", HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				int result = userRepository.deleteUserById(signInFormDto);
				return result;
			}		
		}
	}

	// 편용림
	// 유저 목록
	@Transactional
	public  List<User> readUser() {
		List<User> users = userRepository.selectUserList();
		return users;
	}
	
	// 매니저 목록
	@Transactional
	public List<User> readManager(){
		List<User> managers = userRepository.selectManagerList();
		return managers;
	}
	
	// 강사 목록
	public List<User> readTeacher(){
		List<User> teachers = userRepository.selectTeacherList();
		return teachers;
	}
	
	
	//관리자 유저 수정
	@Transactional
	public int updateUserById(User user) {
		
		int result = userRepository.updateUserById(user);
		return result;
	}
	
	// 삭제
	@Transactional
	public int deleteUserById(String id) {
		
		int result = userRepository.deleteById(id);
		return result;
	}
	
	
	
	// 편용림 : valid 검사
	@Transactional(readOnly = true)
	public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }
	
	/*
	 * 전대영 : email 비번 찾기 
	 */
	public boolean userEmailCheck(String userEmail, String userName) {

        User user = userRepository.findUserByUserId(userEmail);
        if(user!=null && user.getUserName().equals(userName)) {
            return true;
        }
        else {
            return false;
        }
    }
}