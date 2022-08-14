package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/join")
public class JoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String pwd2 = req.getParameter("pwd2");
		String name = req.getParameter("name");
		String nick = req.getParameter("nick");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		String comment = req.getParameter("comment");
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setPwd2(pwd2);
		vo.setName(name);
		vo.setNick(nick);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setAddr(addr);
		vo.setComment(comment);
		
		int result = new MemberService().join(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "회원가입 성공!");
			resp.sendRedirect("/webMiniPrj");
		} else {
			req.getSession().setAttribute("alertMsg", "회원가입 실패");
			resp.sendRedirect("/webMiniPrj");
		}
		
	}
}
