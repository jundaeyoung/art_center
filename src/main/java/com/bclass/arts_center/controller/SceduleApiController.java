package com.bclass.arts_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.dto.response.ResponseDto;
import com.bclass.arts_center.service.ScheduleService;

@RestController
public class SceduleApiController {

	@Autowired
	private ScheduleService scheduleService;

	/**
	 * 김미정 : calendar show detail 정보 불러오기
	 */
	@GetMapping("/api/scheduleDetail/{id}")
	public ResponseDto<RequestShowDto> selectByShowDetail(@PathVariable Integer id) {
		RequestShowDto selectByShowDetail = scheduleService.readByShowDetail(id);
		
		return new ResponseDto<RequestShowDto>(200, HttpStatus.OK.toString(), selectByShowDetail);
	}

}
