package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.request.RequestRentPlaceReservationDto;

@Mapper
public interface RentPlaceReservationRepository {

	public List<RequestRentPlaceReservationDto> selectRentPlaceReservationList();

	public int updateRentPlaceReservation(Integer id);

	public int updateRentById(Integer id);
}
