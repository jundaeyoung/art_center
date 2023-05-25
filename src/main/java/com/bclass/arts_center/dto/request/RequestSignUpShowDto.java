package com.bclass.arts_center.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RequestSignUpShowDto {

	private Integer id;
	private String imgRoute;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private String admissionAge;
	private String adultRate;
	private String youthRate;
	private String infantRate;
	private Integer organizerId;
	private Integer holeId;
	private Integer showTypeId;
	private Integer showStatus;


	private MultipartFile file;

	private String originFileName;
	private String uploadFileName;

	public String setImgRoute() {

		return uploadFileName.length() >= 10 ? "/images/myinfo.png" : "/images/uploads/" + uploadFileName;
	}
}
