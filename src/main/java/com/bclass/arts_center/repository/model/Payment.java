package com.bclass.arts_center.repository.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Payment {

	private String paymentId;
	private Integer userId;
	private String paymentOption;
	private LocalDateTime paymentDate;
	private Integer ticketingId;
}
