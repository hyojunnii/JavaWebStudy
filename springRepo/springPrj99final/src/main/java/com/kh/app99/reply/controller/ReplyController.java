package com.kh.app99.reply.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app99.member.vo.MemberVo;
import com.kh.app99.reply.service.ReplyService;
import com.kh.app99.reply.vo.ReplyVo;

@Controller
@RequestMapping("reply")
public class ReplyController {
	
	private final ReplyService rs;

	@Autowired
	public ReplyController(ReplyService rs) {
		this.rs = rs;
	}
	
	@PostMapping("write")
	@ResponseBody
	public String write(ReplyVo vo, HttpSession session) {
		
		System.out.println(vo);
		
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		vo.setWriter(loginMember.getNo());
		
		int result = rs.write(vo);
		
		//결과 응답
		if(result == 1) {
			return "ok";
		} else {
			return "fail";
		}
	}
	
}//class
