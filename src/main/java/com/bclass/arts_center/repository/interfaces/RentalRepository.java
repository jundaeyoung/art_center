package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.request.RequestHoleDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceReservationDto;

@Mapper
public interface RentalRepository {

	
	public List<RequestHoleDto> selectByLocation(Integer id);
	
	
	public List<RequestHoleDto> selectTimeByLocationId(Integer locationId);
	
	
	public Integer insertRental(RequestRentPlaceDto requestRentPlaceDto);
	
	
	public List<RequestRentPlaceDto> selectRentPlaceReservationByDateAndLocation(RequestRentPlaceDto requestRentPlaceDto);
	
	
	public RequestRentPlaceReservationDto selectRentPlaceReservationById(Integer id);
}
