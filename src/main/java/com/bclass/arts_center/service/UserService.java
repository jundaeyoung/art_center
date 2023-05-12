package com.bclass.arts_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.repository.interfaces.UserRepository;
import com.bclass.arts_center.repository.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User login(User user) {
		User userEntity = userRepository.login(user);
		return userEntity;
	}
}
