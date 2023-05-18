package com.bclass.arts_center.dto;

import lombok.Data;
/**
 * 
 * @author 편용림
 *
 */
@Data
public class GoogleDto {

	private String id;
	private String email;
	private Boolean verifiedEmail;
	private String picture;
}
