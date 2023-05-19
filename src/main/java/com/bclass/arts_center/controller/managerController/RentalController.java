package com.bclass.arts_center.controller.managerController;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.handler.exception.UnAuthorizedException;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.RentalService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/rental")
public class RentalController {

	@Autowired
	private RentalService rentalService;
	
	@Autowired
	private HttpSession session;
	
	
	// 대관신청 바로가기  페이지
	@GetMapping("")
	public String rentalPage(Model model) {
		User principal = (User)session.getAttribute(Define.PRINCIPAL);
		if(principal.getRoleId() != 2) {
			
			 throw new UnAuthorizedException("매니저 계정으로 로그인 해주세요", HttpStatus.BAD_REQUEST);
		}
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
	    return "/manager/rentalLocation";
	}
	
	
	// 대관 신청 insert
	@PostMapping("/reservation")
	public String insertRental(RequestRentPlaceDto requestRentPlaceDto) {
		int result = rentalService.insertRental(requestRentPlaceDto);
		
		
		Time startTime = requestRentPlaceDto.getStartTime();
		Time endTime = requestRentPlaceDto.getEndTime();
		
		
		String str = requestRentPlaceDto.getStartDate();
		String[] split = str.split("~");
		requestRentPlaceDto.setStartDate(split[0]);
		requestRentPlaceDto.setEndDate(split[1]);
		rentalService.insertRental(requestRentPlaceDto);
		 
		
		
		if(startTime.equals(endTime)) {
			throw new CustomRestfullException("시간 선택을 다시 해주세요", HttpStatus.BAD_REQUEST);
		} else {
			System.out.println("insert 됬어용? : " + requestRentPlaceDto+"DDDD");
			System.out.println("여기 값이 들어오나요?" + result);
			return "/manager/rental";
		}
		
	}
}
