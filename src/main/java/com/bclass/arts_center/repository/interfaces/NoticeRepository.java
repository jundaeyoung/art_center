package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.repository.model.Notice;

@Mapper
public interface NoticeRepository {

	/*
	 * 전대영 : 알림 insert
	 */
	public Integer insertNotice(@Param("notice")String notice, @Param("userId")Integer userId, @Param("adminId") Integer adminId);
	
	/*
	 * 전대영 : 알림 select
	 */
	public List<Notice> selectManagerNotice(Integer userId);
	
	/*
	 * 전대영 : 알림 update(상태 변경해서 안보이게 해줌)
	 */
	public Integer updateManagerNotice(Integer id);
}
