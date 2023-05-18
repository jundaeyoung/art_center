package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
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

		List<RequestShowDto> showList = showService.readShowByNewest(begin, range);
		return showList;
	}

	/**
	 * @author 전대영 show 평점 높은순 페이지 들어가기
	 */
	@GetMapping("/highesRatedShow")
	public List<RequestShowDto> highesRatedShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {

		List<RequestShowDto> showList = showService.readShowByHighesRated(begin, range);
		return showList;
	}

	/**
	 * @author 전대영 show 평점 낮은순 페이지 들어가기
	 */
	@GetMapping("/rowestRatedShow")
	public List<RequestShowDto> rowestRatedShow(@RequestParam(required = false) Integer currentPage,
			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {

		List<RequestShowDto> showList = showService.readShowByRowestRated(begin, range);
		return showList;
	}

	/**
	 * @author 전대영 show 카테고리 별 페이지 들어가기
	 */
	@GetMapping("/categoryShow")
	public List<RequestShowDto> categoryShow(@RequestParam(required = false) String category,
			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range) {
		List<RequestShowDto> showList = showService.readShowBycategory(category, begin, range);
		System.out.println(showList);
		return showList;
	}

	/**
	 * @author 손주이
	 * @param model
	 * @return
	 */
	@GetMapping("/showView/{showId}")
	public String showView(@PathVariable Integer showId, Model model) {

		List<ShowViewDto> showInfo = showService.readShowInfoByShowId(showId);

//		System.out.println("s" + showInfo);
		model.addAttribute("showInfo", showInfo);
		model.addAttribute("title", showInfo.get(0).getTitle());
		model.addAttribute("content", showInfo.get(0).getContent());
		model.addAttribute("imgRoute", showInfo.get(0).getImgRoute());
		model.addAttribute("startDate", showInfo.get(0).getStartDate());
		model.addAttribute("endDate", showInfo.get(0).getEndDate());
		model.addAttribute("admissionAge", showInfo.get(0).getAdmissionAge());
		model.addAttribute("location", showInfo.get(0).getLocation());
		model.addAttribute("name", showInfo.get(0).getName());
		model.addAttribute("content", showInfo.get(0).getContent());
		model.addAttribute("nickname", showInfo.get(0).getNickname());
		model.addAttribute("tel", showInfo.get(0).getTel());

		return "/show/showView";
	}

}
