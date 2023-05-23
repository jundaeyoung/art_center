package com.bclass.arts_center.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class MapApiController {
	
	@GetMapping("/map")
	public String map() {
		
		return "user/map";
	}
	
	@GetMapping("/auth/kakao/callback/map")
    @ResponseBody
    public String kakaoCallbackCode(Model model) {
        String apiKey = "385ebb74324290c6b52493ffa1cd9956";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + apiKey);
        
        // 카카오 API 호출 예시
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json?query={주소}";
        String address = "부산 부산진구 중앙대로 749";

        apiUrl = apiUrl.replace("{주소}", address);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
        String responseData = response.getBody();
        
        // 결과 처리 예시
        model.addAttribute("responseData", responseData);

        return responseData.toString();
    }

	
}