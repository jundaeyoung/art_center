package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
	public List<RequestSignUpShowDto> selectMyShow(Integer organizerId);
	
	// manager 공연 등록 detail
	public List<RequestSignUpShowDto> selectMyShowDetail(Integer id);
	
	// user 공연 예매 내역 불러오기
	public List<TicketCheckDto> selectMyTicket(Integer userId);
	
	// user 공연 예매 detail
	public MyTicketDtailDto selectMyTicketDetail(Integer id);
}
