package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public void writeBoard(BoardVO boardVO) {
		mapper.insert(boardVO);
	}

	@Override
	public BoardVO viewContent(BoardVO boardVO) {		
		return mapper.view(boardVO);
	}

	@Override
	public void modify(BoardVO boardVO) {
		mapper.modify(boardVO);
	}

	@Override
	public void delete(BoardVO boardVO) {
		mapper.delete(boardVO);
	}

	@Override
	public void replyBoard(BoardVO boardVO) {
		mapper.reply(boardVO);
	}

	@Override
	public void hitUpdate(BoardVO boardVO) {
		mapper.hitUpdate(boardVO);
	}

	@Override
	public void replyShape(BoardVO boardVO) {
		mapper.replyShape(boardVO);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		return mapper.getPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		
		return mapper.getTotalCnt(cri);
	}

}
