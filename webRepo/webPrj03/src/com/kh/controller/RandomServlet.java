package com.kh.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/random")
public class RandomServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		Random random = new Random();
//		int num = random.nextInt(6) + 1;
		
		int random = (int)(Math.random() * 6) + 1;
		
		System.out.println(random);
		
	}
	
}
