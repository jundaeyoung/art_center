package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Faq;

@Mapper
public interface FaqRepository {

	public List<Faq> selectFaqCategory();

	public List<Faq> selectFaqAll();
	
	public List<Faq> selectFaqByCategoryId(Integer categoryId);

}
