package com.kh.app04.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app04.member.service.MemberService;
import com.kh.app04.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	//회원가입화면
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	//회원가입
	@PostMapping("member/join")
	public String join(MemberVo vo) {
		
		int result = ms.join(vo);
		
		if(result == 1) {
			return "redirect:/";
		} else {
			return "error/errorPage";
		}
	}
	
	//로그인화면
	@GetMapping("member/login")
	public String login() {
		return "member/login";
	}
	
	//로그인
	@PostMapping("/member/login")
	public String login(MemberVo vo, HttpSession session) {
		
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			System.out.println(loginMember);
			return "redirect:/";
		} else {
			session.setAttribute("msg", "로그인 실패..");
			return "redirect:/error-page.jsp";
		}
	}
}
