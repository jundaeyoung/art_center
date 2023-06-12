package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.MyRegistrationInfoDto;
import com.bclass.arts_center.dto.MyTicketDtailDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;
import com.bclass.arts_center.repository.interfaces.MyPageRepository;

@Service
public class MyPageService {

	@Autowired
	private MyPageRepository myPageRepository;


	@Transactional
	public List<MyRegistrationInfoDto> readMyShow(Integer organizerId, Integer begin, Integer range) {
		List<MyRegistrationInfoDto> myShowList = myPageRepository.selectMyShow(organizerId, begin, range);
		
		return myShowList;
	}
	

	@Transactional
	public Integer readMyShowCount(Integer organizerId) {
		Integer showCount = myPageRepository.selectMyShowCount(organizerId);
		
		return showCount;
	}


	@Transactional
	public List<MyRegistrationInfoDto> readMyShowDetail(Integer id) {
		List<MyRegistrationInfoDto> detailList = myPageRepository.selectMyShowDetail(id);
		
		return detailList;
	}


	@Transactional
	public List<MyTicketDtailDto> readMyTicket(Integer userId) {
		List<MyTicketDtailDto> ticketList = myPageRepository.selectMyTicket(userId);
		
		return ticketList;
	}

	
	@Transactional
	public MyTicketDtailDto readMyTicketDetail(Integer id) {
		MyTicketDtailDto ticketDetail = myPageRepository.selectMyTicketDetail(id);
		
		return ticketDetail;
	}
	
	
	@Transactional
	public List<MyRegistrationInfoDto> readMyRentRefund(Integer id){
		List<MyRegistrationInfoDto> rentList = myPageRepository.selectMyRentRefund(id);
		
		return rentList;
	}

}
