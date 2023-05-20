package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.request.RequestReviewDto;
@Mapper
public interface ReviewRepository {

	/**
	 * 작성자 : 전대영 
	 * 리뷰 최신순으로 select
	 */
	public List<RequestReviewDto> selectReviewByNewest(@Param("begin") Integer begin, @Param("range") Integer range);
	
	/**
	 * 작성자 : 전대영 
	 * 리뷰 평점 높은순으로 select
	 */
	public List<RequestReviewDto> selectReviewByHighesRated(@Param("begin") Integer begin, @Param("range") Integer range);
	
	/**
	 * 작성자 : 전대영 
	 * 리뷰 평점 낮은순으로 select
	 */
	public List<RequestReviewDto> selectReviewByRowestRated(@Param("begin") Integer begin, @Param("range") Integer range);
	
	
	/**
	 * 작성자 : 전대영 
	 * 리뷰 count 
	 */
	public Integer selectReviewCount();
	
	/**
	 * 작성자 : 전대영 
	 * 리뷰 카테고리별 select
	 */
	public List<RequestReviewDto> selectReviewByCategory(@Param("category") String category, @Param("begin") Integer begin, @Param("range") Integer range);
	
	
	/**
	 * 작성자 : 전대영 
	 * 리뷰 카테고리별 count 
	 */
	public Integer selectReviewByCategoryCount(String categorty);
	
	/**
	 * 작성자 : 전대영 
	 * review에서 show검색해서show별로 리뷰 보기 
	 */
	public List<RequestReviewDto> selectReviewByShow(@Param("showName") String showName, @Param("begin") Integer begin, @Param("range") Integer range);
	
	/**
	 * 작성자 : 전대영 
	 * review에서 show검색해서show별로 카운터하기
	 */
	public Integer selectReviewCountByShow(String showName);
}
