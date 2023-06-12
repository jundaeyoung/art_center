package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Hole;

@Mapper
public interface HoleRepository {

	public List<Hole> selectHoleAll();
}
