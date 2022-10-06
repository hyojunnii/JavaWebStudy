package com.kh.app99.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app99.board.service.BoardService;
import com.kh.app99.board.vo.BoardVo;
import com.kh.app99.member.vo.MemberVo;

@Controller
@RequestMapping("board")
public class BoardController {
	
	private final BoardService bs;
	
	@Autowired
	public BoardController(BoardService bs) {
		this.bs = bs;
	}
	
	//목록조회
	@GetMapping("list")
	public String list(Model model) {
		List<BoardVo> voList = bs.selectList();
		
		model.addAttribute("voList", voList);
		return "board/list";
	}
	
	//게시글작성
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("write")
	public String write(BoardVo vo, Model model, HttpSession session) {
		
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		vo.setWriter(loginMember.getNo());
		
		int result = bs.write(vo);
		
		if(result == 1) {
			session.setAttribute("alertMsg", "게시글 작성 성공!");
			return "redirect:/board/list";
		} else {
			model.addAttribute("msg", "게시글 작성 실패..");
			return "error/errorPage";
		}
	}
	
	//게시글상세조회 + 조회수증가
	@GetMapping(value = {"detail/{no}", "detail"})
	public String detail(@PathVariable(required=false) String no, Model model) {
		
		BoardVo vo = bs.selectOne(no);
		
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	
	//수정하기
	@GetMapping("edit/{no}")
	public String edit(@PathVariable String no, Model model) {
		BoardVo vo = bs.selectOne(no);
		
		model.addAttribute("vo", vo);
		return "board/edit";
	}
	
}
