package com.bclass.arts_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.repository.interfaces.AnswerRepository;
import com.bclass.arts_center.repository.model.Answer;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository; 
	
	
	@Transactional
	public Answer readAnswerById(Integer quetionId) {
		Answer result = answerRepository.selectAnswer(quetionId);
		
		return result;
	}
	
	
	@Transactional
	public Integer createAnswerById(String content,Integer userId, Integer quetionId) {
		Integer result = answerRepository.insertAnswer(content,userId, quetionId);
		
		return result;
	}
	
	
	@Transactional
	public Integer updateQuestionStatus(Integer quetionId) {
		Integer result = answerRepository.updateQuestionStatus(quetionId);
		
		return result;
	}
	
	
	@Transactional
	public Integer updateAnswer(String content,Integer questionId) {
		Integer result = answerRepository.updateAnswer(content,questionId);
		
		return result;
	}
}
