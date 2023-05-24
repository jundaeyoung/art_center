package com.bclass.arts_center.dto.payment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

/**
 * 
 * @author 손주이
 *
 */
@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoReadyResponse {

	private String tid; // 결제 고유 번호
	private String nextRedirectMobileUrl; // 요청한 클라이언트가 모바일 웹일 경우
	private String nextRedirectPcUrl; // 요청한 클라이언트가 PC 웹일 경우
	private String createdAt; // 결제 준비 요청 시간

}
