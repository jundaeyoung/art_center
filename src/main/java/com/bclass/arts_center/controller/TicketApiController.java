package com.bclass.arts_center.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.dto.response.ResponseDto;
import com.bclass.arts_center.service.TicketService;

@RestController
public class TicketApiController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/api/selectDate/{showId}/{showDate}")
	public ResponseDto<List<TicketingDto>> selectDate(@PathVariable("showId") Integer showId,
			@PathVariable("showDate") Date date) {

		List<TicketingDto> showTimeList = ticketService.readShowTime(showId, date);

		// System.out.println(showTimeList);
		return new ResponseDto<List<TicketingDto>>(200, HttpStatus.OK.toString(), showTimeList);
	}

	@GetMapping("/api/selectSeats/{showId}/{showDatetimeId}")
	public ResponseDto<List<TicketingDto>> selectSeats(@PathVariable("showId") Integer showId,
			@PathVariable("showDatetimeId") Integer showDatetimeId) {
		List<TicketingDto> seatList = ticketService.readSeatInfo(showId, showDatetimeId);

		return new ResponseDto<List<TicketingDto>>(200, HttpStatus.OK.toString(), seatList);
	}

	@GetMapping("/api/occupied/{showDatetimeId}")
	public ResponseDto<List<TicketingDto>> selectOccupiedSeat(@PathVariable Integer showDatetimeId) {

		List<TicketingDto> occupiedList = ticketService.readOccupiedSeat(showDatetimeId);

		return new ResponseDto<List<TicketingDto>>(200, HttpStatus.OK.toString(), occupiedList);
	}

	@GetMapping("/api/remainingCount/{showDatetimeId}")
	public ResponseDto<Integer> remainingCount(TicketingDto ticketingDto, @PathVariable Integer showDatetimeId) {

		Integer totalCount = 30;
		Integer count = ticketService.countTicketing(showDatetimeId);
		Integer remainingCount = totalCount - count;

		return new ResponseDto<Integer>(200, HttpStatus.OK.toString(), remainingCount);
	}
}
