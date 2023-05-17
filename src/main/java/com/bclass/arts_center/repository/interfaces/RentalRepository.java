package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.request.RequestLocationDto;

@Mapper
public interface RentalRepository {

	/**
	 * 김미정 : Location 별 대관예약 페이지 불러오기
	 */
	public List<RequestLocationDto> selectByLocation(Integer id);
	
}
