package com.bclass.arts_center.repository.model;

import java.sql.Timestamp;

import com.bclass.arts_center.utils.TimestampUtil;

import lombok.Data;

/**
 * 
 * @author 전대영
 *
 */
@Data
public class User {
	private Integer id;
	private String userName;
	private String apiId;
	private Integer roleId;
	private String password;
	private String nickname;
	private String email;
	private String birthDate;
	private String tel;
	private Timestamp createdAt;

}
