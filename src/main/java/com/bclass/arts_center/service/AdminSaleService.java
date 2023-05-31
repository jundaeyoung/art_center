package com.bclass.arts_center.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.RentSalesDto;
import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
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
	
	@Transactional
	public List<RentSalesDto> readRentSaleGrape(){
		
		List<RentSalesDto> rentSaleGrape = adminSalesRepository.selectRentSaleGrape();
		
		return rentSaleGrape;
	}
	
	@Transactional
	public List<RequestManagerShowSaleDto> readShowSaleGrape(){
		
		List<RequestManagerShowSaleDto> showSaleGrape = adminSalesRepository.selectShowSalesGrape();
		
		return showSaleGrape;
		
	}
	
	@Transactional
	public List<RequestManagerShowSaleDto> readShowSaleList(){
		
		List<RequestManagerShowSaleDto> showsalesList = adminSalesRepository.selectShowSales();
		
		return showsalesList;
	}
	
	@Transactional
	public List<RequestManagerShowSaleDto> readShowSaleByStartDateAndEndDate(String startDate, String endDate){
		
		List<RequestManagerShowSaleDto> showsalesList = adminSalesRepository.selectShowSalesBystartDateAndEndDate(startDate, endDate);
		
		return showsalesList;
	}
	
	public List<RequestManagerShowSaleDto> readShowSaleBySearch(String searchTitle){
		
		List<RequestManagerShowSaleDto> showSalesList = adminSalesRepository.selectShowSalesBysearchTitle(searchTitle);
		
		return showSalesList;
	}
	
	public List<RentSalesDto> readRentalSlesByStartDateAndEndDate(String startDate, String endDate){
		
		List<RentSalesDto> rentalSlaesList = adminSalesRepository.selectRentSalesBystartDateAndEndDate(startDate, endDate);
		
		return rentalSlaesList;
	}
	
	public List<RentSalesDto> readRentalSalesBySearch(String searchTitle){
		
		List<RentSalesDto> rentalSalesList = adminSalesRepository.selectRentSalesBysearchTitle(searchTitle);
		
		return rentalSalesList;
	}
}
