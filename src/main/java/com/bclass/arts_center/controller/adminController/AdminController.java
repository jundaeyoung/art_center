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

	
	@GetMapping("")
	public String selectUserList(Model model) {
		List<User> userList = userService.readUserList();
		model.addAttribute("userList", userList);
		
		return "/admin/userList";
	}

	
	@GetMapping("/logout")
	public String adminLogout() {
		session.invalidate();
		
		return "redirect:/";
	}


	@GetMapping("/userList")
	public String userList() {
		
		return "redirect:/admin/";
	}


	@GetMapping("/questionAll")
	public String selectQuestionAllList(Model model) {
		List<RequestQuestionDto> questionList = questionService.readQuestionAll();
		if (questionList.isEmpty()) {
			model.addAttribute("questionList", null);
		} else {
			model.addAttribute("questionList", questionList);
		}
		
		return "/admin/adminQuestion";
	}


	@GetMapping("/answer")
	public String createAnswer() {
		questionService.readQuestionAll();
		
		return "/admin/adminQuestion";
	}

	
	@GetMapping("/deleteQuestion/{questionId}")
	public String deleteQuestion(@PathVariable Integer questionId) {
		questionService.deleteQuestionByQuestionId(questionId);
		
		return "redirect:/admin/questionAll";
	}


	@GetMapping("/managerList")
	public String selectManagerList(Model model) {
		List<User> managerList = userService.readManagerList();
		model.addAttribute("managerList", managerList);
		
		return "admin/managerList";
	}

	
	@GetMapping("/updateUser/{userName}")
	public String updateUser(@PathVariable("userName") String userName, Model model) {
		User user = userService.readUserByUserName(userName);
		model.addAttribute("user", user);
		
		return "admin/userUpdate";
	}


	@GetMapping("/show")
	public String selectShowList(Model model) {
		List<RequestShowDto> showList = showService.readShowList();
		model.addAttribute("showList", showList);
		
		return "admin/show";
	}


	@PostMapping("/update")
	public String updateUserById(User user) {
		userService.updateUserById(user);
		if (user.getRoleId() == 1) {
			return "redirect:/admin/userList";
		} else if (user.getRoleId() == 2) {
			return "redirect:/admin/managerList";
		}
		
		return "redirect:/admin/teacherList";
	}


	@GetMapping("/updateShow/{id}/{userId}")
	public String updateShow(@PathVariable Integer id, @PathVariable Integer userId) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		showService.updateShow(id);
		String notice = "공연등록이 수락되었습니다.결제해주세요";
		noticeService.createManagerNotice(notice, userId, principal.getId());
		
		return "redirect:/admin/show";
	}

	
	@GetMapping("/deleteUser/{id}")
	public String deleteUserById(@PathVariable("id") String id) {
		userService.deleteUserById(id);
		
		return "redirect:/admin/userList";
	}

	
	@GetMapping("/deleteManager/{id}")
	public String deleteManagerById(@PathVariable("id") String id) {
		userService.deleteUserById(id);
		
		return "redirect:/admin/managerList";
	}
}

