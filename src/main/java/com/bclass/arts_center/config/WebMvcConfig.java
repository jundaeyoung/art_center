package com.bclass.arts_center.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bclass.arts_center.handler.AuthInterceptor;
import com.bclass.arts_center.handler.LoginInterceptor;
import com.bclass.arts_center.handler.exception.AdminLoginInterceptor;
import com.bclass.arts_center.handler.exception.ManagerLoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptor authInterceptor;
	@Autowired
	private LoginInterceptor loginInterceptor;
	@Autowired
	private ManagerLoginInterceptor managerLoginInterceptor;
	@Autowired
	private AdminLoginInterceptor adminLoginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor).addPathPatterns("/auth/**");

		registry.addInterceptor(loginInterceptor).addPathPatterns("/ticket/**").addPathPatterns("/quest/insert/**")
				.addPathPatterns("/myPage/**").addPathPatterns("/kakao/**");

		registry.addInterceptor(managerLoginInterceptor).addPathPatterns("/rental/**").addPathPatterns("/manager/**")
				.addPathPatterns("/managerNotice/**");

		registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/admin/**");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/images/upload/**")
//				.addResourceLocations("file:///C:\\spring_upload\\arts_center\\upload/");
		registry.addResourceHandler("/images/upload/**")
				.addResourceLocations("file:///Users/jundaeyeong/Desktop/upload");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
