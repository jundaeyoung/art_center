package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.request.RequestRentPlaceReservationDto;
import com.bclass.arts_center.repository.model.Show;

@Mapper
public interface RentPlaceReservationRepository {

	public List<RequestRentPlaceReservationDto> selectRentPlaceReservationList();

	public Integer updateRentPlaceReservation(Integer id);

	public Integer updateRentById(Integer id);
	
	public Integer selectShowIdByRentRefund(Integer id);
	   
	public Integer deleteShowTime(Integer showId);
}
