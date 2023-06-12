package com.bclass.arts_center.dto;

import java.sql.Date;
import java.sql.Time;

import com.bclass.arts_center.utils.TimestampUtil;

import lombok.Data;

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
	private Integer showTypeId;

//	위치
	private String name;
	private String location;

//	주최자
	private String nickname;
	private String tel;

	private String adultRate;
	private String youthRate;
	private String infantRate;

	public String formatDate() {
		return TimestampUtil.dateToString(showDate);
	}

	public String formatTime() {
		return TimestampUtil.timeToString(showTime);
	}
}
