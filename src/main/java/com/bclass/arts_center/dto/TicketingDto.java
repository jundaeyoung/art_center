package com.bclass.arts_center.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import lombok.Data;

/**
 * 
 * @author 손주이, 전대영
 *
 */
@Data
public class TicketingDto {

	private Integer id;
	private Integer showId;
	private String title;
	private Date showDate;
	private Time showTime;
	private Integer showTypeId;
	private Integer ageGroupId;

	private Integer showDatetimeId;
	private Integer seatId;
	private String seatName;
	private int reserveState;

	private Timestamp ticketingDate;

	private Integer userId;

	private String nickname;
	private String tel;
	private String email;
	private String adultRate;
	private String youthRate;
	private String infantRate;
	private Integer infantCount;
	private Integer youthCount;
	private Integer adultCount;

}
