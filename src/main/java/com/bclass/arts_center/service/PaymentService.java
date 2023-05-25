package com.bclass.arts_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.interfaces.PaymentRepository;
import com.bclass.arts_center.repository.model.Payment;

/**
 * 
 * @author 손주이
 *
 */
@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Transactional
	public void createPayment(Payment payment) {

		int result = paymentRepository.insertPayment(payment);

		if (result != 1) {
			throw new CustomRestfullException("결제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
