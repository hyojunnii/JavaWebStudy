package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String temp = req.getParameter("name");
		System.out.println(temp);
		
		//response 통해 응답
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("div{background-color:red}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>" + temp + "</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
 