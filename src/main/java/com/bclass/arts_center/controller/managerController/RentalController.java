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


	@GetMapping("")
	public String rentalPage(RequestSignUpShowDto requestSignUpShowDto, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		RequestShowDto show = showService.readShowByNewestOne(principal.getId());
		if (show == null) {
			model.addAttribute("show", null);
		} else {
			model.addAttribute("show", show);
		}
		return "/manager/rental";
	}


	@GetMapping("/location/{id}/{showId}")
	@Transactional
	public String rentalLocation(Model model, @PathVariable("id") Integer id, @PathVariable("showId") Integer showId) {
		RequestShowDto show = showService.readShowByShowId(showId);
		List<RequestHoleDto> locationList = rentalService.readHoleByLocation(id);
		List<RequestHoleDto> timeList = rentalService.readTimeByLocationId(id);
		System.out.println(locationList);
		if (show == null) {
			model.addAttribute("show", null);
		} else {
			model.addAttribute("show", show);
		}
		model.addAttribute("locationLists", locationList);
		model.addAttribute("timeList", timeList);
		model.addAttribute("locationId", id);
		
		return "/manager/rentalLocation";
	}


	@PostMapping("/location")
	public String rentalLocationPost(Model model, @RequestParam("id") Integer id) {
		List<RequestHoleDto> locationList = rentalService.readHoleByLocation(id);
		List<RequestHoleDto> timeList = rentalService.readTimeByLocationId(id);
		model.addAttribute("timeList", timeList);
		model.addAttribute("locationLists", locationList);
		System.out.println(locationList);
		
		return "/manager/rentalLocation";
	}


	@PostMapping("/reservation")
	public String insertRental(RequestRentPlaceDto requestRentPlaceDto, HttpServletResponse response, Model model) {
		User principal = (User) session.getAttribute(Define.PRINCIPAL);
		
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
		
		String date = requestRentPlaceDto.getStartDate();
		String[] startDateAndEndDate = date.split("~");
		requestRentPlaceDto.setStartDate(startDateAndEndDate[0].replaceAll(" ", ""));
		requestRentPlaceDto.setEndDate(startDateAndEndDate[1].replaceAll(" ", ""));

		model.addAttribute("dto", requestRentPlaceDto);

		rentalService.insertRental(requestRentPlaceDto);
		showService.updateShowHoleById(requestRentPlaceDto.getShowId(), requestRentPlaceDto.getHoleId());

		String dtoStartDate = requestRentPlaceDto.getStartDate().replaceAll("-", "");
		
		String startDate = dtoStartDate.replaceAll(" ", "");
		
		Integer startYear = Integer.parseInt(startDate.substring(0, 4));
		Integer startMonth = Integer.parseInt(startDate.substring(4, 6));
		Integer startDay = Integer.parseInt(startDate.substring(6, 8));
		Calendar startCal = Calendar.getInstance();
		startCal.set(startYear, startMonth - 1, startDay);
		
		
		String dtoEndDate = requestRentPlaceDto.getEndDate().replaceAll("-", "");
		String endDate = dtoEndDate.replaceAll(" ", "");
		Integer endYear = Integer.parseInt(endDate.substring(0, 4));
		Integer endMonth = Integer.parseInt(endDate.substring(4, 6));
		Integer endDay = Integer.parseInt(endDate.substring(6, 8));
		Calendar endCal = Calendar.getInstance();
		endCal.set(endYear, endMonth - 1, endDay);

		
		while (true) {
			if (getDateByInteger(startCal.getTime()) <= getDateByInteger(endCal.getTime())) {
				requestRentPlaceDto.setStartDate(getDateByString(startCal.getTime()));
				requestRentPlaceDto.setEndDate(getDateByString(endCal.getTime()));
				showService.createShowDateTime(requestRentPlaceDto);
				startCal.add(Calendar.DATE, 1);
			} else {
				break;
			}
		}
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			String msg = "대관 신청이 완료되었습니다.";
			w.write("<script>alert('" + msg + "');location.href='/';</script>");
			w.flush();
			w.close();
			return "/payment/payment";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/main";
	}

	
	public static Integer getDateByInteger(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		return Integer.parseInt(sdf.format(date));
	}

	
	public static String getDateByString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(date);
	}
}

