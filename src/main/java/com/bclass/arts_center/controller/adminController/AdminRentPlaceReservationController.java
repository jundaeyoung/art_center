package com.bclass.arts_center.controller.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestRentPlaceReservationDto;
import com.bclass.arts_center.service.RentPlaceReservationService;

@Controller
@RequestMapping("/admin/rentPlace")
public class AdminRentPlaceReservationController {

	@Autowired
	private RentPlaceReservationService placeReservationService;
	
	
	@GetMapping("")
	public String selectRentPlaceList(Model model) {
		List<RequestRentPlaceReservationDto> rentPlaceList = placeReservationService.readRentPlaceReservationList();
		model.addAttribute("rentPlaces", rentPlaceList);
		
		return "admin/rentPlaceReservationList";
	}
	
}
