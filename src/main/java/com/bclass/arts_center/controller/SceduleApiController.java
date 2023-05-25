package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.RequestShowDto;
import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.service.ScheduleService;
import com.bclass.arts_center.service.ShowService;

@RestController
public class SceduleApiController {

	@Autowired
	private ScheduleService scheduleService;
	
	
	 @Autowired private ShowService showService;
	
	
	/**
	 * 김미정 : calendar show detail 정보 불러오기
	 */
	@GetMapping("/api/scheduleDetail/{id}")
	public RequestShowDto.selectByShowDetail selectByShowDetail(@PathVariable Integer id, Model model) {
		RequestShowDto.selectByShowDetail selectByShowDetail = scheduleService.selectByShowDetail(id);
		
		 List<ShowViewDto> showInfo = showService.readShowInfoByShowId(id);
		 model.addAttribute("showInfo",showInfo);
		 
		return selectByShowDetail;
	}
	
}
