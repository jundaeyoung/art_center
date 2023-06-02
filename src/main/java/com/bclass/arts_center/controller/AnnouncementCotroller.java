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

/**
 * 
 * @author 편용림
 *
 */
@Controller
@RequestMapping("/announcement")
public class AnnouncementCotroller {

	@Autowired
	private AnnouncementService announcementService;

	@GetMapping("")
	public String notice(Model model, @RequestParam(defaultValue = "select") String crud) {
		String searchText = "";
		List<Announcement> announcements = announcementService.readAnnouncementBySearchText(searchText);
		model.addAttribute("crud", crud);
		model.addAttribute("announcements", announcements);
		model.addAttribute("searchText", searchText);
		return "/announcement/notice";
	}

	@PostMapping("/search")
	public String notice2(Model model, String searchText) {
		List<Announcement> announcements = announcementService.readAnnouncementBySearchText(searchText);
		model.addAttribute("announcements", announcements);
		model.addAttribute("crud", "select");
		return "/announcement/notice";
	}
}