package com.bclass.arts_center.dto.request;

import lombok.Data;
/**
 * 
 * @author 전대영 
 *
 */
@Data
public class RequestReviewDto {
	private Integer showId;
	private Integer userId;
	private Integer reviewId;
	private Double rating;
	private String title;
	private String content;
	private String imgRoute;
	private String reviewContent;
	private String userName;
	private String reviewCreationDate;
	private String showType;
	private Integer count;
}
