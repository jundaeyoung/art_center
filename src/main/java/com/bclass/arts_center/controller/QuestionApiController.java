package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.repository.model.Question;
import com.bclass.arts_center.service.QuestionService;

@RestController
public class QuestionApiController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("/api/qna/{categoryId}")
	public List<Question> readQuestionByCategory(@PathVariable Integer categoryId) {
		List<Question> questionListByCategory = questionService.readQuestionByCategory(categoryId);
		return questionListByCategory;
	}

}
