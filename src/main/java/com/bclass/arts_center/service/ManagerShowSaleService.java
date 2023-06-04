package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.dto.response.ResponseManagerShowSaleDto;
import com.bclass.arts_center.repository.interfaces.ManagerShowSaleRepository;

@Service
public class ManagerShowSaleService {

	@Autowired
	private ManagerShowSaleRepository managerShowSaleRepository;


	@Transactional
	public List<RequestManagerShowSaleDto> readManagerShowSale(RequestManagerShowSaleDto requestManagerShowSaleDto) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository
				.selectManagerShowSale(requestManagerShowSaleDto);
		
		return showSaleList;
	}

	
	@Transactional
	public List<RequestManagerShowSaleDto> readManagerShowSaleByStartDateAndEndDate(RequestManagerShowSaleDto requestManagerShowSaleDto) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository
				.selectManagerShowSaleByStartDateAndEndDate(requestManagerShowSaleDto);
		
		return showSaleList;
	}
	

	@Transactional
	public List<RequestManagerShowSaleDto> readManagerShowBySearchTitle(RequestManagerShowSaleDto requestManagerShowSaleDto) {
		requestManagerShowSaleDto.setTitle("%"+requestManagerShowSaleDto.getTitle()+"%");
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository
				.selectManagerShowBySearchTitle(requestManagerShowSaleDto);
		
		return showSaleList;
	}
}

