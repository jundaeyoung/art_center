package com.bclass.arts_center.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.payment.AdminKeyDto;
import com.bclass.arts_center.repository.model.Payment;

/**
 * 
 * @author 손주이
 *
 */
@Mapper
public interface PaymentRepository {

	public AdminKeyDto selectAdminKey();

	public int insertPayment(Payment payment);

}
