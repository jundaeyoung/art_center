package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.Show;
import com.bclass.arts_center.service.MainService;
import com.bclass.arts_center.service.TicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	private TicketService ticketService;


	@GetMapping("/ticketing")
	public String ticketingPage(Model model) {

//		공연 정보 불러와서 공연 제목 날짜 뿌리기
		List<Show> showList = ticketService.readShowInfo();
		if(showList.isEmpty()) {
			model.addAttribute("showList",null);
		} else {
			model.addAttribute("showList", showList);
		}

		return "/ticket/ticketing";
	}

	@PostMapping("/ticketing")
	public String ticketProc(TicketingDto ticketingDto) {

//		로그인 했다는 인증 필요

		if (ticketingDto.getShowTitle() == null || ticketingDto.getShowTitle().isEmpty()) {
			throw new CustomRestfullException("관람하실 공연을 선택해 주세요", HttpStatus.BAD_REQUEST);
		}

		if (ticketingDto.getShowDate() == null) {
			throw new CustomRestfullException("시간을 선택해 주세요", HttpStatus.BAD_REQUEST);
		}
		return "";
	}

}
