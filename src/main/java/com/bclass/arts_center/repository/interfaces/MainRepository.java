package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Announcement;
import com.bclass.arts_center.repository.model.Show;

@Mapper
public interface MainRepository {

	/*
	 * 전대영
	 * main에서 공연정보 불러오기
	 */
	public List<Show> selectShowDto();
	
	/**
	 * 김미정
	 * main에서 공지사항 불러오기
	 */
	public List<Announcement> selectAnnouncement();
}
