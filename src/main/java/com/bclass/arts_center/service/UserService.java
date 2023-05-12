package com.bclass.arts_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.SignInFormDto;
import com.bclass.arts_center.dto.SignUpFormDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
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

	@Autowired
	private PasswordEncoder passwordEncoder;

	// 회원가입
	@Transactional
	public int createUser(SignUpFormDto signUpFormDto) {

		String rawPwd = signUpFormDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		signUpFormDto.setPassword(hashPwd);

		int result = userRepository.insertUser(signUpFormDto);

		if (result != 1) {
			throw new CustomRestfullException("회원 가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

	// 로그인
	@Transactional
	public User readUser(SignInFormDto signInFormDto) {

		User userEntity = userRepository.selectUserByUsername(signInFormDto);
		
		if (userEntity == null || userEntity.getUserName().equals(signInFormDto.getUserName()) == false) {
			throw new CustomRestfullException("존재하지 않는 계정입니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		boolean isPwdMatched = passwordEncoder.matches(signInFormDto.getPassword(), userEntity.getPassword());
		
		if (isPwdMatched == false) {
			throw new CustomRestfullException("비밀번호가 틀렸습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return userEntity;
	}
	
	//내 정보
	@Transactional
	public User readUserByUserName(SignInFormDto signInFormDto) {
		User user = userRepository.selectUserByUsername(signInFormDto);
		return user;
	}
	

	// 회원정보 수정
	@Transactional
	public int updateUser(SignUpFormDto signUpFormDto) {
		int result = userRepository.updateUserByUsername(signUpFormDto);
		return result;
	}

	// 회원 탈퇴
	@Transactional
	public int deleteUser(SignInFormDto signInFormDto) {
		
		User userEntity = userRepository.selectUserByUsername(signInFormDto);
		
		boolean isPwdMatched = passwordEncoder.matches(signInFormDto.getPassword(), userEntity.getPassword());
		
		if (isPwdMatched == false) {
			throw new CustomRestfullException("비번이 틀렸습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			int result = userRepository.deleteUserById(signInFormDto);
			System.out.println(result);
			return result;
		}
	}
}
