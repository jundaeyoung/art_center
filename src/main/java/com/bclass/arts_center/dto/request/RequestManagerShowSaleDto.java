package com.bclass.arts_center.dto.request;

import lombok.Data;

@Data
public class RequestManagerShowSaleDto {
	private Integer userId;
	private Integer showId;
	private String imgRoute;
	private String title;
	private String startDate;
	private String endDate;
	private Integer adultRate;
	private Integer youthRate;
	private Integer infantRate;
	private Integer adultCount;
	private Integer youthCount;
	private Integer infantCount;

	
}
