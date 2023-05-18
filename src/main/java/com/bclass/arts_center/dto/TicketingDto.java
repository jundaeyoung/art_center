package com.bclass.arts_center.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import lombok.Data;

/**
 * 
 * @author 손주이
 *
 */
@Data
public class TicketingDto {

	private Integer id;
	private Integer showId;
	private Date showDate;
	private Time showTime;

	private Timestamp ticketingDate;

}
