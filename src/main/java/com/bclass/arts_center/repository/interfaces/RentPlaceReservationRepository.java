package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import com.bclass.arts_center.dto.request.RequestRentPlaceDto;

public interface RentPlaceReservationRepository {

	List<RequestRentPlaceDto> selectRentPlaceReservationList();
}
