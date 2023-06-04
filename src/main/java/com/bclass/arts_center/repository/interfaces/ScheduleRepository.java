package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.request.RequestShowDto;

@Mapper
public interface ScheduleRepository {


	public List<RequestShowDto> selectShowScheduleByCategory(Integer showTypeId);


	public List<RequestShowDto> selectShowSchedule();


	public RequestShowDto selectShowDetailByShowId(Integer id);


	public List<RequestShowDto> selectMyShowSchedule(Integer id);
}
