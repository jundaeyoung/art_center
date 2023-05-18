package com.bclass.arts_center.controller.managerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.request.RequestHoleDto;
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
	@Transactional
	public String rentalLocation(Model model, @PathVariable("id") Integer id) {
		List<RequestHoleDto> locationLists = rentalService.selectByLocation(id);
		List<RequestHoleDto> timeList = rentalService.selectByTime(id);
		System.out.println(locationLists);
		model.addAttribute("locationLists", locationLists);
		model.addAttribute("timeList", timeList);
		model.addAttribute("location", locationLists.get(0).getLocation());
		model.addAttribute("locationId",id);
		model.addAttribute("price", locationLists.get(0).getPrice());
		model.addAttribute("name", locationLists.get(0).getName());
		return "/manager/rentalLocation";
	}
	
	@PostMapping("/location")
	public String rentalLocationPost(Model model, @RequestParam("id") Integer id) {
	    List<RequestHoleDto> locationLists = rentalService.selectByLocation(id);
	    List<RequestHoleDto> timeList = rentalService.selectByTime(id);
	    model.addAttribute("timeList", timeList);
	    model.addAttribute("locationLists", locationLists);
	    model.addAttribute("location", locationLists.get(0).getLocation());
	    return "/manager/rentalLocation";
	}
	
	
	// 대관 신청 insert
	@PostMapping("/reservation")
	public String insertRental(RequestRentPlaceDto requestRentPlaceDto) {
		System.out.println(requestRentPlaceDto+"DDDD");
		int result = rentalService.insertRental(requestRentPlaceDto);
		System.out.println("여기 값이 들어오나요?" +result);
		return "/manager/rental";
	}
}
