package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.dto.MyRegistrationInfoDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;
import com.bclass.arts_center.repository.interfaces.ManagerMyPageRepository;

/**
 * 김미정 
 */

@Service
public class ManagerMyPageService {
	
	@Autowired
	private ManagerMyPageRepository managerMyPageRepository;
	
	@Transactional
	public List<MyRegistrationInfoDto> selectMyShow(Integer organizerId) {
		List<MyRegistrationInfoDto> myShowList = managerMyPageRepository.selectMyShow(organizerId);
		return myShowList;
	}
	
	@Transactional
	public List<MyRegistrationInfoDto> selectMyShowDetail(Integer id) {
		List<MyRegistrationInfoDto> detailList = managerMyPageRepository.selectMyShowDetail(id);
		return detailList;
	}
	
	
	
	
}
