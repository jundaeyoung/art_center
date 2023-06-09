package com.bclass.arts_center.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.payment.KakaoRefundResponse;
import com.bclass.arts_center.dto.payment.RequestPaymentInfoDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.interfaces.PaymentRepository;
import com.bclass.arts_center.repository.model.ManagerPayment;
import com.bclass.arts_center.repository.model.Payment;

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


	@Transactional
	public void createManagerPayment(ManagerPayment payment) {

		int result = paymentRepository.insertManagerPayment(payment);

		if (result != 1) {
			throw new CustomRestfullException("결제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@Transactional
	public void updateCancelStatus(LocalDateTime canceledAt, String tid) {

		int result = paymentRepository.updateCancelStatus(canceledAt, tid);
		if (result != 1) {
			throw new CustomRestfullException("결제 취소 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@Transactional
	public void updateManagerCancelStatus(LocalDateTime canceledAt, String tid) {

		int result = paymentRepository.updateManagerCancelStatus(canceledAt, tid);
		if (result != 1) {
			throw new CustomRestfullException("결제 취소 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@Transactional
	public KakaoRefundResponse refundCheck(String tid) {
		KakaoRefundResponse result = paymentRepository.refundCheck(tid);
		
		return result;
	}
}
