package com.bclass.arts_center.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.TicketingDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.ShowService;
import com.bclass.arts_center.service.TicketService;
import com.bclass.arts_center.utils.Define;

/**
 * 
 * @author 손주이
 *
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	private ShowService showService;

	@Autowired
	private HttpSession session;

	@GetMapping("/ticketing/{showId}")
	public String ticketingPage(@PathVariable("showId") Integer showId, Model model) {
//		로그인 인증 필요
		List<TicketingDto> showDateList = ticketService.readShowDate(showId);

		List<TicketingDto> showInfo = ticketService.readShowInfoForTicketing(showId);
		List<ShowViewDto> showInformation = showService.readShowInfoByShowId(showId);
		System.out.println(showInformation.get(0).getLocationId());
		if (showDateList == null || showDateList.isEmpty()) {
			model.addAttribute("showDateList", null);
		} else {
			model.addAttribute("showDateList", showDateList);
		}
		model.addAttribute("showId", showId);
		if (showInfo == null || showInfo.isEmpty()) {
			model.addAttribute("showInfo", null);
		} else {
			model.addAttribute("title", showInfo.get(0).getTitle());
		}
		if (showInformation == null || showInformation.isEmpty()) {
			model.addAttribute("showInformation", null);
		} else {
			model.addAttribute("showInformation", showInformation.get(0).getLocationId());
		}
		return "/ticket/ticketing";
	}

	@PostMapping("/ticketing")
	public String ticketProc(TicketingDto ticketingDto) {
//		로그인 했다는 인증 필요
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		System.out.println(ticketingDto);
		ticketingDto.setUserId(principal.getId());

		ticketService.waitTicket(ticketingDto);


		return "redirect:/ticket/ticketCheck";
	}

	@GetMapping("/ticketCheck")
	public String ticketCheck(Model model) {

		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		String userBirth = principal.getBirthDate();
		String replaceuserBirth = userBirth.replaceAll("-", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String nowDate = sdf.format(now);

		int startMonth1 = Integer.parseInt(replaceuserBirth.substring(0, 4));
		int startMonth2 = Integer.parseInt(nowDate.substring(0, 4));

		int userAge = startMonth2 - startMonth1;

		List<TicketCheckDto> ticketListInfo = ticketService.checkTicket(principal.getId());
		model.addAttribute("ticketListInfo", ticketListInfo);
		model.addAttribute("userAge", userAge);

		System.out.println(ticketListInfo);
		return "/ticket/ticketCheck";
	}

}
