package com.bclass.arts_center.dto.request;

import java.sql.Time;

import lombok.Data;

/**
 * 
 * @author 김미정
 *
 */
@Data
public class RequestRentPlaceDto {

	private Integer id;
	private String startDate;
	private String endDate;
	private Time startTime;
	private Time endTime;
	private String rentPrice;
	private Integer userId;
	private Integer holeId;
	private Integer locationId;
	private Integer showId;
	
}
