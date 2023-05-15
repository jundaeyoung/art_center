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
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.service.ShowService;
import com.bclass.arts_center.service.TicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private ShowService showService;

	@GetMapping("/ticketing/{id}")
	public String ticketingPage(Model model, @PathVariable Integer id) {

//		공연 정보 불러와서 공연 제목 날짜 뿌리기
		List<RequestShowDto> showTimeInfo = showService.readShowTimesByShowId(id);
		if (showTimeInfo.isEmpty()) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("showList", showTimeInfo);
		}

		return "/ticket/ticketing";
	}

	@PostMapping("/ticketing")
	public String ticketProc(TicketingDto ticketingDto) {

//		로그인 했다는 인증 필요

		return "";
	}

}
