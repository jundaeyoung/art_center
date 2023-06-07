package com.bclass.arts_center.controller;

import java.text.DecimalFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bclass.arts_center.controller.adminController.MessageApiController;
import com.bclass.arts_center.dto.payment.Amount;
import com.bclass.arts_center.dto.payment.KakaoApprovalResponse;
import com.bclass.arts_center.dto.payment.KakaoReadyResponse;
import com.bclass.arts_center.dto.payment.KakaoRefundResponse;
import com.bclass.arts_center.dto.payment.RequestPaymentInfoDto;
import com.bclass.arts_center.handler.exception.LoginException;
import com.bclass.arts_center.repository.model.ManagerPayment;
import com.bclass.arts_center.repository.model.Payment;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.KakaoPaymentService;
import com.bclass.arts_center.service.PaymentService;
import com.bclass.arts_center.service.RentPlaceReservationService;
import com.bclass.arts_center.service.TicketService;
import com.bclass.arts_center.utils.Define;

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

	@Autowired
	private MessageApiController messageApiController;

	
	@GetMapping("/ready")
	public String readyToKakaoPay(Integer ticketingId, Integer rentId, RedirectAttributes redirectAttributes) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		KakaoReadyResponse kakaoReadyResponse = null;
		if (principal == null) {
			throw new LoginException("로그인을 해주세요.", HttpStatus.BAD_REQUEST);
		}
		if (principal.getRoleId() == 1) {
			Integer sessionTicketingId = (Integer) session.getAttribute("ticketingId");
			if (sessionTicketingId != null) {
				kakaoReadyResponse = kakaoPaymentService.kakaoReady(sessionTicketingId);
			} else if (sessionTicketingId == null) {
				session.setAttribute("ticketingId", ticketingId);
				kakaoReadyResponse = kakaoPaymentService.kakaoReady(ticketingId);
			}

		} else if (principal.getRoleId() == 2) {
			session.setAttribute("rentId", rentId);
			kakaoReadyResponse = kakaoPaymentService.kakaoReady2(rentId);
		}
		return "redirect:" + kakaoReadyResponse.getNextRedirectPcUrl();
	}

	
	@GetMapping("/success")
	public String success(Integer ticketingId, @RequestParam(name = "pg_token", required = false) String pgToken,
			Model model) {
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
			// 문자 보내기
			try {
//				messageApiController.sendMessage(sessionTicketingId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ticketService.updateTicketStatus(principal.getId(), sessionTicketingId);
			paymentService.createPayment(payment);
			session.setAttribute("ticketingId", null);
		} else if (principal.getRoleId() == 2) {

			ManagerPayment managerPayment = new ManagerPayment();
			managerPayment.setManagerId(principal.getId());
			managerPayment.setMPaymentId(kakaoApprove.getTid());
			managerPayment.setPaymentOption(kakaoApprove.getPaymentMethodType());
			managerPayment.setPaymentDate(kakaoApprove.getApprovedAt());
			Integer rentId = (Integer) session.getAttribute("rentId");
			managerPayment.setRentId(rentId);
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

	
	@GetMapping("/refund/{tid}")
	public String refundCheck(@PathVariable(name = "tid", required = false) String tid, Model model,
			@RequestParam(name = "id", required = false) Integer id) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		if (principal.getRoleId() == 1) {
		} else if (principal.getRoleId() == 2) {
			KakaoRefundResponse result = paymentService.refundCheck(tid);
			model.addAttribute("kakaoRefundResponse", result);
		}

		return "/payment/refundCheck";
	}
	
	
	@PostMapping("/refund/{tid}")
	public String refund(@PathVariable(name = "tid", required = false) String tid, Model model,
			@RequestParam(name = "id", required = false) Integer id) {
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		
		KakaoRefundResponse kakaoRefundResponse = null;
		if (principal.getRoleId() == 1) {
			kakaoRefundResponse = kakaoPaymentService.kakaoRefund(principal.getId(), tid);
			paymentService.updateCancelStatus(kakaoRefundResponse.getCanceledAt(), tid);
		} else if (principal.getRoleId() == 2) {
			kakaoRefundResponse = kakaoPaymentService.kakaoRefund2(tid);
			paymentService.updateManagerCancelStatus(kakaoRefundResponse.getCanceledAt(), tid);
			rentPlaceReservationService.updateRentByStatus(id);
		}
		model.addAttribute("kakaoRefundResponse", kakaoRefundResponse);
		
		return "/payment/refund";
	}

}

