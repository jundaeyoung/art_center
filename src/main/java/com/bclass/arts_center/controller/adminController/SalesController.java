package com.bclass.arts_center.controller.adminController;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.RentSalesDto;
import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.service.AdminSaleService;
import com.bclass.arts_center.service.TicketService;

@Controller
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private AdminSaleService adminSaleService;
	
	@GetMapping("/showGrape")
	public String showGrape() {
		System.out.println("111111111");
		return "/admin/board2";
	}
	
	@GetMapping("/show")
	public String showSales(Model model) {
		List<TicketingDto> ticketList = ticketService.readTicketingAll();
		System.out.println(ticketList);
		DecimalFormat df = new DecimalFormat("###,###");
		if (ticketList.size() == 0) {
			model.addAttribute("ticketList", null);
		} else {
			int sum = 0;
			for (int i = 0; i < ticketList.size(); i++) {
				if (ticketList.get(i).getAdultCount() != 0) {
					String str = ticketList.get(i).getAdultRate();
					String newStr = str.replaceAll(",", "");
					sum += Integer.parseInt(newStr) * ticketList.get(i).getAdultCount();
				}
			}
			df.format(sum);
			model.addAttribute("ticketList", ticketList);
		}
		
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
	
}
