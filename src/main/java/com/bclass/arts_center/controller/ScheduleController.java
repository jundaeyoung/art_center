package com.bclass.arts_center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ScheduleController {
	
	@GetMapping("/schedule")
	public String schedule() {
		return "/schedule";
	}
	

}
