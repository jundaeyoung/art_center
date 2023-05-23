package com.bclass.arts_center.dto.request;

import lombok.Data;

@Data
public class RequestRentPlaceReservationDto {

	private String nickname;
	private Integer tel;
	private Integer startDate;
	private Integer endDate;
	private String startTime;
	private String endTime;
	private String name;
	private String location;
	private String locationInfo;
	private Integer rentPlaceStatus;
}
