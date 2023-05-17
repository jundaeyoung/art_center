package com.bclass.arts_center.dto;

import lombok.Data;

@Data
public class KakaoDto {
	
	private Long id;
	private Properties properties;
	
	@Data
	public class Properties{
		private String nickname;
	}
	@Data
	public class KakaoAccount{
		private boolean profileNicknameNeedsAgreement;
		private Profile profile;
		
		@Data
		public class Profile{
			private String nickname;
		}
		private String email;
	}
}
