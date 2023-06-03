package com.bclass.arts_center.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bclass.arts_center.dto.NaverDto.Response;
import com.bclass.arts_center.dto.SignInFormDto;
import com.bclass.arts_center.dto.SignUpFormDto;
import com.bclass.arts_center.dto.UpdateUserDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.User;
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
	public String signUpProc(@Valid SignUpFormDto signUpFormDto,HttpServletResponse response, BindingResult errors, Model model) {

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
		if (signUpFormDto.getRoleId() == null) {
			signUpFormDto.setRoleId(1);
		}
		Integer result = userService.createUser(signUpFormDto);
		if (result == 1) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				String msg = "대관 신청이 완료되었습니다.";
				w.write("<script>alert('" + msg + "');</script>");
				w.flush();
				w.close();
				return "redirect:/user/login";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new CustomRestfullException("회원가입에 실패하였습니다.", HttpStatus.BAD_REQUEST);
		}
		System.out.println(result);
		return "redirect:/user/login";
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
		userService.updateUser(updateUserDto);

		return "redirect:/";
	}

	// 회원탈퇴
	@PostMapping("/deleteProc")
	public String delete(SignInFormDto signInFormDto) {

		if (signInFormDto.getPassword() == null || signInFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("password를 입력하세요", HttpStatus.BAD_REQUEST);
		}

		userService.deleteUser(signInFormDto);

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

	@GetMapping("/findId")
	public String findId() {

		return "user/findId";
	}

	@PostMapping("findId")
	public String findId(User user) {
		userService.selectUserName(user);
		return "user/findId";
	}

}