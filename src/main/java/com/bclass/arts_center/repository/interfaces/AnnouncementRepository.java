package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Announcement;


@Mapper
public interface AnnouncementRepository {

	public int insertAnnouncement(Announcement announcement);

	public List<Announcement> selectAnnouncement();

	public Announcement selectAnnouncementById(Integer id);

	public int updateByIdAndUserId(Announcement announcement);

	public int deleteAnnouncementByUserId(Integer id);

	public List<Announcement> selectAnnouncementBySearchText(String searchText);

}