package com.bclass.arts_center.controller.managerController;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.dto.response.ResponseManagerShowSaleDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ManagerShowSaleService;
import com.bclass.arts_center.service.ShowService;
import com.bclass.arts_center.utils.Define;

@Controller
public class ManagerShowSaleController {

	@Autowired
	private ManagerShowSaleService managerShowSaleService;

	@Autowired
	private HttpSession session;

	@GetMapping("/manager/showSale")
	public String managerShowSale(RequestManagerShowSaleDto requestManagerShowSaleDto,
			@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer begin,
			@RequestParam(required = false) Integer range, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		requestManagerShowSaleDto.setUserId(principal.getId());
		List<RequestManagerShowSaleDto> selectCount = managerShowSaleService.selectInfantCount(requestManagerShowSaleDto);
		model.addAttribute("showList", selectCount);
		return "/manager/managerShowSale";
	}

	@PostMapping("/manager/showSaleSearch")
	public String selectByShowSale(ResponseManagerShowSaleDto managerShowSaleDto, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		String str = managerShowSaleDto.getStartDate();
		String[] split = str.split(" ~ ");
		managerShowSaleDto.setUserId(principal.getId());
		managerShowSaleDto.setStartDate(split[0] + " 00:00:00");
		managerShowSaleDto.setEndDate(split[1] + " 00:00:00");
		System.out.println(managerShowSaleDto);
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleService.readShowSale(managerShowSaleDto);
		System.out.println(showSaleList);
		if (showSaleList == null) {
			model.addAttribute("showSaleList", null);
		} else {
			model.addAttribute("showSaleList", showSaleList);
		}
		return "/manager/managerShowSale";
	}
}
