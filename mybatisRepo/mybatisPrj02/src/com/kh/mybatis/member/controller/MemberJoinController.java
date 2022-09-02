package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.common.EncryptorInter;
import com.kh.mybatis.member.service.MemberService;
import com.kh.mybatis.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/join")
public class MemberJoinController extends HttpServlet {
	
	public void MemberLoginController(EncryptorInter x) {
		this.x = x;
	}
	
	private EncryptorInter x;
	
	//회원가입페이지
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//회원가입
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNick(nick);
		
		int result = new MemberService(x).join(vo);
		
		if(result == 1) {
			resp.sendRedirect("/my02");
		} else {
			System.out.println("회원가입 실패");
		}
	}
}
