package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestSignUpShowDto;
import com.bclass.arts_center.service.MyPageService;
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
	
	@GetMapping("/info")
	public String myPage(Model model) {
		
		return "/user/myPage";
	}
	
	@GetMapping("/myShow/{organizerId}")
	public String selectMyShow(Model model, @PathVariable("organizerId") Integer organizerId) {
		List<RequestSignUpShowDto> myShowList = myPageService.selectMyShow(organizerId);
		model.addAttribute("myShowList",myShowList);
		return "/user/myShow";
	}
	
	
	
}
