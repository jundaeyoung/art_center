package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.request.RequestSignUpShowDto;
import com.bclass.arts_center.repository.interfaces.MyPageRepository;

/**
 * 김미정 
 */

@Service
public class MyPageService {
	
	@Autowired
	private MyPageRepository myPageRepository;
	
	@Transactional
	public List<RequestSignUpShowDto> selectMyShow(Integer organizerId) {
		List<RequestSignUpShowDto> myShowList = myPageRepository.selectMyShow(organizerId);
		return myShowList;
	}
	
	@Transactional
	public List<RequestSignUpShowDto> selectMyShowDetail(Integer id) {
		List<RequestSignUpShowDto> detailList = myPageRepository.selectMyShowDetail(id);
		return detailList;
	}
	
	
	
	
}