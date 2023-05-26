package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.repository.model.Faq;
import com.bclass.arts_center.service.FaqService;

@RestController
public class FaqApiController {

	@Autowired
	private FaqService faqService;

	@GetMapping("/api/selectFaq/{categoryId}")
	public List<Faq> selectFaq(@PathVariable Integer categoryId) {

		List<Faq> faqList = faqService.selectByCategoryId(categoryId);
		return faqList;
	}

}
