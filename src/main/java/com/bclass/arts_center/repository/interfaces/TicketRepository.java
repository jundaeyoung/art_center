package com.bclass.arts_center.repository.interfaces;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bclass.arts_center.dto.TicketingDto;

@Mapper
public interface TicketRepository {

	public List<TicketingDto> selectShowInfoForTicketingByShowId(Integer showId);

	public List<TicketingDto> selectShowDateByShowId(Integer showId);

	public List<TicketingDto> selectShowTimeByShowId(Integer showId, Date showDate);

//	public int insert(Ticket ticket);
//
//	public int delete(int id);

}
