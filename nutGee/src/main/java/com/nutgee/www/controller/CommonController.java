package com.nutgee.www.controller;

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
}
