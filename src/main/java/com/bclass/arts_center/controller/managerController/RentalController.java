package com.bclass.arts_center.controller.managerController;

import java.io.PrintWriter;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bclass.arts_center.dto.request.RequestHoleDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;
import com.bclass.arts_center.handler.exception.CustomRestfullException;
import com.bclass.arts_center.repository.model.User;
import com.bclass.arts_center.service.RentalService;
import com.bclass.arts_center.service.ShowService;
import com.bclass.arts_center.utils.Define;

@Controller
@RequestMapping("/rental")
public class RentalController {

	@Autowired
	private RentalService rentalService;

	@Autowired
	private ShowService showService;

	@Autowired
	private HttpSession session;

	/**
	 * 김미정
	 */
	// 대관신청 바로가기 페이지
	@GetMapping("")
	public String rentalPage(RequestSignUpShowDto requestSignUpShowDto, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		if (principal == null) {
			throw new CustomRestfullException("매니저 계정으로 로그인 해주세요.", HttpStatus.BAD_REQUEST);
		}
		if (principal.getRoleId() != 2) {
			throw new CustomRestfullException("매니저 계정으로 로그인 해주세요.", HttpStatus.BAD_REQUEST);
		}
		RequestShowDto show = showService.readShowByNewestOne(principal.getId());
		if (show == null) {
			model.addAttribute("show", null);
		} else {
			model.addAttribute("show", show);
		}
		return "/manager/rental";
	}

	/**
	 * 김미정
	 */
	// 대관 신청 페이지
	@GetMapping("/location/{id}/{showId}")
	@Transactional
	public String rentalLocation(Model model, @PathVariable("id") Integer id, @PathVariable("showId") Integer showId) {
		RequestShowDto show = showService.readShowByShowId(showId);
		List<RequestHoleDto> locationLists = rentalService.selectByLocation(id);
		List<RequestHoleDto> timeList = rentalService.selectByTime(id);
		if (show == null) {
			model.addAttribute("show", null);
		} else {
			model.addAttribute("show", show);
		}
		model.addAttribute("locationLists", locationLists);
		model.addAttribute("timeList", timeList);
		model.addAttribute("location", locationLists.get(0).getLocation());
		model.addAttribute("locationId", id);
		model.addAttribute("price", locationLists.get(0).getPrice());
		model.addAttribute("name", locationLists.get(0).getName());
		return "/manager/rentalLocation";
	}

	/**
	 * 김미정
	 */
	@PostMapping("/location")
	public String rentalLocationPost(Model model, @RequestParam("id") Integer id) {
		List<RequestHoleDto> locationLists = rentalService.selectByLocation(id);
		List<RequestHoleDto> timeList = rentalService.selectByTime(id);
		model.addAttribute("timeList", timeList);
		model.addAttribute("locationLists", locationLists);
		return "/manager/rentalLocation";
	}

	/**
	 * 김미정
	 */
	// 대관 신청 insert
	@PostMapping("/reservation")
	public String insertRental(RequestRentPlaceDto requestRentPlaceDto, HttpServletResponse response, Model model) {
		System.out.println(requestRentPlaceDto);
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		if (principal == null) {
			throw new CustomRestfullException("사용자 인증이 필요합니다.", HttpStatus.UNAUTHORIZED);
		}
		if (requestRentPlaceDto.getStartTime() == null || requestRentPlaceDto.getEndTime() == null) {
			throw new CustomRestfullException("시간 선택을 다시 해주세요", HttpStatus.BAD_REQUEST);
		}
		Time startTime = requestRentPlaceDto.getStartTime();
		Time endTime = requestRentPlaceDto.getEndTime();

		if (startTime.equals(endTime)) {
			throw new CustomRestfullException("시간 선택을 다시 해주세요", HttpStatus.BAD_REQUEST);
		} else if (endTime.compareTo(startTime) < 0) {
			throw new CustomRestfullException("시간 선택을 다시 해주세요", HttpStatus.BAD_REQUEST);
		}
		requestRentPlaceDto.setUserId(principal.getId());
		String str = requestRentPlaceDto.getStartDate();
		String[] split = str.split("~");
		requestRentPlaceDto.setStartDate(split[0]);
		requestRentPlaceDto.setEndDate(split[1]);

		requestRentPlaceDto.setStartDate(split[0].replaceAll(" ", ""));
		requestRentPlaceDto.setEndDate(split[1].replaceAll(" ", ""));

		model.addAttribute("dto", requestRentPlaceDto);
		
		rentalService.insertRental(requestRentPlaceDto);
		showService.updateShowHole(requestRentPlaceDto.getShowId(), requestRentPlaceDto.getHoleId());
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			String msg = "공연신청이 완료되었습니다.";
			w.write("<script>alert('" + msg + "');location.href='/';</script>");
			w.flush();
			w.close();
			return "/payment/payment";
		} catch (Exception e) {
			e.printStackTrace();
		}

		String dtoStartDate = requestRentPlaceDto.getStartDate().replaceAll("-", "");
		String startDate = dtoStartDate.replaceAll(" ", "");
		int startYear = Integer.parseInt(startDate.substring(0, 4));
		int startMonth = Integer.parseInt(startDate.substring(4, 6));
		int startDay = Integer.parseInt(startDate.substring(6, 8));
		String dtoEndDate = requestRentPlaceDto.getEndDate().replaceAll("-", "");
		String endDate = dtoEndDate.replaceAll(" ", "");
		int endYear = Integer.parseInt(endDate.substring(0, 4));
		int endMonth = Integer.parseInt(endDate.substring(4, 6));
		int endDay = Integer.parseInt(endDate.substring(6, 8));

		Calendar startCal = Calendar.getInstance();
		startCal.set(startYear, startMonth - 1, startDay);
		Calendar endCal = Calendar.getInstance();
		endCal.set(endYear, endMonth - 1, endDay);
		while (true) {
			if (getDateByInteger(startCal.getTime()) <= getDateByInteger(endCal.getTime())) {
				startCal.add(Calendar.DATE, 1);
				requestRentPlaceDto.setStartDate(getDateByString(startCal.getTime()));
				requestRentPlaceDto.setEndDate(getDateByString(endCal.getTime()));
				showService.createShowDateTime(requestRentPlaceDto);
			} else {
				break;
			}
		}
		return "/main";
	}

	public static int getDateByInteger(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(sdf.format(date));
	}

	public static String getDateByString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

}