package com.bclass.arts_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.MailDto;
import com.bclass.arts_center.repository.interfaces.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SendEmailService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private static final String FROM_ADDRESS = "jdy1787@naver.com";

	@Transactional
	public MailDto createMailAndChangePassword(String userEmail, String userName) {
		String newPassword = getTempPassword();
		MailDto message = new MailDto();
		message.setAddress(userEmail);
		message.setTitle(userName + "님의 AMADEUS 임시비밀번호 안내 이메일 입니다.");
		message.setMessage(
				"안녕하세요. AMADEUS 임시비밀번호 안내 관련 이메일 입니다." + "[ " + userName + " ]" + "님의 임시 비밀번호는 " + newPassword + " 입니다.");
		updatePassword(newPassword, userEmail);
		return message;
	}
	
	
	@Transactional
	public MailDto createMailCode(String userEmail) {
		String code = getTempPassword();
		MailDto message = new MailDto();
		message.setAddress(userEmail);
		message.setTitle("AMADEUS 인증코드 안내 이메일 입니다.");
		message.setMessage(
				"안녕하세요. AMADEUS 인증코드 안내 관련 이메일 입니다. 인증코드는 " + code + " 입니다.");
		return message;
	}

	
	@Transactional
	public void updatePassword(String password, String userEmail) {
		password = passwordEncoder.encode(password);
		String id = userRepository.findUserByUserId(userEmail).getUserName();
		userRepository.updateUserPassword(id, password);
	}

	
	@Transactional
	public String getTempPassword() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		String code = "";

		Integer idx = 0;
		for (int i = 0; i < 10; i++) {
			idx = (int) (charSet.length * Math.random());
			code += charSet[idx];
		}
		return code;
	}

	
	@Transactional
	public void mailSend(MailDto mailDto) {
		System.out.println("이메일 전송 완료!");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailDto.getAddress());
		message.setFrom(SendEmailService.FROM_ADDRESS);
		message.setSubject(mailDto.getTitle());
		message.setText(mailDto.getMessage());
		mailSender.send(message);
	}
}

