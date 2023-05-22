package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.service.ShowService;
import com.bclass.arts_center.service.TicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/ticketing/{showId}")
	public String ticketingPage(@PathVariable("showId") Integer showId, Model model) {

//		로그인 인증 필요
		List<TicketingDto> showDateList = ticketService.readShowDate(showId);
		model.addAttribute("showDateList", showDateList);
		model.addAttribute("showId", showId);
		
		List<TicketingDto> showInfo = ticketService.readShowInfoForTicketing(showId);
		model.addAttribute("title",showInfo.get(0).getTitle());

		return "/ticket/ticketing";
	}

	@PostMapping("/ticketing")
	public String ticketProc(TicketingDto ticketingDto) {

//		로그인 했다는 인증 필요

		return "";
	}

}
