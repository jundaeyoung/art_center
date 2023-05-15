package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.request.RequestQuestionDto;
import com.bclass.arts_center.repository.model.Question;

@Mapper
public interface QuestionRepository {

	/**
	 * 작성자 : 전대영 question 카테고리별 select
	 */
	public List<RequestQuestionDto> selectQuestionByType(@Param("category") String category,
			@Param("begin") Integer begin, @Param("range") Integer range);

	/**
	 * 작성자 : 전대영 question 카테고리별 Count
	 */
	public Integer selectQuestionCount(String category);

	/**
	 * 작성자 : 전대영 검색한 question select
	 */
	public List<RequestQuestionDto> selectQuestionBySearchText(@Param("searchText") String searchText,
			@Param("begin") Integer begin, @Param("range") Integer range);

	/**
	 * 작성자 : 전대영 검색한 question select count
	 */
	public Integer selectQuestionBySearchTextCount(String search);
	
	
	/**
	 * 작성자 : 전대영
	 * insert Qusetion
	 */
	public Integer insert(Question question);
	
	
	/**
	 * 작성자 : 전대영
	 * insert Qusetion
	 */
	public Integer deleteById(Integer id);
}
