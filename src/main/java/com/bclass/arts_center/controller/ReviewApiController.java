package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.request.RequestReviewDto;
import com.bclass.arts_center.dto.response.ResponseDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ReviewService;
import com.bclass.arts_center.utils.Define;

@RestController
@RequestMapping("apiReview")
public class ReviewApiController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private ReviewService reviewService;
	
	
	@GetMapping("/newestReview")
	public ResponseDto<List<RequestReviewDto>> newestReview(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		Integer reviewCount = reviewService.readReviewByCount();
		List<RequestReviewDto> reviewList = reviewService.readReviewByNewest(begin, range);
		Double count = Math.ceil(reviewCount);
		Integer page = (int) Math.ceil(count / 3);
		reviewList.get(0).setCount(page);
		return new ResponseDto<List<RequestReviewDto>>(200, HttpStatus.OK.toString(), reviewList);
	}
	
	
	@GetMapping("/categoryReview")
	public ResponseDto<List<RequestReviewDto>> categoryReview(@RequestParam(required=false)String category ,@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range) {
		Integer reviewCount = reviewService.readReviewByCategoryCount(category);
		List<RequestReviewDto> reviewList = reviewService.readReviewByCategory(category,begin, range);
		Double count = Math.ceil(reviewCount);
		Integer page = (int) Math.ceil(count / 3);
		reviewList.get(0).setCount(page);
		
		return new ResponseDto<List<RequestReviewDto>>(200, HttpStatus.OK.toString(), reviewList);
	}
	
	@GetMapping("/highestRatedReview")
	public ResponseDto<List<RequestReviewDto>> highestRatedReview(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range) {
		List<RequestReviewDto> reviewList = reviewService.readReviewByHighesRated(begin, range);
		String message = "평점 높은순";
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer reviewCount = reviewService.readReviewByCount();
		Double count = Math.ceil(reviewCount);
		Integer page = (int) Math.ceil(count / 3);
		reviewList.get(0).setCount(page);
		
		return new ResponseDto<List<RequestReviewDto>>(200, HttpStatus.OK.toString(), reviewList);
	}
	
	@GetMapping("/rowestRatedReview")
	public ResponseDto<List<RequestReviewDto>> rowestRatedReview(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range) {
		List<RequestReviewDto> reviewList = reviewService.readReviewByRowestRated(begin, range);
		String message = "평점 낮은순";
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer reviewCount = reviewService.readReviewByCount();
		Double count = Math.ceil(reviewCount);
		Integer page = (int) Math.ceil(count / 3);
		reviewList.get(0).setCount(page);
		
		return new ResponseDto<List<RequestReviewDto>>(200, HttpStatus.OK.toString(), reviewList);
	}
	
}