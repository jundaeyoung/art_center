package com.bclass.arts_center.controller.managerController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.NoticeService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/managerNotice")
public class ManagerNoticeController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private NoticeService noticeService;

	
	@GetMapping("/notice")
	public String notice() {
		
		return "/manager/managerNotice";
	}

	
	@GetMapping("/update/{id}")
	public String updateNotice(@PathVariable Integer id) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		noticeService.updateNotice(id);
		
		return "redirect:/myPage/myShow/"+principal.getId()+"/1/0/5";
	}
}
