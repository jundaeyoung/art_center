package com.bclass.arts_center.repository.model;

import java.sql.Time;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class RentPlaceReservation {

	private Integer id;
	private String startDate;
	private String endDate;
	private Time startTime;
	private Time endTime;
	private String rentPrice;	
	private Timestamp reservationDate;
	private Integer userId;
	private Integer holeId;
	private Integer locationId;
	
}
