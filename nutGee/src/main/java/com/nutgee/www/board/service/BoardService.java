package com.nutgee.www.board.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutgee.www.board.dao.BoardDAO;
import com.nutgee.www.board.vo.BoardVO;
import com.nutgee.www.utils.PageNavigator;

@Service
public class BoardService {

	@Autowired
	BoardDAO bdao;
	private final static int countPerPage = 10;
	private final static int pagePerGroup = 5;

	public int insertBoard(BoardVO bvo) {
		return bdao.insertBoard(bvo);
	}

	public List<BoardVO> selectAllBoard(int currentPage) {
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, bdao.totalBoardCount());
		// PageNavigator navi = new PageNavigator();
		// select를 해올때 몇번부터 몇번까지 가져와라 하는 mybatis API
		RowBounds rb = new RowBounds(navi.getStartRecord(), navi.getCountPerPage());
		List<BoardVO> result = bdao.selectAllBoard(rb);
		return result;
	}
}
