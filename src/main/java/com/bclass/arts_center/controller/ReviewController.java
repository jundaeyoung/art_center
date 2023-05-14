package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.request.RequestReviewDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ReviewService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private HttpSession session;

	/**
	 * @author 전대영 관람평 최신순 페이지 들어가기
	 */
	@GetMapping("/newestReview")
	public String newestReview(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {

		List<RequestReviewDto> reviewList = reviewService.readReviewByNewest(begin, range);
		String message = "최신순";
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer reviewCount = reviewService.readReviewByCount();
		Double count = Math.ceil(reviewCount);
		Integer page = (int) Math.ceil(count / 3);
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
		if (reviewList.isEmpty()) {
			model.addAttribute("reviewList", null);
		} else {
			model.addAttribute("reviewList", reviewList);
		}
		model.addAttribute("message", message);
		return "/user/review";
	}
	
	
	/**
	 * @author 전대영 관람평 평점 높은순 페이지 들어가기
	 */
	@GetMapping("/highestRatedReview")
	public String highestRatedReview(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		
		List<RequestReviewDto> reviewList = reviewService.readReviewByHighesRated(begin, range);
		String message = "평점높은순";
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer reviewCount = reviewService.readReviewByCount();
		Double count = Math.ceil(reviewCount);
		Integer page = (int) Math.ceil(count / 3);
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
		if (reviewList.isEmpty()) {
			model.addAttribute("reviewList", null);
		} else {
			model.addAttribute("reviewList", reviewList);
		}
		model.addAttribute("message", message);
		return "/user/review";
	}
	
	
	/**
	 * @author 전대영 관람평 평점 낮은순 페이지 들어가기
	 */
	@GetMapping("/rowestRatedReview")
	public String rowestRatedReview(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		
		List<RequestReviewDto> reviewList = reviewService.readReviewByRowestRated(begin, range);
		String message = "평점낮은순";
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer reviewCount = reviewService.readReviewByCount();
		Double count = Math.ceil(reviewCount);
		Integer page = (int) Math.ceil(count / 3);
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
		if (reviewList.isEmpty()) {
			model.addAttribute("reviewList", null);
		} else {
			model.addAttribute("reviewList", reviewList);
		}
		model.addAttribute("message", message);
		return "/user/review";
	}
	
	/**
	 * @author 전대영 리뷰 카테고리별 페이지 들어가기
	 */
	@GetMapping("/categoryReview")
	public String categoryReview(@RequestParam(required=false)String category ,@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		
		List<RequestReviewDto> reviewList = reviewService.readReviewByCategory(category,begin, range);
		String message = category;
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer reviewCount = reviewService.readReviewByCategoryCount(category);
		Double count = Math.ceil(reviewCount);
		Integer page = (int) Math.ceil(count / 3);
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
		if (reviewList.isEmpty()) {
			model.addAttribute("reviewList", null);
		} else {
			model.addAttribute("reviewList", reviewList);
		}
		model.addAttribute("message", message);
		return "/user/review";
	}
	
}
