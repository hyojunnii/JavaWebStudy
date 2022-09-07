package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.service.BoardService;
import com.kh.mybatis.board.vo.BoardVo;
import com.kh.mybatis.common.PageVo;
import com.kh.mybatis.common.Pagination;

@WebServlet(urlPatterns = "/board/list")
public class BoardListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String keyword = req.getParameter("keyword");
		String condition = req.getParameter("condition");
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", keyword);
		map.put("condition", condition);
		
		//페이징처리
		int listCount = new BoardService().selectListCount(map);
		int currentPage = Integer.parseInt(req.getParameter("p"));
		int pageLimit = 5;
		int boardLimit = 5;
		
		PageVo pvo = Pagination.getPageVo(listCount, currentPage, pageLimit, boardLimit);
		
		List<BoardVo> list = new BoardService().selectList(pvo, map);
		
		req.setAttribute("pvo", pvo);
		req.setAttribute("list", list);
		req.setAttribute("condition", condition);
		req.setAttribute("keyword", keyword);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
	}
}
