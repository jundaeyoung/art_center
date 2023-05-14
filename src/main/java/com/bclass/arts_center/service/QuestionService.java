package com.bclass.arts_center.service;

import java.beans.Transient;
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
	
	@Transactional
	public Integer createQeustion(Question question) {
		int createResult = questionRepository.insert(question);
		return createResult;
	}
	
	@Transactional
	public Integer deleteQuestion(Integer id) {
		int deleteResult = questionRepository.deleteById(id);
		System.out.println(id);
		System.out.println(deleteResult);
		return deleteResult;
	}
}
