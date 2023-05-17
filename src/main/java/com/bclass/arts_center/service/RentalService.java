package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestLocationDto;
import com.bclass.arts_center.repository.interfaces.RentalRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	@Transactional
	public List<RequestLocationDto> selectByLocation(Integer id) {
		List<RequestLocationDto> list = rentalRepository.selectByLocation(id);
		return list;
	}
}
