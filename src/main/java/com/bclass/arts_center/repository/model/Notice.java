package com.bclass.arts_center.repository.model;

import lombok.Data;

@Data
public class Notice {

	private Integer id;
	private String notice;
	private Integer adminId;
	private Integer userId;
	private Integer status;
}
