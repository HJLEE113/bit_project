package edu.bit.board.mapper;

import java.util.List;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardMapper {

	public List<BoardVO> getList();

	public void insert(BoardVO boardVO);

	public BoardVO view(BoardVO boardVO);

	public void modify(BoardVO boardVO);

	public void delete(BoardVO boardVO);

	public void reply(BoardVO boardVO);

	public void hitUpdate(BoardVO boardVO);

	public void replyShape(BoardVO boardVO);

	public List<BoardVO> getPaging(Criteria cri);

	public int getTotalCnt(Criteria cri);

}