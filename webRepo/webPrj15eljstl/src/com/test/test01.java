package com.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test01")
public class test01 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//request 데이터 담기
		req.setAttribute("data", "안녕(리퀘스트)");
		
		//session 데이터 담기
		req.getSession().setAttribute("data", "잘가(세션)");
		
		//어플리케이션(==서블릿컨텍스트) 영역에 담기
		req.getServletContext().setAttribute("data", "반가워요(어플리케이션)");
		
		//리퀘스트에 데이터 담기 (배열)
		String[] arr = {"사과", "딸기", "포도"};
		req.setAttribute("fruits", arr);
		
		//리퀘스트에 데이터 담기 (맵)
		Map<String, String> m = new HashMap<String, String>();
		m.put("first", "apple");
		m.put("second", "grape");
		m.put("third", "orange");
		req.setAttribute("fruitsMap", m);
		
		//리퀘스트에 데이터 담기 (객체)
		MemberVo vo = new MemberVo();
		vo.setMemberId("user01");
		vo.setMemberPwd("1234");
		vo.setMemberNick("nick01");
		req.setAttribute("member", vo);
		
		req.setAttribute("age", 20);
		
		
		req.getRequestDispatcher("/views/view01.jsp").forward(req, resp);
	}
}
