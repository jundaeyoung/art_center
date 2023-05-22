package com.bclass.arts_center.controller.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestQuestionDto;
import com.bclass.arts_center.repository.model.Answer;
import com.bclass.arts_center.service.AnswerService;
import com.bclass.arts_center.service.QuestionService;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuestionService questionService;

	@GetMapping("/select/{quetionId}")
	public String selectAnswers(@PathVariable Integer quetionId, Model model) {
		RequestQuestionDto question = questionService.readQuestionByQuestionId(quetionId);
		Answer answer = answerService.selectAnswerById(quetionId);
		model.addAttribute("answer", answer);
		if (question == null) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", question);
		}
		return "/admin/adminAnswerWrite";
	}

	@GetMapping("/create/{userId}/{quetionId}")
	public String createAnswer(@PathVariable Integer userId, @PathVariable Integer quetionId, Model model) {
		answerService.createAnswerById(userId, quetionId);
		answerService.updateQuestionStatus(quetionId);
		List<RequestQuestionDto> questionList = questionService.readQuestionAll();
		if (questionList.isEmpty()) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", questionList);
		}
		return "/admin/adminQuestion";
	}

	@GetMapping("/update/{questionId}")
	public String updateAnswer(String content, @PathVariable Integer questionId, Model model) {
		answerService.updateAnswer(content, questionId);
		List<RequestQuestionDto> questionList = questionService.readQuestionAll();
		if (questionList.isEmpty()) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", questionList);
		}
		return "/admin/adminQuestion";
	}
}
