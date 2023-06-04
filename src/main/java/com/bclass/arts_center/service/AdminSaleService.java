package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.request.RequestManagerRentSaleDto;
import com.bclass.arts_center.repository.interfaces.AdminSalesRepository;

@Service
public class AdminSaleService {
	
	@Autowired
	private AdminSalesRepository adminSalesRepository;
	
	
	@Transactional
	public List<RequestManagerRentSaleDto> readRentSaleGrape(){
		List<RequestManagerRentSaleDto> rentSaleGrape = adminSalesRepository.selectRentSaleGrape();
		
		return rentSaleGrape;
	}
	
	
	@Transactional
	public List<RequestManagerShowSaleDto> readShowSaleGrape(){
		
		List<RequestManagerShowSaleDto> showSaleGrape = adminSalesRepository.selectShowSaleGrape();
		
		return showSaleGrape;
		
	}
	
	
	@Transactional
	public List<RequestManagerRentSaleDto> readRentSaleList(){
		List<RequestManagerRentSaleDto> rentSaleList = adminSalesRepository.selectRentSaleList();
		
		return rentSaleList;
	}
	
	
	@Transactional
	public List<RequestManagerShowSaleDto> readShowSaleList(){
		List<RequestManagerShowSaleDto> showsaleList = adminSalesRepository.selectShowSaleList();
		
		return showsaleList;
	}
	
	
	@Transactional
	public List<RequestManagerShowSaleDto> readShowSaleByStartDateAndEndDate(String startDate, String endDate){
		List<RequestManagerShowSaleDto> showsaleList = adminSalesRepository.selectShowSaleByStartDateAndEndDate(startDate, endDate);
		
		return showsaleList;
	}
	
	@Transactional
	public List<RequestManagerShowSaleDto> readShowSaleSearchBySearch(String searchTitle){
		List<RequestManagerShowSaleDto> showSaleList = adminSalesRepository.selectShowSaleSearchByTitle(searchTitle);
		
		return showSaleList;
	}
	
	@Transactional
	public List<RequestManagerRentSaleDto> readRentalSaleByStartDateAndEndDate(String startDate, String endDate){
		List<RequestManagerRentSaleDto> rentalSlaeList = adminSalesRepository.selectRentSaleByStartDateAndEndDate(startDate, endDate);
		
		return rentalSlaeList;
	}
	
	@Transactional
	public List<RequestManagerRentSaleDto> readRentalSaleBySearch(String searchTitle){
		List<RequestManagerRentSaleDto> rentalSaleList = adminSalesRepository.selectRentSaleBySearchTitle(searchTitle);
		
		return rentalSaleList;
	}
}
