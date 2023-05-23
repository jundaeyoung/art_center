package com.bclass.arts_center.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.service.TicketService;

@RestController
public class TicketApiController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/api/selectDate/{showId}/{showDate}")
	public List<TicketingDto> selectDate(@PathVariable("showId") Integer showId, @PathVariable("showDate") Date date) {

		List<TicketingDto> showTimeList = ticketService.readShowTime(showId, date);

		System.out.println(showTimeList);
		return showTimeList;
	}

	@GetMapping("/api/selectSeats/{showId}/{showDateTimeId}")
	public List<TicketingDto> selectSeats(@PathVariable("showId") Integer showId,
			@PathVariable("showDateTimeId") Integer showDateTimeId) {
		List<TicketingDto> seatList = ticketService.readSeatInfo(showId, showDateTimeId);

		return seatList;
	}
	
//	@PostMapping("/api/ticketCheck")
//	@ResponseBody
//	public String ticketCheck () {
//		
//		System.out.println("111111111111");
//		return "string";
//	}

}
