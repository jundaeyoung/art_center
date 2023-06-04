package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.service.ScheduleService;

@Controller
@RequestMapping("/")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	

	@GetMapping("/schedule")
	public String selectShowSchedule(Model model) {
		List<RequestShowDto> showList = scheduleService.readShowSchedule();
		model.addAttribute("lists", showList);
		
		return "/schedule";
	}
	

	@GetMapping("/schedule/category/{id}")
	public String selectShowScheduleByCategory(Model model, @PathVariable("id") Integer showTypeId) {
		List<RequestShowDto> showListByCategory = scheduleService.readShowScheduleByCategory(showTypeId);
		model.addAttribute("categoryLists", showListByCategory);
		
		return "/schedule";
	}
	
}
