package com.bclass.arts_center.controller.managerController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ScheduleService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/manager/schedule")
public class ManagerScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private HttpSession session;

	
	@GetMapping("")
	public String selectMyShowSchedule(Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		List<RequestShowDto> showList = scheduleService.readMyShowSchedule(principal.getId());
		if (showList.isEmpty() || showList == null) {
			model.addAttribute("lists", null);
		} else {
			model.addAttribute("lists", showList);
		}
		return "/manager/managerSchedule";
	}

}
