package com.bclass.arts_center.repository.interfaces;
 
import java.util.List; 

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;

@Mapper
public interface ManagerShowSaleRepository {
	
	
	
	/*
	 * 전대영 : 매니저 공연 매출 보기 
	 */
	public List<RequestManagerShowSaleDto> selectAndCount(RequestManagerShowSaleDto requestManagerShowSaleDto);
	
	/*
	 * 전대영 : 매니저 공연 달력별로 매출 보기
	 */
	public List<RequestManagerShowSaleDto> selectManagerShowSaleByDate(RequestManagerShowSaleDto requestManagerShowSaleDto);
	
	/*
	 * 전대영 : 매니저 공연 검색하여 매출 보기
	 */
	public List<RequestManagerShowSaleDto> selectManagerShowBySearch(RequestManagerShowSaleDto requestManagerShowSaleDto);
	
	/*
	 * 전대영 : 매니저 공연 검색하여 매출 보기
	 */
	public List<RequestManagerShowSaleDto> selectManagerShowDetailByShowId(@Param("showId") Integer showId, @Param("userId")Integer userId);
	

}
