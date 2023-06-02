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

import com.bclass.arts_center.dto.RentSalesDto;
import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.service.AdminSaleService;

@Controller
@RequestMapping("/admin/sales")
public class AdminSalesController {

	@Autowired
	private AdminSaleService adminSaleService;
	
	@GetMapping("/showGrape")
	public String showGrape() {
		return "/admin/board2";
	}
	
	@GetMapping("/show")
	public String showSales(Model model) {
		List<RequestManagerShowSaleDto> showSalesList = adminSaleService.readShowSaleList();
		int totalShowPrice = 0;
		for (RequestManagerShowSaleDto dto : showSalesList) {
	        String ShowPriceString = Integer.toString(dto.getTotalshowSales());
	        String cleanedShowPriceString = ShowPriceString;
	        int rentPrice = Integer.parseInt(cleanedShowPriceString);
	        totalShowPrice += rentPrice;
	    }
		DecimalFormat decimalFormat = new DecimalFormat("#,###"); // 쉼표 포함한 형식 지정
		String formattedTotalRentPrice = decimalFormat.format(totalShowPrice);
		
		model.addAttribute("showSalesList", showSalesList);
		model.addAttribute("totalShowPrice",formattedTotalRentPrice);
		
		return "/admin/showSales";
	}
	
	@GetMapping("/rent")
	public String rentSales(Model model) {
	    List<RentSalesDto> rentSaleslist = adminSaleService.readRentSale();

	    int totalRentPrice = 0;
	    for (RentSalesDto rentSalesDto : rentSaleslist) {
	        String rentPriceString = rentSalesDto.getRentPrice();
	        String cleanedRentPriceString = rentPriceString.replace(",", "");
	        int rentPrice = Integer.parseInt(cleanedRentPriceString);
	        totalRentPrice += rentPrice;
	    }

	    DecimalFormat decimalFormat = new DecimalFormat("#,###"); // 쉼표 포함한 형식 지정
	    String formattedTotalRentPrice = decimalFormat.format(totalRentPrice);

	    model.addAttribute("rentSaleslist", rentSaleslist);
	    model.addAttribute("totalRentPrice", formattedTotalRentPrice); // 쉼표를 포함한 문자열로 추가
	    return "/admin/rentSales";
	}
	
	@PostMapping("/showSalesDay")
	public String ShowSalesDay(RequestManagerShowSaleDto requestManagerShowSaleDto,Model model){
		String str = requestManagerShowSaleDto.getStartDate();
		String[] split = str.split(" ~ ");
		requestManagerShowSaleDto.setStartDate(split[0] + " 00:00:00");
		requestManagerShowSaleDto.setEndDate(split[1] + " 00:00:00");
		List<RequestManagerShowSaleDto> showSalesList = adminSaleService.readShowSaleByStartDateAndEndDate(requestManagerShowSaleDto.getStartDate(), requestManagerShowSaleDto.getEndDate());
		int totalShowPrice = 0;
		for (RequestManagerShowSaleDto dto : showSalesList) {
	        String ShowPriceString = Integer.toString(dto.getTotalshowSales());
	        String cleanedShowPriceString = ShowPriceString;
	        int rentPrice = Integer.parseInt(cleanedShowPriceString);
	        totalShowPrice += rentPrice;
	    }
		DecimalFormat decimalFormat = new DecimalFormat("#,###"); // 쉼표 포함한 형식 지정
		String formattedTotalRentPrice = decimalFormat.format(totalShowPrice);
		model.addAttribute("showSalesList", showSalesList);
		model.addAttribute("totalShowPrice", formattedTotalRentPrice);
		return "/admin/showSales";
	
	}
	
	@PostMapping("/showSalesTitle")
	public String showSalesSearchTitle(@RequestParam("searchTitle") String searchTitle,Model model) {
		List<RequestManagerShowSaleDto> showSalesList = adminSaleService.readShowSaleBySearch(searchTitle);
		model.addAttribute("showSalesList", showSalesList);
		
		return "/admin/showSales";
		}
	
	@PostMapping("/rentSalesDay")
	public String rentSalesDay(RequestManagerShowSaleDto requestManagerShowSaleDto, Model model) {
		String str = requestManagerShowSaleDto.getStartDate();
		String[] split = str.split(" ~ ");
		requestManagerShowSaleDto.setStartDate(split[0] + " 00:00:00");
		requestManagerShowSaleDto.setEndDate(split[1] + " 00:00:00");
		List<RentSalesDto> rentSaleslist = adminSaleService.readRentalSlesByStartDateAndEndDate(requestManagerShowSaleDto.getStartDate(), requestManagerShowSaleDto.getEndDate());
		
		int totalRentPrice = 0;
	    for (RentSalesDto rentSalesDto : rentSaleslist) {
	        String rentPriceString = rentSalesDto.getRentPrice();
	        String cleanedRentPriceString = rentPriceString.replace(",", "");
	        int rentPrice = Integer.parseInt(cleanedRentPriceString);
	        totalRentPrice += rentPrice;
	    }
	    
	    DecimalFormat decimalFormat = new DecimalFormat("#,###"); // 쉼표 포함한 형식 지정
	    String formattedTotalRentPrice = decimalFormat.format(totalRentPrice);
	    model.addAttribute("rentSaleslist", rentSaleslist);
	    model.addAttribute("totalRentPrice", formattedTotalRentPrice); // 쉼표를 포함한 문자열로 추가
		
		return "/admin/rentSales";
	}
	
	@PostMapping("/rentSalesTitle")
	public String rentSalesSearchTitle(@RequestParam("searchTitle") String searchTitle,Model model) {
		
		
		List<RentSalesDto> rentSaleslist = adminSaleService.readRentalSalesBySearch(searchTitle);
		System.out.println(rentSaleslist);
		int totalRentPrice = 0;
	    for (RentSalesDto rentSalesDto : rentSaleslist) {
	        String rentPriceString = rentSalesDto.getRentPrice();
	        String cleanedRentPriceString = rentPriceString.replace(",", "");
	        int rentPrice = Integer.parseInt(cleanedRentPriceString);
	        totalRentPrice += rentPrice;
	    }
	    
	    DecimalFormat decimalFormat = new DecimalFormat("#,###"); // 쉼표 포함한 형식 지정
	    String formattedTotalRentPrice = decimalFormat.format(totalRentPrice);
		model.addAttribute("rentSaleslist", rentSaleslist);
	    model.addAttribute("totalRentPrice", formattedTotalRentPrice);
		
		return "/admin/rentSales";
	}
	
}
