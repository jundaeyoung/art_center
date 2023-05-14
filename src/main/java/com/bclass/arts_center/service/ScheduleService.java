package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.RequestShowDto;
import com.bclass.arts_center.repository.interfaces.ScheduleRepository;
import com.bclass.arts_center.repository.model.Category;
import com.bclass.arts_center.repository.model.Show;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	
	/**
	 * 김미정 공연장 위치 카테고리 
	 */
	@Transactional
	public List<RequestShowDto.selectByCategory> findCategory(Integer showTypeId) {
		List<RequestShowDto.selectByCategory> list = scheduleRepository.findCategory(showTypeId);
		return list;
		
	}
	
	// 공연정보 불러오기
	@Transactional
	public List<RequestShowDto.selectSchedule> selectByShow(){
		List<RequestShowDto.selectSchedule> list = scheduleRepository.selectByShow();
		return list;
	}
	
}