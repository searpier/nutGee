package com.nutgee.www.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.nutgee.www.board.vo.BoardVO;

@Mapper
public interface BoardDAO {

	public int insertBoard(BoardVO bvo);
	public int totalBoardCount();
	public List<BoardVO> selectAllBoard(RowBounds rb);
}
