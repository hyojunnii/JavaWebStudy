package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class TestServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서비스 메소드 호출됨 ..");
		
		String name = req.getParameter("name");
		
		resp.getWriter().println("<!DOCTYPE HTML>");
		resp.getWriter().println("<html>");
		resp.getWriter().println("<head>");
		resp.getWriter().println("</head>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>hello</h1>");
		resp.getWriter().println(name);
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
	
}//class
