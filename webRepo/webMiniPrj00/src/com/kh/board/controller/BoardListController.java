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

@WebServlet(urlPatterns = "/main")
public class BoardListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BoardVo> boardList = new BoardService().showlist();
		
		req.getSession().setAttribute("boardList", boardList);
		
		req.getRequestDispatcher("/views/main/mainpage.jsp").forward(req, resp);
	}
}
