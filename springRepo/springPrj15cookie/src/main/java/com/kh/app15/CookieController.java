package com.kh.app15;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cookie")
public class CookieController {
	
	/*
	 * 1. 쿠키는 서버가 만들어준다.
	 * 2. 쿠키는 클라이언트가 가지고 있다.
	 * 3. 클라이언트는 특정 URL에 접속할 때 , 해당 URL 에 맞는 쿠키를 들고 간다.
	 */
	
	@GetMapping("create")
	@ResponseBody
	public String cookie(HttpServletResponse resp) {
		
		Cookie c = new Cookie("k01", "v01");
		c.setMaxAge(60 * 60 * 24); //하루
		c.setPath("/");
		
		resp.addCookie(c);
		
		return "cookie !!!";
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String delete(HttpServletResponse resp) {
		Cookie c = new Cookie("k01", "v01");
		c.setMaxAge(0);
		c.setPath("/");
		
		resp.addCookie(c);
		
		return "cookie delete";
	}
	
	@GetMapping("check")
	public String check() {
		return "check";
	}
	
	@GetMapping("check2")
	@ResponseBody
	public String check2(@CookieValue Cookie k01) {
		System.out.println(k01);
		System.out.println(k01.getName());
		System.out.println(k01.getValue());
		System.out.println(k01.getMaxAge());
		System.out.println(k01.getPath());
		
		return "check cookie at controller";
		
	}
}//class
