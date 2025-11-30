package com.scorebook.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.scorebook.exception.PasswordNotMatchException;
import com.scorebook.form.UserRegistrationForm;
import com.scorebook.service.UserAccountService;

@Controller
public class RegistrationController {

	private final UserAccountService userAccountService;
	
	public RegistrationController(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("registrationForm", new UserRegistrationForm());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid UserRegistrationForm registrationForm,
							   BindingResult result,
							   Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		
		try {
			userAccountService.regist(registrationForm);
		} catch(PasswordNotMatchException ex) {
			result.rejectValue("confirmPassword", "password.mismatch", ex.getMessage());
			return "register";
		}
		
		return "redirect:/login?registered";
	}
}
