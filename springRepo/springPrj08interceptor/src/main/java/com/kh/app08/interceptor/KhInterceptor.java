package com.kh.app08.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//인터셉터로 만들기
//1. 클래스 상속 2. 인터페이스 상속

//preHandle
//public class KhInterceptor extends HandlerInterceptorAdapter{
public class KhInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle 호출 ~");
		System.out.println(handler);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandle 메소드 호출 ~");
		System.out.println(handler);
		System.out.println(modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion 메소드 호출 ~");
		System.out.println(ex);
	}
	
	//필터 : 요청 발생시 동작
	//	- 서블릿 요청 전에 동작
	//인터셉터 : 요청 발생시 동작하지만 어떤 요청은 제외 가능
	//	- 서블릿 요청 중간(3가지 경우)에 동작
	//	- 모니터링, 필터와 비슷한 역할(좀 더 좋은 기능 가짐 - 특정 경로 제외, 시점이 조금 더 다양함)
	
}
