package com.bclass.arts_center.controller.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.request.RequestManagerRentSaleDto;
import com.bclass.arts_center.dto.response.ResponseDto;
import com.bclass.arts_center.service.AdminSaleService;

@RestController
@RequestMapping("/apiAdminShowSale")
public class AdminSaleApiController {

	@Autowired
	private AdminSaleService adminSaleService;

	
	@GetMapping("/admin/rentSale")
	public ResponseDto<List<RequestManagerRentSaleDto>> adminRentSaleList(RequestManagerRentSaleDto requestManagerRentSaleDto) {
		List<RequestManagerRentSaleDto> rentSaleList = adminSaleService.readRentSaleGrape();
		
		return new ResponseDto<List<RequestManagerRentSaleDto>>(200, HttpStatus.OK.toString(), rentSaleList);
	}	

	
	@GetMapping("/admin/showSale")
	public ResponseDto<List<RequestManagerShowSaleDto>> adminShowSaleList(RequestManagerShowSaleDto dto) {
		List<RequestManagerShowSaleDto> showSaleList = adminSaleService.readShowSaleGrape();
		
		return new ResponseDto<List<RequestManagerShowSaleDto>>(200, HttpStatus.OK.toString(), showSaleList);
	}

}