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
		List<Faq> faqListByCategory = faqService.readFaqCategory();
		List<Faq> faqList = faqService.readFaqAll();
		
		if (faqListByCategory == null || faqListByCategory.isEmpty()) {
			model.addAttribute("faqCategoryList", null);
		} else {
			model.addAttribute("faqCategoryList", faqListByCategory);
		}
		if (faqList == null || faqList.isEmpty()) {
			model.addAttribute("faqList", null);
		} else {
			model.addAttribute("faqList", faqList);
		}

		return "/announcement/faq";
	}

}

