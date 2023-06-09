package com.bclass.arts_center.handler.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.utils.Define;

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute(Define.PRINCIPAL);
		
		if(principal==null || principal.getRoleId()!=3) {
			throw new LoginException("관리자만 이용가능합니다. 관리자 아이디로 로그인 해주세요.", HttpStatus.BAD_REQUEST);
		}
		return true;
	}
}
