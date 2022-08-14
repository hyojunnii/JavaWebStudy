package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/quit")
public class MemberQuitController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberVo vo = (MemberVo)req.getSession().getAttribute("loginMember");
		
		int quitVo = new MemberService().quit(vo);
		
		if(quitVo == 1) {
			req.getSession().invalidate();
			req.getSession().setAttribute("alertMsg", "회원 탈퇴 성공!");
			resp.sendRedirect("/semi");
		} else {
			req.getSession().setAttribute("alertMsg", "회원 탈퇴 실패!");
			resp.sendRedirect("/semi");
		}
	}
}
