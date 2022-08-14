package com.kh.plus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/plus")
public class PlusController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 처리
		int x = Integer.parseInt(req.getParameter("a"));
		int y = Integer.parseInt(req.getParameter("b"));
		
		//화면 작업
		PrintWriter out = resp.getWriter();
		out.println("<h1>");
		out.println(x + "," + y + "plus 결과 : " + (x+y) );
		out.println("</h1>");
	}

}//class






















