package com.bclass.arts_center.dto;

import lombok.Data;

@Data
public class KaKaoProfile {

	private Long id;
	private String connected_at;
	
	
	@Data
	public class Properties{
		private String nickname;
	}
	
	@Data
	public class KakaoAccount{
		
		private String email;
	}
}
