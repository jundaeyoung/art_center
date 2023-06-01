package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestQuestionDto;
import com.bclass.arts_center.repository.interfaces.QuestionRepository;
import com.bclass.arts_center.repository.model.Question;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	/**
	 * 작성자 : 전대영 quetion select
	 */
	@Transactional
	public List<RequestQuestionDto> readQuestionByType(String category, Integer begin, Integer range) {
		List<RequestQuestionDto> questionList = questionRepository.selectQuestionByType(category, begin, range);
		return questionList;
	}


	/*
	 * 작성자 : 전대영 question Count
	 */
	@Transactional
	public Integer readQuestionCount(String category) {
		Integer questionCount = questionRepository.selectQuestionCount(category);
		return questionCount;
	}

	/**
	 * 작성자 : 전대영 quetion 검색한값으로 select
	 */
	@Transactional
	public List<RequestQuestionDto> readQuestionBySearchText(String searchText, Integer begin, Integer range) {
		searchText = "%" + searchText + "%";
		List<RequestQuestionDto> questionList = questionRepository.selectQuestionBySearchText(searchText,begin,range);
		return questionList;
	}
	
	/**
	 * 작성자 : 전대영 quetion 검색한값으로 select count
	 */
	@Transactional
	public Integer readQuestionBySearchTextCount(String searchText) {
		String search = "%" + searchText + "%";
		Integer searchCount = questionRepository.selectQuestionBySearchTextCount(search);
		return searchCount;
	}
	
	/*
	 * 전대영 : 질문 적기
	 */
	@Transactional
	public Integer createQeustion(Question question) {
		int createResult = questionRepository.insert(question);
		return createResult;
	}
	/*
	 * 전대영 : 질문 삭제하기
	 */
	@Transactional
	public Integer deleteQuestion(Integer id) {
		int deleteResult = questionRepository.deleteById(id);
		System.out.println(id);
		System.out.println(deleteResult);
		return deleteResult;
	}
	
	
	/**
	 * 작성자 : 전대영 quetion All select
	 */
	@Transactional
	public List<RequestQuestionDto> readQuestionAll() {
		List<RequestQuestionDto> questionList = questionRepository.selectQuestionAll();
		return questionList;
	}
	
	/**
	 * 작성자 : 전대영 quetion 하나씩 select
	 */
	@Transactional
	public RequestQuestionDto readQuestionByQuestionId(Integer questionId) {
		RequestQuestionDto question = questionRepository.selectQuestionByQuestionId(questionId);
		return question;
	}
	
	/**
	 * 작성자 : 전대영 quetion 하나씩 delete
	 */
	@Transactional
	public Integer deleteQuestionByQuestionId(Integer questionId) {
		Integer result = questionRepository.deleteQuestionByQuestionId(questionId);
		return result;
	}
	
	/**
	 * @author 손주이
	 * @param question
	 * @return questionListByCategory
	 */
	@Transactional
	public List<Question> readQuestionByCategory(Integer categoryId) {
		List<Question> questionListByCategory = questionRepository.selectQuestionByCategory(categoryId);
		return questionListByCategory;
	}
}
