package com.bclass.arts_center.dto.payment;

import lombok.Data;

/**
 * 결제 취소 요청으로 취소된 금액
 * 
 * @author 손주이
 *
 */
@Data
public class ApprovedCancelAmount {

	private Integer toal;  // 요청으로 취소된 전체 금액
}
