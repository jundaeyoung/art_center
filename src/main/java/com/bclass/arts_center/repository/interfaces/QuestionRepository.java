package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.request.RequestQuestionDto;
import com.bclass.arts_center.repository.model.Question;

@Mapper
public interface QuestionRepository {

	public List<RequestQuestionDto> selectQuestionByType(@Param("category") String category,
			@Param("begin") Integer begin, @Param("range") Integer range);

	public Integer selectQuestionCount(String category);

	public List<RequestQuestionDto> selectQuestionBySearchText(@Param("searchText") String searchText,
			@Param("begin") Integer begin, @Param("range") Integer range);

	public Integer selectQuestionBySearchTextCount(String search);
	
	public Integer insert(Question question);
	
	public Integer deleteById(Integer id);
	
	public List<RequestQuestionDto> selectQuestionAll();
	
	public RequestQuestionDto selectQuestionByQuestionId(Integer questionId);
	
	public Integer deleteQuestionByQuestionId(Integer questionId);
}
