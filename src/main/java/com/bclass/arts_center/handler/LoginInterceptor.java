package com.bclass.arts_center.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bclass.arts_center.handler.exception.LoginException;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.utils.Define;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute(Define.PRINCIPAL);
		
		if(principal == null) {
			throw new LoginException("로그인 후 이용 가능한 서비스 입니다.", HttpStatus.BAD_REQUEST);
		}
		if(principal != null && principal.getRoleId()==2) {
			throw new LoginException("매니저는 이용할 수 없는 서비스 입니다.", HttpStatus.BAD_REQUEST);
		}
		if(principal != null && principal.getRoleId()==3) {
			throw new LoginException("관리자는 이용할 수 없는 서비스 입니다.", HttpStatus.BAD_REQUEST);
		}
		return true;
	}
}
