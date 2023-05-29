package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.repository.interfaces.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	/**
	 * 김미정 : 카테고리 별 데이터 불러오기
	 */
	@Transactional
	public List<RequestShowDto> selecctByCategory(Integer showTypeId) {
		List<RequestShowDto> list = scheduleRepository.selectByCategory(showTypeId);
		return list;

	}

	/**
	 * 김미정 : 전체 calendar 데이터 불러오기
	 */
	@Transactional
	public List<RequestShowDto> selectByShow() {
		List<RequestShowDto> list = scheduleRepository.selectByShow();
		return list;
	}

	/**
	 * 김미정 : calendar detail 정보 불러오기
	 */
	@Transactional
	public RequestShowDto selectByShowDetail(Integer id) {
		RequestShowDto list = scheduleRepository.selectByShowDetail(id);
		return list;
	}

	/**
	 * 전대영 : 내 스케줄 데이터 불러오기
	 */
	@Transactional
	public List<RequestShowDto> selectByMyShow(Integer id) {
		List<RequestShowDto> list = scheduleRepository.selectByMySchedule(id);
		return list;
	}

}