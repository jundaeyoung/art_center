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

	/*
	 * 전대영 : 매니저 공연 매출 보기 
	 */
	@Transactional
	public List<RequestManagerShowSaleDto> readAndCount(RequestManagerShowSaleDto requestManagerShowSaleDto) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository
				.selectAndCount(requestManagerShowSaleDto);

		return showSaleList;
	}
	/*
	 * 전대영 : 매니저 공연 매출 날짜별로 보기 
	 */
	@Transactional
	public List<RequestManagerShowSaleDto> readManagerShowSaleByDate(RequestManagerShowSaleDto requestManagerShowSaleDto) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository
				.selectManagerShowSaleByDate(requestManagerShowSaleDto);
		
		return showSaleList;
	}
	
	/*
	 * 전대영 : 매니저 공연 매출 검색하여 보기 
	 */
	@Transactional
	public List<RequestManagerShowSaleDto> readManagerShowBySearch(RequestManagerShowSaleDto requestManagerShowSaleDto) {
		requestManagerShowSaleDto.setTitle("%"+requestManagerShowSaleDto.getTitle()+"%");
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository
				.selectManagerShowBySearch(requestManagerShowSaleDto);
		
		return showSaleList;
	}
	
	/*
	 * 전대영 : 매니저 공연 detail 매출 보기 
	 */
	@Transactional
	public List<RequestManagerShowSaleDto> readManagerShowDetailByShowId(Integer showId,Integer userId) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository
				.selectManagerShowDetailByShowId(showId,userId);
		return showSaleList;
	}
	
	
}
