package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.request.RequestHoleDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceDto;

/**
 * 
 * @author 김미정
 *
 */
@Mapper
public interface RentalRepository {

	/**
	 * 김미정 : Location 별 대관예약 페이지 불러오기
	 */
	public List<RequestHoleDto> selectByLocation(Integer id);
	
	public List<RequestHoleDto> selectByTime(Integer id);
	
	/**
	 * 작성자 : 김미정
	 * 대관 예약 insert
	 */
	public Integer insertRental(RequestRentPlaceDto requestRentPlaceDto);
	
	/*
	 * 전대영 : 대관예약 시간 구하기
	 */
	public List<RequestRentPlaceDto> selectByDateAndLocation(RequestRentPlaceDto requestRentPlaceDto);
	
	public List<RequestHoleDto> selectByTime2(Integer id);
}
