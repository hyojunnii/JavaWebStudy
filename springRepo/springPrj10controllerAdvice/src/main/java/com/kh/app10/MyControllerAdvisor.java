package com.kh.app10;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(basePackages = "com.kh.app10")
//@ControllerAdvice(annotations = Controller.class)
@ControllerAdvice(annotations = KhAno.class)
public class MyControllerAdvisor {
	
	//컨트롤러 어드바이스 - 컨트롤러 예외처리

	@ExceptionHandler(Exception.class)
	public String m01(Exception e, HttpServletRequest req) {
		System.out.println("예외발생");
		return "error/e404";
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public String m02(Exception e) {
		System.out.println("나누기 0 불가");
		return "error/ae";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String m03(Exception e) {
		System.out.println("숫자를 가지고 파싱하세요");
		return "error/nfe";
	}
}
