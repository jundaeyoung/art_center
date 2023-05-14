package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.RequestShowDto;
import com.bclass.arts_center.repository.model.Category;
import com.bclass.arts_center.repository.model.Show;
import com.bclass.arts_center.service.ScheduleService;

@Controller
@RequestMapping("/")
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	/**
	 * 김미정 : schedule 페이지  
	 */
	@GetMapping("/schedule")
	public String schedule(Model model) {
		List<RequestShowDto.selectSchedule> lists = scheduleService.selectByShow();
		model.addAttribute("lists", lists);
		return "/schedule";
	}
	
	
	/**
	 * 김미정 : 공연장 위치 카테고리
	 */
	@GetMapping("/schedule/category/{id}")
	public String findCategory(Model model, @PathVariable("id") Integer showTypeId) {
		List<RequestShowDto.selectByCategory> categoryLists = scheduleService.findCategory(showTypeId);
		model.addAttribute("categoryLists", categoryLists);
		return "/schedule";
	}
	
	
}
