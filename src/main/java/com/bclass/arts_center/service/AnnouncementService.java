package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.repository.interfaces.AnnouncementRepository;
import com.bclass.arts_center.repository.model.Announcement;



@Service
public class AnnouncementService {

	@Autowired
	private AnnouncementRepository announcementRepository;
	
	
	@Transactional
	public List<Announcement> readAnnouncement(){
		List<Announcement> announcementList = announcementRepository.selectAnnouncement();
		
		return announcementList;
	}
	
	
	@Transactional
	public Announcement readAnnouncementById(Integer id) {
		Announcement announcement = announcementRepository.selectAnnouncementById(id);
		
		return announcement;
	}
	
	
	@Transactional
	public Integer createAnnouncement(Announcement announcement) {
		Integer result = announcementRepository.insertAnnouncement(announcement);
		
		return result;
	}
	
	
	@Transactional
	public Integer updateAnnouncement(Announcement announcement) {
		Integer resultRowCount = announcementRepository.updateByIdAndUserId(announcement);
		
		return resultRowCount;
		
	}

	
	@Transactional
	public Integer deleteAnnouncementByUserId(Integer id) {
		Integer resultRowCount = announcementRepository.deleteAnnouncementByUserId(id);
		
		return resultRowCount;
	}
	
	
	@Transactional
	public List<Announcement> readAnnouncementBySearchText(String searchText){
		searchText = "%" + searchText + "%";
		List<Announcement> announcementList = announcementRepository.selectAnnouncementBySearchText(searchText);
		
		return announcementList;
	}
	
	

	
}