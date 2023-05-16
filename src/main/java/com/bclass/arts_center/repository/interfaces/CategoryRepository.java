package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Category;

@Mapper
public interface CategoryRepository {

	public List<Category> selectCategoryAll();
}
