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

import com.bclass.arts_center.dto.RequestUserCountDto;
import com.bclass.arts_center.dto.SignInFormDto;
import com.bclass.arts_center.dto.SignUpFormDto;
import com.bclass.arts_center.dto.UpdateUserDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.interfaces.UserRepository;
import com.bclass.arts_center.repository.model.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Transactional
	public Integer createUser(SignUpFormDto signUpFormDto) {

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
		Integer result = userRepository.insertUser(signUpFormDto);

		return result;
	}

	
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

	
	public User readUserByApiId(String apiId) {
		User userEntity = userRepository.selectUserByApiId(apiId);
		return userEntity;
	}

	
	@Transactional
	public User readUserByUserName(String userName) {
		User user = userRepository.selectUserByUsername(userName);
		return user;
	}

	
	@Transactional
	public int readUserCountByUserName(String userName) {
		int result = userRepository.selectUserCountByUserName(userName);
		return result;
	}

	
	@Transactional
	public int updateUser(UpdateUserDto updateUserDto) {
		String rawPwd = updateUserDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		updateUserDto.setPassword(hashPwd);
		int result = userRepository.updateUserByUsername(updateUserDto);
		return result;
	}

	
	@Transactional
	public int deleteUser(SignInFormDto signInFormDto) {

		User userEntity = userRepository.selectUserByUsername(signInFormDto.getUserName());

		if (userEntity.getApiId() != null) {
			int result = userRepository.deleteUserById(signInFormDto);
			return result;
		} else {

			boolean isPwdMatched = passwordEncoder.matches(signInFormDto.getPassword(), userEntity.getPassword());

			if (isPwdMatched == false) {
				throw new CustomRestfullException("비밀번호가 틀렸습니다", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				int result = userRepository.deleteUserById(signInFormDto);
				return result;
			}
		}
	}

	
	@Transactional
	public List<User> readUserList() {
		List<User> users = userRepository.selectUserList();
		return users;
	}
	

	@Transactional
	public List<User> readManagerList() {
		List<User> managers = userRepository.selectManagerList();
		return managers;
	}

	
	@Transactional
	public int updateUserById(User user) {
		int result = userRepository.updateUserById(user);
		return result;
	}

	
	@Transactional
	public int deleteUserById(String id) {
		int result = userRepository.deleteById(id);
		return result;
	}

	
	@Transactional(readOnly = true)
	public Map<String, String> userValidateHandling(Errors errors) {
		Map<String, String> validatorResult = new HashMap<>();

		for (FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		return validatorResult;
	}

	@Transactional
	public boolean findUserNameByEmail(String userEmail, String userName) {

		User user = userRepository.findUserByUserId(userEmail);
		if (user != null && user.getUserName().equals(userName)) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public boolean emailCheckByEmail(String userEmail) {
		if (userEmail.length() < 5 || userEmail.isBlank()) {
			return false;
		}
		User user = userRepository.findUserByUserId(userEmail);
		if (user != null && user.getEmail().equals(userEmail)) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional
	public Integer userNameCheck(String userName) {
		Integer result = userRepository.findUserByUserName(userName);
		return result;
	}

	@Transactional
	public Integer nicknameCheck(String nickname) {
		Integer result = userRepository.findUserByNickname(nickname);
		return result;
	}

	@Transactional
	public Integer telCheck(String nickname) {
		Integer result = userRepository.findUserByTel(nickname);
		return result;
	}

	@Transactional
	public User selectUserNameByEmailAndTel(User user) {
		User findUser = userRepository.findUserByEmailAndTel(user);

		return findUser;
	}

	
	public List<RequestUserCountDto> readJoinUserByStartDateAndEndDate() {
		List<RequestUserCountDto> userList = userRepository.selectJoinUserByDate();
		
		return userList;
	}

}

