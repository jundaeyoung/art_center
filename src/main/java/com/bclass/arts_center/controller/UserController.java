package com.bclass.arts_center.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bclass.arts_center.dto.SignInFormDto;
import com.bclass.arts_center.dto.SignUpFormDto;
import com.bclass.arts_center.dto.UpdateUserDto;
import com.bclass.arts_center.dto.request.MailDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.SendEmailService;
import com.bclass.arts_center.service.UserService;
import com.bclass.arts_center.utils.Define;

/**
 * 
 * @author 편용림
 *
 *         유저 Controller
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/*
	 * 전대영 : email 임시비밀번호 발급
	 */
	@Autowired
	private SendEmailService sendEmailService;

	@Value("${spring.mail.username}")
	private String from;

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	// 로그인 페이지
	@GetMapping("/login")
	public String login() {
		return "/user/signIn";
	}

	// 회원가입 페이지
	@GetMapping("/signUp")
	public String signUp() {
		
		return "/user/signUpchoice";
	}
	
	@GetMapping("/signUpchoice")
	public String signUpchoice(Integer roleId, Model model) {
		model.addAttribute("roleId", roleId);
		return "/user/signUp";
	}

	// 개인정보 수정 페이지
	@GetMapping("/update")
	public String update(Model model, String userName) {
		SignInFormDto dto = new SignInFormDto();
		dto.setUserName(userName);
		User user = userService.readUserByUserName(dto.getUserName());

		model.addAttribute("user", user);

		return "/user/update";

	}

	// 회원탈퇴 페이지
	@GetMapping("/delete")
	public String delete(Model model, String userName) {
		SignInFormDto dto = new SignInFormDto();
		dto.setUserName(userName);
		User user = userService.readUserByUserName(dto.getUserName());
		model.addAttribute("user", user);

		return "/user/delete";
	}

	// 로그인 처리
	@PostMapping("/loginProc")
	public String loginProc(SignInFormDto signInFormDto) {

		if (signInFormDto.getUserName() == null || signInFormDto.getUserName().isEmpty()) {
			throw new CustomRestfullException("username을 입력하세요", HttpStatus.BAD_REQUEST);
		}
		if (signInFormDto.getPassword() == null || signInFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("password를 입력하세요", HttpStatus.BAD_REQUEST);
		}
		User principal = userService.readUser(signInFormDto);

		session.setAttribute(Define.PRINCIPAL, principal);

		if (principal.getRoleId() == 3) {
			return "redirect:/admin";
		} else {
			return "redirect:/";
		}
	}

	// 로그아웃 처리
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

	// 회원가입 처리
	@PostMapping("/signUp")
	public String signUpProc(@Valid SignUpFormDto signUpFormDto, BindingResult errors, Model model) {

		if (signUpFormDto.getUserName() == null || signUpFormDto.getUserName().isEmpty()) {
			throw new CustomRestfullException("아이디를 입력해주세요", HttpStatus.BAD_REQUEST);
		} else if (signUpFormDto.getPassword() == null || signUpFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("패스워드 입력해주세요", HttpStatus.BAD_REQUEST);
		} else if (signUpFormDto.getNickname() == null || signUpFormDto.getNickname().isEmpty()) {
			throw new CustomRestfullException("닉네임을 입력해주세요", HttpStatus.BAD_REQUEST);
		} else if (signUpFormDto.getEmail() == null || signUpFormDto.getEmail().isEmpty()) {
			throw new CustomRestfullException("이메일을 입력해주세요", HttpStatus.BAD_REQUEST);
		} else if (signUpFormDto.getBirthDate() == null) {
			throw new CustomRestfullException("생년월일을 입력해주세요.", HttpStatus.BAD_REQUEST);
		} else if (signUpFormDto.getTel() == null || signUpFormDto.getTel().isEmpty()) {
			throw new CustomRestfullException("전화번호를 입력주세요", HttpStatus.BAD_REQUEST);
		} else if (signUpFormDto.getBirthDate() == null) {
			throw new CustomRestfullException("생년월일을 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		if (errors.hasErrors()) {
			
			Map<String, String> validatorResult = userService.validateHandling(errors);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}

			return "/user/signUp";
		}
		userService.createUser(signUpFormDto);
		return "redirect:/";
	}

	// 개인정보 수정
	@PostMapping("/update")
	public String update(@Valid UpdateUserDto updateUserDto, BindingResult errors, Model model) {

		if (errors.hasErrors()) {

			model.addAttribute("user", updateUserDto);

			Map<String, String> validatorResult = userService.validateHandling(errors);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			return "/user/update";

		}
		int result = userService.updateUser(updateUserDto);

		return "redirect:/";
	}

	// 회원탈퇴
	@PostMapping("/deleteProc")
	public String delete(SignInFormDto signInFormDto) {

		if (signInFormDto.getPassword() == null || signInFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("password를 입력하세요", HttpStatus.BAD_REQUEST);
		}

		int result = userService.deleteUser(signInFormDto);

		session.invalidate();

		return "redirect:/";
	}

	/*
	 * 작성자 : 전대영 비밀번호 찾기
	 */
	@GetMapping("/findPw")
	public String findPw() {
		return "/user/findPw";
	}

	/*
	 * 작성자 : Email과 name의 일치여부를 check하는 컨트롤러
	 */
	@GetMapping("/check/findPw")
	public @ResponseBody Map<String, Boolean> findPassword(String userEmail, String userName) {
		Map<String, Boolean> json = new HashMap<>();
		boolean findPasswordCheck = userService.userEmailCheck(userEmail, userName);
		json.put("check", findPasswordCheck);
		return json;
	}

	/*
	 * 전대영 : 등록된 이메일로 임시비밀번호를 발송하고 발송된 임시비밀번호로 사용자의 pw를 변경하는 컨트롤러
	 */
	@PostMapping("/check/findPw/sendEmail")
	public @ResponseBody void sendEmail(String userEmail, String userName) {
		MailDto dto = sendEmailService.createMailAndChangePassword(userEmail, userName);
		sendEmailService.mailSend(dto);

	}

	/*
	 * 작성자 : email 중복검사
	 */
	@GetMapping("/check/findEmail")
	public @ResponseBody Map<String, Boolean> findEmail(String userEmail) {
		Map<String, Boolean> json = new HashMap<>();
		boolean findEmailCheck = userService.emailCheck(userEmail);
		json.put("check", findEmailCheck);
		return json;
	}

	/*
	 * 전대영 : 이메일 중복검사 인증코드 날림
	 */
	@PostMapping("/check/email/sendEmail")
	public @ResponseBody String sendEmailCheckEmail(String userEmail) {
		String str = sendEmailService.getTempPassword();
		MailDto dto = new MailDto();
		dto.setAddress(userEmail);
		dto.setTitle("AMADEUS 인증코드 안내 이메일 입니다.");
		dto.setMessage("안녕하세요. AMADEUS 인증코드 안내 관련 이메일 입니다. 인증코드는 " + str + " 입니다.");
		sendEmailService.mailSend(dto);

		return str;

	}
	@PostMapping("/check/userName")
	@ResponseBody
	public Integer sendUserNameCheck(@RequestBody String userName) {
		Integer result = userService.userNameCheck(userName);
		return result;
	}
	
	@PostMapping("/check/nickname")
	@ResponseBody
	public Integer sendNicknameCheck(@RequestBody String nickname) {
		Integer result = userService.nicknameCheck(nickname);
		return result;
	}
	
	@GetMapping("/findId")
	public String findId() {
		
		return "user/findId";
	}
	
	@PostMapping("findId")
	public String findId(User user) {
		User users = userService.selectUserName(user);
		return "user/findId";
	}
	
	
	
	@PostMapping("/findBy")
	@ResponseBody
	public Integer sendTelCheck(@RequestBody String tel) {
		Integer result = userService.telCheck(tel);
		return result;
	}
	
}