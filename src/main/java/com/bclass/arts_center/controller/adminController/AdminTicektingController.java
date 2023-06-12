package com.bclass.arts_center.controller.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.service.TicketService;

@Controller
@RequestMapping("/ticketing")
public class AdminTicektingController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/")
	public String selectTicekting(Model model) {
		List<TicketingDto> ticketList = ticketService.readTicketingAll();

		if (ticketList.size() == 0 || ticketList.isEmpty()) {
			model.addAttribute("ticketList", null);
		} else {
			model.addAttribute("ticketList", ticketList);
		}
		return "/admin/ticketing";
	}

}


