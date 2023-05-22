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

	/*
	 * 손주이 : 공연 일정 정보
	 */
	@Transactional
	public List<TicketingDto> readShowDate(Integer showId) {
		List<TicketingDto> dateList = ticketRepository.selectShowDateByShowId(showId);
		return dateList;
	}

	/*
	 * 손주이 : 공연 일정 해당 시간 정보
	 */
	@Transactional
	public List<TicketingDto> readShowTime(Integer showId, Date showDate) {
		List<TicketingDto> timeList = ticketRepository.selectShowTimeByShowId(showId, showDate);
		return timeList;
	}
	
	/*
	 * 전대영 : admin 예매 목록 검색
	 */
	@Transactional
	public List<TicketingDto> readTicketingAll() {
		List<TicketingDto> timeList = ticketRepository.selectTicketingAll();
		return timeList;
	}

	/*
	 * 손주이 : 해당 공연 일정의 좌석 정보
	 */
	@Transactional
	public List<TicketingDto> readSeatInfo(Integer showId, Integer showDateTimeId) {
		List<TicketingDto> seatList = ticketRepository.selectSeatInfo(showId, showDateTimeId);
		return seatList;
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
