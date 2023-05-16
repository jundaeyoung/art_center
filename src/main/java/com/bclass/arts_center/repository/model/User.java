package com.bclass.arts_center.repository.model;

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
	private String password;
	private String nickname;
	private String email;
	private String birthDate;
	private String tel;
	private Integer roleId;
	private Long provider; 
	
}
