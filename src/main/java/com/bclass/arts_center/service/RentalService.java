package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestHoleDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceDto;
import com.bclass.arts_center.repository.interfaces.RentalRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	
	@Transactional
	public List<RequestHoleDto> readHoleByLocation(Integer id) {
		List<RequestHoleDto> holeList = rentalRepository.selectByLocation(id);
		
		return holeList;
	}
	
	
	@Transactional
	public List<RequestHoleDto> readTimeByLocationId(Integer locationId) {
		List<RequestHoleDto> timeList = rentalRepository.selectTimeByLocationId(locationId);
		
		return timeList;
	}

	
	@Transactional
	public Integer insertRental(RequestRentPlaceDto requestRentPlaceDto) {
		Integer count = rentalRepository.insertRental(requestRentPlaceDto);
		
		return count;
	}
	
	
	@Transactional
	public List<RequestRentPlaceDto> readRentPlaceReservationByDateAndLocation(RequestRentPlaceDto requestRentPlaceDto) {
		List<RequestRentPlaceDto> rendPlaceList = rentalRepository.selectRentPlaceReservationByDateAndLocation(requestRentPlaceDto);
		
		return rendPlaceList;
	}
}


