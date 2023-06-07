package com.bclass.arts_center.controller;

import java.util.List;

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

import com.bclass.arts_center.dto.MyRegistrationInfoDto;
import com.bclass.arts_center.dto.MyTicketDtailDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.MyTiketDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.handler.exception.LoginException;
import com.bclass.arts_center.repository.model.Review;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.MyPageService;
import com.bclass.arts_center.service.ReviewService;
import com.bclass.arts_center.service.TicketService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/myPage")
public class MyPageController {

	@Autowired
	private HttpSession session;

	@Autowired
	private MyPageService myPageService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ReviewService reviewService;


	@GetMapping("/info")
	public String myPage(Model model) {
		
		return "/user/myPage";
	}


	@GetMapping("/myShow/{organizerId}/{currentPage}/{begin}/{range}")
	public String selectMyShow(@PathVariable("organizerId") Integer organizerId, @PathVariable("currentPage") Integer currentPage,
			@PathVariable("begin") Integer begin, @PathVariable("range") Integer range,Model model) {
		List<MyRegistrationInfoDto> myShowList = myPageService.readMyShow(organizerId, begin, range);
		Integer showCount = myPageService.readMyShowCount(organizerId);
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 5);
		Integer startPage = currentPage - 2;
		
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 4;
		if (endPage >= page) {
			endPage = page;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("myShowList", myShowList);
		model.addAttribute("organizerId", organizerId);
		model.addAttribute("principal", principal);
		
		return "/user/myShow";
	}


	@GetMapping("/showDetail/{id}")
	public String selectMyShowDetail(Model model, @PathVariable Integer id) {

		List<MyRegistrationInfoDto> detailList = myPageService.readMyShowDetail(id);
		model.addAttribute("detailList", detailList);
		
		return "/manager/myShowDetail";
	}


	@GetMapping("/myTicket/{userId}")
	public String selectMyTicket(Model model, @PathVariable Integer userId) {
		List<MyTicketDtailDto> myTicketList = myPageService.readMyTicket(userId);
		if (myTicketList == null) {
			model.addAttribute("myTicketList", null);
		} else {
			model.addAttribute("myTicketList", myTicketList);
		}
		
		return "/user/myTicketList";
	}


	@GetMapping("/myTicketDetail/{id}")
	public String ticketDetail(@PathVariable Integer id, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		model.addAttribute("userName", principal.getNickname());

		MyTicketDtailDto ticketInfo = myPageService.readMyTicketDetail(id);
		if (ticketInfo == null) {
			model.addAttribute("ticketInfo", null);
		} else {
			model.addAttribute("ticketInfo", ticketInfo);
		}

		return "/user/myTicketDetail";
	}
	

	@GetMapping("/myTicketReview")
	public String myTicketReview(Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		List<MyTiketDto> myTicketList = ticketService.readMyTicketByUserId(principal.getId());
		System.out.println(myTicketList);
		model.addAttribute("myTicketList", myTicketList);
		
		return "/user/myTicketReview";
	}
	

	@PostMapping("/myReviewWrite")
	public String myReviewWrite(Integer showId, Review review, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		review.setUserId(principal.getId());
		List<MyTiketDto> myTicketList = ticketService.readMyTicketByUserId(principal.getId());
		model.addAttribute("myTicketList", myTicketList);
		reviewService.saveReview(review);
		
		return "/user/myTicketReview";
	}
	

	@GetMapping("/myReviewShowType")
	public String myReviewShowType(String showType, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		MyTiketDto myTiketDto = new MyTiketDto();
		myTiketDto.setUserId(principal.getId());
		myTiketDto.setShowType(showType);
		List<MyTiketDto> myTicketList = reviewService.readMyReviewByShowType(myTiketDto);
		model.addAttribute("myTicketList", myTicketList);
		
		return "/user/myTicketReview";
	
	}
	
	@GetMapping("/rentRefund")
	public String rentRefund(Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		List<MyRegistrationInfoDto> myrentList = myPageService.readMyRentRefund(principal.getId());
		model.addAttribute("myrentList", myrentList);
		
		return "/user/rentRefund";
	}

}


