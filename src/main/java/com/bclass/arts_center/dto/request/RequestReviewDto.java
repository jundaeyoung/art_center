package com.bclass.arts_center.dto.request;

import lombok.Data;
/**
 * 
 * @author 전대영 
 *
 */
@Data
public class RequestReviewDto {
	private Integer show_id;
	private Double rating;
	private String title;
	private String content;
	private String reviewCreationDate;
	private String imgRoute;
	private String userName;
}
