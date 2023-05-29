package com.bclass.arts_center.controller.managerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.service.ScheduleService;

@Controller
@RequestMapping("/manager")
public class ManagerScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	/**
	 * 작성자 : 전대영 managerSchedule 페이지 데이터 불러오기
	 */
	@GetMapping("/schedule/{id}")
	public String selectByShow(@PathVariable Integer id,Model model) {
		List<RequestShowDto> showList = scheduleService.selectByMyShow(id);
		model.addAttribute("lists", showList);
		return "/manager/managerSchedule";
	}

}
