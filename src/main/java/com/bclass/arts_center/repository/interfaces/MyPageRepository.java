package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.MyRegistrationInfoDto;
import com.bclass.arts_center.dto.MyTicketDtailDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;

/**
 * 
 * @author 김미정
 * @author 손주이
 */

@Mapper
public interface MyPageRepository {

	// manager 공연 등록 내역 불러오기
	public List<MyRegistrationInfoDto> selectMyShow(@Param("organizerId") Integer organizerId,
			@Param("begin") Integer begin, @Param("range") Integer range);

	// 공연,대관 목록 count
	public Integer selectMyShowCount(Integer organizerId);

	// manager 공연 등록 detail
	public List<MyRegistrationInfoDto> selectMyShowDetail(Integer id);

	// user 공연 예매 내역 불러오기
	public List<MyTicketDtailDto> selectMyTicket(Integer userId);

	// user 공연 예매 detail
	public MyTicketDtailDto selectMyTicketDetail(Integer id);

	public List<MyRegistrationInfoDto> selectMyRentRefund(Integer id);
}
