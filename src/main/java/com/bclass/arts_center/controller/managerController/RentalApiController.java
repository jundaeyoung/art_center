package com.bclass.arts_center.controller.managerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bclass.arts_center.dto.request.RequestHoleDto;
import com.bclass.arts_center.service.RentalService;

@RestController
public class RentalApiController {

	@Autowired
	RentalService rentalService;
	
	@PostMapping("/api/rentalLocation")
	//@RequestBody http메세지 body에서 데이터를 읽어라 그 중에 json형식의 문자열
	public RequestHoleDto changeRentalTime(@RequestBody RequestHoleDto requestHoleDto) {
		System.out.println(requestHoleDto.getHoleId()+"holeId");
		System.out.println(requestHoleDto.getStartDate()+"start");
		String str = requestHoleDto.getStartDate();
		String[] split = str.split("~");
		
		requestHoleDto.setStartDate(split[0]);
		requestHoleDto.setEndDate(split[1]);
		
	    List<RequestHoleDto> holeList = rentalService.selectByLocation2(requestHoleDto);
		
	    System.out.println(requestHoleDto.toString());
	    System.out.println(holeList+"dddddddddddd");
	    
	    return requestHoleDto;
	}
	
}
