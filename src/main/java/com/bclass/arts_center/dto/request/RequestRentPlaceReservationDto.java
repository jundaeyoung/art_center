package com.bclass.arts_center.dto.request;

import java.sql.Date;

import lombok.Data;

@Data
public class RequestRentPlaceReservationDto {
	
	private Integer id;
	private String nickname;
	private String startTime;
	private String endTime;
	private String rentPrice;
	private String birthDate;
	private Date reservationDate;
	private String startDate;
	private String endDate;
	private Integer tel;
	private String name;
	private String location;
	private String locationInfo;
	private String rentPlaceStatus;
	private String youthRate;
	private String adultRate;
	private String title;
	
}
