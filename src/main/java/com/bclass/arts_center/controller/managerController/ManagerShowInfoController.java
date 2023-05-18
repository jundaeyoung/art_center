package com.bclass.arts_center.controller.managerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerShowInfoController {

	
	@GetMapping("/manager/showInfo")
	public String managerShowInfo() {
		
		return "/manager/managerShowInfo";
	}
}
