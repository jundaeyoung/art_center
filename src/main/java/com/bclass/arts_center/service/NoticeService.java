package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bclass.arts_center.repository.interfaces.NoticeRepository;
import com.bclass.arts_center.repository.model.Notice;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;


	@Transactional
	public Integer createAdminNotice(String notice,Integer userId, Integer adminId) {
		Integer result = noticeRepository.insertAdminNotice(notice,userId, adminId);
		
		return result;
	}
	

	@Transactional
	public Integer createManagerNotice(String notice,Integer userId, Integer adminId) {
		Integer result = noticeRepository.insertManaegerNotice(notice,userId, adminId);
		
		return result;
	}
	
	
	@Transactional
	public List<Notice> readNotice(Integer userId){
		List<Notice> noticeList = noticeRepository.selectManagerNotice(userId);
		
		return noticeList;
	}
	
	
	@Transactional
	public Integer updateNotice(Integer id){
		Integer updateNotice = noticeRepository.updateManagerNotice(id);
		
		return updateNotice;
	}
}
