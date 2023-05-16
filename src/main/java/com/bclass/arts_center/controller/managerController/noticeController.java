package com.bclass.arts_center.controller.managerController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class NoticeController {

	@GetMapping("/notice")
	public String notice(Model model) {
		
		return "/manager/notice";
	}
}
