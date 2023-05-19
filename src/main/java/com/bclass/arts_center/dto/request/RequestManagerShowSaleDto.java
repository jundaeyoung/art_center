package com.bclass.arts_center.dto.request;

import lombok.Data;

@Data
public class RequestManagerShowSaleDto {
	private Integer userId;
	private Integer showId;
	private String imgRoute;
	private String showStatus;
	private String title;
	private String startDate;
	private String endDate;
	private String adultRate;
	private String youthRate;
	private String infantRate;
	private Integer adultCount;
	private Integer youthCount;
	private Integer infantCount;

	
}
