package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.repository.model.Category;
import com.bclass.arts_center.service.ScheduleService;

@Controller
@RequestMapping("/")
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping("/schedule")
	public String schedule() {
		return "/schedule";
	}
	
	// 공연장페이지  카테고리
	@GetMapping("/category")
	public String findCategory(Model model, @RequestParam(name="type") String type) {
		List<Category> list = scheduleService.findCategory(type);
		model.addAttribute("list",list);
		return "/schedule";
	}
}
