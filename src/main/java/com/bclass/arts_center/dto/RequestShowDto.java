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
	
	/**
	 * @author 김미정
	 * 카테고리 별 dto
	 */
	@Data
	public static class selectByCategory {
		private Integer id;
		private String title;
		private Date startDate;
		private Date endDate;
		private String holeName;
	}
	
	/**
	 * @author 김미정
	 * 전체 calendar dto 
	 */
	@Data
	public static class selectByShow {
		private Integer id;
		private String title;
		private Date startDate;
		private Date endDate;
		private String holeName;
	}
	
	
	
	
}
