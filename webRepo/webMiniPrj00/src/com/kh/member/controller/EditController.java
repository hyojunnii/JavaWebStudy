package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/edit")
public class EditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		MemberVo mvo = (MemberVo) req.getSession().getAttribute("loginMember");
		
		String id = mvo.getId();
		String name = mvo.getName();
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		String comment = req.getParameter("comment");
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setName(name);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setAddr(addr);
		vo.setComment(comment);
		
		int result = new MemberService().edit(vo);
		
		if(result == 1) {
			mvo.setEmail(email);
			mvo.setPhone(phone);
			mvo.setAddr(addr);
			mvo.setComment(comment);
			req.getSession().setAttribute("alertMsg", "정보수정 성공!");
			resp.sendRedirect("/webMiniPrj/member/mypage");
		} else {
			req.getSession().setAttribute("alertMsg", "정보수정 실패");
			resp.sendRedirect("/webMiniPrj/member/mypage");
		}
	}
}
