package com.bclass.arts_center.repository.model;

import lombok.Data;

@Data
public class Review {

	private Integer id;
	private String content;
	private String reviewCreationDate;
	private Integer rating;
	private Integer userId;
	private Integer showId;
}
