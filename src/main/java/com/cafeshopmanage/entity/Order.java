package com.cafeshopmanage.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orderapp")
public class Order {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "product")
	private String product;
	
	@Column(name = "date")
	private Date date;

	@Column(name = "price")
	private String price;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "total")
	private String total;

}
