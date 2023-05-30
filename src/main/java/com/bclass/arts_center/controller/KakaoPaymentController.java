package com.bclass.arts_center.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bclass.arts_center.dto.payment.KakaoApprovalResponse;
import com.bclass.arts_center.dto.payment.KakaoReadyResponse;
import com.bclass.arts_center.dto.payment.KakaoRefundResponse;
import com.bclass.arts_center.repository.model.ManagerPayment;
import com.bclass.arts_center.repository.model.Payment;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.KakaoPaymentService;
import com.bclass.arts_center.service.PaymentService;
import com.bclass.arts_center.service.RentPlaceReservationService;
import com.bclass.arts_center.service.TicketService;
import com.bclass.arts_center.utils.Define;

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

	@Autowired
	private RentPlaceReservationService rentPlaceReservationService;

	@GetMapping("/ready")
	public String readyToKakaoPay(Integer rentId, RedirectAttributes redirectAttributes) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		KakaoReadyResponse kakaoReadyResponse = null;
		if (principal.getRoleId() == 1) {
			Integer sessionTicketingId = (Integer) session.getAttribute("ticketingId");
			kakaoReadyResponse = kakaoPaymentService.kakaoReady(sessionTicketingId);

		} else if (principal.getRoleId() == 2) {
			kakaoReadyResponse = kakaoPaymentService.kakaoReady2(rentId);
			session.setAttribute("rentId", rentId);
		}
		return "redirect:" + kakaoReadyResponse.getNextRedirectPcUrl();
	}

	@GetMapping("/success")
	public String success(@RequestParam("pg_token") String pgToken, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		KakaoApprovalResponse kakaoApprove = kakaoPaymentService.kakaoApprove(pgToken);
		model.addAttribute("kakaoApprove", kakaoApprove);

		if (principal.getRoleId() == 1) {

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

		} else if (principal.getRoleId() == 2) {

			ManagerPayment managerPayment = new ManagerPayment();
			managerPayment.setManagerId(principal.getId());
			managerPayment.setMPaymentId(kakaoApprove.getTid());
			managerPayment.setPaymentOption(kakaoApprove.getPaymentMethodType());
			managerPayment.setPaymentDate(kakaoApprove.getApprovedAt());
			// 여기에 렌트 예약한 id 받을 예정
			Integer rentId = (Integer) session.getAttribute("rentId");
			managerPayment.setRentId(rentId);
			// 렌트 아이디 받아가지고 status 업데이트
			rentPlaceReservationService.updateRentPlaceReservation(rentId);
			paymentService.createManagerPayment(managerPayment);
		}
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

	@PostMapping("/refund/{tid}")
	public String refund(@PathVariable String tid) {

		KakaoRefundResponse kakaoRefundResponse = kakaoPaymentService.kakaoRefund(tid);

		return "/payment/refund";
	}
}