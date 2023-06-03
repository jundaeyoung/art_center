package com.bclass.arts_center.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

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

import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.payment.AdminKeyDto;
import com.bclass.arts_center.dto.payment.KakaoApprovalResponse;
import com.bclass.arts_center.dto.payment.KakaoReadyResponse;
import com.bclass.arts_center.dto.payment.KakaoRefundResponse;
import com.bclass.arts_center.dto.payment.RequestPaymentInfoDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceReservationDto;
import com.bclass.arts_center.repository.interfaces.PaymentRepository;
import com.bclass.arts_center.repository.interfaces.RentalRepository;
import com.bclass.arts_center.repository.interfaces.TicketRepository;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.utils.Define;

/**
 * 
 * @author 손주이
 *
 */
@Service
public class KakaoPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private RentalRepository rentalRepository;

	@Autowired
	private HttpSession session;

	private static final String cid = "TC0ONETIME";

	private AdminKeyDto ADMIN_KEY;

	private String tid;

	public KakaoPaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
		this.ADMIN_KEY = paymentRepository.selectAdminKey();
	}

	/**
	 * 결제 대기
	 * 
	 * @return response.getBody()
	 */
	@Transactional
	public KakaoReadyResponse kakaoReady(Integer ticketingId) {

		TicketCheckDto ticketCheckDto = ticketRepository.selectTicketForPay(ticketingId);
		String userBirth = ticketCheckDto.getBirthDate();
		System.out.println("dd" + userBirth);
		String replaceuserBirth = userBirth.replaceAll("-", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String nowDate = sdf.format(now);
		int startMonth1 = Integer.parseInt(replaceuserBirth.substring(0, 4));
		int startMonth2 = Integer.parseInt(nowDate.substring(0, 4));
		int userAge = startMonth2 - startMonth1;

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + ADMIN_KEY.getAdminKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", cid);
		params.add("partner_order_id", "partner_order_id");
		params.add("partner_user_id", "partner_user_id");

		params.add("item_name", ticketCheckDto.getTitle());
		params.add("quantity", "1");
		if (userAge > 19) {
			params.add("total_amount", ticketCheckDto.getAdultRate().replace(",", ""));
		} else if (userAge <= 19) {
			params.add("total_amount", ticketCheckDto.getYouthRate().replace(",", ""));
		}
		params.add("tax_free_amount", "0");
		params.add("approval_url", "http://localhost:8080/kakao/success");
		params.add("cancel_url", "http://localhost:8080/kakao/cancel");
		params.add("fail_url", "http://localhost:8080/kakao/fail");

		HttpEntity<MultiValueMap<String, String>> kakaoRequestEntity = new HttpEntity<>(params, headers);

		ResponseEntity<KakaoReadyResponse> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/ready",
				HttpMethod.POST, kakaoRequestEntity, KakaoReadyResponse.class);

		this.tid = response.getBody().getTid();
		return response.getBody();
	}

	@Transactional
	public KakaoReadyResponse kakaoReady2(Integer rentId) {

		RequestRentPlaceReservationDto rentPlaceReservation = rentalRepository.selectRentPlaceReservationById(rentId);

		String price = rentPlaceReservation.getRentPrice();
		String rentPrice = price.replace(",", "");

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + ADMIN_KEY.getAdminKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", cid);
		params.add("partner_order_id", "partner_order_id");
		params.add("partner_user_id", "partner_user_id");

		params.add("item_name", rentPlaceReservation.getLocation() + " " + rentPlaceReservation.getName() + " (공연 : "
				+ rentPlaceReservation.getTitle() + ")");
		params.add("quantity", "1");
		params.add("total_amount", rentPrice);
		params.add("tax_free_amount", "0");
		params.add("approval_url", "http://localhost:8080/kakao/success");
		params.add("cancel_url", "http://localhost:8080/kakao/cancel");
		params.add("fail_url", "http://localhost:8080/kakao/fail");

		HttpEntity<MultiValueMap<String, String>> kakaoRequestEntity = new HttpEntity<>(params, headers);

		ResponseEntity<KakaoReadyResponse> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/ready",
				HttpMethod.POST, kakaoRequestEntity, KakaoReadyResponse.class);

		this.tid = response.getBody().getTid();
		return response.getBody();
	}

	/**
	 * 결제 요청
	 * 
	 * @param pgToken
	 * @return response.getBody()
	 */
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

	/**
	 * 환불 요청
	 * 
	 * @return response.getBody()
	 */
	@Transactional
	public KakaoRefundResponse kakaoRefund(Integer userId, String tid) {

		RequestPaymentInfoDto requestPayment = paymentRepository.selectPaymentInfo(userId, tid);
		// System.out.println("rr" + requestPayment);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + ADMIN_KEY.getAdminKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", cid);
		params.add("tid", tid);
		if (requestPayment.getAgeGroupId() == 3) {
			params.add("cancel_amount", requestPayment.getAdultRate());
		} else if (requestPayment.getAgeGroupId() == 2) {
			params.add("cancel_amount", requestPayment.getYouthRate());
		}
		params.add("cancel_tax_free_amount", "0");

		HttpEntity<MultiValueMap<String, String>> kakaoRequestEntity = new HttpEntity<>(params, headers);

		ResponseEntity<KakaoRefundResponse> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/cancel",
				HttpMethod.POST, kakaoRequestEntity, KakaoRefundResponse.class);

		return response.getBody();
	}

	/**
	 * 대관 환불 요청
	 * 
	 * @return response.getBody()
	 */
	@Transactional
	public KakaoRefundResponse kakaoRefund2(String tid) {

		RequestPaymentInfoDto requestPaymentInfoDto = paymentRepository.selectRentalPaymentInfo(tid);

		String rentPrice = requestPaymentInfoDto.getRentPrice();
		rentPrice = rentPrice.replace(",", ""); // 콤마(,) 제거
		int cancelAmount = Integer.parseInt(rentPrice); // 숫자로 변환
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + ADMIN_KEY.getAdminKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", cid);
		params.add("tid", tid);
		params.add("cancel_amount", String.valueOf(cancelAmount));
		params.add("cancel_tax_free_amount", "0");

		HttpEntity<MultiValueMap<String, String>> kakaoRequestEntity = new HttpEntity<>(params, headers);

		ResponseEntity<KakaoRefundResponse> response = restTemplate.exchange("https://kapi.kakao.com/v1/payment/cancel",
				HttpMethod.POST, kakaoRequestEntity, KakaoRefundResponse.class);

		return response.getBody();
	}

}