//package com.bclass.arts_center.controller;
//
//import java.util.HashMap;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bclass.arts_center.dto.ShowViewDto;
//import com.bclass.arts_center.dto.request.RequestShowDto;
//import com.bclass.arts_center.repository.model.User;
//import com.bclass.arts_center.service.ShowService;
//import com.bclass.arts_center.utils.Define;
//
//@RestController
//@RequestMapping("/apiShow")
//public class ShowApiController {
//
//	@Autowired
//	private ShowService showService;
//	
//	@Autowired
//	private ShowController showcontroller;
//
//	@Autowired
//	private HttpSession session;
//
//	/**
//	 * @author 전대영 show 최신순 페이지 들어가기
//	 */
//	@GetMapping("/newestShow")
//	public HashMap<String, Object> newestShow(@RequestParam(required = false) Integer currentPage,
//			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
//
//		HashMap<String, Object> hashMap = new HashMap<String, Object>();
//		System.out.println(hashMap);
//		List<RequestShowDto> showList = showService.readShowByNewest(begin, range);
//		String message = "최신순";
//		User principal = (User) session.getAttribute(Define.PRINCIPAL);
//		Integer showCount = showService.readShowByCount();
//		Double count = Math.ceil(showCount);
//		Integer page = (int) Math.ceil(count / 3);
//		Integer startPage = currentPage - 2;
//		if (startPage <= 0) {
//			startPage = 1;
//		}
//		Integer endPage = startPage + 4;
//		if (endPage >= page) {
//			endPage = page;
//		}
//		System.out.println(showList.get(0).getShowId());
//
//		model.addAttribute("currentPage", currentPage);
//		model.addAttribute("page", page);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("page", page);
//		model.addAttribute("principal", principal);
//		if (principal == null) {
//			model.addAttribute("userInfo", null);
//		} else {
//			model.addAttribute("userInfo", principal);
//		}
//		if (showList.isEmpty()) {
//			model.addAttribute("showList", null);
//		} else {
//			model.addAttribute("showList", showList);
//		}
//		model.addAttribute("message", message);
//		return "/show/show";
//	}
//
//	/**
//	 * @author 전대영 show 평점 높은순 페이지 들어가기
//	 */
//	@GetMapping("/highesRatedShow")
//	public String highesRatedShow(@RequestParam(required = false) Integer currentPage,
//			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
//
//		List<RequestShowDto> showList = showService.readShowByHighesRated(begin, range);
//		String message = "평점높은순";
//		User principal = (User) session.getAttribute(Define.PRINCIPAL);
//		Integer showCount = showService.readShowByCount();
//		Double count = Math.ceil(showCount);
//		Integer page = (int) Math.ceil(count / 3);
//		Integer startPage = currentPage - 2;
//		if (startPage <= 0) {
//			startPage = 1;
//		}
//		Integer endPage = startPage + 4;
//		if (endPage >= page) {
//			endPage = page;
//		}
//		model.addAttribute("currentPage", currentPage);
//		model.addAttribute("page", page);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("page", page);
//		model.addAttribute("principal", principal);
//		if (principal == null) {
//			model.addAttribute("userInfo", null);
//		} else {
//			model.addAttribute("userInfo", principal);
//		}
//		if (showList.isEmpty()) {
//			model.addAttribute("showList", null);
//		} else {
//			model.addAttribute("showList", showList);
//		}
//		model.addAttribute("message", message);
//		return "/show/show";
//	}
//
//	/**
//	 * @author 전대영 show 평점 낮은순 페이지 들어가기
//	 */
//	@GetMapping("/rowestRatedShow")
//	public String rowestRatedShow(@RequestParam(required = false) Integer currentPage,
//			@RequestParam(required = false) Integer begin, @RequestParam(required = false) Integer range, Model model) {
//
//		List<RequestShowDto> showList = showService.readShowByRowestRated(begin, range);
//		String message = "평점낮은순";
//		User principal = (User) session.getAttribute(Define.PRINCIPAL);
//		Integer showCount = showService.readShowByCount();
//		Double count = Math.ceil(showCount);
//		Integer page = (int) Math.ceil(count / 3);
//		Integer startPage = currentPage - 2;
//		if (startPage <= 0) {
//			startPage = 1;
//		}
//		Integer endPage = startPage + 4;
//		if (endPage >= page) {
//			endPage = page;
//		}
//		model.addAttribute("currentPage", currentPage);
//		model.addAttribute("page", page);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("page", page);
//		model.addAttribute("principal", principal);
//		if (principal == null) {
//			model.addAttribute("userInfo", null);
//		} else {
//			model.addAttribute("userInfo", principal);
//		}
//		if (showList.isEmpty()) {
//			model.addAttribute("showList", null);
//		} else {
//			model.addAttribute("showList", showList);
//		}
//		model.addAttribute("message", message);
//		return "/show/show";
//	}
//
//	/**
//	 * @author 전대영 show 카테고리 별 페이지 들어가기
//	 */
//	@GetMapping("/categoryShow")
//	public HashMap<String, Object> categoryShow(@RequestParam(required = false) String category,
//			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
//			@RequestParam(required = false) Integer range, Model model) {
//		HashMap<String, Object> hashMap = new HashMap<String, Object>();
//		hashMap.put("category", category);
//		hashMap.put("currentPage", currentPage);
//		hashMap.put("begin", begin);
//		hashMap.put("range", range);
//		
//		List<RequestShowDto> showList = showService.readShowBycategory(category, begin, range);
//		System.out.println(hashMap.values());
//		String message = category;
//		User principal = (User) session.getAttribute(Define.PRINCIPAL);
//		Integer showCount = showService.readShowBycategoryCount(category);
//		Double count = Math.ceil(showCount);
//		Integer page = (int) Math.ceil(count / 3);
//		Integer startPage = currentPage - 2;
//		if (startPage <= 0) {
//			startPage = 1;
//		}
//		Integer endPage = startPage + 4;
//		if (endPage >= page) {
//			endPage = page;
//		}
//		model.addAttribute("currentPage", currentPage);
//		model.addAttribute("page", page);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("page", page);
//		model.addAttribute("principal", principal);
//		if (principal == null) {
//			model.addAttribute("userInfo", null);
//		} else {
//			model.addAttribute("userInfo", principal);
//		}
//		if (showList.isEmpty()) {
//			model.addAttribute("showList", null);
//		} else {
//			model.addAttribute("showList", showList);
//		}
//		model.addAttribute("message", message);
//		return new HashMap<String,Object>(hashMap);
//	}
//
//	/**
//	 * @author 손주이
//	 * @param model
//	 * @return
//	 */
//	@GetMapping("/showView/{showId}")
//	public String showView(@PathVariable Integer showId, Model model) {
//
//		System.out.println("제발" + showId);
//
//		List<ShowViewDto> showInfo = showService.readShowInfoByShowId(showId);
//
////		System.out.println("s" + showInfo);
//		model.addAttribute("showInfo", showInfo);
//		model.addAttribute("title", showInfo.get(0).getTitle());
//		model.addAttribute("content", showInfo.get(0).getContent());
//		model.addAttribute("imgRoute", showInfo.get(0).getImgRoute());
//		model.addAttribute("startDate", showInfo.get(0).getStartDate());
//		model.addAttribute("endDate", showInfo.get(0).getEndDate());
//		model.addAttribute("admissionAge", showInfo.get(0).getAdmissionAge());
//		model.addAttribute("location", showInfo.get(0).getLocation());
//		model.addAttribute("name", showInfo.get(0).getName());
//		model.addAttribute("content", showInfo.get(0).getContent());
//		model.addAttribute("nickname", showInfo.get(0).getNickname());
//		model.addAttribute("tel", showInfo.get(0).getTel());
//
//		return "/show/showView";
//	}
//
//}
