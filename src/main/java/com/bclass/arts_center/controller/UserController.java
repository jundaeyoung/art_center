package com.bclass.arts_center.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	@PostMapping("/loginProc")
	public String loginProc(User user) {
		userService.login(user);
		session.setAttribute("username", user.getUserName());
		session.setAttribute("password", user.getPassword());
		System.out.println(session);
		return "redirect:/";
	}
}
