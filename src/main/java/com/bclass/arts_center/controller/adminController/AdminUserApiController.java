package com.bclass.arts_center.controller.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.RequestUserCountDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.UserService;

@RestController
public class AdminUserApiController {

	@Autowired
	private UserService userService;

	@GetMapping("/api/admin/userjoinPerDate")
	public List<RequestUserCountDto> readUserByDate() {
		System.out.println("111111111111111111");
		List<RequestUserCountDto> joinDateUserList = userService.readJoinUserByDate();
		return joinDateUserList;
	}

}
