package com.bclass.arts_center.controller.managerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestLocationDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceDto;
import com.bclass.arts_center.service.RentalService;

@Controller
@RequestMapping("/rental")
public class RentalController {

	@Autowired
	private RentalService rentalService;
	
	// 대관신청 바로가기  페이지
	@GetMapping("")
	public String rentalPage() {
		return "/manager/rental";
	}
	
	// 대관 신청 페이지
	@GetMapping("/location/{id}")
	public String rentalLocation(Model model, @PathVariable("id") Integer id) {
		List<RequestLocationDto> locationLists = rentalService.selectByLocation(id);
		model.addAttribute("locationLists", locationLists);
		model.addAttribute("location",locationLists.get(0).getLocation());
		return "/manager/rentalLocation";
	}
	
	// 대관 신청 insert
	@PostMapping("/reservation")
	public String insertRental(RequestRentPlaceDto requestRentPlaceDto) {
		rentalService.insertRental(requestRentPlaceDto);
		return "/manager/rental";
	}
}
