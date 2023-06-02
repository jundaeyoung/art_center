package com.bclass.arts_center.controller.adminController;

import java.text.DecimalFormat;
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

	/*
	 * 전대영 : 관리자 예매 목록 검색
	 */
	@GetMapping("/")
	public String selectTicekting(Model model) {
		List<TicketingDto> ticketList = ticketService.readTicketingAll();
		DecimalFormat df = new DecimalFormat("###,###");
		if (ticketList.size() == 0) {
			model.addAttribute("ticketList", null);
		} else {
			int sum = 0;
			for (int i = 0; i < ticketList.size(); i++) {
				if (ticketList.get(i).getAdultCount() != 0) {
					String str = ticketList.get(i).getAdultRate();
					String newStr = str.replaceAll(",", "");
					sum += Integer.parseInt(newStr) * ticketList.get(i).getAdultCount();
				}
			}
			df.format(sum);
			model.addAttribute("ticketList", ticketList);
		}
		return "/admin/ticketing";
	}

	@GetMapping
	public String readTicketingAll() {

		return "/admin/ticketing";

	}

}
