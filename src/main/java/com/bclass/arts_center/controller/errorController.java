package com.bclass.arts_center.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class errorController implements ErrorController {
	private String ERROR_TEMPLATES_PATH = "/error";

	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			int statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return ERROR_TEMPLATES_PATH;
			}
			if (statusCode == HttpStatus.FORBIDDEN.value()) {
				return ERROR_TEMPLATES_PATH;
			}
			if (statusCode == HttpStatus.BAD_REQUEST.value()) {
				return ERROR_TEMPLATES_PATH;
			}
			if (statusCode == HttpStatus.BAD_GATEWAY.value()) {
				return ERROR_TEMPLATES_PATH;
			}
			return ERROR_TEMPLATES_PATH;
		}
		return ERROR_TEMPLATES_PATH;
	}
}
