package com.scorebook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



/**
 * トップページ
 */
@Controller
public class TopController {

	@GetMapping("/")
	public String top(org.springframework.ui.Model model,HttpSession session) {
		return "index";
	}
}
