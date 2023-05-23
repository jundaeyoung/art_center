package com.bclass.arts_center.dto.request;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

/**
 * @author 전대영
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
	private String showRating;
	private String name;
	private Date showDate;
	private Time showTime;
	private Integer count;
	private String admissionAge;
	private String adultRate;
	private String youthRate;
	private String infantRate;
	private String showStatus;
	
}
