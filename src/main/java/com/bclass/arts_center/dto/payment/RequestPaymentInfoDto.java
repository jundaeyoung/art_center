package com.bclass.arts_center.dto.payment;

import lombok.Data;

@Data
public class RequestPaymentInfoDto {

	private Integer userId;
	private String paymentId;
	private Integer ageGroupId;
	private String adultRate;
	private String youthRate;

}
