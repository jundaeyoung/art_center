package com.bclass.arts_center.dto.payment;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

/**
 * 결제 승인 요청 시
 * 
 * @author 손주이
 *
 */
@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoApprovalResponse {

	private String aid;
	private String tid;
	private String cid;
	private String partnerOrderId;
	private String partnerUserId;
	private String paymentMethodType;
	private Amount amount;
	private CardInfo cardInfo;
	private String itemName;
	private String itemCode;
	private Integer quantity;
	private LocalDateTime createdAt;
	private LocalDateTime approvedAt;
	private String payload;

}
