package com.bclass.arts_center.controller.managerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.request.RequestHoleDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceDto;
import com.bclass.arts_center.dto.response.ResponseDto;
import com.bclass.arts_center.service.RentalService;

/**
 * 
 * @author 김미정
 *
 */
@RestController
public class RentalApiController {

	@Autowired
	RentalService rentalService;

	@PostMapping("/api/rentalLocation")
	// @RequestBody http메세지 body에서 데이터를 읽어라 그 중에 json형식의 문자열
	public ResponseDto<List<RequestRentPlaceDto>> changeRentalTime(@RequestBody RequestRentPlaceDto requestHoleDto) {
		String str = requestHoleDto.getStartDate();
		String[] split = str.split(" ~ ");

		requestHoleDto.setStartDate(split[0].replaceAll(" ", ""));
		requestHoleDto.setEndDate(split[1].replaceAll(" ", ""));

		List<RequestRentPlaceDto> holeList = rentalService.selectByDateAndLocation(requestHoleDto);
		return new ResponseDto<List<RequestRentPlaceDto>>(200, HttpStatus.OK.toString(), holeList);
	}

}
