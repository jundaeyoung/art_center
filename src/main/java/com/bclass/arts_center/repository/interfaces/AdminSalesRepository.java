package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.RentSalesDto;
import com.bclass.arts_center.dto.request.RequestManagerShowSaleDto;

/**
 * 
 * @author 편용림
 *
 */

@Mapper
public interface AdminSalesRepository {

	// 작성자 : 편용림 대관 총 매출
	public List<RentSalesDto> selectRentSalesDtoList();
	
	// 작성자 : 편용림 대관 그래프
	public List<RentSalesDto> selectRentSaleGrape();
	
	// 작성자 : 편용림 티켓 그래프
	public List<RequestManagerShowSaleDto> selectShowSalesGrape();
	
}
