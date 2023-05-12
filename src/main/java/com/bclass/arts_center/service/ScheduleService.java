package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bclass.arts_center.repository.interfaces.ScheduleRepository;
import com.bclass.arts_center.repository.model.Category;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public List<Category> findCategory(String showType) {
		showType = "%" + showType + "%";
		List<Category> list = scheduleRepository.findCategory(showType);
		return list;
		
	}
	
}