package com.bclass.arts_center.repository.interfaces;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.TicketingDto;

@Mapper
public interface TicketRepository {

	public List<TicketingDto> selectShowInfoForTicketingByShowId(Integer showId);

	public List<TicketingDto> selectShowDateByShowId(Integer showId);

	public List<TicketingDto> selectShowTimeByShowId(@Param("showId") Integer showId, @Param("showDate") Date showDate);

	public List<TicketingDto> selectTicketingAll();

	public List<TicketingDto> selectSeatInfo(@Param("showId") Integer showId,
			@Param("showDateTimeId") Integer showDateTimeId);

	public int insertTicket(TicketingDto ticketingDto);

	public List<TicketCheckDto> selectTicket(Integer userId);
	
	public TicketCheckDto selectTicketForPay(Integer ticketingId);

	public int updateTicketing(@Param("userId") Integer userId, @Param("sessionTicketingId") Integer sessionTicketingId);
//	public int delete(int id);

}
