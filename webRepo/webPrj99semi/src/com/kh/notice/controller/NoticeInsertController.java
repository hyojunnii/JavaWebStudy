package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.service.NoticeService;
import com.kh.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/insert")
public class NoticeInsertController extends HttpServlet{
	
	//공지사항 작성 페이지 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/notice/noticeInsertForm.jsp").forward(req, resp);
	}
	
	//공지사항 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String no = req.getParameter("writerNo");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeVo vo = new NoticeVo();
		vo.setWriter(no);
		vo.setTitle(title);
		vo.setContent(content);
		
		int result = new NoticeService().insertNotice(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "공지사항 작성 완료!");
			resp.sendRedirect("/semi/notice/list");
		} else {
			req.setAttribute("errorMsg", "공지사항 작성 실패");
			RequestDispatcher x = req.getRequestDispatcher("/views/error/errorPage.jsp");
			x.forward(req, resp);
		}
		
	}
	
}
