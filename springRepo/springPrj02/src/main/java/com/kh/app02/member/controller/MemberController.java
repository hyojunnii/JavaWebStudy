package com.kh.app02.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.app02.member.service.MemberService;
import com.kh.app02.member.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService s;

	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberVo vo) {
		int result = s.join(vo);
		
		if(result == 1) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		return "member/join";
	}
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVo vo, Model model) {
		MemberVo loginMember = s.login(vo);
		
		if(loginMember != null) {
			System.out.println("로그인 성공");
			//req.setAttribute("msg","로그인 성공!!");
			model.addAttribute("msg", "로그인 성공!!");
			return "member/success";
		} else {
			System.out.println("로그인 실패");
		}
		return "redirect:/";
	}
	
	
	//회원정보 조회
	
	//회원정보 수정
	
	//회원탈퇴
	
}//class
