package com.bclass.arts_center.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.service.PaymentService;

@Controller
@RequestMapping("/pay")
public class PaymentController {

	@Autowired
	private HttpSession session;

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/payment/{ticketingId}")
	public String payTicket(@PathVariable int ticketingId) {

		session.setAttribute("ticketingId", ticketingId);

		return "/payment/payment";
	}

//	@PostMapping("/payment")
//	public String paymentSuccess() {
//		
//		
//		
//		
//		
//		
//		
//		
//
//		return "redirect:/payment/success";
//	}
}
