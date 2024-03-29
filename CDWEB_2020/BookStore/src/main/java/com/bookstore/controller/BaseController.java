package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
	@RequestMapping(value = { "/login" })
	public String login(@RequestParam(value = "error", required = false) final String error, Model model) {
		if (error != null) {
			model.addAttribute("message", "Login Failed!");
		}
		return "home/login";
	}

	@RequestMapping("/logout")
	public String logout(final Model model) {
		model.addAttribute("message", "Logged out!");
		return "home/login";
	}

	@RequestMapping("/user")
	public String user() {
		return "home/index";
	}

}