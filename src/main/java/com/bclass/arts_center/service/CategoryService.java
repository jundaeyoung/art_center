package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bclass.arts_center.repository.interfaces.CategoryRepository;
import com.bclass.arts_center.repository.model.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> readCategoryAll(){
		List<Category> categoryList = categoryRepository.selectCategoryAll();
		
		return categoryList;
	}
}
