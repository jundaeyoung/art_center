package com.bclass.arts_center.repository.interfaces;
 
import java.util.List; 

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;

@Mapper
public interface ManagerShowSaleRepository {
	
	
	public List<RequestManagerShowSaleDto> selectManagerShowSale(RequestManagerShowSaleDto requestManagerShowSaleDto);
	

	public List<RequestManagerShowSaleDto> selectManagerShowSaleByStartDateAndEndDate(RequestManagerShowSaleDto requestManagerShowSaleDto);
	

	public List<RequestManagerShowSaleDto> selectManagerShowBySearchTitle(RequestManagerShowSaleDto requestManagerShowSaleDto);
	

	public List<RequestManagerShowSaleDto> selectManagerShowDetailByShowId(@Param("showId") Integer showId, @Param("userId")Integer userId);
}
