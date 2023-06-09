package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.repository.interfaces.MainRepository;
import com.bclass.arts_center.repository.model.Announcement;
import com.bclass.arts_center.repository.model.Show;

@Service
public class MainService {

	@Autowired
	private MainRepository mainRepository;

	@Transactional
	public List<Show> readShowDto() {
		List<Show> selectShows = mainRepository.selectShowDto();
		
		return selectShows;
	}
	
	public List<Announcement> selectAnnouncement(){
		List<Announcement> selectAnnouncement = mainRepository.selectAnnouncement();
		
		return selectAnnouncement;
	}
}
