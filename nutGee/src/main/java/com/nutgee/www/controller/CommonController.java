package com.nutgee.www.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nutgee.www.customer.vo.CustomerVO;

@Controller
public class CommonController {
	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}
	@RequestMapping("/signupForm")
	public String signup() throws Exception {
		return "signupForm";
	}
	@RequestMapping("/loginForm")
	public String loginForm() throws Exception {
		return "loginForm";
	}
	@RequestMapping("/blogList")
	public String blogList() throws Exception {
		return "blog";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.setAttribute("id", null);
		return "redirect:/";
	}
}
