package com.rentcar.controller;

import com.rentcar.model.SignupForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.rentcar.service.CustomerService;
import com.rentcar.service.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	@Autowired
	CustomerService customerService;

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String performLogin(
			@RequestParam String username,
			@RequestParam String password,
			Model model) {

		// 这里应该有一些身份验证的逻辑，你需要使用userService去校验用户的用户名和密码
		boolean isAuthenticated = userService.authenticate(username, password);

		if (isAuthenticated) {
			// 登录成功，根据你的需要重定向到相应的页面
			return "redirect:/home";
		} else {
			// 登录失败，返回到登录页面并显示错误消息
			model.addAttribute("loginError", "Invalid username or password");
			return "login";
		}
	}
	@RequestMapping(value = "sign-up",method = RequestMethod.GET)
	public String showSignUpForm(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "customerSignUp";
	}

	@RequestMapping(value = "sign-up",method = RequestMethod.POST)
	public String customerSignUpPagePost(@Valid @ModelAttribute SignupForm signupForm, BindingResult result
			, RedirectAttributes redirectAttrs) {
		// 检查Username和DrivingLicenseNo是否唯一
		if (userService.isUsernameExists(signupForm.getUsername())) {
			result.rejectValue("username", "error.username", "An account already exists for this username.");
		}

		if (customerService.isDrivingLicenseNoExists(signupForm.getDrivingLicenseNo())) {
			result.rejectValue("drivingLicenseNo", "error.drivingLicenseNo", "A customer with this driving license number already exists.");
		}
		// 检查是否有验证错误
		if (result.hasErrors()) {
			// 如果有错误，返回到注册表单，并显示错误信息
			return "customerSignUp";
		}
		int customer_id = customerService.addCustomerDetail(signupForm.getFirstname(), signupForm.getLastname(), signupForm.getPhoneNo(), signupForm.getGender(), signupForm.getDrivingLicenseNo());
		userService.addUserDetails(customer_id, signupForm.getUsername(), signupForm.getPassword());
		// 添加一个flash attribute，在重定向后依然可以使用，通常用于成功操作的消息。
		redirectAttrs.addFlashAttribute("registerSuccess", true);
		return "redirect:/login";
	}
}
