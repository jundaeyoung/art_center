package com.bclass.arts_center.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.payment.AdminKeyDto;
import com.bclass.arts_center.dto.payment.KakaoRefundResponse;
import com.bclass.arts_center.dto.payment.RequestPaymentInfoDto;
import com.bclass.arts_center.repository.model.ManagerPayment;
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

	// 작성자 : 편용림 대관 결제
	public int insertManagerPayment(ManagerPayment managerPayment);

	public RequestPaymentInfoDto selectPaymentInfo(@Param("userId") Integer userId, @Param("tid") String tid);

	public int updateCancelStatus(KakaoRefundResponse kakaoRefund);

}
