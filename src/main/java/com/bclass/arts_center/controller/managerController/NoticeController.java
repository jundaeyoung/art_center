package com.bclass.arts_center.controller.managerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/managerNotice")
public class NoticeController {

	
	@GetMapping("/notice")
	public String notice() {
		
		return "/manager/managerNotice";
	}
}
