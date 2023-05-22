package com.bclass.arts_center.controller.managerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestQuestionDto;
import com.bclass.arts_center.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("")
	public String Admin() {
		return "admin/board";
	}
	
	@GetMapping("/userlist")
	public String User() {
		
		return "";
	}
	
	/*
	 * 전대영 : Question목록보기
	 */
	@GetMapping("/questionAll")
	public String QuestionAllList(Model model) {
		List<RequestQuestionDto> questionList = questionService.readQuestionAll();
		if (questionList.isEmpty()) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", questionList);
		}
		return "/admin/adminQuestion";
	}
	
	/*
	 * 전대영 : Question 답변 달기
	 */
	@GetMapping("/answer")
	public String createAnswer(Model model) {
		questionService.readQuestionAll();
		return "/admin/adminQuestion";
	}
	
	/*
	 * 전대영 : Question 삭제하기
	 */
	@GetMapping("/deleteQuestion/{questionId}")
	public String deleteQuestion(@PathVariable Integer questionId,Model model) {
		questionService.deleteQuestionByQuestionId(questionId);
		return "redirect:/admin/questionAll";
	}
}
