package com.bclass.arts_center.repository.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Show {

	private Integer id;
	private String imgRoute;
	private String title;
	private String content;
	private Date startDate;
	private Date endDate;
	private String admissionAge;
	private String adultRate;
	private String youthRate;
	private String infantRate;
	private Integer organizerId;
	private Integer holeId;
	private Integer showTypeId;
}
