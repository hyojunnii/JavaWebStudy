package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.service.BoardService;
import com.kh.board.vo.BoardVo;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/board/insert")
public class BoardInsertController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	
		MemberVo mvo = (MemberVo) req.getSession().getAttribute("loginMember");
		
		String writer = mvo.getNick();
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVo bvo = new BoardVo();
		bvo.setCategory(category);
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		
		int result = new BoardService().insert(bvo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "게시글 작성 성공!");
			resp.sendRedirect("/webMiniPrj/main");
		} else {
			req.getSession().setAttribute("alertMsg", "게시글 작성 실패!");
			resp.sendRedirect("/webMiniPrj/main");
		}
		
	}
}
