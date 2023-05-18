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
public class KakaoDto {
	
	private String id;
	private Properties properties;
	private KakaoAccount kakaoaccount;
	
	@Data
	public class Properties{
		private String nickname;
	}
	
	@Data
	@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
	public class KakaoAccount{
		private String email;
		private boolean profileNicknameNeedsAgreement;
		private Profile profile;
		
		@Data
		public class Profile{
			private String nickname;
		}
	}
}
