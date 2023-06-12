package com.bclass.arts_center.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.bclass.arts_center.dto.SignInFormDto;
import com.bclass.arts_center.dto.SignUpFormDto;
import com.bclass.arts_center.dto.UpdateUserDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.handler.exception.LoginException;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.UserService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/user")
public class UserController {

   @Autowired
   private UserService userService;

   @Autowired
   private HttpSession session;

   @GetMapping("/login")
   public String login() {

      return "/user/signIn";
   }

   @GetMapping("/signUp")
   public String signUp() {

      return "/user/signUpchoice";
   }

   @GetMapping("/signUpchoice")
   public String signUpchoice(Integer roleId, Model model) {
      model.addAttribute("roleId", roleId);

      return "/user/signUp";
   }

   @GetMapping("/update")
   public String update(Model model, String userName) {
      User principal = (User) session.getAttribute(Define.PRINCIPAL);
      if (principal == null) {
         throw new LoginException("로그인을 해주세요.", HttpStatus.BAD_REQUEST);
      }
      SignInFormDto dto = new SignInFormDto();
      dto.setUserName(userName);
      User user = userService.readUserByUserName(dto.getUserName());
      model.addAttribute("user", user);

      return "/user/update";
   }

   @GetMapping("/updatePassword")
   public String updatePassword(Model model, String password) {
      User principal = (User) session.getAttribute(Define.PRINCIPAL);
      if (principal == null) {
         throw new LoginException("로그인을 해주세요.", HttpStatus.BAD_REQUEST);
      }
      SignInFormDto dto = new SignInFormDto();
      dto.setUserName(password);
      User user = userService.readUserByUserName(dto.getUserName());
      model.addAttribute("user", user);

      return "/user/updatePassword";
   }

   @GetMapping("/delete")
   public String delete(Model model, String userName) {
      SignInFormDto dto = new SignInFormDto();
      dto.setUserName(userName);
      User user = userService.readUserByUserName(dto.getUserName());
      model.addAttribute("user", user);

      return "/user/delete";
   }

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

   @GetMapping("/logout")
   public String logout() {
      session.invalidate();

      return "redirect:/";
   }

   @PostMapping("/signUp")
   public String signUpProc(@Valid SignUpFormDto signUpFormDto, HttpServletResponse response, BindingResult errors,
         Model model) {
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
         Map<String, String> validatorResult = userService.userValidateHandling(errors);
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
         throw new LoginException("회원가입에 성공하였습니다.", HttpStatus.OK);
      } else {
         throw new CustomRestfullException("회원가입에 실패하였습니다.", HttpStatus.BAD_REQUEST);
      }
   }

   @PostMapping("/update")
   public String update(@Valid UpdateUserDto updateUserDto, BindingResult errors, Model model) {
      User principal = (User) session.getAttribute(Define.PRINCIPAL);
      if (principal == null) {
         throw new LoginException("로그인을 해주세요.", HttpStatus.BAD_REQUEST);
      }
      if (errors.hasErrors()) {
         model.addAttribute("user", updateUserDto);
         Map<String, String> validatorResult = userService.userValidateHandling(errors);
         for (String key : validatorResult.keySet()) {
            model.addAttribute(key, validatorResult.get(key));
         }
         return "/user/update";
      }
      updateUserDto.setUserName(principal.getUserName());
      userService.checkPassword(updateUserDto);
      userService.updateUser(updateUserDto);
      principal.setNickname(updateUserDto.getNickname());
      principal.setEmail(updateUserDto.getEmail());
      principal.setTel(updateUserDto.getTel());
      session.setAttribute(Define.PRINCIPAL, principal);

      return "redirect:/";
   }

   @PostMapping("/updatePassword")
   public String updatePassword(UpdateUserDto updateUserDto, Model model) {
      User principal = (User) session.getAttribute(Define.PRINCIPAL);
      if (principal == null) {
         throw new LoginException("로그인을 해주세요.", HttpStatus.BAD_REQUEST);
      }
      updateUserDto.setUserName(principal.getUserName());
      userService.checkPassword(updateUserDto);
      if (!updateUserDto.getNewPassword().equals(updateUserDto.getNewPasswordCheck())) {
         throw new CustomRestfullException("변경할 비밀번호가 일치하지않습니다.다시 입력해주세요.", HttpStatus.BAD_REQUEST);
      }
      userService.checkPassword(updateUserDto);
      updateUserDto.setNickname(principal.getNickname());
      updateUserDto.setEmail(principal.getEmail());
      updateUserDto.setTel(principal.getTel());
      updateUserDto.setPassword(updateUserDto.getNewPassword());
      userService.updateUser(updateUserDto);
      return "redirect:/";
   }

   @PostMapping("/deleteProc")
   public String delete(SignInFormDto signInFormDto) {
      if (signInFormDto.getPassword() == null || signInFormDto.getPassword().isEmpty()) {
         throw new CustomRestfullException("password를 입력하세요", HttpStatus.BAD_REQUEST);
      }
      userService.deleteUser(signInFormDto);
      session.invalidate();

      return "redirect:/";
   }

   @GetMapping("/findPw")
   public String findPw() {

      return "/user/findPw";
   }

   @GetMapping("/findId")
   public String findId() {

      return "user/findId";
   }

   @PostMapping("findId")
   public String findId(User user, Model model) {
      if (user.getEmail() == null || user.getEmail().isEmpty()) {
         throw new CustomRestfullException("email을 입력하세요", HttpStatus.BAD_REQUEST);
      }
      if (user.getTel() == null || user.getTel().isEmpty()) {
         throw new CustomRestfullException("휴대폰 번호를 입력하세요", HttpStatus.BAD_REQUEST);
      }
      
      User userName = userService.selectUserNameByEmailAndTel(user);
      
      if (userName == null) {
         throw new CustomRestfullException("찾으시는 정보가 없습니다. 다시 한번 확인해주세요.", HttpStatus.BAD_REQUEST);
      }
      model.addAttribute("userName", userName);
      return "user/findId";
   }

}