package com.bclass.arts_center.dto.request;

import lombok.Data;

/**
 * 
 * @author 김미정
 *
 */
@Data
public class RequestHoleDto {

	private Integer id;
	private String name;
	private String price;
	private String startDate;
	private String endDate;
	private Integer locationId;
	private String location;
	private Integer timeId;
	private String startTime;
	private String endTime;
	private Integer holeId;
}
