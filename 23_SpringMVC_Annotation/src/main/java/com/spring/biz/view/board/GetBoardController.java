package com.spring.biz.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController{

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println(">>> 게시글 상세페이지-getBoard()");
		
		BoardVO board = boardDAO.getBoard(vo);
		mav.addObject("board", board); //뷰에서 사용할 데이터 저장
		mav.setViewName("getBoard.jsp"); //뷰리졸버 사용안함
		
		return mav;
	}

}
