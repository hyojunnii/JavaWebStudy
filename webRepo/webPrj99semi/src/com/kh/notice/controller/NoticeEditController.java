package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.service.NoticeService;
import com.kh.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/edit")
public class NoticeEditController extends HttpServlet{
	
	//공지사항 수정 화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		NoticeVo vo = new NoticeService().selectOne(num);
		
		if(vo != null) {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/notice/noticeEdit.jsp").forward(req, resp);
		} else {
			req.setAttribute("errorMsg", "공지사항 수정 중 에러 발생!");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
	}
	
	//공지사항 수정하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String num = req.getParameter("num");
		
		NoticeVo vo = new NoticeVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(num);
		
		int result = new NoticeService().edit(vo);
		
		if(result == 1) {
			resp.sendRedirect(req.getContextPath() + "/notice/detail?num=" + num);
		} else {
			req.setAttribute("errorMsg", "공지사항 수정 실패");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
	}
}
