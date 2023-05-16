package com.bclass.arts_center.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.bclass.arts_center.dto.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author 편용림
 *
 */
@Controller
@ResponseBody
public class AuthController {
	
	@GetMapping("/auth/kakao/callback")
	public String kakaoCallbackCode(@RequestParam String code) {
		System.out.println("11111111111111");
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code"); // 고정
		params.add("client_id", "2b8daa8c6238674fc9d677d8c51dd08f"); // REST API키
		params.add("redirect_uri", "http://localhost:8080/auth/kakao/callback");
		params.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> kakaoReqEntity = new HttpEntity<>(params, headers);
		
		ResponseEntity<OAuthToken> responseToken = restTemplate.exchange("https://kauth.kakao.com/oauth/token",
				HttpMethod.POST, kakaoReqEntity, OAuthToken.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String userInfo = requestKakaoUserInfo(responseToken.getBody().getAccessToken());
		
		System.out.println(userInfo);
		
		
		return userInfo;
	}
	
	
	private String requestKakaoUserInfo(String oAuthToken) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + oAuthToken);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		
		HttpEntity<String> profileReqEntity = new HttpEntity<>(headers);
		// https://kapi.kakao.com/v2/user/me
		ResponseEntity<String> response = restTemplate.exchange("https://kapi.kakao.com/v2/user/me",
				HttpMethod.GET,
				profileReqEntity,
				String.class);
		
		String responsBody = response.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonNode = objectMapper.readTree(responsBody);
			Long id = jsonNode.get("id").asLong();
			String nickname = jsonNode.get("properties")
							  .get("nickname").asText();
			
			System.out.println(id);
			System.out.println(nickname);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return response.getBody().toString();
	};
	
	@GetMapping("/google/callback")
	public String googleCallbackCode(@RequestParam String code) {
		
		System.out.println("구글 CALLBACK");
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("client_id", "101775853902-vpcpe0bdhvfndednj00mn5bsvij135m5.apps.googleusercontent.com"); // REST API키
		params.add("client_secret", "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");
		params.add("code", code);
		params.add("redirect_uri", "http://localhost:8080/google/callback");
		params.add("grant_type", "authorization_code"); // 고정
		
		HttpEntity<MultiValueMap<String, String>> kakaoReqEntity = new HttpEntity<>(params, headers);
		
		ResponseEntity<String> responseToken = restTemplate.exchange("https://www.googleapis.com/oauth2/v4/token",
				HttpMethod.POST, kakaoReqEntity, String.class);
		
		
		return responseToken.getBody().toString();
	}
	

	
	

	
	
}