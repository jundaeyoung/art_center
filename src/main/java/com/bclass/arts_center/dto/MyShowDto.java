package com.bclass.arts_center.dto;

import lombok.Data;

@Data
public class MyShowDto {

	private Integer id;
	private String imgRoute;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private String admissionAge;
	private Integer showStatus;
	private Integer rentPlaceStatus;
	private Integer rentId;
	private Integer showTypeId;
	private String mPaymentId;
	
}
