package com.bclass.arts_center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapApiController {
	
	@GetMapping("/auth/kakao/callback")
	@ResponseBody
	public String kakaoCallbackCode() {
		
		return "/user/map";
	}

	
}