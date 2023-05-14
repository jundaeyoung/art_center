package com.bclass.arts_center.dto;

import java.sql.Date;

import lombok.Data;

/**
 * 
 * @author 김미정
 *
 */
@Data
public class RequestShowDto {

	@Data
	public static class selectByCategory {
		private String title;
		private Date startDate;
		private String holeName;
	}
	
	@Data
	public static class selectSchedule {
		private String title;
		private Date startDate;
		private String holeName;
	}
	
	
}
