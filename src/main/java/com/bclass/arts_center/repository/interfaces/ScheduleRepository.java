package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.request.RequestShowDto;

@Mapper
public interface ScheduleRepository {

	/**
	 * 김미정 : 카테고리 별 데이터 불러오기
	 */
	public List<RequestShowDto> selectByCategory(Integer showTypeId);

	/**
	 * 김미정 : calendar 전체 데이터 불러오기
	 */
	public List<RequestShowDto> selectByShow();

	/**
	 * 김미정 : calendar 공연 디테일 정보 불러오기
	 */
	public RequestShowDto selectByShowDetail(Integer id);

	/*
	 * 전대영 : 나의 스케줄 보기 ( 매니저 )
	 */
	public List<RequestShowDto> selectByMySchedule(Integer id);
}
