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
	private Integer locationId;
	private String location;
	private Integer timeId;
	private Time startTime;
	private Time endTime;
	private Integer holeId;
}
