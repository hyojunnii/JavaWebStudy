package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/score")
public class ScoreServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int kor = Integer.parseInt(req.getParameter("kor"));
		int math = Integer.parseInt(req.getParameter("math"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		
		int score = (kor + math + eng) / 3;
		
		System.out.println(score);
		
		//화면에 result 보여주기
		resp.setContentType("text/html; charset=UTF-8");
//		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		
		pw.println("<h1>세 과목의 평균 : " + score + "</h1>");
		
	}
}
