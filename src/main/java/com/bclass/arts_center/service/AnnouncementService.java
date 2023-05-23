package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.repository.interfaces.AnnouncementRepository;
import com.bclass.arts_center.repository.model.Announcement;


/**
 * 
 * @author 편용림
 *
 */

@Service
public class AnnouncementService {

	@Autowired
	private AnnouncementRepository announcementRepository;
	
	
	// 전체 찾기
	@Transactional
	public List<Announcement> readAnnouncement(){
		
		return announcementRepository.selectAnnouncement();
		
	}
	
	// 하나 찾기 (디테일)
	
	@Transactional
	public Announcement readAnnouncementById(Integer id) {
		
		Announcement announcement = announcementRepository.selectAnnouncementById(id);
		
		return announcement;
	}
	
	
	// 글작성
	@Transactional
	public int createAnnouncement(Announcement announcement) {
		
		int result = announcementRepository.insertAnnouncement(announcement);
		return result;
	}
	
	//글수정
	@Transactional
	public int updateAnnouncement(Announcement announcement) {
		int resultRowCount = announcementRepository.updateByIdAndUserId(announcement);
		
		return resultRowCount;
		
	}
	
	//글삭제
	@Transactional
	public int deleteAnnouncementByUserId(Integer id) {
		int resultRowCount = announcementRepository.deleteAnnouncementByUserId(id);
		
		return resultRowCount;
	}
	
	@Transactional
	public List<Announcement> readAnnouncementBySearchText(String searchText){
		searchText = "%" + searchText + "%";
		List<Announcement> announcements = announcementRepository.selectAnnouncementBySearchText(searchText);
		return announcements;
	}
	
	

	
}