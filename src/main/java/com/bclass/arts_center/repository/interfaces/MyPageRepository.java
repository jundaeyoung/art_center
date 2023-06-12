package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.MyRegistrationInfoDto;
import com.bclass.arts_center.dto.MyTicketDtailDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;


@Mapper
public interface MyPageRepository {

	public List<MyRegistrationInfoDto> selectMyShow(@Param("organizerId") Integer organizerId,
			@Param("begin") Integer begin, @Param("range") Integer range);
	
	public Integer selectMyShowCount(Integer organizerId);

	public List<MyRegistrationInfoDto> selectMyShowDetail(Integer id);

	public List<MyTicketDtailDto> selectMyTicket(Integer userId);

	public MyTicketDtailDto selectMyTicketDetail(Integer id);
	
	public List<MyRegistrationInfoDto> selectMyRentRefund(Integer id);
}
