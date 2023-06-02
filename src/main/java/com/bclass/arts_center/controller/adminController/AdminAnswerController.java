package com.bclass.arts_center.controller.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestQuestionDto;
import com.bclass.arts_center.repository.model.Answer;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.AnswerService;
import com.bclass.arts_center.service.QuestionService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/admin/answer")
public class AdminAnswerController {

	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private HttpSession session;

	@GetMapping("/select/{quetionId}")
	public String selectAnswers(@PathVariable Integer quetionId, Model model) {
		RequestQuestionDto question = questionService.readQuestionByQuestionId(quetionId);
		Answer answer = answerService.selectAnswerById(quetionId);
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		model.addAttribute("principal", principal);
		if (answer == null) {
			model.addAttribute("answer", null);
		} else {
			model.addAttribute("answer", answer);
		}
		if (question == null) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", question);
		}
		return "/admin/adminAnswerWrite";
	}

	@PostMapping("/create")
	public String createAnswer(String content, Integer userId, Integer questionId, Model model) {
		answerService.createAnswerById(content, userId, questionId);
		answerService.updateQuestionStatus(questionId);
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