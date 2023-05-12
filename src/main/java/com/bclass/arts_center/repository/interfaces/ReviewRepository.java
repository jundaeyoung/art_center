package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.request.RequestReviewDto;

@Mapper
public interface ReviewRepository {

	/**
	 * 작성자 : 전대영 리뷰 최신순으로 select
	 */
	public List<RequestReviewDto> selectReviewByNewest(@Param("begin") Integer begin, @Param("range") Integer range);

	public Integer selectReviewByNewestCount();
}
