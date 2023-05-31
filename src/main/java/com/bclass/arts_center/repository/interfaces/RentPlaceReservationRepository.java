package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.request.RequestRentPlaceReservationDto;

@Mapper
public interface RentPlaceReservationRepository {

	// 작성자 : 편용림 대관승인 리스트 조회
	public List<RequestRentPlaceReservationDto> selectRentPlaceReservationList();

	// 작성자 : 편용림 승인 요청 업데이트
	public int updateRentPlaceReservation(Integer id);

	// 작성자 : 편용림 대관 예약 취소
	public int updateRentById(Integer id);
	
}
