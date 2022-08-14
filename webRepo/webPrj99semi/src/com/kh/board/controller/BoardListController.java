package com.kh.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.service.BoardService;
import com.kh.board.vo.BoardVo;
import com.kh.common.PageVo;

@WebServlet(urlPatterns = "/board/list")
public class BoardListController extends HttpServlet{
	
	//게시글 목록 화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//----------페이징 처리-----------
		int listCount;		//현재 총 게시글 갯수
		int currentPage;	//현재 페이지(사용자요청)
		int pageLimit;		//페이지 하단에 보여질 페이지버튼의 최대 갯수
		int boardLimit;		//한 페이지 내 보여질 게시글 최대 갯수
		// 위 4개 이용해서 아래 3개 값 구하기
		int maxPage;		//가장 마지막 페이지
		int startPage;		//페이징바의 시작
		int endPage;		//페이징바의 끝
		
		//1. listCount 값 구하기
		listCount = new BoardService().getCount();
		
		//2. currentPage 값 구하기
		currentPage = Integer.parseInt(req.getParameter("p"));
		
		//3. pageLimit
		pageLimit = 10;
		
		//4. boardLimit
		boardLimit = 10;
		
		//5. maxPage (총페이지수)
		//listCount(현재 게시글 갯수), boardLimit(한 페이지 내 게시글 최대 갯수)
		//13 -> 2p / 20 -> 2p / 21 -> 3p
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		//6. startPage 
		//pageLimit(페이지버튼 최대 갯수), currentPage(현재페이지)
		//1, 11, 21, 31
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		//7. endPage
		//10, 20, 30, 40
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		//vo에 페이지 관련 변수 담기
		PageVo pageVo = new PageVo();
		pageVo.setListCount(listCount);
		pageVo.setCurrentPage(currentPage);
		pageVo.setPageLimit(pageLimit);
		pageVo.setBoardLimit(boardLimit);
		pageVo.setMaxPage(maxPage);
		pageVo.setStartPage(startPage);
		pageVo.setEndPage(endPage);
		
		//게시글 관련 데이터 준비
		List<BoardVo> boardVoList = new BoardService().selectList(pageVo);
		
		//준비한 데이터 담기
		req.setAttribute("pv", pageVo);
		req.setAttribute("list", boardVoList);
		
		//화면 보여주기
		req.getRequestDispatcher("/views/board/boardList.jsp").forward(req, resp);
	}
	
	
}
