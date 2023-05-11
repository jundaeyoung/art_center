package com.bclass.arts_center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DummyController {
	@GetMapping("/")
	public String main() {
		
		return "/dummy";
	}
}
