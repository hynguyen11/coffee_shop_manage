package com.cafeshopmanage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.cafeshopmanage.model.AppUserModel;
import com.cafeshopmanage.repository.AppUserRepository;
import com.cafeshopmanage.service.LoginServer;

@Controller
public class LoginController {

	@Autowired
	AppUserRepository appUserRepository;

	@Autowired
	LoginServer loginServer;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginPage(Model model, @ModelAttribute("appUser") AppUserModel appUserModel) {
		return "/login/login";
	}

	@RequestMapping(value = { "/login/signin" }, method = RequestMethod.POST)
	public RedirectView signinPage(Model model, @ModelAttribute("appUser") AppUserModel appUserModel) {
		String rePassword = appUserModel.getRePassword();
		String password = appUserModel.getEncrytedPassword();
		if (loginServer.checkPassword(rePassword, password)) {
			if (loginServer.checkUserName(appUserModel.getUserName())) {
				loginServer.createUser(appUserModel);
				return new RedirectView(request.getContextPath() + "/login?signin=true");
			}
		}
		return new RedirectView(request.getContextPath() + "/login?signin=false");
	}
}
