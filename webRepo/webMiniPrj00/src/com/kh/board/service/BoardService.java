package com.kh.board.service;

import com.kh.board.repository.BoardDao;
import com.kh.board.vo.BoardVo;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

public class BoardService {
	
	private final BoardDao dao = new BoardDao();
	
	public List<BoardVo> showlist() {
		
		Connection conn = getConnection();
		List<BoardVo> boardList = null;
		
		boardList = dao.showList(conn);
		
		close(conn);
		
		return boardList;
	}

	public int insert(BoardVo bvo) {
		
		if(bvo.getTitle().length() == 0) {
			return -1;
		}
		
		if(bvo.getContent().length() == 0) {
			return -2;
		}
		
		Connection conn = getConnection();
		int result = 0;
		
		result = dao.insert(conn, bvo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public List<BoardVo> myList(String writer) {
		Connection conn = getConnection();
		List<BoardVo> boardList = null;
		
		boardList = dao.myList(conn, writer);
		
		close(conn);
		
		return boardList;
	}

}
