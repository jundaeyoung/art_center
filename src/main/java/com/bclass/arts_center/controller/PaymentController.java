package com.bclass.arts_center.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.service.PaymentService;
import com.bclass.arts_center.service.TicketService;

@Controller
@RequestMapping("/pay")
public class PaymentController {

	@Autowired
	private HttpSession session;
	@Autowired
	private TicketService ticketService;

	@GetMapping("/payment/{ticketingId}")
	public String payTicket(@PathVariable int ticketingId,Model model) {
		TicketCheckDto ticket = ticketService.checkTicketForPay(ticketingId);
		session.setAttribute("ticketingId", ticketingId);
		if(ticket==null) {
			model.addAttribute("ticket", null);
		}else {
			model.addAttribute("ticket", ticket);
		}
		return "/payment/payment";
	}

}
