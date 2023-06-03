package com.bclass.arts_center.dto.payment;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

/**
 * 결제 취소 ㄹ시 응담
 * 
 * @author 손쥥
 *
 */
@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoRefundResponse {

	private String aid; // 요청 고유 번호
	private String tid; // 결제 고유 번호
	private String cid; // 가맹점 코드
	private String status; // 결제 상태
	private String partnerOrderId; // 가맹점 주문번호
	private String partnerUserId; // 가맹점 회원 id
	private String paymentMethodType; // 결제 수단, CARD 또는 MONEY 중 하나
	private Amount amount; // 결제 금액 정보
	private ApprovedCancelAmount approvedCancelAmount; // 이번 요청으로 취소된 금액
	private CanceledAmount canceledAmount; // 누계 취소 금액
	private CancelAvailableAmount cancelAvailableAmount; // 남은 취소 가능 금액
	private String itemName; // 상품 이름
	private String itemCode; // 상품 코드
	private Integer quantity; // 상품 수량
	private LocalDateTime createdAt; // 결제 준비 요청 시각
	private LocalDateTime approvedAt; // 결제 승인 시각
	private LocalDateTime canceledAt; // 결제 취소 시각
	private String payload; // 취소 요청 시 전달한 값
	private String rentPrice; // 취소 요청 시 전달한 값
}
