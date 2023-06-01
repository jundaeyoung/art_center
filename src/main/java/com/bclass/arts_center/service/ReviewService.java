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

	/**
	 * 작성자 : 전대영 관람평 최신순으로 select
	 */
	@Transactional
	public List<RequestReviewDto> readReviewByNewest(Integer begin, Integer range) {
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByNewest(begin, range);
		return reviewList;
	}

	/**
	 * 작성자 : 전대영 관람평 높은순으로 select
	 */
	@Transactional
	public List<RequestReviewDto> readReviewByHighesRated(Integer begin, Integer range) {
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByHighesRated(begin, range);
		return reviewList;
	}

	/**
	 * 작성자 : 전대영 관람평 낮은순으로 select
	 */
	@Transactional
	public List<RequestReviewDto> readReviewByRowestRated(Integer begin, Integer range) {
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByRowestRated(begin, range);
		return reviewList;
	}

	/**
	 * 작성자 : 전대영 리뷰 Count
	 */
	@Transactional
	public Integer readReviewByCount() {
		Integer reviewCount = reviewRepository.selectReviewCount();
		return reviewCount;
	}
	
	/**
	 * 작성자 : 전대영 관람평 카테고리 별 select
	 */
	@Transactional
	public List<RequestReviewDto> readReviewByCategory(String category, Integer begin, Integer range) {
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByCategory(category, begin, range);
		return reviewList;
	}
	
	/**
	 * 작성자 : 전대영 리뷰 Count
	 */
	@Transactional
	public Integer readReviewByCategoryCount(String category) {
		Integer reviewCount = reviewRepository.selectReviewByCategoryCount(category);
		return reviewCount;
	}
	
	/**
	 * 작성자 : 전대영 review에서 show검색해서show별로 리뷰 보기
	 */
	@Transactional
	public List<RequestReviewDto> readReviewByShow(String showName, Integer begin, Integer range) {
		showName = "%"+showName+"%";
		List<RequestReviewDto> reviewList = reviewRepository.selectReviewByShow(showName, begin, range);
		return reviewList;
	}
	
	/**
	 * 작성자 : 전대영 review에서 show검색해서show별로 카운터
	 */
	@Transactional
	public Integer readReviewCountByShow(String showName) {
		Integer reviewCount = reviewRepository.selectReviewCountByShow(showName);
		return reviewCount;
	}
	
	// 작성자 : 편용림 리뷰작성
	@Transactional
	public int saveReview(Review review) {
		int result = reviewRepository.insertReview(review);
		return result;
	}
	
	// 작성자 : 편용림 리뷰 카테고리별 검색
	
	@Transactional
	public List<MyTiketDto> readMyReviewByShowType(MyTiketDto myTiketDto){

		List<MyTiketDto> reviewList = reviewRepository.selectMyTiketDtoByShowType(myTiketDto);
		
		return reviewList;
		
	}
}
