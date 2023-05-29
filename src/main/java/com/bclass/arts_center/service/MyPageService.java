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

	/**
	 * @author 김미정
	 * @param organizerId
	 * @return myShowList
	 */
	@Transactional
	public List<RequestSignUpShowDto> selectMyShow(Integer organizerId) {
		List<RequestSignUpShowDto> myShowList = myPageRepository.selectMyShow(organizerId);
		return myShowList;
	}
	@Transactional
	public List<MyRegistrationInfoDto> selectMyShow2(Integer organizerId) {
		List<MyRegistrationInfoDto> myShowList = myPageRepository.selectMyShow2(organizerId);
		return myShowList;
	}

	/**
	 * @author 김미정
	 * @param id
	 * @return detailList
	 */
	@Transactional
	public List<RequestSignUpShowDto> selectMyShowDetail(Integer id) {
		List<RequestSignUpShowDto> detailList = myPageRepository.selectMyShowDetail(id);
		return detailList;
	}
	@Transactional
	public List<MyRegistrationInfoDto> selectMyShowDetail2(Integer id) {
		List<MyRegistrationInfoDto> detailList = myPageRepository.selectMyShowDetail2(id);
		return detailList;
	}

	/**
	 * @author 손주이
	 * @param userId
	 * @return ticketList
	 */
	@Transactional
	public List<TicketCheckDto> readMyTicketList(Integer userId) {

		List<TicketCheckDto> ticketList = myPageRepository.selectMyTicket(userId);
		return ticketList;
	}

	
	/**
	 * @author 손주이
	 * @param id
	 * @return ticketDetail
	 */
	public MyTicketDtailDto readMyTicketDetail(Integer id) {

		MyTicketDtailDto ticketDetail = myPageRepository.selectMyTicketDetail(id);
		return ticketDetail;
	}

}
