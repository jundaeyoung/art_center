package com.bclass.arts_center.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.payment.KakaoApprovalResponse;
import com.bclass.arts_center.dto.payment.KakaoReadyResponse;
import com.bclass.arts_center.dto.payment.KakaoRefundResponse;
import com.bclass.arts_center.repository.model.Payment;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.KakaoPaymentService;
import com.bclass.arts_center.service.PaymentService;
import com.bclass.arts_center.service.TicketService;
import com.bclass.arts_center.utils.Define;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

/**
 * 
 * @author 손주이
 *
 */
@Controller
@RequestMapping("/kakao")
public class KakaoPaymentController {

	@Autowired
	private HttpSession session;

	@Autowired
	private KakaoPaymentService kakaoPaymentService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private TicketService ticketService;

	@PostMapping("/ready")
	public String readyToKakaoPay() {
		KakaoReadyResponse kakaoReadyResponse = kakaoPaymentService.kakaoReady();
		return "redirect:" + kakaoReadyResponse.getNextRedirectPcUrl();
	}

	@GetMapping("/success")
	public String success(@RequestParam("pg_token") String pgToken, Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		KakaoApprovalResponse kakaoApprove = kakaoPaymentService.kakaoApprove(pgToken);
		model.addAttribute("kakaoApprove", kakaoApprove);
		Payment payment = new Payment();
		payment.setUserId(principal.getId());
		payment.setPaymentId(kakaoApprove.getTid());
		payment.setPaymentOption(kakaoApprove.getPaymentMethodType());
		payment.setPaymentDate(kakaoApprove.getApprovedAt());
		Integer sessionTicketingId = (Integer) session.getAttribute("ticketingId");
		payment.setTicketingId(sessionTicketingId);

		System.out.println(payment);
		ticketService.updateTicketStatus(principal.getId(), sessionTicketingId);
		paymentService.createPayment(payment);

		return "/payment/success";
	}

	@GetMapping("/cancel")
	public String cancel() {

		return "/payment/cancel";

	}

	@GetMapping("/fail")
	public String fail() {

		return "/payment/fail";
	}

	@PostMapping("/refund")
	public ResponseEntity<?> refund() {

		KakaoRefundResponse kakaoRefundResponse = kakaoPaymentService.kakaoRefund();

		return new ResponseEntity<>(kakaoRefundResponse, HttpStatus.OK);
	}
}
