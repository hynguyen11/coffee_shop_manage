package com.cafeshopmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafeshopmanage.common.base.BaseController;
import com.cafeshopmanage.model.AppUserModel;
import com.cafeshopmanage.model.OrderModel;
import com.cafeshopmanage.model.ProductModel;
import com.cafeshopmanage.service.CategoryService;
import com.cafeshopmanage.service.OrderService;
import com.cafeshopmanage.service.ProductService;
import com.cafeshopmanage.service.UserService;

@Controller
public class IndexController extends BaseController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@Autowired
	UserService userService;

	@Autowired
	AdminController adminController;

	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String indexPage(Model model) {
		initial(model);
		if (((AppUserModel) model.getAttribute("userInfor")).getRoleId() == 1) {
			if (((AppUserModel) model.getAttribute("userInfor")).getUserId() != null) {
				AppUserModel appUserModel = userService
						.getUser(((AppUserModel) model.getAttribute("userInfor")).getUserId());
				model.addAttribute("userForm", appUserModel);
				return adminController.adminPage(model);
			}
		}
		model.addAttribute("productList", productService.getProductList());
		model.addAttribute("categoryList", categoryService.getAllCategory());
		model.addAttribute("productForm", new ProductModel());
		return "/index/index";
	}
	@RequestMapping(value = { "/indexCategory/{id}" }, method = RequestMethod.GET)
	public String searchCategory(Model model, @PathVariable String id) {
		initial(model);
		model.addAttribute("categoryList", categoryService.getAllCategory());
		model.addAttribute("indexList", productService.getProductByCategory(id));
		model.addAttribute("indexForm", new ProductModel());
		return "index/index";
	}
	
	@RequestMapping(value = { "/index-order" }, method = RequestMethod.POST)
	public String OrderPost(Model model,@ModelAttribute("orderForm") OrderModel orderForm,
			@RequestParam(value = "action", required = true) String action) {
		initial(model);
		if ("save".equals(action)) {
			orderService.createUpdateOrder(orderForm);
			return "index/index";
		}
		return "index/index";
	}

}
