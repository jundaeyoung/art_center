package com.bclass.arts_center.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

/*
 * @author 손주이
 */
@Data
public class ShowViewDto {

	private Integer showId;
	private Integer showTimeId;
	private String title;
	private String content;
	private String imgRoute;
	private Date showDate;
	private Time showTime;
	private Date startDate;
	private Date endDate;
	private String holeId;
	private Integer locationId;
	private String admissionAge;
	private String userTel;

//	위치
	private String name;
	private String location;

//	주최자
	private String nickname;
	private String tel;
	
	private String adultRate;
	private String youthRate;
	private String infantRate;

}
