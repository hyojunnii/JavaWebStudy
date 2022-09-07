package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.common.EncryptorInter;
import com.kh.mybatis.common.MyEncryptor;
import com.kh.mybatis.member.service.MemberService;
import com.kh.mybatis.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/login")
public class MemberLoginController extends HttpServlet {
	
	/*
	 * public MemberLoginController(EncryptorInter x) { this.x = x; }
	 * 
	 * private EncryptorInter x;
	 */
	
	//로그인페이지
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	//로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		
		MemberVo loginMember = new MemberService().login(vo);
		
		if(loginMember != null) {
			System.out.println("로그인 성공");
			System.out.println(loginMember);
		} else {
			System.out.println("로그인 실패");
		}
	}
}
