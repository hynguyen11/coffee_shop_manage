package com.cafeshopmanage.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeModel {

	private Integer id;

	private String fullname;

	private String position;
	
	private String email;
	
	private MultipartFile imageUpload;

	private String phonenumber;
	
	private String pictureLink;

}