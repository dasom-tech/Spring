package com.spring.biz.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	//리턴타입 ModelAndView -> String
	//전달하는 데이터 타입 ModelAndView -> Model
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println(">>> 글상세 - String getBoard()");
		BoardVO board = boardDAO.getBoard(vo);
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}	
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDAO boardDAO, Model model,
			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false)          
			String condition, 
			@RequestParam(value = "searchKeyword", defaultValue="", required=false)
			String keyword) {
		System.out.println(">>> 게시글 전체 목록- String getBoardList()");
		System.out.println("> condition : " + condition);
		System.out.println("> keyword : -" + keyword + "-");
		
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardDAO.getBoardList(condition, keyword);
		
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}	
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 입력 - insertBoard()");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}	
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 글수정 - updateBoard()");
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}	
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 글수정 - deleteBoard()");
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}	
}
