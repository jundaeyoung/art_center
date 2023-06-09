package com.bclass.arts_center.dto.payment;

import lombok.Data;

@Data
public class RequestPaymentInfoDto {
	private Integer userId;
	private Integer rentId;
	private String paymentId;
	private String mPaymentId;
	private Integer ageGroupId;
	private String adultRate;
	private String youthRate;
	private String rentPrice;

}
