package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.repository.interfaces.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepository;

	/**
	 * 작성자 : 전대영 show 최신순으로 select
	 */
	@Transactional
	public List<RequestShowDto> readShowByNewest(Integer begin, Integer range) {
		List<RequestShowDto> showList = showRepository.selectShowByNewest(begin, range);
		return showList;
	}

	/**
	 * 작성자 : 전대영 show 관람평 높은순으로 select
	 */
	@Transactional
	public List<RequestShowDto> readShowByHighesRated(Integer begin, Integer range) {
		List<RequestShowDto> showList = showRepository.selectShowByHighesRated(begin, range);
		return showList;
	}

	/**
	 * 작성자 : 전대영 show 관람평 낮은순으로 select
	 */
	@Transactional
	public List<RequestShowDto> readShowByRowestRated(Integer begin, Integer range) {
		List<RequestShowDto> showList = showRepository.selectShowByRowestRated(begin, range);
		return showList;
	}

	/**
	 * 작성자 : 전대영 show Count
	 */
	@Transactional
	public Integer readShowByCount() {
		Integer showNewestCount = showRepository.selectShowCount();
		return showNewestCount;
	}

	/**
	 * 작성자 : 전대영 show 카테고리별 select
	 */
	@Transactional
	public List<RequestShowDto> readShowBycategory(String category, Integer begin, Integer range) {
		List<RequestShowDto> showList = showRepository.selectShowByCategory(category, begin, range);
		return showList;
	}

	/**
	 * 작성자 : 전대영 show 카테고리별 Count
	 */
	@Transactional
	public Integer readShowBycategoryCount(String category) {
		Integer showNewestCount = showRepository.selectShowByCategoryCount(category);
		return showNewestCount;
	}

	/*
	 * 손주이 : showId와 일치하는 공연정보
	 */
	public List<ShowViewDto> readShowInfoByShowId(Integer id) {
		List<ShowViewDto> ShowInfoList = showRepository.selectShowInfoByShowId(id);
		return ShowInfoList;
	}

	/*
	 * 작성자 : 손주이 showId와 일치하는 show 상연날짜 select
	 */
	public List<ShowViewDto> readShowDateByShowId(Integer showId) {
		List<ShowViewDto> showTimeList = showRepository.selectShowDateByShowId(showId);
		return showTimeList;
	}
}
