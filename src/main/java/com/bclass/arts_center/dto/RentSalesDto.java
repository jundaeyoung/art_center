package com.bclass.arts_center.dto;

import lombok.Data;

@Data
public class RentSalesDto {

	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	private String title;
	private String location;
	private String name;
	private String nickname;
	private String rentPrice;
	private Integer totalPrice;
	
}
