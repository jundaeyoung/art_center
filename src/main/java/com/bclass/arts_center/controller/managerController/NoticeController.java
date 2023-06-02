package com.bclass.arts_center.controller.managerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.service.NoticeService;

@Controller
@RequestMapping("/managerNotice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("/notice")
	public String notice() {
		return "/manager/managerNotice";
	}

	@GetMapping("/update/{id}")
	public String updateNotice(@PathVariable Integer id) {
		noticeService.updateNotice(id);
		return "redirect:/";
	}
}
