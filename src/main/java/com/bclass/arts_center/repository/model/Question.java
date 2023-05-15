package com.bclass.arts_center.repository.model;

import lombok.Data;

@Data
public class Question {
	
	private Integer id;
	private String title;
	private String content;
	private Integer userId;
	private Integer questionTypeId;
	private Integer answerStatus;
}
