package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Hole;

@Mapper
public interface HoleRepository {

	/*
	 * 작성자 전대영 hole 정보 select
	 */
	public List<Hole> selectHoleAll();

}
