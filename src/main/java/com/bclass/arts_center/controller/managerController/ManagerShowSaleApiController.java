package com.bclass.arts_center.controller.managerController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.response.ResponseDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ManagerShowSaleService;
import com.bclass.arts_center.utils.Define;

@RestController
@RequestMapping("/apiShowSale")
public class ManagerShowSaleApiController {

	@Autowired
	private ManagerShowSaleService managerShowSaleService;
	
	@Autowired
	private HttpSession session;

	
	@GetMapping("/manager/showSale")
	public ResponseDto<List<RequestManagerShowSaleDto>> managerShowSale(
		RequestManagerShowSaleDto requestManagerShowSaleDto) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		requestManagerShowSaleDto.setUserId(principal.getId());
		List<RequestManagerShowSaleDto> selectList = managerShowSaleService.readManagerShowSale(requestManagerShowSaleDto);
		
		return new ResponseDto<List<RequestManagerShowSaleDto>>(200, HttpStatus.OK.toString(), selectList);
	}


	@GetMapping("/manager/showSaleByDate/{startDate}")
	public ResponseDto<List<RequestManagerShowSaleDto>> selectShowSaleByStartDateAndEndDate(
			@PathVariable("startDate") String startDate, RequestManagerShowSaleDto requestManagerShowSaleDto,
			Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		
		String str = requestManagerShowSaleDto.getStartDate();
		String[] split = str.split(" ~ ");
		requestManagerShowSaleDto.setUserId(principal.getId());
		requestManagerShowSaleDto.setStartDate(split[0] + " 00:00:00");
		requestManagerShowSaleDto.setEndDate(split[1] + " 00:00:00");
		
		List<RequestManagerShowSaleDto> selectList = managerShowSaleService
				.readManagerShowSaleByStartDateAndEndDate(requestManagerShowSaleDto);
		
		return new ResponseDto<List<RequestManagerShowSaleDto>>(200, HttpStatus.OK.toString(), selectList);
	}

	@GetMapping("/manager/showSaleBySearch/{title}")
	public ResponseDto<List<RequestManagerShowSaleDto>> selectShowSaleBySearch(@PathVariable("title") String title,
			RequestManagerShowSaleDto requestManagerShowSaleDto, Model model) {
		
		if (title.equals("none")) {
			title = "";
			requestManagerShowSaleDto.setTitle(title);
			}
		
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		requestManagerShowSaleDto.setUserId(principal.getId());
		List<RequestManagerShowSaleDto> selectList = managerShowSaleService
				.readManagerShowBySearchTitle(requestManagerShowSaleDto);
		
		return new ResponseDto<List<RequestManagerShowSaleDto>>(200, HttpStatus.OK.toString(), selectList);
	}
}

