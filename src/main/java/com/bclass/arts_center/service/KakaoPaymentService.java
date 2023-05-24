package com.bclass.arts_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.bclass.arts_center.dto.payment.AdminKeyDto;
import com.bclass.arts_center.dto.payment.KakaoReadyResponse;
import com.bclass.arts_center.dto.payment.KakaoApprovalResponse;
import com.bclass.arts_center.dto.payment.KakaoRefundResponse;
import com.bclass.arts_center.repository.interfaces.PaymentRepository;
/**
 * 
 * @author 손주이
 *
 */
@Service
public class KakaoPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	private static final String cid = "TC0ONETIME";

	private AdminKeyDto ADMIN_KEY;
	
	private String tid;

	public KakaoPaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
		this.ADMIN_KEY = paymentRepository.selectAdminKey();
	}

	@Transactional
	public KakaoReadyResponse kakaoReady() {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + ADMIN_KEY.getAdminKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", cid);
		params.add("partner_order_id", "partner_order_id");
		params.add("partner_user_id", "partner_user_id");
		params.add("item_name", "추남, 추녀");
		params.add("quantity", "1");
		params.add("total_amount", "50000");
		params.add("tax_free_amount", "0");
		params.add("approval_url", "http://localhost:8080/payment/success");
		params.add("cancel_url", "http://localhost:8080/payment/cancel");
		params.add("fail_url", "http://localhost:8080/payment/fail");
		
		HttpEntity<MultiValueMap<String, String>> kakaoRequestEntity = new HttpEntity<>(params, headers);

		ResponseEntity<KakaoReadyResponse> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/ready",
				HttpMethod.POST, kakaoRequestEntity, KakaoReadyResponse.class);

		this.tid = response.getBody().getTid();
		return response.getBody();
	}

	@Transactional
	public KakaoApprovalResponse kakaoApprove(String pgToken) {


		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + ADMIN_KEY.getAdminKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cid", cid);
		params.add("tid", this.tid);
		params.add("partner_order_id", "partner_order_id");
		params.add("partner_user_id", "partner_user_id");
		params.add("pg_token", pgToken);

		HttpEntity<MultiValueMap<String, String>> kakaoRequestEntity = new HttpEntity<>(params, headers);

		ResponseEntity<KakaoApprovalResponse> response = restTemplate.exchange(
				"https://kapi.kakao.com/v1/payment/approve", HttpMethod.POST, kakaoRequestEntity,
				KakaoApprovalResponse.class);

		return response.getBody();
	}

	@Transactional
	public KakaoRefundResponse kakaoRefund() {

		KakaoReadyResponse kakaoReadyResponse = new KakaoReadyResponse();

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + ADMIN_KEY.getAdminKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", cid);
		params.add("tid", kakaoReadyResponse.getTid());
		params.add("cancel_amount", "5000");
		params.add("cancel_tax_free_amount", "0");

		HttpEntity<MultiValueMap<String, String>> kakaoRequestEntity = new HttpEntity<>(params, headers);

		ResponseEntity<KakaoRefundResponse> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/cancel",
				HttpMethod.POST, kakaoRequestEntity, KakaoRefundResponse.class);

		return response.getBody();
	}
	

}
