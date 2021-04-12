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

	/* 메인화면이동 */
	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}

	/* 회원가입폼이동 */
	@RequestMapping("/signupForm")
	public String signup() throws Exception {
		return "signupForm";
	}

	/* 로그인폼이동 */
	@RequestMapping("/loginForm")
	public String loginForm() throws Exception {
		return "loginForm";
	}

	/* 블로그리스트이동 */
	@RequestMapping("/blogList")
	public String blogList() throws Exception {
		return "blog";
	}

	/* 게시판리스트이동 */
	@RequestMapping("/boardList")
	public String boardList() throws Exception {
		return "board";
	}

	/* 게시판글쓰기이동 */
	@RequestMapping("/boardForm")
	public String boardForm() throws Exception {
		return "boardForm";
	}

	/* 로그아웃 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.setAttribute("id", null);
		return "redirect:/";
	}
}
