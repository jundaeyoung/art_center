package com.bclass.arts_center.repository.model;

import lombok.Data;

@Data
public class Faq {

	private Integer id;
	private String title;
	private String content;
	private Integer categoryId;
	private String category;

}
