package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ShowService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private ShowService showService;

	@Autowired
	private HttpSession session;

	@GetMapping("/newestShow")
	public String newestShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
		List<RequestShowDto> showList = showService.readShowByNewest(begin, range);
		
		Integer showCount = showService.readShowByNewestCount();
		String message = "최신순";
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		Integer startPage = currentPage - 2;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 4;
		if (endPage >= page) {
			endPage = page;
		}

		if (principal == null) {
			model.addAttribute("userInfo", null);
		} else {
			model.addAttribute("userInfo", principal);
		}
		if (showList.isEmpty()) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("showList", showList);
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("message", message);
		return "/show/show";
	}


	@GetMapping("/highesRatedShow")
	public String highesRatedShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {

		List<RequestShowDto> showList = showService.readShowByHighesRated(begin, range);
		String message = "평점높은순";
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer showCount = showService.readShowByCount();
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		Integer startPage = currentPage - 2;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 4;
		if (endPage >= page) {
			endPage = page;
		}
		if (principal == null) {
			model.addAttribute("userInfo", null);
		} else {
			model.addAttribute("userInfo", principal);
		}
		if (showList.isEmpty()) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("showList", showList);
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("message", message);
		return "/show/show";
	}


	@GetMapping("/rowestRatedShow")
	public String rowestRatedShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {

		List<RequestShowDto> showList = showService.readShowByRowestRated(begin, range);
		String message = "평점낮은순";
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer showCount = showService.readShowByCount();
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		Integer startPage = currentPage - 2;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 4;
		if (endPage >= page) {
			endPage = page;
		}
		if (principal == null) {
			model.addAttribute("userInfo", null);
		} else {
			model.addAttribute("userInfo", principal);
		}
		if (showList.isEmpty()) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("showList", showList);
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("message", message);
		
		return "/show/show";
	}


	@GetMapping("/categoryShow")
	public String categoryShow(@RequestParam(required = false) String category,
			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, Model model) {
		List<RequestShowDto> showList = showService.readShowBycategory(category, begin, range);
		String message = category;
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		Integer showCount = showService.readShowBycategoryCount(category);
		Double count = Math.ceil(showCount);
		Integer page = (int) Math.ceil(count / 3);
		Integer startPage = currentPage - 2;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 4;
		if (endPage >= page) {
			endPage = page;
		}
		if (principal == null) {
			model.addAttribute("userInfo", null);
		} else {
			model.addAttribute("userInfo", principal);
		}
		if (showList.isEmpty()) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("showList", showList);
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("message", message);
		
		return "/show/show";
	}


	@GetMapping("/showView/{showId}")
	public String showView(@PathVariable Integer showId, Model model) {
		List<ShowViewDto> showInfo = showService.readShowInfoByShowId(showId);
		List<RequestShowDto> reviewList = showService.readReviewByShowId(showId);
		
		String adultRate = showInfo.get(0).getAdultRate().replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		String youthRate = showInfo.get(0).getYouthRate().replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		
		if (reviewList == null || reviewList.isEmpty()) {
			model.addAttribute("reviewList", null);
		} else {
			model.addAttribute("reviewList", reviewList);
		}
		if (showInfo == null || showInfo.isEmpty()) {
			throw new CustomRestfullException("현재 상영중이 아닌 공연입니다", HttpStatus.BAD_REQUEST);
		} else {
			model.addAttribute("showInfo", showInfo);
			model.addAttribute("adultRate",adultRate);
			model.addAttribute("youthRate",youthRate);
		}
		return "/show/showView";
	}

}


