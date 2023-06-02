package com.bclass.arts_center.controller.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.RentSalesDto;
import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.response.ResponseDto;
import com.bclass.arts_center.service.AdminSaleService;
import com.bclass.arts_center.service.TicketService;

@RestController
@RequestMapping("/apiAdminShowSale")
public class AdminSaleApicontroller {

	@Autowired
	private AdminSaleService adminSaleService;

	@GetMapping("/admin/rentSale")
	public ResponseDto<List<RentSalesDto>> adminRentSales(RentSalesDto rentSalesDto) {
		List<RentSalesDto> rentSalesGrape = adminSaleService.readRentSaleGrape();
		return new ResponseDto<List<RentSalesDto>>(200, HttpStatus.OK.toString(), rentSalesGrape);
	}	

	@GetMapping("/admin/showSale")
	public ResponseDto<List<RequestManagerShowSaleDto>> adminShowSales(RequestManagerShowSaleDto dto) {
		List<RequestManagerShowSaleDto> showSalesGrape = adminSaleService.readShowSaleGrape();
		return new ResponseDto<List<RequestManagerShowSaleDto>>(200, HttpStatus.OK.toString(), showSalesGrape);
	}

}
