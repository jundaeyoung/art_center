package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.repository.interfaces.FaqRepository;
import com.bclass.arts_center.repository.model.Faq;

@Service
public class FaqService {

	@Autowired
	private FaqRepository faqRepository;

	@Transactional
	public List<Faq> selectFaqCategory() {
		List<Faq> faqCategoryList = faqRepository.selectFaqCategory();
		return faqCategoryList;
	}

	@Transactional
	public List<Faq> selectAll() {
		List<Faq> faqList = faqRepository.selectFaqAll();
		return faqList;
	}
}
