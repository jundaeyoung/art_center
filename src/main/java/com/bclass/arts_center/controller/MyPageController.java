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
	
	@GetMapping("/info")
	public String myPage(Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		
		if(principal == null) {
			throw new CustomRestfullException("로그인 해주세요.", HttpStatus.BAD_REQUEST);
		}
		
		return "/user/myPage";
	}
	
	@GetMapping("/myShow/{organizerId}")
	public String selectMyShow(Model model, @PathVariable("organizerId") Integer organizerId) {
		
		List<RequestSignUpShowDto> myShowList = myPageService.selectMyShow(organizerId);
		model.addAttribute("myShowList",myShowList);
		
		return "/user/myShow";
	}
	
	@GetMapping("/showDetail/{id}")
	public String selectMyShowDetail(Model model, @PathVariable("id") Integer id) {
		List<RequestSignUpShowDto> detailList = myPageService.selectMyShowDetail(id);
		String title = detailList.get(0).getTitle();
		String content = detailList.get(0).getContent();
		String imgRoute = detailList.get(0).getImgRoute();
		model.addAttribute("title",title);
		model.addAttribute("content", content);
		model.addAttribute("imgRoute", imgRoute);
		return "/user/myShowDetail";
	}
	
	
}