package com.bclass.arts_center.controller;

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
import com.bclass.arts_center.service.KakaoPaymentService;

/**
 * 
 * @author 손주이
 *
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private KakaoPaymentService kakaoPaymentService;

	@PostMapping("/ready")
	public String readyToKakaoPay() {
		KakaoReadyResponse kakaoReadyResponse = kakaoPaymentService.kakaoReady();
		return "redirect:" + kakaoReadyResponse.getNextRedirectPcUrl();
	}

	@GetMapping("/success")
	public String success(@RequestParam("pg_token") String pgToken, Model model) {

		KakaoApprovalResponse kakaoApprove = kakaoPaymentService.kakaoApprove(pgToken);
		model.addAttribute("kakaoApprove", kakaoApprove);

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
