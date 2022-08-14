package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/subway")
public class SubwayServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String birth = req.getParameter("birth");
		
		String yearStr = birth.substring(0,4);
		int year = Integer.parseInt(yearStr);
		
		int todayYear = LocalDate.now().getYear();
		
		int age = todayYear-year+1;
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		
		if(age >= 65) {
			pw.println("무료");
		} else if(age >= 20) {
			pw.println("1250원");
		} else if(age >= 14) {
			pw.println("720원");
		} else if(age >= 8) {
			pw.println("450원");
		} else {
			pw.println("무료");
		}
		
	}
	
}
