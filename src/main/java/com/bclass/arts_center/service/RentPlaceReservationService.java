package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestRentPlaceReservationDto;
import com.bclass.arts_center.repository.interfaces.RentPlaceReservationRepository;

@Service
public class RentPlaceReservationService {

	@Autowired
	private RentPlaceReservationRepository placeReservationRepository;
	
	
	@Transactional
	public List<RequestRentPlaceReservationDto> readRentPlaceReservationList(){
		List<RequestRentPlaceReservationDto> rentPlaceReservationList = placeReservationRepository.selectRentPlaceReservationList();
		return rentPlaceReservationList;
	};
	
	
	@Transactional
	public int updateRentPlaceReservation(Integer id) {
		int resultRowCount = placeReservationRepository.updateRentPlaceReservation(id);
		return resultRowCount;
	}
	
	
	@Transactional
	public int updateRentByStatus(Integer id) {
		int resultRowCount = placeReservationRepository.updateRentById(id);
		return resultRowCount;
	}
}
