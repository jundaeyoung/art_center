package com.bclass.arts_center.handler;

import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bclass.arts_center.handler.exception.AdminLoginException;
import com.bclass.arts_center.handler.exception.AdminLoginInterceptor;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.handler.exception.LoginException;
import com.bclass.arts_center.handler.exception.ManagerLoginException;
import com.bclass.arts_center.handler.exception.ManagerLoginInterceptor;

@RestControllerAdvice
public class MyRestfullExceptionHandler {

	
	@ExceptionHandler(CustomRestfullException.class)
	public String basicException(CustomRestfullException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+ e.getMessage() +"');"); 
		sb.append("history.back();");
		sb.append("</script>");
		return sb.toString();
	}
	
	@ExceptionHandler(LoginException.class)
	public String loginException(LoginException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+e.getMessage()+"');");
		sb.append("location.href='/user/login';");
		sb.append("</script>");
		
		return sb.toString();
	}
	@ExceptionHandler(ManagerLoginException.class)
	public String managerLoginException(LoginException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+e.getMessage()+"');");
		sb.append("location.href='/user/login';");
		sb.append("</script>");
		
		return sb.toString();
	}
	@ExceptionHandler(AdminLoginException.class)
	public String adminLoginException(LoginException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+e.getMessage()+"');");
		sb.append("location.href='/user/login';");
		sb.append("</script>");
		
		return sb.toString();
	}
}
