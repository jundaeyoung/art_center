package com.bclass.arts_center.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.MyTiketDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.interfaces.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	/**
	 * ticketing 시 필요한 공연 정보
	 * 
	 * @author 손주이
	 * @param showId
	 * @return showList
	 */
	@Transactional
	public List<TicketingDto> readShowInfoForTicketing(Integer showId) {

		List<TicketingDto> showList = ticketRepository.selectShowInfoForTicketingByShowId(showId);
		return showList;
	}

	/**
	 * 공연 일정 정보
	 * 
	 * @author 손주이
	 * @param showId
	 * @return dateList
	 */
	@Transactional
	public List<TicketingDto> readShowDate(Integer showId) {

		List<TicketingDto> dateList = ticketRepository.selectShowDateByShowId(showId);
		return dateList;
	}

	/**
	 * 공연 일정 해당 시간 정보
	 * 
	 * @author 손주이
	 * @param showId
	 * @param showDate
	 * @return timeList
	 */
	@Transactional
	public List<TicketingDto> readShowTime(Integer showId, Date showDate) {

		List<TicketingDto> timeList = ticketRepository.selectShowTimeByShowId(showId, showDate);
		return timeList;
	}

	/**
	 * admin 예매 목록 검색
	 * 
	 * @author 전대영
	 * @return timeList
	 */
	@Transactional
	public List<TicketingDto> readTicketingAll() {

		List<TicketingDto> timeList = ticketRepository.selectTicketingAll();
		return timeList;
	}

	/**
	 * 해당 공연 일정의 좌석 정보
	 * 
	 * @author 손주이
	 * @param showId
	 * @param showDateTimeId
	 * @return seatList
	 */
	@Transactional
	public List<TicketingDto> readSeatInfo(Integer showId, Integer showDatetimeId) {

		List<TicketingDto> seatList = ticketRepository.selectSeatInfo(showId, showDatetimeId);
		return seatList;
	}

	@Transactional
	public List<TicketingDto> readOccupiedSeat(Integer showDatetimeId) {

		List<TicketingDto> occupiedList = ticketRepository.selectOccupiedSeat(showDatetimeId);
		return occupiedList;
	}

	/**
	 * 예매
	 * 
	 * @author 손주이
	 * @param ticketingDto
	 */
	@Transactional
	public void waitTicket(TicketingDto ticketingDto) {

		int result = ticketRepository.insertTicket(ticketingDto);
		if (result != 1) {
			throw new CustomRestfullException("예매 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	public void selectSeat(Integer seatId, Integer showDatetimeId) {

		int result = ticketRepository.insertSeat(seatId, showDatetimeId);
		if (result != 1) {
			throw new CustomRestfullException("예매 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 결제 대기 중 인 티켓 확인
	 * 
	 * @author 손주이
	 * @param userId
	 * @return ticketEntityList
	 */
	@Transactional
	public List<TicketCheckDto> checkTicket(Integer userId) {

		List<TicketCheckDto> ticketEntityList = ticketRepository.selectTicket(userId);
		if (ticketEntityList == null) {
			throw new CustomRestfullException("티켓 정보를 찾을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ticketEntityList;
	}

	/**
	 * 결제된 티켓 결제완료시키기
	 * 
	 * @author 손주이
	 * @param userId
	 * @param id
	 */
	@Transactional
	public void updateTicketStatus(Integer userId, Integer ticketingId) {

		int result = ticketRepository.updateTicketing(userId, ticketingId);
		if (result != 1) {
			throw new CustomRestfullException("티켓 정보가 업데이트 되지 않았습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * 작성자 : 편용림 내가본 공연 조회
	 */
	
	@Transactional
	public List<MyTiketDto> readMyTicketByUserId(Integer userId) {
		
		List<MyTiketDto> myTiketList = ticketRepository.selectMyTiketDto(userId);
		
		return myTiketList;
	}

	/**
	 * 예매 취소
	 * 
	 * @param id
	 */
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
