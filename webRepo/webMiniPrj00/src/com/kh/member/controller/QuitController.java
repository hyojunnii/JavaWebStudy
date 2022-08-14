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
public class QuitController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVo mvo = (MemberVo) req.getSession().getAttribute("loginMember");
		
		String id = mvo.getId();
		String name = mvo.getName();
		
		int result = new MemberService().quit(id, name);
		
		if(result == 1) {
			req.getSession().invalidate();
			req.getSession().setAttribute("alertMsg", "탈퇴 성공!");
			resp.sendRedirect("/webMiniPrj/main");
		} else {
			req.getSession().setAttribute("alertMsg", "탈퇴 실패");
			resp.sendRedirect("/webMiniPrj/member/mypage");
		}
		
	}
}
