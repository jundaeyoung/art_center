package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.MyRegistrationInfoDto;
import com.bclass.arts_center.dto.request.RequestSignUpShowDto;

/**
 * 
 * @author 김미정
 *
 */

@Mapper
public interface ManagerMyPageRepository {

	// 공연예약 불러오기
	public List<MyRegistrationInfoDto> selectMyShow(Integer organizerId);
	
	// 공연예약 detail
	public List<MyRegistrationInfoDto> selectMyShowDetail(Integer id);
}
