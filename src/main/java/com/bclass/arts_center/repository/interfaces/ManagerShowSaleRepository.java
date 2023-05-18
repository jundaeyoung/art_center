package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.dto.response.ResponseManagerShowSaleDto;

@Mapper
public interface ManagerShowSaleRepository {
	
	
	/*
	 * 전대영 : 매니저 공연 매출 보기
	 */
	public List<RequestShowDto> selectManagerShowSaleByUserId(Integer userId);
	
	/*
	 * 전대영 : 매니저 공연 매출 보기
	 */
	public List<RequestManagerShowSaleDto> selectManagerShowSaleByDate(ResponseManagerShowSaleDto managerShowSaleDto);

	/*
	 * 전대영 : 매니저 공연 검색하기
	 */
	public List<RequestManagerShowSaleDto> selectManagerShowBySearch(String title);
	
	
	
	
	
	public List<RequestManagerShowSaleDto> selectCount(RequestManagerShowSaleDto requestManagerShowSaleDto);
	
}
