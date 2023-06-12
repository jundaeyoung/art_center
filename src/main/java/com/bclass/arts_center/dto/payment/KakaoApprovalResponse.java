package com.bclass.arts_center.dto.payment;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoApprovalResponse {

	private String aid; // 요청 고유 번호
	private String tid; // 결제 고유 번호
	private String cid; // 가맹점 코드
	private String partnerOrderId; // 가맹점 주문번호
	private String partnerUserId; // 가맹점 회원 id
	private String paymentMethodType; // 결제 수단, CARD 또는 MONEY 중 하나
	private Amount amount; // 결제 금액 정보
	private CardInfo cardInfo; // 결제 상세 정보, 결제수단이 카드일 경우만 포함
	private String itemName; // 상품 이름
	private String itemCode; // 상품 코드
	private Integer quantity; // 상품 수량
	private LocalDateTime createdAt; // 결제 준비 요청 시각
	private LocalDateTime approvedAt; // 결제 승인 시각
	private String payload; // 결제 승인 요청에 대해 저장한 값, 요청 시 전달된 내용
	private String fomatAmount;

}
