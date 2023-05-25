package com.bclass.arts_center.repository.model;

import java.awt.TextArea;

import lombok.Data;

@Data
public class Faq {

	private Integer id;
	private String title;
	private TextArea content;
	private Integer categoryId;
	private String category;

}
