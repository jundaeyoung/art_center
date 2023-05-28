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

/**
 * 
 * @author 편용림
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	
	@Autowired
	private AuthInterceptor authInterceptor;
	
	// 추후에 추가할 예정
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
				.addPathPatterns("/auth/**");
	}
	/*
	 * 작성자 : 전대영
	 * 이미지 경로 바꿔줌
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/upload/**")
//				.addResourceLocations("file:///C:\\spring_upload\\arts_center\\upload/");
		.addResourceLocations("/Users/jundaeyeong/Desktop/upload");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	
}
