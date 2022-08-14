package com.kh.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.service.BoardService;
import com.kh.board.vo.BoardVo;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/board/mylist")
public class BoardMyListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo mvo = (MemberVo) req.getSession().getAttribute("loginMember");
		
		String writer = mvo.getNick();
		
		List<BoardVo> boardList = new BoardService().myList(writer);
		
		req.getSession().setAttribute("boardList", boardList);
		
		req.getRequestDispatcher("/views/main/mainpage.jsp").forward(req, resp);
	}
}
