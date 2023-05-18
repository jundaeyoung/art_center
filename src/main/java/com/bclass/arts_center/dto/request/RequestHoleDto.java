package com.bclass.arts_center.dto.request;

import java.sql.Time;

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
	private String tel;
	private Integer locationId;
	private String location;
	private String locationInfo;
	private Integer timeId;
	private Time startTime;
	private Time endTime;
	private Integer holeId;
}
