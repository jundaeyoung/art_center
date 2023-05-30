package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.repository.model.Faq;
import com.bclass.arts_center.service.FaqService;

@Controller
@RequestMapping("/notice")
public class FaqController {

	@Autowired
	private FaqService faqService;

	@GetMapping("/faq")
	public String faq(Model model) {

		List<Faq> faqCategoryList = faqService.selectFaqCategory();
		model.addAttribute("faqCategoryList", faqCategoryList);

		List<Faq> faqList = faqService.selectAll();
		model.addAttribute("faqList", faqList);

		return "/announcement/faq";
	}

	@GetMapping("/faq/{categoryId}")
	public String faqByCategory(@PathVariable Integer categoryId, Model model) {

		List<Faq> faqCategoryList = faqService.selectFaqCategory();
		model.addAttribute("faqCategoryList", faqCategoryList);

		List<Faq> faqList = faqService.selectByCategoryId(categoryId);
		model.addAttribute("faqList", faqList);

		return "/announcement/faq";

	}

}
