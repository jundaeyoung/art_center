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
	private String title;
	private String content;
	private String imgRoute;
	private Date showDate;
	private Time showTime;
	private Date startDate;
	private Date endDate;
	private String hole;

}
