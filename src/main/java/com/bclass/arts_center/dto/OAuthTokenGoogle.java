package com.bclass.arts_center.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OAuthTokenGoogle {

	private String access_token;
	private Integer expiresIn;
	private String scope;
	private String tokenType;
	private String idToken;
}


