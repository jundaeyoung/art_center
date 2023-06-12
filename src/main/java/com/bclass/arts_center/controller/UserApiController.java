package com.bclass.arts_center.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.request.MailDto;
import com.bclass.arts_center.dto.response.ResponseDto;
import com.bclass.arts_center.service.SendEmailService;
import com.bclass.arts_center.service.UserService;

@RestController
@RequestMapping("/user/check")
public class UserApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private SendEmailService sendEmailService;

	@Value("${spring.mail.username}")
	private String from;
	

	@PostMapping("/userName")
	public ResponseDto<Integer> sendUserNameCheck(@RequestBody String userName) {
		Integer result = userService.userNameCheck(userName);
		
		return new ResponseDto<Integer>(200,HttpStatus.OK.toString(),result);
	}

	
	@PostMapping("/nickname")
	public ResponseDto<Integer> sendNicknameCheck(@RequestBody String nickname) {
		Integer result = userService.nicknameCheck(nickname);
		
		return new ResponseDto<Integer>(200, HttpStatus.OK.toString(),result);
	}

	
	@PostMapping("/tel")
	public ResponseDto<Integer> sendTelCheck(@RequestBody String tel) {
		Integer result = userService.telCheck(tel);
		
		return new ResponseDto<Integer>(200,HttpStatus.OK.toString(),result);
	}
	
	
	@GetMapping("/findPw")
	public ResponseDto<Map<String, Boolean>> findPassword(String userEmail, String userName) {
		Map<String, Boolean> json = new HashMap<>();
		boolean findPasswordCheck = userService.findUserNameByEmail(userEmail, userName);
		json.put("check", findPasswordCheck);
		
		return new ResponseDto<Map<String, Boolean>>(200, HttpStatus.OK.toString(),json);
	}

	
	@PostMapping("/findPw/sendEmail")
	public void sendEmail(String userEmail, String userName) {
		MailDto dto = sendEmailService.createMailAndChangePassword(userEmail, userName);
		sendEmailService.mailSend(dto);
	}

	
	@GetMapping("/findEmail")
	public ResponseDto<Map<String, Boolean>> findEmail(String userEmail) {
		Map<String, Boolean> json = new HashMap<>();
		boolean findEmailCheck = userService.emailCheckByEmail(userEmail);
		json.put("check", findEmailCheck);
		
		return new ResponseDto<Map<String,Boolean>>(200,HttpStatus.OK.toString(),json);
	}


	@PostMapping("/email/sendEmail")
	public ResponseDto<String> sendEmailCheckEmail(String userEmail) {
		String code = sendEmailService.getTempPassword();
		MailDto message = new MailDto();
		message.setAddress(userEmail);
		message.setTitle("AMADEUS 인증코드 안내 이메일 입니다.");
		message.setMessage("안녕하세요. AMADEUS 인증코드 안내 관련 이메일 입니다. 인증코드는 " + code + " 입니다.");
		sendEmailService.mailSend(message);
		
		return new ResponseDto<String>(200, HttpStatus.OK.toString(),code);
	}
}


