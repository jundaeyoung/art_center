package com.bclass.arts_center.repository.model;

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
	private Integer locationId;
}
