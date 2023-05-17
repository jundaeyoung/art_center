package com.bclass.arts_center.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.repository.model.Show;
import com.bclass.arts_center.repository.model.Ticket;

@Mapper
public interface TicketRepository {
	
	public List<Show> selectShowInfo();

	public int insert(Ticket ticket);

	public int delete(int id);

}
