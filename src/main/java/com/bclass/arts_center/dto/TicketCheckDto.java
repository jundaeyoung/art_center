package com.bclass.arts_center.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.bclass.arts_center.utils.TimestampUtil;

import lombok.Data;

@Data
public class TicketCheckDto {
   private Integer id;
   private Integer userId;
   private String birthDate;
   private String tel;

   private Integer showId;
   private String title;
   private String imgRoute;
   private String adultRate;
   private String youthRate;

   private String name;

   private Timestamp ticketingDate;
   private Integer ageGroupId;

   private Integer showDatetimeId;
   private Date showDate;
   private Time showTime;

   private Integer seatId;
   private String seatName;
   private String qrCode;

   private Integer showTypeId;
   private String holeName;

   public String formatDate() {
      return TimestampUtil.dateToString(showDate);
   }

   public String formatTime() {
      return TimestampUtil.timeToString(showTime);
   }

}