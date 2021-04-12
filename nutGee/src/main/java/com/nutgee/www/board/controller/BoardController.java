package com.nutgee.www.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nutgee.www.board.service.BoardService;
import com.nutgee.www.board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService bService;
	
	@RequestMapping("/regBoard")
	public String regBoard(@ModelAttribute("BoardVO") BoardVO bvo, ModelMap medel) throws Exception {
		bService.insertBoard(bvo);
		return "redirect:/blogList";
	}
}
