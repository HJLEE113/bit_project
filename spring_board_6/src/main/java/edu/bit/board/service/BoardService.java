package edu.bit.board.service;

import java.util.List;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getList();

	public void writeBoard(BoardVO boardVO);

	public BoardVO viewContent(BoardVO boardVO);

	public void modify(BoardVO boardVO);

	public void delete(BoardVO boardVO);

	public void replyBoard(BoardVO boardVO);

	public void hitUpdate(BoardVO boardVO);

	public void replyShape(BoardVO boardVO);
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}