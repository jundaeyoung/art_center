package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.RentSalesDto;
import com.bclass.arts_center.repository.interfaces.AdminSalesRepository;

@Service
public class AdminSaleService {
	
	@Autowired
	private AdminSalesRepository adminSalesRepository;

	@Transactional
	public List<RentSalesDto> readRentSale(){
		
		List<RentSalesDto> rentSalesDtolist = adminSalesRepository.selectRentSalesDtoList();
		
		return rentSalesDtolist;
	};
}
