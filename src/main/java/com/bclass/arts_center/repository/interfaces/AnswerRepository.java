package com.bclass.arts_center.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.repository.model.Answer;

@Mapper
public interface AnswerRepository {

	
	public Answer selectAnswer(Integer questionId);
	
	public Integer insertAnswer(@Param("userId") Integer userId, @Param("questionId") Integer questionId);
	
	public Integer updateQuestionStatus(Integer questionId);
	
	public Integer updateAnswer(@Param("content") String content, @Param("questionId") Integer questionId);
}
