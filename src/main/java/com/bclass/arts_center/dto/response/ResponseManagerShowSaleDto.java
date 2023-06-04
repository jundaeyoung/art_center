package com.bclass.arts_center.dto.response;

import lombok.Data;

@Data
public class ResponseManagerShowSaleDto {
	private String startDate;
	private String endDate;
	private Integer userId;
	private String title;
}
