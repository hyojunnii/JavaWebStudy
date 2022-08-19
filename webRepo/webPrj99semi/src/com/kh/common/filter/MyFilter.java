package com.kh.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter{
	
	//필터 생성될 때 최초 한번 호출되는 메소드
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		System.out.println("필터 init called..");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			System.out.println("필터 접근함");
		
			request.setCharacterEncoding("UTF-8");
			
			//필터 통과시킴
			chain.doFilter(request, response);
	}
	
	//필터 파괴(톰캣종료)될 때 호출되는 메소드
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
		System.out.println("필터 파괴됨..");
	}

}

//관리자 페이지 접속 필터
//@WebFilter(urlPatterns = "/admin/*")
//public class MyFilter implements Filter{
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//			
//			//필터에서 세션 가져오는 방법
//			result = ((HttpServletRequest)request).getSession().getAttribute("loginMember").권한 == 관리자;
//			if(result) {
//				chain.doFilter(request, response);
//			} else {
//				request.getRequestDispatcher("에러페이지").forward(request, response);
//			}
//	}
//}
