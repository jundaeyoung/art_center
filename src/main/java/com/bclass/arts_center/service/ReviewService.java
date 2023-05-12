package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestReviewDto;
import com.bclass.arts_center.repository.interfaces.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	/**
	 * 작성자 : 전대영 리뷰 최신순으로 select
	 */
	@Transactional
	public List<RequestReviewDto> readReviewByNewest(Integer begin, Integer range) {
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByNewest(begin, range);

		return reviewList;
	}

	/**
	 * 작성자 : 전대영 리뷰 최신순 Count
	 */
	@Transactional
	public Integer readReviewByNewestCount() {
		Integer reviewNewestCount = reviewRepository.selectReviewByNewestCount();

		return reviewNewestCount;
	}
}
