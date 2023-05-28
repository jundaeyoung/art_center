package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.service.ShowService;

@RestController
@RequestMapping("/apiShow")
public class ShowApiController {

	@Autowired
	private ShowService showService;

	@Autowired
	private HttpSession session;

	/**
	 * @author 전대영 show 최신순 페이지 들어가기
	 */
	@GetMapping("/newestShow")
	public List<RequestShowDto> newestShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range) {
		List<RequestShowDto> showListCount = showService.readShowByNewestCount();
		Integer showCount = showListCount.size();
		List<RequestShowDto> showList = showService.readShowByNewest(begin, range);
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		showList.get(0).setCount(page);
		return showList;
	}

	/**
	 * @author 전대영 show 평점 높은순 페이지 들어가기
	 */
	@GetMapping("/highesRatedShow")
	public List<RequestShowDto> highesRatedShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		Integer showCount = showService.readShowByCount();
		List<RequestShowDto> showList = showService.readShowByHighesRated(begin, range);
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		showList.get(0).setCount(page);
		return showList;
	}

	/**
	 * @author 전대영 show 평점 낮은순 페이지 들어가기
	 */
	@GetMapping("/rowestRatedShow")
	public List<RequestShowDto> rowestRatedShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		Integer showCount = showService.readShowByCount();
		List<RequestShowDto> showList = showService.readShowByRowestRated(begin, range);
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		showList.get(0).setCount(page);
		return showList;
	}

	/**
	 * @author 전대영 show 카테고리 별 페이지 들어가기
	 */
	@GetMapping("/categoryShow")
	public List<RequestShowDto> categoryShow(@RequestParam(required = false) String category,
			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range) {
		Integer showCount = showService.readShowBycategoryCount(category);
		List<RequestShowDto> showList = showService.readShowBycategory(category, begin, range);
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		showList.get(0).setCount(page);
		return showList;
	}
	
	@GetMapping("/showView/{showId}")
	public List<RequestShowDto> showView(@PathVariable Integer showId) {

		List<RequestShowDto> reviewList = showService.readReviewByShowId(showId);
		return reviewList;
	}

}
