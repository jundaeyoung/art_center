package com.bclass.arts_center.repository.model;

import lombok.Data;

@Data
public class Answer {
	
	private Integer id;
	private String content;
	private Integer userId;
	private Integer quetionId;
}
