package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestHoleDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceDto;
import com.bclass.arts_center.repository.interfaces.RentalRepository;

/**
 * 
 * @author 김미정
 *
 */
@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	@Transactional
	public List<RequestHoleDto> selectByLocation(Integer id) {
		List<RequestHoleDto> list = rentalRepository.selectByLocation(id);
		return list;
	}
	
	@Transactional
	public List<RequestHoleDto> selectByTime(Integer id) {
		List<RequestHoleDto> list = rentalRepository.selectByTime(id);
		return list;
	}
	/**
	 * 김미정 : manager 계정에서 rental insert
	 */
	
	
	@Transactional
	public Integer insertRental(RequestRentPlaceDto requestRentPlaceDto) {
		int count = rentalRepository.insertRental(requestRentPlaceDto);
		return count;
	}
	/*
	 * 전대영 : 대관 예약 가능 시간 구하기
	 */
	@Transactional
	public List<RequestRentPlaceDto> selectByDateAndLocation(RequestRentPlaceDto requestRentPlaceDto) {
		List<RequestRentPlaceDto> rendPlaceList = rentalRepository.selectByDateAndLocation(requestRentPlaceDto);
		return rendPlaceList;
	}
	
	
	
}
