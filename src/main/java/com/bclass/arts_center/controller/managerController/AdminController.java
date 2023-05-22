package com.bclass.arts_center.controller.managerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@GetMapping("")
	public String Admin() {
		return "admin/board";
	}
	
	@GetMapping("/userlist")
	public String User() {
		
		return "";
	}
}
