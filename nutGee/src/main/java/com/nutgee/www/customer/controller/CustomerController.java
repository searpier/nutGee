package com.nutgee.www.customer.controller;

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
	public @ResponseBody CustomerVO selectCustomer(@ModelAttribute("CustomerVO") CustomerVO cvo, ModelMap medel)
			throws Exception {
		cvo.setId("searpier");
		cvo.setPwd("searpier");
		CustomerVO result = customerService.selectCustomer(cvo);
		return result;
	}
}
