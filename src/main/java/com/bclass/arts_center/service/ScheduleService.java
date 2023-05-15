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
	 * 김미정 : 카테고리 별 데이터 불러오기
	 */
	@Transactional
	public List<RequestShowDto.selectByCategory> selecctByCategory(Integer showTypeId) {
		List<RequestShowDto.selectByCategory> list = scheduleRepository.selectByCategory(showTypeId);
		return list;
		
	}
	
	/**
	 * 김미정 : 전체 calendar 데이터 불러오기
	 */
	@Transactional
	public List<RequestShowDto.selectByShow> selectByShow(){
		List<RequestShowDto.selectByShow> list = scheduleRepository.selectByShow();
		return list;
	}
	
	/**
	 * 김미정 : calendar detail 정보 불러오기
	 */
	@Transactional
	public RequestShowDto.selectByShowDetail selectByShowDetail(Integer id){
		RequestShowDto.selectByShowDetail list = scheduleRepository.selectByShowDetail(id);
		return list;
	}
	
}