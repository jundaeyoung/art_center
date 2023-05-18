package com.bclass.arts_center.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
/**
 * 
 * @author 편용림
 *
 */
@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OAuthTokenKakao {
	
	private String tokenType;
	private String accessToken;
	private Integer expiresIn;
	private String refreshToken;
	private Integer refreshTokenExpiresIn;
	
}