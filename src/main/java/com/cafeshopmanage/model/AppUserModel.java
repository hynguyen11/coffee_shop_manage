package com.cafeshopmanage.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserModel {
	private Long userId;

	private String userName;

	private String encrytedPassword;
	
	private String rePassword;

	private String phoneNumber;
	
	private String address;
	
    private Integer roleId;
}
