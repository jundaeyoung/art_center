package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.request.RequestShowDto;

@Mapper
public interface ShowRepository {

	/**
	 * 작성자 : 전대영 
	 * show 최신순으로 select
	 */
	public List<RequestShowDto> selectShowByNewest(@Param("begin") Integer begin, @Param("range") Integer range);
	
	/**
	 * 작성자 : 전대영 
	 * show 평점 높은순으로 select
	 */
	public List<RequestShowDto> selectShowByHighesRated(@Param("begin") Integer begin, @Param("range") Integer range);
	
	/**
	 * 작성자 : 전대영 
	 * show 평점 낮은순으로 select
	 */
	public List<RequestShowDto> selectShowByRowestRated(@Param("begin") Integer begin, @Param("range") Integer range);
	
	
	/**
	 * 작성자 : 전대영 
	 * show count 
	 */
	public Integer selectShowCount();
	
	/**
	 * 작성자 : 전대영 
	 * show 카테고리별 select
	 */
	public List<RequestShowDto> selectShowByCategory(@Param("category") String category,@Param("begin") Integer begin, @Param("range") Integer range);
	
	
	/**
	 * 작성자 : 전대영 
	 * show 카테고리별 count 
	 */
	public Integer selectShowByCategoryCount(String category);
}
