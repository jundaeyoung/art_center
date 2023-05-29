package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.MyRegistrationInfoDto;
import com.bclass.arts_center.dto.MyTicketDtailDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.MyPageService;
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

	/**
	 * 마이페이지 
	 * @param 김미정
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
	 * @param 김미정
	 */
	@GetMapping("/myShow/{organizerId}")
	public String selectMyShow1(Model model, @PathVariable("organizerId") Integer organizerId) {
		List<MyRegistrationInfoDto> myShowList = myPageService.selectMyShow2(organizerId);
		model.addAttribute("myShowList",myShowList);
		
		return "/user/myShow";
	}
	
	/**
	 * 공연, 대관 예약 상세보기 
	 * @param 김미정
	 */
	@GetMapping("/showDetail/{id}")
	public String selectMyShowDetail1(Model model, @PathVariable Integer id) {
		List<MyRegistrationInfoDto> detailList = myPageService.selectMyShowDetail2(id);
		model.addAttribute("detailList",detailList);
		return "/user/myShowDetail";
	}


	/**
	 * @author 손주이
	 * @param model
	 * @param userId
	 * @return
	 */
	@GetMapping("/myTicket/{userId}")
	public String selectMyTicket(Model model, @PathVariable Integer userId) {

		List<TicketCheckDto> myTicketList = myPageService.readMyTicketList(userId);
		model.addAttribute("myTicketList", myTicketList);
		return "/user/myTicketList";
	}

	/**
	 * @author 손주이
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/myTicketDetail/{id}")
	public String ticketDetail(@PathVariable Integer id, Model model) {
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		model.addAttribute("userName", principal.getNickname());

		MyTicketDtailDto ticketInfo = myPageService.readMyTicketDetail(id);
		System.out.println(ticketInfo);
		if (ticketInfo == null) {
			model.addAttribute("ticketInfo", null);
		} else {
			model.addAttribute("ticketInfo", ticketInfo);
		}

		return "/user/myTicketDetail";
	}

}
