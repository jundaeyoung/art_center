package com.bclass.arts_center.dto.request;

import lombok.Data;

/**
 * 
 * @author 전대영
 *
 */
@Data
public class RequestShowDto {
	private Integer id;
	private String title;
	private String content;
	private String imgRoute;
	private String startDate;
	private String endDate;
	private String location;
	private String showType;
	private Double rating;
	private Integer showId;
	private Integer userId;
	private Integer reviewId;
	private String reviewContent;
	private String userName;
	private String reviewCreationDate;
}
