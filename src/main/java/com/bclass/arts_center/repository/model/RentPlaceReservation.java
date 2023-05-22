package com.bclass.arts_center.repository.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import lombok.Data;

/**
 * 
 * @author 김미정
 *
 */
@Data
public class RentPlaceReservation {

	private Integer id;
	private Date startDate;
	private Date endDate;
	private Time startTime;
	private Time endTime;
	private Timestamp reservationDate;
	private Integer userId;
	private Integer holeId;
	private Integer locationId;
	
}
