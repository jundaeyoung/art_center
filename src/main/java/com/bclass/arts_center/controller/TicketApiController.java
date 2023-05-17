package com.bclass.arts_center.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	public List<TicketingDto> selectDate(@PathVariable("showId") Integer showId, @PathVariable("showDate") Date date,
			Model model) {
		List<TicketingDto> showTimeList = ticketService.readShowTime(showId, date);
		model.addAttribute("showTimeList", showTimeList);

		return showTimeList;
	}

}
