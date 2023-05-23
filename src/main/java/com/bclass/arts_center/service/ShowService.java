package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;
import com.bclass.arts_center.repository.interfaces.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepository;

	
	/**
	 * 
	 * 작성자 : 편용림 admin 예약 승낙한 순서대로 조회
	 */
	
	@Transactional
	public List<RequestShowDto> readShow(){
		List<RequestShowDto> showList = showRepository.selectShowInfoAdmin();
		return showList;
	}
	
	/*
	 *  작성자 : 편용림 admin status 업데이트
	 */
	@Transactional
	public int updateShow(Integer id) {
		int result = showRepository.updateShowById(id);
		return result;
	}
	
	
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

	/**
	 * 작성자 : 전대영 manager 계정에서 show insert
	 */
	@Transactional
	public Integer createShow(RequestSignUpShowDto requestSignUpShowDto) {
		Integer showNewestCount = showRepository.insertShow(requestSignUpShowDto);
		System.out.println(requestSignUpShowDto);
		return showNewestCount;
	}
	
	/*
	 * 손주이 : showId와 일치하는 공연정보
	 */
	@Transactional
	public List<ShowViewDto> readShowInfoByShowId(Integer id) {
		List<ShowViewDto> ShowInfoList = showRepository.selectShowInfoByShowId(id);
		return ShowInfoList;
	}

	/*
	 * 작성자 : 손주이 showId와 일치하는 show 상연날짜 select
	 */
	@Transactional
	public List<ShowViewDto> readShowDateByShowId(Integer showId) {
		List<ShowViewDto> showTimeList = showRepository.selectShowDateByShowId(showId);
		return showTimeList;
	}
}
