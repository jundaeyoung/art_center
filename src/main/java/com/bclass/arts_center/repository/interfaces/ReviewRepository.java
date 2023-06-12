package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.MyTiketDto;
import com.bclass.arts_center.dto.request.RequestReviewDto;
import com.bclass.arts_center.repository.model.Review;
@Mapper
public interface ReviewRepository {

	public List<RequestReviewDto> selectReviewByNewest(@Param("begin") Integer begin, @Param("range") Integer range);
	
	public List<RequestReviewDto> selectReviewByHighesRated(@Param("begin") Integer begin, @Param("range") Integer range);
	
	public List<RequestReviewDto> selectReviewByRowestRated(@Param("begin") Integer begin, @Param("range") Integer range);
	
	public Integer selectReviewCount();
	
	public List<RequestReviewDto> selectReviewByCategory(@Param("category") String category, @Param("begin") Integer begin, @Param("range") Integer range);
	
	public Integer selectReviewByCategoryCount(String categorty);
	
	public List<RequestReviewDto> selectReviewByShow(@Param("showName") String showName, @Param("begin") Integer begin, @Param("range") Integer range);
	
	public Integer selectReviewCountByShow(String showName);
	
	public int insertReview(Review review);
	
	public List<MyTiketDto> selectMyTiketDtoByShowType(MyTiketDto myTiketDto);
	
}
