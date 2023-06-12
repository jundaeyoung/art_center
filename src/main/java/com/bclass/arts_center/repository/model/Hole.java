package com.bclass.arts_center.repository.model;

import java.sql.Time;

import lombok.Data;

/**
 * 
 * @author 김미정
 *
 */
@Data
public class Hole {
	private Integer id;
	private String name;
	private String price;
	private String tel;
	private Time startTime;
	private Time endTime;
	private Integer locationId;
	private Integer timeId;
}
