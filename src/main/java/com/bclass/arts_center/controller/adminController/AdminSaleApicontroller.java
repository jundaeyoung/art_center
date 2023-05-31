package com.bclass.arts_center.controller.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.RentSalesDto;
import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.service.AdminSaleService;
import com.bclass.arts_center.service.TicketService;

@RestController
@RequestMapping("/apiAdminShowSale")
public class AdminSaleApicontroller {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private AdminSaleService adminSaleService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/admin/rentSale")
	public List<RentSalesDto> adminRentSales(RentSalesDto rentSalesDto){
		List<RentSalesDto> rentSalesGrape = adminSaleService.readRentSaleGrape();
		return rentSalesGrape;
	}
	
	@GetMapping("/admin/showSale")
	public List<RequestManagerShowSaleDto> adminShowSales(RequestManagerShowSaleDto dto){
		List<RequestManagerShowSaleDto> showSalesGrape = adminSaleService.readShowSaleGrape();
		return showSalesGrape;
	}
	
	
}
