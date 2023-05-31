package com.bclass.arts_center.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MyRegistrationInfoDto {

	private Integer id;
	private String imgRoute;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private String admissionAge;
	private String adultRate;
	private String youthRate;
	private Integer organizerId;
	private Integer holeId;
	private Integer showTypeId;
	private Integer showStatus;
	private Integer rentPlaceId;
	private Time startTime;
	private Time endTime;
	private String rentPrice;
	private Date reservationDate;
	private Integer userId;
	private Integer locationId;
	private Integer rentPlaceStatus;
	private Integer showId;
	private String name;
	private String tel;
	private String location;
	private String locationInfo;
	private String rentId;
	private String mPaymentId;
	
    public String getMPaymentId() {
        return mPaymentId;
    }

    public void setMPaymentId(String mPaymentId) {
        this.mPaymentId = mPaymentId;
    }
	
	
}
