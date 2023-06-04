package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.repository.model.Notice;

@Mapper
public interface NoticeRepository {
	
	public Integer insertAdminNotice(@Param("notice")String notice, @Param("userId")Integer userId, @Param("adminId") Integer adminId);

	public Integer insertManaegerNotice(@Param("notice")String notice, @Param("userId")Integer userId, @Param("adminId") Integer adminId);
	
	public List<Notice> selectManagerNotice(Integer userId);
	
	public Integer updateManagerNotice(Integer id);
}
