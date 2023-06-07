package com.bclass.arts_center.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.bclass.arts_center.dto.GoogleDto;
import com.bclass.arts_center.dto.KakaoDto;
import com.bclass.arts_center.dto.NaverDto;
import com.bclass.arts_center.dto.OAuthTokenGoogle;
import com.bclass.arts_center.dto.OAuthTokenKakao;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.UserService;
import com.bclass.arts_center.utils.Define;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	// 카카오 엑세스 토큰 들고오기
	@GetMapping("/auth/kakao/callback")
	public String kakaoCallbackCode(@RequestParam String code, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code"); // 고정
		params.add("client_id", "2b8daa8c6238674fc9d677d8c51dd08f"); // REST API키
		params.add("redirect_uri", "http://192.168.0.85:8080/auth/kakao/callback");
		params.add("code", code);

		HttpEntity<MultiValueMap<String, String>> kakaoReqEntity = new HttpEntity<>(params, headers);

		ResponseEntity<OAuthTokenKakao> responseToken = restTemplate.exchange("https://kauth.kakao.com/oauth/token",
				HttpMethod.POST, kakaoReqEntity, OAuthTokenKakao.class);

		ResponseEntity<KakaoDto> userInfo = requestKakaoUserInfo(responseToken.getBody().getAccessToken());

		model.addAttribute("userInfo", userInfo.getBody());

		String apiId = userInfo.getBody().getId() + "kakao";

		model.addAttribute("apiId", apiId);

		User principal = userService.readUserByApiId(apiId);

		if (principal == null) {
			return "/user/signUp";
		}
		session.setAttribute(Define.PRINCIPAL, principal);

		return "redirect:/";
	}

	// 카카오 엑세스토큰으로 바디값 받기
	public ResponseEntity<KakaoDto> requestKakaoUserInfo(String OAuthTokenKakao) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + OAuthTokenKakao);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<String> profileReqEntity = new HttpEntity<>(headers);
		// https://kapi.kakao.com/v2/user/me
		ResponseEntity<KakaoDto> response = restTemplate.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.GET,
				profileReqEntity, KakaoDto.class);

		return response;
	};

	@GetMapping("/kakaologout")
	public String kakaoLogout(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}

	@GetMapping("/naverlogout")
	public String naverLogout(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}

	@GetMapping("/googlelogout")
	public String googleLogout(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}

	// 구글 엑세스 토큰 들고오기
	@GetMapping("/google/callback")
	public String GoogleCallbackCode(@RequestParam String code, Model model) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("client_id", "101775853902-vpcpe0bdhvfndednj00mn5bsvij135m5.apps.googleusercontent.com"); // REST
																												// API키
		params.add("client_secret", "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");
		params.add("code", code);
		params.add("redirect_uri", "http://192.168.0.85:8080/google/callback");
		params.add("grant_type", "authorization_code"); // 고정

		HttpEntity<MultiValueMap<String, String>> kakaoReqEntity = new HttpEntity<>(params, headers);

		ResponseEntity<OAuthTokenGoogle> responseToken = restTemplate.exchange("https://oauth2.googleapis.com/token",
				HttpMethod.POST, kakaoReqEntity, OAuthTokenGoogle.class);

		ResponseEntity<GoogleDto> userInfo = RequestGoogleUserInfo(responseToken.getBody().getAccess_token());

		String apiId = userInfo.getBody().getId() + "google";
		User principal = userService.readUserByApiId(apiId);

		model.addAttribute("apiId", apiId);
		model.addAttribute("userInfo", userInfo.getBody());

		if (principal == null) {
			return "/user/signUp";
		}
		session.setAttribute(Define.PRINCIPAL, principal);

		return "redirect:/";

	}

	// 구글 바디 값 들고오기
	public ResponseEntity<GoogleDto> RequestGoogleUserInfo(String oAuthTokenGoogle) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", " Bearer " + oAuthTokenGoogle);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<String> profileReqEntity = new HttpEntity<>(headers);

		// https://kapi.kakao.com/v2/user/me
		ResponseEntity<GoogleDto> response = restTemplate.exchange("https://www.googleapis.com/oauth2/v2/userinfo",
				HttpMethod.GET, profileReqEntity, GoogleDto.class);

		return response;
	}

	@GetMapping("auth/naver/callback")
	public String NaverCallbackCode(@RequestParam String code, Model model) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code"); // 고정
		params.add("client_id", "q3WIWBEaLw_SUTxgY8kb"); // REST API키
		params.add("client_secret", "NjalKNjvE5");
		params.add("redirect_uri", "http://192.168.0.85:8080/auth/naver/callback");
		params.add("code", code);

		HttpEntity<MultiValueMap<String, String>> naverReqEntity = new HttpEntity<>(params, headers);

		ResponseEntity<OAuthTokenKakao> responseToken = restTemplate.exchange("https://nid.naver.com/oauth2.0/token",
				HttpMethod.POST, naverReqEntity, OAuthTokenKakao.class);

		ResponseEntity<NaverDto> userInfo = RequestNaverUserInfo(responseToken.getBody().getAccessToken());

		String apiId = userInfo.getBody().getResponse().getId() + "naver";

		model.addAttribute("userInfo", userInfo.getBody().getResponse());
		model.addAttribute("apiId", apiId);

		User principal = userService.readUserByApiId(apiId);
		if (principal == null) {
			return "/user/signUp";
		}
		session.setAttribute(Define.PRINCIPAL, principal);

		return "redirect:/";

	}

	// 네이버 바디 값 들고오기
	public ResponseEntity<NaverDto> RequestNaverUserInfo(String OAuthTokenKakao) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.add("Authorization", " Bearer " + OAuthTokenKakao);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<String> profileReqEntity = new HttpEntity<>(headers);
		ResponseEntity<NaverDto> response = restTemplate.exchange("https://openapi.naver.com/v1/nid/me", HttpMethod.GET,
				profileReqEntity, NaverDto.class);

		return response;
	}

}

