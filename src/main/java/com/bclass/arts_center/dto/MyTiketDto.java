package com.bclass.arts_center.dto;

import lombok.Data;

@Data
public class MyTiketDto {
	private Integer ticketId;
	private Integer userId;
	private String imgRoute;
	private String title;
	private String content;
	private String location;
	private String name;
	private String seatName;
	private String showDate;
	private String showTime;
	private String showType;
	private String reviewContent;
	private Integer showId;
	private Integer rating;
	
}
