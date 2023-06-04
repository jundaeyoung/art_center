package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Announcement;
import com.bclass.arts_center.repository.model.Show;

@Mapper
public interface MainRepository {

	public List<Show> selectShowDto();
	
	public List<Announcement> selectAnnouncement();
}
