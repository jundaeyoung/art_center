package com.bclass.arts_center.repository.model;

import lombok.Data;

@Data
public class Announcement {

	private Integer id;
	private String title;
	private String content;
	private Integer userId;
	private String createdDate;
	
}