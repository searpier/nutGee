package com.nutgee.www.customer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nutgee.www.customer.service.CustomerService;
import com.nutgee.www.customer.vo.CustomerVO;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/signup")
	public String singup(@ModelAttribute("CustomerVO") CustomerVO cvo, String birthdayMonth, String birthdayDay,
			ModelMap medel) throws Exception {
		cvo.setBirthDate(birthdayMonth + "-" + birthdayDay);
		System.out.println(cvo);
		int result = customerService.signupCustomer(cvo);
		medel.addAttribute("result", result);
		return "redirect:/";
	}

	@RequestMapping("/login")
	public String selectCustomer(@ModelAttribute("CustomerVO") CustomerVO cvo,HttpSession session, ModelMap medel)
			throws Exception {
		CustomerVO result = customerService.selectCustomer(cvo);
		if(result!=null) {
			session.setAttribute("id", result.getId());
		}
		return "redirect:/";
	}
}
