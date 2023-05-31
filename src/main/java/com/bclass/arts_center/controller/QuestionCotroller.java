package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.request.RequestQuestionDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.Question;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.QuestionService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/quest")
public class QuestionCotroller {

	@Autowired
	private HttpSession session;

	@Autowired
	private QuestionService questionService;

	@GetMapping("/")
	public String question(Model model) {
		String searchText = "";
		Integer begin = 0;
		Integer range = 5;
		Integer currentPage = 1;
		List<RequestQuestionDto> questionList = questionService.readQuestionBySearchText(searchText, begin, range);
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer questionCount = questionService.readQuestionBySearchTextCount(searchText);
		Double count = Math.ceil(questionCount);
		Integer page = (int) Math.ceil(count / 5);
		Integer startPage = currentPage - 2;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 4;
		if (endPage >= page) {
			endPage = page;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("principal", principal);
		if (principal == null) {
			model.addAttribute("userInfo", null);
		} else {
			model.addAttribute("userInfo", principal);
		}
		if (questionList.isEmpty()) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", questionList);
		}
		model.addAttribute("searchText", searchText);
		return "/question/question";
	}

	/*
	 * 작성자 : 전대영 question type 별로 select하기
	 */
	@GetMapping("/info")
	public String infoQeustion(@RequestParam(required = false) String category,
			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, Model model) {

		List<RequestQuestionDto> questionList = questionService.readQuestionByType(category, begin, range);
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer questionCount = questionService.readQuestionCount(category);
		Double count = Math.ceil(questionCount);
		Integer page = (int) Math.ceil(count / 5);
		Integer startPage = currentPage - 2;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 4;
		if (endPage >= page) {
			endPage = page;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("principal", principal);
		if (principal == null) {
			model.addAttribute("userInfo", null);
		} else {
			model.addAttribute("userInfo", principal);
		}
		if (questionList.isEmpty()) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", questionList);
		}
		model.addAttribute("category", category);
		return "/question/question";
	}

	/*
	 * 작성자 : 전대영 question 검색한 값으로 select 하기
	 */
	@GetMapping("/search")
	public String serachQuestion(String searchText, Integer currentPage, Integer begin, Integer range, Model model) {
		List<RequestQuestionDto> questionList = questionService.readQuestionBySearchText(searchText, begin, range);
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer questionCount = questionService.readQuestionBySearchTextCount(searchText);
		Double count = Math.ceil(questionCount);
		Integer page = (int) Math.ceil(count / 5);
		Integer startPage = currentPage - 2;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 4;
		if (endPage >= page) {
			endPage = page;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("principal", principal);
		model.addAttribute("searchText", searchText);
		if (principal == null) {
			model.addAttribute("userInfo", null);
		} else {
			model.addAttribute("userInfo", principal);
		}
		if (questionList.isEmpty()) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", questionList);
		}
		return "/question/question";
	}

	/*
	 * 작성자 : 전대영 question insert하기
	 */
	@PostMapping("/insert")
	public String writeQuestion(Question question) {
		//System.out.println(question.getQuestionTypeId());
		if (question.getTitle() == null || question.getTitle().isEmpty()) {
			throw new CustomRestfullException("제목을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (question.getQuestionTypeId() == null) {
			throw new CustomRestfullException("카테고리를 선택해주세요", HttpStatus.BAD_REQUEST);
		}
		if (question.getContent() == null || question.getContent().isEmpty()) {
			throw new CustomRestfullException("내용을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		questionService.createQeustion(question);
		return "redirect:/quest/";
	}

	@GetMapping("/delete")
	public String deleteQuestion(Integer id) {
		questionService.deleteQuestion(id);
		return "redirect:/quest/";
	}

}
