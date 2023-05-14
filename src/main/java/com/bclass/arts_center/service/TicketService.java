package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.interfaces.TicketRepository;
import com.bclass.arts_center.repository.model.Show;
import com.bclass.arts_center.repository.model.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Transactional
	public List<Show> readShowInfo() {
		List<Show> showList = ticketRepository.selectShowInfo();
		return showList;
	}

	/**
	 * 예매
	 * 
	 * @param ticket
	 */
	@Transactional
	public void insertTicket(Ticket ticket) {

		int result = ticketRepository.insert(ticket);
		if (result != 1) {
			throw new CustomRestfullException("예매 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 예매 취소
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteTicket(int id) {

		int result = ticketRepository.delete(id);
		if (result != 1) {
			throw new CustomRestfullException("예매 내역 취소 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
