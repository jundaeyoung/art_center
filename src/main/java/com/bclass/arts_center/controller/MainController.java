package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.repository.model.Show;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.MainService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private MainService mainService;
	@Autowired
	private HttpSession session;

	/*
	 * 전대영 main에서 공연정보 불러오기
	 */
	@GetMapping("/")
	public String main(Model model) {
		List<Show> showsList = mainService.readShowDto();
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		if (principal == null) {
			model.addAttribute("userInfo", null);
		} else {
			model.addAttribute("userInfo", principal);
		}
		if (showsList.isEmpty()) {
			model.addAttribute("showsList", null);
		} else {
			model.addAttribute("showsList", showsList);
		}
		return "/main";
	}
}
