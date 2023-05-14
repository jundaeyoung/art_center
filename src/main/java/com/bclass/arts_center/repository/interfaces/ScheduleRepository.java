	package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.RequestShowDto;
import com.bclass.arts_center.repository.model.Category;
import com.bclass.arts_center.repository.model.Show;

@Mapper
public interface ScheduleRepository {
	
	/**
	 * 김미정 : 공연장 위치 카테고리 
	 */
	public List<RequestShowDto.selectByCategory> findCategory(Integer showTypeId);
	
	// 공연정보
	public List<RequestShowDto.selectSchedule> selectByShow();
	
}
