package com.bclass.arts_center.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class TicketCheckDto {

	private Integer userId;
	private Timestamp ticketingDate;
	
	private Integer showId;
	private String title;
	private String imgRoute;
	
	private Integer showDatetimeId;
	private Date showDate;
	private Time showTime;

	private Integer seatId;
	private String seatName;

}