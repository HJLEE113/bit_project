package edu.bit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageVO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class BoardController {
	
	private BoardService boardService;

	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("list");
		log.info(cri);
		model.addAttribute("list", boardService.getList());
		int total = boardService.getTotalCount(cri);
		log.info(total);
		
		model.addAttribute("pageMaker",new PageVO(cri,total));
	
	}
	
	@GetMapping("/write_view")
	public void writeView(Model model) {
		log.info("writeView");
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write");
		boardService.writeBoard(boardVO);
		return "redirect:list";
	}
	
	@GetMapping("/content_view")
	public void contentView(BoardVO boardVO,Model model) {
		log.info("contentView");
		boardService.hitUpdate(boardVO);
		model.addAttribute("content_view", boardService.viewContent(boardVO));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, Model model) {
		log.info("modify");
		boardService.modify(boardVO);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO, Model model) {
		log.info("delete");
		boardService.delete(boardVO);
		return "redirect:list";
	}
	
	@GetMapping("/reply_view")
	public void replyView(BoardVO boardVO,Model model) {
		log.info("replyView");
		model.addAttribute("reply_view", boardService.viewContent(boardVO));
	}
	
	@PostMapping("/reply")
	public String reply(BoardVO boardVO, Model model) {
		log.info("reply");
		boardService.replyShape(boardVO);
		boardService.replyBoard(boardVO);
		return "redirect:list";
	}
}