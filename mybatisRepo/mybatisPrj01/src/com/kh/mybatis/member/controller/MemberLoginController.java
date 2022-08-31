package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.service.MemberService;
import com.kh.mybatis.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/login")
public class MemberLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		
		MemberVo loginMember = new MemberService().login(vo);
		
		if(loginMember != null) {
			System.out.println("로그인 성공");
			System.out.println(loginMember);
		} else {
			System.out.println("로그인 실패");
		}
	}
}
