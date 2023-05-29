package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.repository.model.Announcement;
import com.bclass.arts_center.repository.model.Notice;
import com.bclass.arts_center.repository.model.Show;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.MainService;
import com.bclass.arts_center.service.NoticeService;
import com.bclass.arts_center.service.ScheduleService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private MainService mainService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private HttpSession session;

	/*
	 * 전대영 main에서 공연정보 불러오기
	 */
	@GetMapping("/")
	public String main(Model model) {
		List<Show> showsList = mainService.readShowDto();
		List<Announcement> selectAnnouncement = mainService.selectAnnouncement();
		model.addAttribute("selectAnnouncement",selectAnnouncement);
		System.out.println(selectAnnouncement);
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		if (principal == null) {
			model.addAttribute("principal", null);
		} else {
			List<Notice> noticeList = noticeService.readNotice(principal.getId());
			List<RequestShowDto> showList = scheduleService.selectByMyShow(principal.getId());
			model.addAttribute("lists", showList);
				if (noticeList == null || noticeList.size()==0) {
					model.addAttribute("noticeList", null);
					model.addAttribute("message", 0);
				} else {
					model.addAttribute("noticeList", noticeList);
				}
				model.addAttribute("principal", principal);
		}
		if (showsList.isEmpty()) {
			model.addAttribute("showsList", null);
		} else {
			model.addAttribute("showsList", showsList);
		}
		return "/main";
	}
	
}
