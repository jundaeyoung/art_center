package com.bclass.arts_center.repository.interfaces;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bclass.arts_center.dto.MyTiketDto;
import com.bclass.arts_center.dto.TicketCheckDto;
import com.bclass.arts_center.dto.TicketingDto;

/**
 * 
 * @author 손주이
 *
 */
@Mapper
public interface TicketRepository {

	public List<TicketingDto> selectShowInfoForTicketingByShowId(Integer showId);

	public List<TicketingDto> selectShowDateByShowId(Integer showId);

	public List<TicketingDto> selectShowTimeByShowId(@Param("showId") Integer showId, @Param("showDate") Date showDate);

	public List<TicketingDto> selectTicketingAll();

	public List<TicketingDto> selectSeatInfo(@Param("showId") Integer showId, @Param("showDatetimeId") Integer showDatetimeId);

	public List<TicketingDto> selectOccupiedSeat(Integer showDatetimeId);

	public int insertTicket(TicketingDto ticketingDto);

	public int insertSeat(@Param("seatId") Integer seatId,@Param("showDatetimeId") Integer showDatetimeId);

	public List<TicketCheckDto> selectTicket(Integer userId);
	
	public TicketCheckDto selectTicketForPay(Integer ticketingId);

	public int updateTicketing(@Param("userId") Integer userId, @Param("ticketingId") Integer ticketingId);
	
	public int updateQrCode(@Param("id")Integer id, @Param("path") String path);
//	public int delete(int id);
	public TicketCheckDto selectTicketId();
	
	
	public List<MyTiketDto> selectMyTiketDto(Integer userId);
	
	
	public TicketCheckDto selectTicketIdbyId(Integer id);

	/**
	 * @author 김미정
	 * @param showDatetimeId
	 */
	public Integer countTicketing(Integer showDatetimeId);
	
	
//	public int delete(int id);
	
	
}
