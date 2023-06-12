package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestRentPlaceReservationDto;
import com.bclass.arts_center.repository.interfaces.RentPlaceReservationRepository;
import com.bclass.arts_center.repository.model.Show;

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
	public Integer updateRentPlaceReservation(Integer id) {
		Integer resultRowCount = placeReservationRepository.updateRentPlaceReservation(id);
		
		return resultRowCount;
	}
	
	
	@Transactional
	public Integer updateRentByStatus(Integer id) {
		Integer resultRowCount = placeReservationRepository.updateRentById(id);
		
		return resultRowCount;
	}
	
	
	@Transactional
	   public Integer readShowIdByRentRefund(Integer id) {
	      Integer showId = placeReservationRepository.selectShowIdByRentRefund(id);
	      
	      return showId;
	   }
	   
	   
	   
	   @Transactional
	   public Integer deleteShowTime(Integer showId) {
	      Integer resultRowCount = placeReservationRepository.deleteShowTime(showId);
	      
	      return resultRowCount;
	   }
}
