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


	@Transactional
	public List<RequestShowDto> readShowScheduleByCategory(Integer showTypeId) {
		List<RequestShowDto> showList = scheduleRepository.selectShowScheduleByCategory(showTypeId);
		
		return showList;
	}


	@Transactional
	public List<RequestShowDto> readShowSchedule() {
		List<RequestShowDto> showList = scheduleRepository.selectShowSchedule();
		
		return showList;
	}


	@Transactional
	public RequestShowDto readByShowDetail(Integer id) {
		RequestShowDto list = scheduleRepository.selectShowDetailByShowId(id);
		
		return list;
	}


	@Transactional
	public List<RequestShowDto> readMyShowSchedule(Integer id) {
		List<RequestShowDto> list = scheduleRepository.selectMyShowSchedule(id);
		
		return list;
	}

}

