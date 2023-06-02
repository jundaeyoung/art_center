package com.bclass.arts_center.controller.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.service.TicketService;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoEmptyResponseException;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.exception.NurigoUnknownException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

@RestController
public class MessageApiController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/sendMessage")
	public void sendMessage(Integer sessionTicketingId) throws NurigoEmptyResponseException, NurigoUnknownException {
		TicketCheckDto result = ticketService.readTicketIdById(sessionTicketingId);
		Message message = new Message();
		DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("NCSIUCBVWM1LNGYW", "PORQYCOTCZG40A9QVR77YYW0HS5IJM6Y", "https://api.coolsms.co.kr");
		message.setFrom("01024790491");
		message.setTo(result.getTel());
		System.out.println(result.getTel() + "messageApiController 확인하고 sysout 삭제 바람!!!!!!!!");
		if (result.getShowTypeId() == 1) {
			message.setText("공연 시간: " + result.getShowDate() + "일" + result.getShowTime() + "시 \n" + "공연정보: "
					+ result.getTitle() + "(" + result.getName() + "/" + result.getSeatName() + ")\n" + "즐거운 시간 되십시오");
		} else if (result.getShowTypeId() == 2) {
			message.setText("전시회 시간: " + result.getShowDate() + "일" + result.getShowTime() + "시 \n" + "전시회 정보: "
					+ result.getTitle() + "(" + result.getName() + ")\n" + "즐거운 시간 되십시오");
		} else {
			message.setText("아카데미 시간: " + result.getShowDate() + "일" + result.getShowTime() + "시 \n" + "아카데미 정보: "
					+ result.getTitle() + "(" + result.getName() + ")\n" + "즐거운 시간 되십시오");
		}
		try {
			messageService.send(message);
		} catch (NurigoMessageNotReceivedException exception2) {
		}
	}
}