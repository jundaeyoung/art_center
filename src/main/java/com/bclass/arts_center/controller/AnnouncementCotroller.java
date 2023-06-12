package com.bclass.arts_center.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.repository.model.Announcement;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.AnnouncementService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/announcement")
public class AnnouncementCotroller {

	@Autowired
	private AnnouncementService announcementService;

	@GetMapping("")
	public String notice(@RequestParam(defaultValue = "select") String crud, Model model) {
		String searchText = "";
		List<Announcement> announcementList = announcementService.readAnnouncementBySearchText(searchText);
		model.addAttribute("crud", crud);
		model.addAttribute("announcements", announcementList);
		model.addAttribute("searchText", searchText);

		return "/announcement/notice";
	}

	@PostMapping("/search")
	public String noticePost(String searchText, Model model) {
		List<Announcement> announcementList = announcementService.readAnnouncementBySearchText(searchText);
		model.addAttribute("announcements", announcementList);
		model.addAttribute("crud", "select");
		
		return "/announcement/notice";
	}
}
