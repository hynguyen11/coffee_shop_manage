package com.cafeshopmanage.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import com.cafeshopmanage.entity.AppUser;
import com.cafeshopmanage.model.AppUserModel;
import com.cafeshopmanage.repository.AppUserRepository;
import com.cafeshopmanage.utils.AuditorAwareImpl;

public abstract class BaseController {

	private AuditorAwareImpl auditorAwareImpl = new AuditorAwareImpl();

	@Autowired
	AppUserRepository appUserRepo;

	public void initial(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (("anonymousUser").equals(auth.getPrincipal())) {
			AppUserModel user = new AppUserModel();
			model.addAttribute("userInfor", user);
			user.setRoleId(-1);
			return;
		}

		AppUser entity = appUserRepo.findUserAccount(auditorAwareImpl.getCurrentAuditor().get());
		if (entity == null) {
			return;
		}
		AppUserModel user = new AppUserModel();
		user.setUserId(entity.getUserId());
		user.setUserName(entity.getUserName());
		user.setRoleId(entity.getRoleId());
		model.addAttribute("userInfor", user);
	}
}
