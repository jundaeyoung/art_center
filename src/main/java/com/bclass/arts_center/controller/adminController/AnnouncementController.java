package com.bclass.arts_center.controller.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.repository.model.Announcement;
import com.bclass.arts_center.service.AnnouncementService;

@Controller
@RequestMapping("/Announcement")
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;
	
	@GetMapping("")
	public String AnnouncementList (Model model) {
		
		List<Announcement> announcements = announcementService.readAnnouncement();
		
		model.addAttribute("announcements", announcements);
		
		return "admin/announcementList";
	}
	
	@GetMapping("/detail")
	public String detailannouncement(Integer id, Model model) {
		Announcement announcement = announcementService.readAnnouncementById(id);
		model.addAttribute("announcement", announcement);
		return "admin/announcementUpdate";
	}
	
	@PostMapping("/update")
	public String updateAnnouncement(Announcement announcement) {
		int result = announcementService.updateAnnouncement(announcement);
		return "redirect:/Announcement";
	}
	@GetMapping("/delete")
	public String deleteAnnouncement(Integer id) {
		System.out.println("11111111111");
		int result = announcementService.deleteAnnouncementByUserId(id);
		
		return "redirect:/Announcement";
	}
	
}
