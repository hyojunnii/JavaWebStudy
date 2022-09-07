package com.kh.app01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService s;
	
	@RequestMapping("/member/login")
	public String login() {
		System.out.println("로그인 호출!");
		int result = s.login();
		
		return "login";
	}
}
