package com.bclass.arts_center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bclass.arts_center.repository.interfaces.HoleRepository;
import com.bclass.arts_center.repository.model.Hole;

@Service
public class HoleService {

	@Autowired
	private HoleRepository holeRepository;
	
	public List<Hole> readHoleAll() {
		List<Hole> holeList = holeRepository.selectHoleAll();
		
		return holeList;
	}
}
