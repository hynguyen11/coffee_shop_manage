package com.cafeshopmanage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.cafeshopmanage.common.base.BaseController;
import com.cafeshopmanage.model.AppUserModel;
import com.cafeshopmanage.model.EmployeeModel;
import com.cafeshopmanage.model.OrderModel;
import com.cafeshopmanage.model.ProductModel;
import com.cafeshopmanage.service.CategoryService;
import com.cafeshopmanage.service.EmployeeService;
import com.cafeshopmanage.service.OrderService;
import com.cafeshopmanage.service.PositionService;
import com.cafeshopmanage.service.ProductService;
import com.cafeshopmanage.service.UserService;


@Controller
public class AdminController extends BaseController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PositionService positionService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "/admin/index";
	}
	
	@RequestMapping(value = { "/menu" }, method = RequestMethod.GET)
	public String listProduct(Model model) {
		initial(model);
		model.addAttribute("productList", productService.getProductList());
		model.addAttribute("categoryList", categoryService.getAllCategory());
		model.addAttribute("productForm", new ProductModel());
		return "admin/menu";
	}
	
	@RequestMapping(value = { "/searchCategory/{id}" }, method = RequestMethod.GET)
	public String searchCategory(Model model, @PathVariable String id) {
		initial(model);
		model.addAttribute("categoryList", categoryService.getAllCategory());
		model.addAttribute("productList", productService.getProductByCategory(id));
		model.addAttribute("productForm", new ProductModel());
		return "admin/menu";
	}

	@RequestMapping(value = { "/menu-add" }, method = RequestMethod.GET)
	public String createProduct(Model model, @ModelAttribute("productForm") ProductModel productForm) {
		initial(model);
		if (productForm.getId() != null) {
			productForm = productService.getProduct(productForm.getId());
		}
		model.addAttribute("productForm", productForm);
		return "/admin/menu";
	}
	
	@RequestMapping(value = { "/menu-add" }, method = RequestMethod.POST)
	public RedirectView createProductPost(Model model,@ModelAttribute("productForm") ProductModel productForm,
			@RequestParam(value = "action", required = true) String action) {
		initial(model);
		if ("save".equals(action)) {
			productService.createUpdateProduct(productForm);
			return new RedirectView(request.getContextPath() + "/menu");
		}
		return new RedirectView(request.getContextPath() + "/menu");
	}
	
	
	@RequestMapping(value = { "/menu-update" }, method = RequestMethod.GET)
	public void updateProduct(Model model, @ModelAttribute("productForm") ProductModel productForm) {
		initial(model);
		if (productForm.getId() != null) {
			productForm = productService.getProduct(productForm.getId());
		}
		model.addAttribute("productForm", productForm);
	}
	
	@RequestMapping(value = { "/menu-delete" }, method = RequestMethod.POST)
	public RedirectView deleteProduct(Model model, @ModelAttribute("productFormDelete") ProductModel productForm) {
		initial(model);
		productService.deleteProduct(productForm);
		return new RedirectView(request.getContextPath() + "/menu");
	}

	@RequestMapping(value = { "/employee" }, method = RequestMethod.GET)
	public String listEmployee(Model model) {
		initial(model);
		model.addAttribute("employeeList", employeeService.getEmployeeList());
		model.addAttribute("positionList", positionService.getAllPosition());
		model.addAttribute("employeeForm", new EmployeeModel());
		return "/admin/employee";
	}
	
	@RequestMapping(value = { "/employee-delete" }, method = RequestMethod.POST)
	public RedirectView deleteEmployee(Model model, @ModelAttribute("employeeFormDelete") EmployeeModel employeeModel) {
		initial(model);
		employeeService.deleteEmployee(employeeModel);
		return new RedirectView(request.getContextPath() + "/employee");
	}
	
	@RequestMapping(value = { "/employee-add" }, method = RequestMethod.GET)
	public String createEmployee(Model model, @ModelAttribute("employeeForm") EmployeeModel employeeModel) {
		initial(model);
		if (employeeModel.getId() != null) {
			employeeModel = employeeService.getEmployee(employeeModel.getId());
		}
		model.addAttribute("employeeForm", employeeModel);
		return "admin/employee";
	}
	
	@RequestMapping(value = { "/employee-add" }, method = RequestMethod.POST)
	public RedirectView createEmployeePost(Model model, @ModelAttribute("employeeForm") EmployeeModel employeeForm,
			@RequestParam(value = "action", required = true) String action) {
		initial(model);
		if ("save".equals(action)) {
			employeeService.createUpdateEmployee(employeeForm);
			return new RedirectView(request.getContextPath() + "/employee");
		} else {
			return new RedirectView(request.getContextPath() + "/employee");
		}
	}
	
	

	@RequestMapping(value = { "/order" }, method = RequestMethod.GET)
	public String listOrder(Model model) {
		initial(model);
		model.addAttribute("orderList", orderService.getOrderList());
		model.addAttribute("orderForm", new OrderModel());
		return "/admin/order";
	}
	
	@RequestMapping(value = { "/user" }, method = RequestMethod.GET)
	public String listUser(Model model) {
		initial(model);
		model.addAttribute("userList", userService.getUsers());
		model.addAttribute("userForm", new AppUserModel());
		return "/admin/user";
	}
	
	@RequestMapping(value = { "/user-delete" }, method = RequestMethod.POST)
	public RedirectView deleteUser(Model model, @ModelAttribute("userFormDelete") AppUserModel userForm) {
		initial(model);
		userService.deleteUser(userForm);
		return new RedirectView(request.getContextPath() + "/user");
	}
}
