package com.scorebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ログインページの表示
 */
@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String errorMessage = null;
		if(session != null) {
			Exception ex = (Exception)session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			if(ex != null) {
				errorMessage = ex.getMessage();
			}
		}
		model.addAttribute("loginError", errorMessage);
		return "login";
	}
}
