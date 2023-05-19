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
			System.out.println(df.format(sum));
			model.addAttribute("showList", selectCount);
			model.addAttribute("sum", df.format(sum));
		}
		return "/manager/managerShowSale";
	}

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
		if (showSaleList == null) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("showList", showSaleList);
		}
		return "/manager/managerShowSale";
	}

	@PostMapping("/manager/showSaleBySearch")
	public String selectShowSaleBySearch(RequestManagerShowSaleDto requestManagerShowSaleDto, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		requestManagerShowSaleDto.setUserId(principal.getId());
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleService
				.readManagerShowBySearch(requestManagerShowSaleDto);
		if (showSaleList == null) {
			model.addAttribute("showList", null);
		} else {
			model.addAttribute("showList", showSaleList);
		}
		return "/manager/managerShowSale";
	}

	@GetMapping("/manager/showSaleDetailByShowId/{showId}/{userId}")
	public String selectShowSaleDetailByShowId(@PathVariable Integer showId, @PathVariable Integer userId,
			Model model) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleService.readManagerShowDetailByShowId(showId,
				userId);

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
