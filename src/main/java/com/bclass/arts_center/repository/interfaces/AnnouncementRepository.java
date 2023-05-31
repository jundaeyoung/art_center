package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Announcement;

/**
 * 
 * @author 편용림
 *
 */

@Mapper
public interface AnnouncementRepository {

	// 공지 등록
	public int insertAnnouncement(Announcement announcement);

	// 공지 전부 찾기
	public List<Announcement> selectAnnouncement();

	// 공지 하나 찾기
	public Announcement selectAnnouncementById(Integer id);

	// 공지 수정
	public int updateByIdAndUserId(Announcement announcement);

	// 공지 삭제
	public int deleteAnnouncementByUserId(Integer id);

	// 공지 검색
	public List<Announcement> selectAnnouncementBySearchText(String searchText);

}