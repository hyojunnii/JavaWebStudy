package com.kh.app99.member.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app99.common.FileUploader;
import com.kh.app99.member.service.MemberService;
import com.kh.app99.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	private final MemberService ms;
	
	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
	}
	
	//회원가입
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo, HttpServletRequest req) {
		
		//파일 있는지
		if(vo.getProfile() != null && !vo.getProfile().isEmpty()) {
			//파일 업로드 후 저장된 파일명 얻기
			String savePath = req.getServletContext().getRealPath("/resources/upload/profile/");
			String changeName = FileUploader.fileUpload(vo.getProfile(), savePath);
			vo.setFileName(changeName);
		}
		
		int result = ms.insertMember(vo);
		
		if(result == 1) {
			return "redirect:/";
		} else {
			return "redirect:/errorPage";
		}
	}
	
	//로그인
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo vo, HttpSession session, Model model, String saveId, HttpServletResponse resp) {
		
		if(saveId != null) { 	//아이디 저장
			Cookie c = new Cookie("rid", vo.getId());
			resp.addCookie(c);
		}
		
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			return "redirect:/";
		} else {
			model.addAttribute("msg","로그인 실패..");
			return "common/error";
		}
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//마이페이지
	@GetMapping("mypage")
	public String mypage() {
		return "member/mypage";
	}
	
	@PostMapping("mypage")
	public String mypage(MemberVo vo, HttpServletRequest req, HttpSession session, Model model) {
		
		//파일 처리
		//기존파일 삭제
		String savePath = req.getServletContext().getRealPath("/resources/upload/profile/");
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		
		String fileName = loginMember.getFileName();
		File f = new File(savePath + fileName);
		if(f.exists()) {
			f.delete();
		}
		//신규로 받은 파일 업로드, 파일명 얻기
		if(!vo.getProfile().isEmpty()) {
			String changeName = FileUploader.fileUpload(vo.getProfile(), savePath);
			vo.setFileName(changeName);
		}
		
		vo.setNo(loginMember.getNo());
		
		MemberVo updatedMember = ms.edit(vo);
		
		if(updatedMember != null) {
			session.setAttribute("loginMember", updatedMember);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "정보수정실패");
			return "error/errorPage";
		}
	}
	
	//아이디 중복확인
	@PostMapping("dup")
	@ResponseBody
	public String dup(String memberId) {
		int result = ms.checkDup(memberId);
		return "" + result;
	}
	
	//회원목록조회
	@GetMapping("list")
	public String list(Model model) {
		
		List<MemberVo> voList = ms.selectList();
		
		model.addAttribute("voList", voList);
		
		return "member/list";
	}
	
}//class
