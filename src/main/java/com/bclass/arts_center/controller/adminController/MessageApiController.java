package com.bclass.arts_center.controller.adminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoEmptyResponseException;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.exception.NurigoUnknownException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

@RestController
public class MessageApiController {
	
	@GetMapping("/sendMessage")
	public void sendMessage() throws NurigoEmptyResponseException, NurigoUnknownException {
		Message message = new Message();
//		DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("NCSIUCBVWM1LNGYW", "PORQYCOTCZG40A9QVR77YYW0HS5IJM6Y", "https://api.coolsms.co.kr");
		message.setFrom("01024790491");
		message.setTo("01042410914");
		message.setText("SMS는 한글 45자, 영자 90자까지 입력할 수 있습니다.");
		System.out.println(message+"message");
//		try {
//			  messageService.send(message);
//			} catch (NurigoMessageNotReceivedException exception2) {
//			}
	}
	
}