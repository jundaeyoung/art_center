package com.bclass.arts_center.repository.interfaces;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.payment.AdminKeyDto;
import com.bclass.arts_center.dto.payment.KakaoRefundResponse;
import com.bclass.arts_center.dto.payment.RequestPaymentInfoDto;
import com.bclass.arts_center.repository.model.ManagerPayment;
import com.bclass.arts_center.repository.model.Payment;

@Mapper
public interface PaymentRepository {

	public AdminKeyDto selectAdminKey();

	public int insertPayment(Payment payment);

	public int insertManagerPayment(ManagerPayment managerPayment);

	public RequestPaymentInfoDto selectPaymentInfo(@Param("userId") Integer userId, @Param("tid") String tid);

	public int updateCancelStatus(@Param("canceledAt") LocalDateTime canceledAt, @Param("tid") String tid);

	public RequestPaymentInfoDto selectRentalPaymentInfo(@Param("tid") String tid);

	public int updateManagerCancelStatus(@Param("canceledAt") LocalDateTime canceledAt, @Param("tid") String tid);
	
	public KakaoRefundResponse refundCheck(@Param("tid") String tid);
}
