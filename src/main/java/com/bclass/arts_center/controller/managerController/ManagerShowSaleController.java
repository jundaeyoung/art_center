package com.bclass.arts_center.controller.managerController;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.response.ResponseManagerShowSaleDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ManagerShowSaleService;
import com.bclass.arts_center.utils.Define;

@Controller
public class ManagerShowSaleController {

	@Autowired
	private ManagerShowSaleService managerShowSaleService;

	@Autowired
	private HttpSession session;

	/*
	 * 전대영 : 판매 매출 보기
	 */
	@GetMapping("/manager/showSale")
	public String managerShowSale(RequestManagerShowSaleDto requestManagerShowSaleDto,
			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		requestManagerShowSaleDto.setUserId(principal.getId());
		List<RequestManagerShowSaleDto> selectCount = managerShowSaleService.readAndCount(requestManagerShowSaleDto);
		DecimalFormat df = new DecimalFormat("###,###");
		if (selectCount == null) {
			model.addAttribute("showList", null);
		} else {
			int sum = 0;
			for (int i = 0; i < selectCount.size(); i++) {
				if (selectCount.get(i).getAdultCount() != 0) {
					String str = selectCount.get(i).getAdultRate();
					String newStr = str.replaceAll(",", "");
					sum += Integer.parseInt(newStr) * selectCount.get(i).getAdultCount();
				}
			}
			df.format(sum);
			model.addAttribute("showList", selectCount);
			model.addAttribute("sum", df.format(sum));
		}
		return "/manager/managerShowSale";
	}

	/*
	 * 전대영 : 날짜별로 매출 보기
	 */
	@PostMapping("/manager/showSaleByDate")
	public String selectShowSaleByDate(RequestManagerShowSaleDto requestManagerShowSaleDto, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		String str = requestManagerShowSaleDto.getStartDate();
		String[] split = str.split(" ~ ");
		requestManagerShowSaleDto.setUserId(principal.getId());
		requestManagerShowSaleDto.setStartDate(split[0] + " 00:00:00");
		requestManagerShowSaleDto.setEndDate(split[1] + " 00:00:00");
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleService
				.readManagerShowSaleByDate(requestManagerShowSaleDto);
		DecimalFormat df = new DecimalFormat("###,###");
		if (showSaleList == null) {
			model.addAttribute("showList", null);
		} else {
			int sum = 0;
			for (int i = 0; i < showSaleList.size(); i++) {
				if (showSaleList.get(i).getAdultCount() != 0) {
					String string = showSaleList.get(i).getAdultRate();
					String newStr = string.replaceAll(",", "");
					sum += Integer.parseInt(newStr) * showSaleList.get(i).getAdultCount();
				}
			}
			df.format(sum);
			model.addAttribute("showList", showSaleList);
			model.addAttribute("sum", df.format(sum));
		}
		return "/manager/managerShowSale";
	}

	/*
	 * 전대영 : 판매 상품 검색하기
	 */
	@PostMapping("/manager/showSaleBySearch")
	public String selectShowSaleBySearch(RequestManagerShowSaleDto requestManagerShowSaleDto, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		requestManagerShowSaleDto.setUserId(principal.getId());
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleService
				.readManagerShowBySearch(requestManagerShowSaleDto);
		DecimalFormat df = new DecimalFormat("###,###");
		if (showSaleList == null) {
			model.addAttribute("showList", null);
		} else {
			int sum = 0;
			for (int i = 0; i < showSaleList.size(); i++) {
				if (showSaleList.get(i).getAdultCount() != 0) {
					String string = showSaleList.get(i).getAdultRate();
					String newStr = string.replaceAll(",", "");
					sum += Integer.parseInt(newStr) * showSaleList.get(i).getAdultCount();
				}
			}
			df.format(sum);
			model.addAttribute("showList", showSaleList);
			model.addAttribute("sum", df.format(sum));
		}
		return "/manager/managerShowSale";
	}

	/*
	 * 전대영 : 공연 detail보기
	 */
	@GetMapping("/manager/showSaleDetailByShowId/{showId}/{userId}/{currentPage}/{begin}/{range}")
	public String selectShowSaleDetailByShowId(@PathVariable(value = "showId", required = false) Integer showId,
			@PathVariable(value = "userId", required = false) Integer userId,
			@PathVariable(value = "currentPage", required = false) Integer currentPage,
			@PathVariable(value = "begin", required = false) Integer begin,
			@PathVariable(value = "range", required = false) Integer range, Model model) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleService.readManagerShowDetailByShowId(showId,
				userId, begin, range);
		System.out.println(showSaleList);
		Integer showSaleCount = managerShowSaleService.readManagerShowDetailCountByShowId(showId, userId);
		Double count = Math.ceil(showSaleCount);
		Integer page = (int) Math.ceil(count / 5);
		Integer startPage = currentPage - 2;
		if (startPage <= 0) {
			startPage = 1;
		}
		Integer endPage = startPage + 4;
		if (endPage >= page) {
			endPage = page;
		}
		model.addAttribute("showId", showId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		System.out.println(page+"DDD");
		DecimalFormat df = new DecimalFormat("###,###");
		model.addAttribute("showList", null);
		int sum = 0;
		for (int i = 0; i < showSaleList.size(); i++) {
			if (showSaleList.get(i).getAdultCount() != 0) {
				String string = showSaleList.get(i).getAdultRate();
				String newStr = string.replaceAll(",", "");
				sum += Integer.parseInt(newStr) * showSaleList.get(i).getAdultCount();
			}
		}
		df.format(sum);
		if (showSaleList == null || showSaleList.isEmpty()) {
			model.addAttribute("showList", null);
		} else {
			String imgRoute = showSaleList.get(0).getImgRoute();
			String title = showSaleList.get(0).getTitle();
			model.addAttribute("showList", showSaleList);
			model.addAttribute("imgRoute", imgRoute);
			model.addAttribute("title", title);
		}
		return "/manager/managerShowSaleDetail";
	}
}
