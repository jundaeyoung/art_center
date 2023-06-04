package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;
import com.bclass.arts_center.dto.request.RequestManagerRentSaleDto;


@Mapper
public interface AdminSalesRepository {

	public List<RequestManagerRentSaleDto> selectRentSaleGrape();

	public List<RequestManagerShowSaleDto> selectShowSaleGrape();

	public List<RequestManagerRentSaleDto> selectRentSaleList();

	public List<RequestManagerShowSaleDto> selectShowSaleList();

	public List<RequestManagerShowSaleDto> selectShowSaleByStartDateAndEndDate(@Param("startDate") String startDate,
			@Param("endDate") String endDate);

	public List<RequestManagerRentSaleDto> selectRentSaleByStartDateAndEndDate(@Param("startDate") String startDate,
			@Param("endDate") String endDate);

	public List<RequestManagerShowSaleDto> selectShowSaleSearchByTitle(@Param("searchTitle") String searchTitle);

	public List<RequestManagerRentSaleDto> selectRentSaleBySearchTitle(@Param("searchTitle") String searchTitle);

}
