package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.RequestUserCountDto;
import com.bclass.arts_center.dto.SignInFormDto;
import com.bclass.arts_center.dto.SignUpFormDto;
import com.bclass.arts_center.dto.UpdateUserDto;
import com.bclass.arts_center.repository.model.User;


@Mapper
public interface UserRepository {

	public User selectUserByUsernameAndPassword(SignInFormDto signInFormDto);

	public User selectUserByApiId(String apiId);

	public User selectUserBynickname(String nickname);

	public User selectUserByUsername(String userName);

	public Integer selectUserCountByUserName(String userName);

	public Integer insertUser(SignUpFormDto signUpFormDto);

	public Integer insertUserByApiid(SignUpFormDto signUpFormDto);

	public Integer updateUserByUsername(UpdateUserDto updateUserDto);

	public Integer deleteUserById(SignInFormDto signInFormDto);

	public List<User> selectUserList();

	public List<User> selectManagerList();

	public Integer updateUserById(User user);

	public Integer deleteByApiId(String userName);

	public User findUserByUserId(String userEmail);

	public Integer updateUserPassword(@Param("id") String id, @Param("pw") String pw);

	public Integer findUserByUserName(String userName);

	public Integer findUserByNickname(String userName);

	public Integer findUserByTel(String userName);

	public User findUserByEmailAndTel(User user);

	public List<RequestUserCountDto> selectJoinUserByDate();
}
