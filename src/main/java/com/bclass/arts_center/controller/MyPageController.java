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

import com.bclass.arts_center.dto.MyRegistrationInfoDto;
import com.bclass.arts_center.dto.MyTicketDtailDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.MyTiketDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.Review;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.MyPageService;
import com.bclass.arts_center.service.ReviewService;
import com.bclass.arts_center.service.TicketService;
import com.bclass.arts_center.utils.Define;

/**
 * 
 * @김미정 : 나의 정보 페이지
 */
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

	/**
	 * @author 김미정
	 * @param model
	 * @return myPage
	 */
	@GetMapping("/info")
	public String myPage(Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		if (principal == null) {
			throw new CustomRestfullException("로그인 해주세요.", HttpStatus.BAD_REQUEST);
		}

		return "/user/myPage";
	}

	/**
	 * 공연 대관 내역 보기
	 * 
	 * @author 김미정
	 * @param model
	 * @param organizerId
	 * @return myShow
	 */
	@GetMapping("/myShow/{organizerId}")
	public String selectMyShow(Model model, @PathVariable("organizerId") Integer organizerId) {
		System.out.println("select 전");
		List<MyRegistrationInfoDto> myShowList = myPageService.selectMyShow(organizerId);
		System.out.println(myShowList);
		System.out.println("select 후 :" + myShowList.get(0).getMPaymentId());
		model.addAttribute("myShowList", myShowList);
		return "/user/myShow";
	}

	/**
	 * 공연, 대관 예약 상세보기
	 * 
	 * @author 김미정
	 * @param model
	 * @param id
	 * @return myShowDetail
	 */
	@GetMapping("/showDetail/{id}")
	public String selectMyShowDetail(Model model, @PathVariable Integer id) {

		List<MyRegistrationInfoDto> detailList = myPageService.selectMyShowDetail(id);
		model.addAttribute("detailList", detailList);
		return "/user/myShowDetail";
	}

	/**
	 * @author 손주이
	 * @param model
	 * @param userId
	 * @return myTicketList
	 */
	@GetMapping("/myTicket/{userId}")
	public String selectMyTicket(Model model, @PathVariable Integer userId) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		List<MyTicketDtailDto> myTicketList = myPageService.readMyTicketList(userId);
		if (myTicketList == null) {
			model.addAttribute("myTicketList", null);
		} else {
			model.addAttribute("myTicketList", myTicketList);
		}
		return "/user/myTicketList";
	}

	/**
	 * @author 손주이
	 * @param id
	 * @param model
	 * @return myTicketDetail
	 */
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
		model.addAttribute("myTicketList", myTicketList);
		return "/user/myTicketReview";
	}
	
	@PostMapping("/myReviewWrite")
	public String myReviewWrite(Integer showId, Review review) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		review.setUserId(principal.getId());
		int result = reviewService.saveReview(review);
		
		return "/user/myTicketReview";
	}
	
	@GetMapping("/myReviewShowType")
	public String myReviewShowType(String showType, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		MyTiketDto myTiketDto = new MyTiketDto();
		myTiketDto.setUserId(principal.getId());
		myTiketDto.setShowType(showType);
		List<MyTiketDto> myTicketList = reviewService.readMyReviewByShowType(myTiketDto);
		System.out.println(myTicketList);
		model.addAttribute("myTicketList", myTicketList);
		return "/user/myTicketReview";
	
	}

}
