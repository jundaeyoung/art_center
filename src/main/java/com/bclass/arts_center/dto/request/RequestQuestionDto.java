package com.bclass.arts_center.dto.request;

import lombok.Data;

@Data
public class RequestQuestionDto {

	private Integer id; // question id
	private Integer userId;
	private String userName;
	private String role;
	private String title;
	private String content;
	private String questionType;
	private Integer answerStatus;
	private String answer;
}
