package com.bclass.arts_center.dto;

import java.security.Timestamp;
import java.sql.Time;

import lombok.Data;

@Data
public class MyRegistrationInfoDto {

	private Integer id;
	private String imgRoute;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private String admissionAge;
	private String adultRate;
	private String youthRate;
	private String infantRate;
	private Integer organizerId;
	private Integer holeId;
	private Integer showTypeId;
	private Integer showStatus;
	
	private Integer rentPlaceId;
	private Time startTime;
	private Time endTime;
	private String rentPrice;
	private Timestamp reservationDate;
	private Integer userId;
	private Integer locationId;
	private Integer rentPlaceStatus;
	private Integer showId;
	
	private String name;
	private String tel;
	
	private String location;
	private String locationInfo;
	private String rentId;
	
	
	
}
