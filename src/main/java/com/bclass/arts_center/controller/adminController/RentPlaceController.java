package com.bclass.arts_center.controller.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 작성자 : 편용림 대관 페이지 (admin)
 */

@Controller
@RequestMapping("/rentPlace")
public class RentPlaceController {

	@GetMapping("")
	public String RentPlace() {
		
		return "/admin/rentPlace";
	}
	
}
