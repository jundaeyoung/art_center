package com.bclass.arts_center.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.User;

@Mapper
public interface UserRepository {

	public User login(User user);
}
