package com.bclass.arts_center.repository.model;

import lombok.Data;
/**
 * 
 * @author 전대영 
 *
 */
@Data
public class Show {

	private Integer id;
	private String imgRoute;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private String admissionAge;
	private String adultRate;
	private String youngRate;
	private String infantRate;
	private Integer organizerId;
	private Integer holeId;
	private Integer showTypeId;
}
