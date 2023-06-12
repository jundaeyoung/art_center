package com.bclass.arts_center.repository.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ManagerPayment {

	private String mPaymentId;
	private Integer managerId;
	private String paymentOption;
	private LocalDateTime paymentDate;
	private Integer rentId;
	
}
