package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.ShowViewDto;
import com.bclass.arts_center.dto.request.RequestRentPlaceDto;
import com.bclass.arts_center.dto.request.RequestShowDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;
import com.bclass.arts_center.repository.interfaces.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepository;


	@Transactional
	public List<RequestShowDto> readShowList() {
		List<RequestShowDto> showList = showRepository.selectShowInfoAdmin();
		
		return showList;
	}


	@Transactional
	public Integer updateShowStatusById(Integer id) {
		Integer result = showRepository.updateShowStatusById(id);
		
		return result;
	}


	@Transactional
	public Integer updateShowHoleById(Integer id, Integer holeId) {
		Integer result = showRepository.updateShowHoleById(id, holeId);
		
		return result;
	}


	@Transactional
	public List<RequestShowDto> readShowByNewest(Integer begin, Integer range) {
		List<RequestShowDto> showList = showRepository.selectShowByNewest(begin, range);
		
		return showList;
	}


	@Transactional
	public Integer readShowByNewestCount() {
		Integer showCount = showRepository.selectShowByNewestCount();
		
		return showCount;
	}


	@Transactional
	public List<RequestShowDto> readShowByHighesRated(Integer begin, Integer range) {
		List<RequestShowDto> showList = showRepository.selectShowByHighesRated(begin, range);
		
		return showList;
	}


	@Transactional
	public List<RequestShowDto> readShowByRowestRated(Integer begin, Integer range) {
		List<RequestShowDto> showList = showRepository.selectShowByRowestRated(begin, range);
		return showList;
	}


	@Transactional
	public Integer readShowByCount() {
		Integer showNewestCount = showRepository.selectShowCount();
		return showNewestCount;
	}


	@Transactional
	public List<RequestShowDto> readShowBycategory(String category, Integer begin, Integer range) {
		List<RequestShowDto> showList = showRepository.selectShowByCategory(category, begin, range);
		return showList;
	}

	
	@Transactional
	public Integer readShowBycategoryCount(String category) {
		Integer showNewestCount = showRepository.selectShowByCategoryCount(category);
		return showNewestCount;
	}


	@Transactional
	public Integer createShow(RequestSignUpShowDto requestSignUpShowDto) {
		Integer showNewestCount = showRepository.insertShow(requestSignUpShowDto);
		return showNewestCount;
	}


	@Transactional
	public Integer createShowDateTime(RequestRentPlaceDto requestRentPlaceDto) {
		Integer showNewestCount = showRepository.insertShowDateTime(requestRentPlaceDto);
		return showNewestCount;
	}


	@Transactional
	public RequestShowDto readShowByNewestOne(Integer userId) {
		RequestShowDto show = showRepository.selectShowByNewestOne(userId);
		return show;
	}

	
	@Transactional
	public RequestShowDto readShowByShowId(Integer userId) {
		RequestShowDto show = showRepository.selectShowByShowId(userId);
		return show;
	}


	@Transactional
	public List<RequestShowDto> readReviewByShowId(Integer userId) {
		List<RequestShowDto> show = showRepository.selectReviewByShowId(userId);
		return show;
	}


	@Transactional
	public List<ShowViewDto> readShowInfoByShowId(Integer id) {
		List<ShowViewDto> ShowInfoList = showRepository.selectShowInfoByShowId(id);
		return ShowInfoList;
	}


	@Transactional
	public List<ShowViewDto> readShowDateByShowId(Integer showId) {
		List<ShowViewDto> showTimeList = showRepository.selectShowDateByShowId(showId);
		return showTimeList;
	}
}
