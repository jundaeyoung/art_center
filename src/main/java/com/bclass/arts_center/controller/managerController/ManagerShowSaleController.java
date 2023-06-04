package com.bclass.arts_center.controller.managerController;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.response.ResponseManagerShowSaleDto;
import com.bclass.arts_center.handler.exception.LoginException;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ManagerShowSaleService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/manager")
public class ManagerShowSaleController {

	@Autowired
	private ManagerShowSaleService managerShowSaleService;

	@Autowired
	private HttpSession session;


	@GetMapping("/showSale")
	public String selectManagerShowSale(RequestManagerShowSaleDto requestManagerShowSaleDto,
			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		
		requestManagerShowSaleDto.setUserId(principal.getId());
		List<RequestManagerShowSaleDto> managerShowSaleList = managerShowSaleService.readManagerShowSale(requestManagerShowSaleDto);
		
		if (managerShowSaleList == null) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("showList", managerShowSaleList);
			model.addAttribute("showListSize", managerShowSaleList.size());
		}
		return "/manager/managerShowSale";
	}

	
	@PostMapping("/showSaleByDate")
	public String selectShowSaleByDate(RequestManagerShowSaleDto requestManagerShowSaleDto, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		if (principal == null || principal.getRoleId() != 2) {
			throw new LoginException("매니저 아이디로 로그인을 해주세요.", HttpStatus.BAD_REQUEST);
		}
		
		String date = requestManagerShowSaleDto.getStartDate();
		String[] startDateAndEndDate = date.split(" ~ ");
		requestManagerShowSaleDto.setUserId(principal.getId());
		requestManagerShowSaleDto.setStartDate(startDateAndEndDate[0] + " 00:00:00");
		requestManagerShowSaleDto.setEndDate(startDateAndEndDate[1] + " 00:00:00");
		
		List<RequestManagerShowSaleDto> managerShowSaleList = managerShowSaleService
				.readManagerShowSaleByStartDateAndEndDate(requestManagerShowSaleDto);
		
		if (managerShowSaleList == null) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("showList", managerShowSaleList);
			model.addAttribute("startDate", requestManagerShowSaleDto.getStartDate().substring(0, 10));
			model.addAttribute("endDate", requestManagerShowSaleDto.getEndDate().substring(0, 10));
		}
		return "/manager/managerShowSaleByDate";
	}


	@PostMapping("/showSaleBySearch")
	public String selectShowSaleBySearch(String title, RequestManagerShowSaleDto requestManagerShowSaleDto,
			Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		requestManagerShowSaleDto.setUserId(principal.getId());
		
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleService
				.readManagerShowBySearchTitle(requestManagerShowSaleDto);
		
		if (showSaleList == null) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("title", title);
			model.addAttribute("showList", showSaleList);
		}
		return "/manager/managerShowSaleBySearch";
	}
	
}
