package com.bclass.arts_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.RequestShowDto;
import com.bclass.arts_center.service.ScheduleService;

@RestController
public class SceduleApiController {

	@Autowired
	ScheduleService scheduleService;
	
	/**
	 * 김미정 : calendar show detail 정보 불러오기
	 */
	@GetMapping("/api/scheduleDetail/{id}")
	public RequestShowDto.selectByShowDetail selectByShowDetail(@PathVariable Integer id) {
		RequestShowDto.selectByShowDetail selectByShowDetail = scheduleService.selectByShowDetail(id);
		return selectByShowDetail;
	}
}
