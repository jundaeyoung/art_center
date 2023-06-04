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
	public List<TicketingDto> readShowTime(Integer showId, Date showDate) {
		List<TicketingDto> timeList = ticketRepository.selectShowTimeByShowId(showId, showDate);
		
		return timeList;
	}

	
	@Transactional
	public List<TicketingDto> readTicketingAll() {
		List<TicketingDto> timeList = ticketRepository.selectTicketingAll();
		
		return timeList;
	}

	
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

	
	@Transactional
	public Integer countTicketing(Integer showDatetimeId) {
		Integer ticketingPeople = ticketRepository.countTicketing(showDatetimeId);
		
		return ticketingPeople;
	}
	

	@Transactional
	public void waitTicket(TicketingDto ticketingDto) {
		Integer result = ticketRepository.insertTicket(ticketingDto);
		if (result != 1) {
			throw new CustomRestfullException("예매 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@Transactional
	public void selectSeat(Integer seatId, Integer showDatetimeId) {
		Integer result = ticketRepository.insertSeat(seatId, showDatetimeId);
		if (result != 1) {
			throw new CustomRestfullException("예매 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@Transactional
	public List<TicketCheckDto> checkTicket(Integer userId) {
		List<TicketCheckDto> ticketEntityList = ticketRepository.selectTicket(userId);
		if (ticketEntityList == null) {
			throw new CustomRestfullException("티켓 정보를 찾을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ticketEntityList;
	}
	
	
	@Transactional
	public TicketCheckDto checkTicketForPay(Integer ticketingId) {
		TicketCheckDto ticketEntityList = ticketRepository.selectTicketForPay(ticketingId);
		if (ticketEntityList == null) {
			throw new CustomRestfullException("티켓 정보를 찾을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return ticketEntityList;
	}


	@Transactional
	public void updateTicketStatus(Integer userId, Integer ticketingId) {
		Integer result = ticketRepository.updateTicketing(userId, ticketingId);
		if (result != 1) {
			throw new CustomRestfullException("티켓 정보가 업데이트 되지 않았습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@Transactional
	public Integer updateQrCode(Integer id,String path) {
		Integer result = ticketRepository.updateQrCode(id,path);
		
		return result;
	}
	
	
	@Transactional
	public TicketCheckDto readTicketId() {
		TicketCheckDto result = ticketRepository.selectTicketId();
		return result;
	}
	
	
	@Transactional
	public List<MyTiketDto> readMyTicketByUserId(Integer userId) {
		List<MyTiketDto> myTiketList = ticketRepository.selectMyTiketDto(userId);
		
		return myTiketList;
	}
	
	
	@Transactional
	public TicketCheckDto readTicketIdById(Integer id) {
		TicketCheckDto result = ticketRepository.selectTicketIdbyId(id);
		return result;
	}

}
