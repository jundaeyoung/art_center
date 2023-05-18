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
	 * 전대영 : 공연 매니저 id로 select
	 */
	@Transactional
	public List<RequestShowDto> readShowById(Integer userId) {
		List<RequestShowDto> showSaleList = managerShowSaleRepository.selectManagerShowSaleByUserId(userId);
		return showSaleList;
	}

	/*
	 * 전대영 : 공연 title 검색
	 */
	@Transactional
	public List<RequestManagerShowSaleDto> readShowByTitle(String title) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository.selectManagerShowBySearch(title);

		return showSaleList;
	}

	/*
	 * 전대영 : 공연 검색
	 */
	@Transactional
	public List<RequestManagerShowSaleDto> readShowSale(ResponseManagerShowSaleDto managerShowSaleDto) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository
				.selectManagerShowSaleByDate(managerShowSaleDto);

		return showSaleList;
	}

	/*
	 * 전대영 : 공연 검색
	 */
	@Transactional
	public List<RequestManagerShowSaleDto> selectInfantCount(RequestManagerShowSaleDto requestManagerShowSaleDto) {
		List<RequestManagerShowSaleDto> showSaleList = managerShowSaleRepository
				.selectCount(requestManagerShowSaleDto);

		return showSaleList;
	}
}
