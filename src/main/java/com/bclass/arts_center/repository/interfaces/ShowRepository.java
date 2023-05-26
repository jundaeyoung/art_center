package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;

@Mapper
public interface ShowRepository {

	/**
	 * 작성자 : 전대영 show 최신순으로 select
	 */
	public List<RequestShowDto> selectShowByNewest(@Param("begin") Integer begin, @Param("range") Integer range);
	
	/**
	 * 작성자 : 전대영 show 최신순으로 count
	 */
	public List<RequestShowDto> selectShowByNewestCount();

	/**
	 * 작성자 : 전대영 show 평점 높은순으로 select
	 */
	public List<RequestShowDto> selectShowByHighesRated(@Param("begin") Integer begin, @Param("range") Integer range);

	/**
	 * 작성자 : 전대영 show 평점 낮은순으로 select
	 */
	public List<RequestShowDto> selectShowByRowestRated(@Param("begin") Integer begin, @Param("range") Integer range);

	/**
	 * 작성자 : 전대영 show count
	 */
	public Integer selectShowCount();

	/**
	 * 작성자 : 전대영 show 카테고리별 select
	 */
	public List<RequestShowDto> selectShowByCategory(@Param("category") String category, @Param("begin") Integer begin,
			@Param("range") Integer range);

	/**
	 * 작성자 : 전대영 show 카테고리별 count
	 */
	public Integer selectShowByCategoryCount(String category);

	/**
	 * 작성자 : 전대영 show insert
	 */
	public Integer insertShow(RequestSignUpShowDto requestSignUpShowDto);
	
	/**
	 * 작성자 : 전대영 show insert
	 */
	public Integer insertShowDateTime(RequestRentPlaceDto requestRentPlaceDto);

	/**
	 * 작성자 : 전대영 show insert된거 최근 하나만 가져오기
	 */
	public RequestShowDto selectShowByNewestOne(Integer userId);
	
	/**
	 * 작성자 : 전대영 show 아이디로 찾기
	 */
	public RequestShowDto selectShowByShowId(Integer showId);
	
	/*
	 * 손주이 : showId와 일치하는 공연 정보 select
	 */
	public List<ShowViewDto> selectShowInfoByShowId(Integer showId);

	/*
	 * 손주이 ticketing 에 필요한 공연 날짜 정보 select
	 */
	public List<ShowViewDto> selectShowDateByShowId(Integer showId);
	
	
	/**
	 * 
	 * 편용림 admin에 공연 예약 전체조회
	 */
	public List<RequestShowDto> selectShowInfoAdmin();
	
	public int updateShowById(Integer id);
	
	/*
	 * 전대영 manager 공연 hole 업데이트
	 */
	public int updateShowHole(@Param("id")Integer id ,@Param("holeId") Integer holeId);
	
}
