package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트");
		vo.setWriter("테스터");
		vo.setContent("데스트중");
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		vo.setSeq(1);
		BoardVO vo2 = dao.getBoard(vo);
		System.out.println("vo2 : " + vo2);
		
		List<BoardVO> list = dao.getBoardList();
		for (BoardVO board : list) {
			System.out.println("board: " + board);
		}
		
		dao.updateBoard(vo2);
		vo2.setTitle("안부인사");
		vo2.setContent("잘 지내시죠?");
		System.out.println("vo2 : " + vo2);
		
		vo.setSeq(2);
		dao.deleteBoard(vo);
		
		for (BoardVO board : list) {
			System.out.println("board: " + board);
		}	
		

	}

}








