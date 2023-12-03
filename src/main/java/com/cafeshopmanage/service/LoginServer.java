package com.cafeshopmanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeshopmanage.entity.AppUser;
import com.cafeshopmanage.model.AppUserModel;
import com.cafeshopmanage.repository.AppUserRepository;
import com.cafeshopmanage.utils.EncrytedPasswordUtils;
import com.cafeshopmanage.utils.MapperUtils;

@Service
public class LoginServer {
	
	@Autowired
	AppUserRepository appUserRepository;

	public boolean checkPassword(String rePassword, String password) {
		if (rePassword != null && password != null && password.equals(rePassword)) {
			return true;
		}
		return false;
	}

	public boolean checkUserName(String userName) {
		AppUser appUser = appUserRepository.findUserAccount(userName);
		if (appUser != null) {
			return false;
		}
		return true;
	}

	public void createUser(AppUserModel appUserModel) {
		AppUser appUser = new AppUser();
		MapperUtils.map(appUserModel, appUser);
		appUser.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword(appUserModel.getRePassword()));
		appUser.setRoleId(2);
		appUserRepository.save(appUser);
	}
}
