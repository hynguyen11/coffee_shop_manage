package com.cafeshopmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeshopmanage.entity.AppUser;
import com.cafeshopmanage.model.AppUserModel;
import com.cafeshopmanage.repository.AppUserRepository;
import com.cafeshopmanage.utils.MapperUtils;

@Service
public class UserService {

	@Autowired
	AppUserRepository appUserRepository;

	public List<AppUserModel> getUsers() {
		List<AppUserModel> listAppUserModel = new ArrayList<>();
		List<AppUser> listAppUser = appUserRepository.findAll();
		for (AppUser appUser : listAppUser) {
			AppUserModel model = new AppUserModel();
			MapperUtils.map(appUser, model);
			listAppUserModel.add(model);
		}
		return listAppUserModel;
	}
	
	public void deleteUser(AppUserModel userForm) {
		appUserRepository.deleteById(userForm.getUserId());
    }
	
	public AppUserModel getUser(Long id) {
		Optional<AppUser> appUser = appUserRepository.findById(id);
		if (appUser.isPresent()) {
			AppUserModel model = new AppUserModel();
			MapperUtils.map(appUser.get(), model);
			return model;
		}
		return new AppUserModel();
	}
}
