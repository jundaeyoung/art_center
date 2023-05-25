package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.RequestShowDto;
import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.service.ScheduleService;
import com.bclass.arts_center.service.ShowService;

@Controller
@RequestMapping("/")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	/**
	 * 김미정 : schedule 페이지 데이터 불러오기 
	 */
	@GetMapping("/schedule")
	public String selectByShow(Model model) {
		List<RequestShowDto.selectByShow> lists = scheduleService.selectByShow();
		model.addAttribute("lists", lists);
		return "/schedule";
	}
	
	
	/**
	 * 김미정 : 공연장 위치 카테고리 별 데이터 불러오기
	 */
	@GetMapping("/schedule/category/{id}")
	public String selectByCategory(Model model, @PathVariable("id") Integer showTypeId) {
		List<RequestShowDto.selectByCategory> categoryLists = scheduleService.selecctByCategory(showTypeId);
		model.addAttribute("categoryLists", categoryLists);
		return "/schedule";
	}
	
}
