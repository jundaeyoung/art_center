package com.bclass.arts_center.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.repository.interfaces.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	/*
	 * 손주이 : ticketing 시 필요한 공연 정보
	 */
	@Transactional
	public List<TicketingDto> readShowInfoForTicketing(Integer showId) {
		List<TicketingDto> showList = ticketRepository.selectShowInfoForTicketingByShowId(showId);
		return showList;
	}

	@Transactional
	public List<TicketingDto> readShowDate(Integer showId) {
		List<TicketingDto> dateList = ticketRepository.selectShowDateByShowId(showId);
		return dateList;
	}

	@Transactional
	public List<TicketingDto> readShowTime(Integer showTimeId, Date showDate) {
		List<TicketingDto> timeList = ticketRepository.selectShowTimeByShowId(showTimeId, showDate);
		return timeList;
	}

//	/**
//	 * 예매
//	 * 
//	 * @param ticket
//	 */
//	@Transactional
//	public void insertTicket(Ticket ticket) {
//
//		int result = ticketRepository.insert(ticket);
//		if (result != 1) {
//			throw new CustomRestfullException("예매 실패", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	/**
//	 * 예매 취소
//	 * 
//	 * @param id
//	 */
//	@Transactional
//	public void deleteTicket(int id) {
//
//		int result = ticketRepository.delete(id);
//		if (result != 1) {
//			throw new CustomRestfullException("예매 내역 취소 실패", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

}
