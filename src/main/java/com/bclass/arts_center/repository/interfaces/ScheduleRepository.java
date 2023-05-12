package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Category;

@Mapper
public interface ScheduleRepository {
	
	// 카테고리 구분
	public List<Category> findCategory(String showType);
	
}
