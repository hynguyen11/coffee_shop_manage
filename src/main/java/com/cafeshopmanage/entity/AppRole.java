package com.cafeshopmanage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "App_Role", //
		uniqueConstraints = { //
				@UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name") })
@Getter
@Setter
public class AppRole {

	@Id
	@GeneratedValue
	@Column(name = "Role_Id", nullable = false)
	private Long roleId;

	@Column(name = "Role_Name", length = 30, nullable = false)
	private String roleName;
}