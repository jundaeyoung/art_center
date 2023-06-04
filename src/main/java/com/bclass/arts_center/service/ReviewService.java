package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.MyTiketDto;
import com.bclass.arts_center.dto.request.RequestReviewDto;
import com.bclass.arts_center.repository.interfaces.ReviewRepository;
import com.bclass.arts_center.repository.model.Review;

@Service
public class ReviewService {

	
	@Autowired
	private ReviewRepository reviewRepository;


	@Transactional
	public List<RequestReviewDto> readReviewByNewest(Integer begin, Integer range) {
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByNewest(begin, range);
		
		return reviewList;
	}


	@Transactional
	public List<RequestReviewDto> readReviewByHighesRated(Integer begin, Integer range) {
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByHighesRated(begin, range);
		
		return reviewList;
	}


	@Transactional
	public List<RequestReviewDto> readReviewByRowestRated(Integer begin, Integer range) {
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByRowestRated(begin, range);
		
		return reviewList;
	}


	@Transactional
	public Integer readReviewByCount() {
		Integer reviewCount = reviewRepository.selectReviewCount();
		
		return reviewCount;
	}
	

	@Transactional
	public List<RequestReviewDto> readReviewByCategory(String category, Integer begin, Integer range) {
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByCategory(category, begin, range);
		
		return reviewList;
	}
	

	@Transactional
	public Integer readReviewByCategoryCount(String category) {
		Integer reviewCount = reviewRepository.selectReviewByCategoryCount(category);
		return reviewCount;
	}
	

	@Transactional
	public List<RequestReviewDto> readReviewByShow(String showName, Integer begin, Integer range) {
		showName = "%"+showName+"%";
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByShow(showName, begin, range);
		return reviewList;
	}
	

	@Transactional
	public Integer readReviewCountByShow(String showName) {
		Integer reviewCount = reviewRepository.selectReviewCountByShow(showName);
		return reviewCount;
	}
	

	@Transactional
	public Integer saveReview(Review review) {
		Integer result = reviewRepository.insertReview(review);
		
		return result;
	}
	

	
	@Transactional
	public List<MyTiketDto> readMyReviewByShowType(MyTiketDto myTiketDto){

		List<MyTiketDto> reviewList = reviewRepository.selectMyTiketDtoByShowType(myTiketDto);
		
		return reviewList;
	}
}
