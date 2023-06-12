package com.bclass.arts_center.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class MyTicketDtailDto {
	private String paymentId;
	private String paymentOption;
	private String paymentDate;
	private Integer paymentStatus;
	private Integer cancelStatus;
	
	private Integer id;
	private Timestamp ticketingDate;
	
	private Integer showId;
	private String title;
	private String imgRoute;
	
	private Integer showDatetimeId;
	private Date showDate;
	private Time showTime;

	private Integer seatId;
	private String seatName;
	
	private String name;
	private String location;
	
	
	private Integer ageGroupId;
	private String qrCode;
}
