package com.bclass.arts_center.controller.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.repository.model.Announcement;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.AnnouncementService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/admin/announcement")
public class AdminAnnouncementController {

	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private HttpSession session;
	
	
	@GetMapping("")
	public String selectAnnouncementList (Model model) {
		List<Announcement> announcementList = announcementService.readAnnouncement();
		model.addAttribute("announcements", announcementList);
		
		return "admin/announcementList";
	}
	
	
	@GetMapping("/board")
	public String writeBoard() {
		return "admin/announcementWrite";
	}
	
	
	@GetMapping("/detail")
	public String detailAnnouncement(Integer id, Model model) {
		Announcement announcement = announcementService.readAnnouncementById(id);
		model.addAttribute("announcement", announcement);
		
		return "admin/announcementUpdate";
	}
	
	
	@PostMapping("/write")
	public String writeAnnouncement(Announcement announcement) {
		 User principal = (User)session.getAttribute(Define.PRINCIPAL);
		 announcement.setUserId(principal.getId());
		 announcementService.createAnnouncement(announcement);
		 
		return "redirect:/admin/announcement";
	}
	
	
	@PostMapping("/update")
	public String updateAnnouncement(Announcement announcement) {
		announcementService.updateAnnouncement(announcement);
		
		return "redirect:/admin/announcement";
	}
	
	
	@GetMapping("/delete")
	public String deleteAnnouncement(Integer id) {
		announcementService.deleteAnnouncementByUserId(id);
		
		return "redirect:/admin/announcement";
	}
	
}

