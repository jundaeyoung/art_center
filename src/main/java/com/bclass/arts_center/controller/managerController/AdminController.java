package com.bclass.arts_center.controller.managerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.UserService;

/**
 * 
 * @author 편용림
 *
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	// 메인화면
	@GetMapping("")
	public String Admin() {
		return "admin/board";
	}
	
	/*
	 * 편용림
	 * 유저 목록
	 */
	@GetMapping("/userList")
	public String UserList(Model model) {
		System.out.println("1111111");
		List<User> userList = userService.readUser();
		System.out.println(userList);
		model.addAttribute("userList", userList);
		return "admin/userList";
	}
}
