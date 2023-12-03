package com.cafeshopmanage.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel {

	private Integer id;

	private String name;

	private String price;
	
	private String category;

	private MultipartFile imageUpload;

	private String detail;
	
	private String pictureLink;
	
}