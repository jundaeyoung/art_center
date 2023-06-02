package com.bclass.arts_center.controller.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bclass.arts_center.dto.request.RequestQuestionDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.NoticeService;
import com.bclass.arts_center.service.QuestionService;
import com.bclass.arts_center.service.ShowService;
import com.bclass.arts_center.service.UserService;
import com.bclass.arts_center.utils.Define;

/**
 * 
 * @author 편용림, 전대영
 *
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserService userService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ShowService showService;
	@Autowired
	private NoticeService noticeService;

	// 메인화면
	@GetMapping("")
	public String admin(Model model) {
		List<User> userList = userService.readUser();
		model.addAttribute("userList", userList);
		return "/admin/userList";
	}

	// 작성자 : 편용림 관리자 페이지 로그아웃
	@GetMapping("/logout")
	public String adminLogout() {
		session.invalidate();
		return "redirect:/";
	}

	/*
	 * 작성자 편용림 : 유저 목록
	 */
	@GetMapping("/userList")
	public String userList() {
		return "redirect:/admin/";
	}

	/*
	 * 전대영 : Question목록보기
	 */
	@GetMapping("/questionAll")
	public String QuestionAllList(Model model) {
		List<RequestQuestionDto> questionList = questionService.readQuestionAll();
		if (questionList.isEmpty()) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", questionList);
		}
		return "/admin/adminQuestion";
	}

	/*
	 * 전대영 : Question 답변 달기
	 */
	@GetMapping("/answer")
	public String createAnswer() {
		questionService.readQuestionAll();
		return "/admin/adminQuestion";
	}

	/*
	 * 전대영 : Question 삭제하기
	 */
	@GetMapping("/deleteQuestion/{questionId}")
	public String deleteQuestion(@PathVariable Integer questionId) {
		questionService.deleteQuestionByQuestionId(questionId);
		return "redirect:/admin/questionAll";
	}

	/**
	 * 작성자 편용림 : 매니저 목록
	 */
	@GetMapping("/managerList")
	public String managerList(Model model) {
		List<User> managerList = userService.readManager();
		model.addAttribute("managerList", managerList);
		return "admin/managerList";
	}

	/*
	 * 편용림 유저 정보 수정
	 * 
	 */
	@GetMapping("/updateUser/{userName}")
	public String updateUser(@PathVariable("userName") String userName, Model model) {
		User user = userService.readUserByUserName(userName);
		model.addAttribute("user", user);
		return "admin/userUpdate";
	}

	/**
	 * 작성자 편용림 : 공연 예약 수락 페이지
	 */

	@GetMapping("/show")
	public String show(Model model) {
		List<RequestShowDto> showList = showService.readShow();
		model.addAttribute("showList", showList);
		return "admin/show";
	}

	/**
	 * 
	 * @param 편용림
	 * @return 수정 페이지
	 */
	@PostMapping("/update")
	public String update(User user) {
		userService.updateUserById(user);

		if (user.getRoleId() == 1) {
			return "redirect:/admin/userList";
		} else if (user.getRoleId() == 2) {
			return "redirect:/admin/managerList";
		}

		return "redirect:/admin/teacherList";

	}

	/*
	 * 편용림 작성자 : 승인
	 */
	@GetMapping("/updateShow/{id}/{userId}")
	public String updateShow(@PathVariable Integer id, @PathVariable Integer userId) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		showService.updateShow(id);
		String notice = "공연등록이 수락되었습니다.";
		noticeService.createManagerNotice(notice, userId, principal.getId());
		return "redirect:/admin/show";
	}

	/**
	 * 편용림
	 * 
	 * @return admin 유저 삭제
	 */
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		userService.deleteUserById(id);
		return "redirect:/admin/userList";
	}

	/**
	 * 편용림
	 * 
	 * @return admin 매니저 삭제
	 */
	@GetMapping("/deleteManager/{id}")
	public String deleteManager(@PathVariable("id") String id) {
		userService.deleteUserById(id);
		return "redirect:/admin/managerList";
	}
}