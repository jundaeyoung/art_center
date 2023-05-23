package com.bclass.arts_center.repository.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Ticket {

	private int id;
	private Timestamp ticketingDate;
	private int userId;
	private int showId;
	private int seatId;
	private int showDateTimeId;
	private int ageGroupId;
}
