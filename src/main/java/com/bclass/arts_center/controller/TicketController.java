package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.TicketService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private HttpSession session;

	@GetMapping("/ticketing/{showId}")
	public String ticketingPage(@PathVariable("showId") Integer showId, Model model) {

//		로그인 인증 필요
		List<TicketingDto> showDateList = ticketService.readShowDate(showId);
		model.addAttribute("showDateList", showDateList);
		model.addAttribute("showId", showId);

		List<TicketingDto> showInfo = ticketService.readShowInfoForTicketing(showId);
		model.addAttribute("title", showInfo.get(0).getTitle());

		return "/ticket/ticketing";
	}

	@PostMapping("/ticketing")
	public String ticketProc(TicketingDto ticketingDto) {
//		로그인 했다는 인증 필요

		User principal = (User) session.getAttribute(Define.PRINCIPAL);
//
//		System.out.println(ticketingDto.getShowId() + "showId");
//		System.out.println(ticketingDto.getSeatId() + "showSEat");
//		System.out.println(ticketingDto.getShowDateTimeId() + "dateTime");

		ticketingDto.setUserId(principal.getId());

//		System.out.println(ticketingDto.getUserId());
		ticketService.waitTicket(ticketingDto);

//		if()

		return "redirect:/ticket/ticketCheck";
	}

	@GetMapping("/ticketCheck")
	public String ticketCheck(Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		List<TicketCheckDto> ticketListInfo = ticketService.checkTicket(principal.getId());
		model.addAttribute("ticketListInfo", ticketListInfo);

		return "/ticket/ticketCheck";
	}

	@GetMapping("/payment")
	public String payTicket() {

		return "/pay/payment";
	}

}

/*
 * 선생님,,저는 잘 모르겠어요,,
 * 
 * @PostMapping("/a/a/")
 * 
 * @Resource // 주이양 !! 이거는 데이터를 리턴하겠다는 표시 입니다 !!!! public String
 * test1(@RequestBody String a) {
 * 
 * // 인증검사 // 유효성 검사
 * 
 * // 서비스 호출 -- 데이터 처리 및 트랜잭션 처리
 * 
 * // 응답 적절하게 내려주기 return "{'a' : a}"; }
 */