package com.bclass.arts_center.dto;

import java.sql.Date;

import lombok.Data;

/**
 * 
 * @author 선즈;ㅇ
 *
 */
@Data
public class TicketingDto {

	private String showTitle;
	private Date showDate;
	private int peopleOfNum;
}
