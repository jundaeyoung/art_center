package com.bclass.arts_center.controller.managerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RentalController {

	@GetMapping("/rental")
	public String rentalPage() {
		return "/manager/rental";
	}
}
