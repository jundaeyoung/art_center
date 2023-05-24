package com.bclass.arts_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.repository.interfaces.PaymentRepository;

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
	public void updateTicketing() {
		
	}
	
}
