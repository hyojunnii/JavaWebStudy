package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		
		MemberVo loginMember = new MemberService().login(vo);
		
		if(loginMember != null) {
			req.getSession().setAttribute("loginMember", loginMember);
			resp.sendRedirect("/webMiniPrj");
		} else {
			req.getSession().setAttribute("alertMsg", "존재하지 않는 회원입니다.");
			resp.sendRedirect("/webMiniPrj");
		}
	
	}
}
