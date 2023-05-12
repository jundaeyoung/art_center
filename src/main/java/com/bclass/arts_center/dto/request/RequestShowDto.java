package com.bclass.arts_center.dto.request;

import lombok.Data;

@Data
public class RequestShowDto {
	private Integer id;
	private String title;
	private String imgRoute;
	private String startDate;
	private String endDate;
	private String location;
	private String showType;
}
