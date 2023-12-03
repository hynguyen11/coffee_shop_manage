package com.cafeshopmanage.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderModel {

	private Integer id;

	private String product;

	private Date date;
	
	private String price;

	private String quantity;
	
	private String total;
	
}