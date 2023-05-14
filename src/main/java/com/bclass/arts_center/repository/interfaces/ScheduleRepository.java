	package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.RequestShowDto;
import com.bclass.arts_center.repository.model.Category;
import com.bclass.arts_center.repository.model.Show;

@Mapper
public interface ScheduleRepository {
	
	/**
	 * 김미정 : 카테고리 별 데이터 불러오기
	 */
	public List<RequestShowDto.selectByCategory> selectByCategory(Integer showTypeId);
	
	/**
	 * 김미정 : calendar 전체 데이터 불러오기
	 */
	public List<RequestShowDto.selectByShow> selectByShow();
	
}
