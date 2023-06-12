package com.bclass.arts_center.controller.adminController;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.request.RequestManagerRentSaleDto;
import com.bclass.arts_center.service.AdminSaleService;

@Controller
@RequestMapping("/admin/sales")
public class AdminSaleController {

	@Autowired
	private AdminSaleService adminSaleService;
	
	
	@GetMapping("/selectShowSalList")
	public String selectShowSalList(Model model) {
		List<RequestManagerShowSaleDto> showSaleList = adminSaleService.readShowSaleList();
		
		int totalShowPrice = 0;
		for (RequestManagerShowSaleDto dto : showSaleList) {
	        String ShowPriceString = Integer.toString(dto.getTotalshowSales());
	        String cleanedShowPriceString = ShowPriceString;
	        int rentPrice = Integer.parseInt(cleanedShowPriceString);
	        totalShowPrice += rentPrice;
	    }
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedTotalRentPrice = decimalFormat.format(totalShowPrice);
		
		model.addAttribute("showSalesList", showSaleList);
		model.addAttribute("totalShowPrice",formattedTotalRentPrice);
		
		return "/admin/showSale";
	}
	
	
	@GetMapping("/selectRentSaleList")
	public String selectRentSaleList(Model model) {
	    List<RequestManagerRentSaleDto> rentSalelist = adminSaleService.readRentSaleList();
	    
	    int totalRentPrice = 0;
	    for (RequestManagerRentSaleDto requestManagerRentSaleDto : rentSalelist) {
	        String rentPriceString = requestManagerRentSaleDto.getRentPrice();
	        String cleanedRentPriceString = rentPriceString.replace(",", "");
	        int rentPrice = Integer.parseInt(cleanedRentPriceString);
	        totalRentPrice += rentPrice;
	    }
	    DecimalFormat decimalFormat = new DecimalFormat("#,###"); 
	    String formattedTotalRentPrice = decimalFormat.format(totalRentPrice);

	    model.addAttribute("rentSaleslist", rentSalelist);
	    model.addAttribute("totalRentPrice", formattedTotalRentPrice); 
	    
	    return "/admin/rentSale";
	}
	
	
	@PostMapping("/selectShowSaleListByStartDateAndEndDate")
	public String selectShowSaleListByStartDateAndEndDate(RequestManagerShowSaleDto requestManagerShowSaleDto,Model model){
		String date = requestManagerShowSaleDto.getStartDate();
		String[] splitDate = date.split(" ~ ");
		requestManagerShowSaleDto.setStartDate(splitDate[0] + " 00:00:00");
		requestManagerShowSaleDto.setEndDate(splitDate[1] + " 00:00:00");
		
		List<RequestManagerShowSaleDto> showSaleList = adminSaleService.readShowSaleByStartDateAndEndDate(requestManagerShowSaleDto.getStartDate(), requestManagerShowSaleDto.getEndDate());
		
		int totalShowSalePrice = 0;
		for (RequestManagerShowSaleDto dto : showSaleList) {
	        String showPriceString = Integer.toString(dto.getTotalshowSales());
	        String cleanedShowPriceString = showPriceString;
	        int showPrice = Integer.parseInt(cleanedShowPriceString);
	        totalShowSalePrice += showPrice;
	    }
		DecimalFormat decimalFormat = new DecimalFormat("#,###"); // 쉼표 포함한 형식 지정
		String formattedTotalRentPrice = decimalFormat.format(totalShowSalePrice);
		model.addAttribute("showSalesList", showSaleList);
		model.addAttribute("totalShowPrice", formattedTotalRentPrice);
		
		return "/admin/showSale";
	
	}
	
	
	@PostMapping("/selectShowSaleSearchByTitle")
	public String selectShowSaleSearchByTitle(@RequestParam("searchTitle") String searchTitle, Model model) {
		List<RequestManagerShowSaleDto> showSaleListByTitle = adminSaleService.readShowSaleSearchBySearch(searchTitle);
		model.addAttribute("showSalesList", showSaleListByTitle);
		
		return "/admin/showSale";
		}
	
	
	@PostMapping("/selectRentSaleByStartDateAndEndDate")
	public String selectRentSaleByStartDateAndEndDate(RequestManagerShowSaleDto requestManagerShowSaleDto, Model model) {
		String date = requestManagerShowSaleDto.getStartDate();
		String[] splitDate = date.split(" ~ ");
		requestManagerShowSaleDto.setStartDate(splitDate[0] + " 00:00:00");
		requestManagerShowSaleDto.setEndDate(splitDate[1] + " 00:00:00");
		
		List<RequestManagerRentSaleDto> rentSaleList = adminSaleService.readRentalSaleByStartDateAndEndDate(requestManagerShowSaleDto.getStartDate(), requestManagerShowSaleDto.getEndDate());
		
		int totalRentPrice = 0;
	    for (RequestManagerRentSaleDto requestManagerRentSaleDto : rentSaleList) {
	        String rentPriceString = requestManagerRentSaleDto.getRentPrice();
	        String cleanedRentPriceString = rentPriceString.replace(",", "");
	        int rentPrice = Integer.parseInt(cleanedRentPriceString);
	        totalRentPrice += rentPrice;
	    }
	    DecimalFormat decimalFormat = new DecimalFormat("#,###"); 
	    String formattedTotalRentPrice = decimalFormat.format(totalRentPrice);
	    model.addAttribute("rentSaleslist", rentSaleList);
	    model.addAttribute("totalRentPrice", formattedTotalRentPrice); 
		
		return "/admin/rentSale";
	}
	
	
	@PostMapping("/selectRentSaleBySearchTitle")
	public String selectRentSaleBySearchTitle(@RequestParam("searchTitle") String searchTitle,Model model) {
		List<RequestManagerRentSaleDto> rentSaleList = adminSaleService.readRentalSaleBySearch(searchTitle);
		
		int totalRentPrice = 0;
	    for (RequestManagerRentSaleDto requestManagerRentSaleDto : rentSaleList) {
	        String rentPriceString = requestManagerRentSaleDto.getRentPrice();
	        String cleanedRentPriceString = rentPriceString.replace(",", "");
	        int rentPrice = Integer.parseInt(cleanedRentPriceString);
	        totalRentPrice += rentPrice;
	    }
	    
	    DecimalFormat decimalFormat = new DecimalFormat("#,###"); 
	    String formattedTotalRentPrice = decimalFormat.format(totalRentPrice);
		model.addAttribute("rentSaleslist", rentSaleList);
	    model.addAttribute("totalRentPrice", formattedTotalRentPrice);
		
		return "/admin/rentSale";
	}
}


