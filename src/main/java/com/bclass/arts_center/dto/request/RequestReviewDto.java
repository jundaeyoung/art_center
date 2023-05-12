package com.bclass.arts_center.dto.request;

import lombok.Data;

@Data
public class RequestReviewDto {
	private Integer show_id;
	private Integer rating;
	private String title;
	private String content;
	private String reviewCreationDate;
	private String imgRoute;
	private String userName;
}
