package com.kh.app01.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board") //공통 url
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	/**
	 * 글 작성 화면
	 */
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "board/write";
		// /WEB-INF/views/ + board/write + .jsp
	}
	
	/**
	 * 글 작성 진행
	 * @param 데이터 가져오는법 : 
	 * 1. getParameter(req파라미터 필요) == Servlet
	 * 2. Parameter에 @RequestParam(생략o) name
	 * 3. Parameter에 vo객체
	 */
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVo vo) {
		System.out.println("board 컨트롤러 호출됨..");
		
		System.out.println(vo);
		int result = service.write();
		return "board/write";
	}
	
	/**
	 * 게시글 목록 조회
	 */
	
}
