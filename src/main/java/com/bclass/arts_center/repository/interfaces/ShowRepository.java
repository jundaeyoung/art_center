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

	public List<RequestShowDto> selectShowByNewest(@Param("begin") Integer begin, @Param("range") Integer range);
	
	public Integer selectShowByNewestCount();

	public List<RequestShowDto> selectShowByHighesRated(@Param("begin") Integer begin, @Param("range") Integer range);

	public List<RequestShowDto> selectShowByRowestRated(@Param("begin") Integer begin, @Param("range") Integer range);

	public Integer selectShowCount();

	public List<RequestShowDto> selectShowByCategory(@Param("category") String category, @Param("begin") Integer begin,
			@Param("range") Integer range);

	public Integer selectShowByCategoryCount(String category);

	public Integer insertShow(RequestSignUpShowDto requestSignUpShowDto);

	public Integer insertShowDateTime(RequestRentPlaceDto requestRentPlaceDto);

	public RequestShowDto selectShowByNewestOne(Integer userId);

	public RequestShowDto selectShowByShowId(Integer showId);

	public List<RequestShowDto> selectReviewByShowId(Integer showId);

	public List<ShowViewDto> selectShowInfoByShowId(Integer showId);

	public List<ShowViewDto> selectShowDateByShowId(Integer showId);
	
	public List<RequestShowDto> selectShowInfoAdmin();
	
	public Integer updateShowStatusById(Integer id);
	
	public Integer updateShowHoleById(@Param("id")Integer id ,@Param("holeId") Integer holeId);
	
}
