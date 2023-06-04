package com.bclass.arts_center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.dto.response.ResponseDto;
import com.bclass.arts_center.service.ShowService;

@RestController
@RequestMapping("/apiShow")
public class ShowApiController {

	@Autowired
	private ShowService showService;

	@GetMapping("/newestShow")
	public ResponseDto<List<RequestShowDto>> newestShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range) {
		List<RequestShowDto> showList = showService.readShowByNewest(begin, range);
		
		Integer showCount = showService.readShowByNewestCount();
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		showList.get(0).setCount(page);
		
		return new ResponseDto<List<RequestShowDto>>(200, HttpStatus.OK.toString(), showList);
	}

	@GetMapping("/highesRatedShow")
	public ResponseDto<List<RequestShowDto>> highesRatedShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		List<RequestShowDto> showList = showService.readShowByHighesRated(begin, range);
		
		Integer showCount = showService.readShowByCount();
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		showList.get(0).setCount(page);
		
		return new ResponseDto<List<RequestShowDto>>(200, HttpStatus.OK.toString(), showList);
	}


	@GetMapping("/rowestRatedShow")
	public ResponseDto<List<RequestShowDto>> rowestRatedShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		List<RequestShowDto> showList = showService.readShowByRowestRated(begin, range);
		
		Integer showCount = showService.readShowByCount();
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		showList.get(0).setCount(page);
		
		return new ResponseDto<List<RequestShowDto>>(200, HttpStatus.OK.toString(), showList);
	}


	@GetMapping("/categoryShow")
	public ResponseDto<List<RequestShowDto>> categoryShow(@RequestParam(required = false) String category,
			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range) {
		List<RequestShowDto> showList = showService.readShowBycategory(category, begin, range);
		
		Integer showCount = showService.readShowBycategoryCount(category);
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		showList.get(0).setCount(page);
		
		return new ResponseDto<List<RequestShowDto>>(200, HttpStatus.OK.toString(), showList);
	}

	
	@GetMapping("/showView/{showId}")
	public ResponseDto<List<RequestShowDto>> showView(@PathVariable Integer showId) {
		List<RequestShowDto> reviewList = showService.readReviewByShowId(showId);
		
		return new ResponseDto<List<RequestShowDto>>(200, HttpStatus.OK.toString(), reviewList);
	}
}

