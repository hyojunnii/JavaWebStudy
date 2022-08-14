package com.kh.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.board.vo.BoardVo;
import static com.kh.common.JDBCTemplate.*;

public class BoardDao {

	public List<BoardVo> showList(Connection conn) {
		
		String sql = "SELECT NO, CATEGORY, TITLE, CONTENT, WRITER, CNT, E_DATE, STATUS FROM BOARD WHERE STATUS='Y' ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("NO");
				String category = rs.getString("CATEGORY");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String cnt = rs.getString("CNT");
				String eDate = rs.getString("E_DATE");
				
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.seteDate(eDate);
				
				boardList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardList;
	}

	public int insert(Connection conn, BoardVo bvo) {
		
		String sql = "INSERT INTO BOARD(NO, CATEGORY, TITLE, CONTENT, WRITER) VALUES(SEQ_BOARD_NO.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getCategory());
			pstmt.setString(2, bvo.getTitle());
			pstmt.setString(3, bvo.getContent());
			pstmt.setString(4, bvo.getWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<BoardVo> myList(Connection conn, String writer2) {
		String sql = "SELECT NO, CATEGORY, TITLE, CONTENT, WRITER, CNT, E_DATE, STATUS FROM BOARD WHERE STATUS='Y' AND WRITER = ? ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer2);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("NO");
				String category = rs.getString("CATEGORY");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String cnt = rs.getString("CNT");
				String eDate = rs.getString("E_DATE");
				
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.seteDate(eDate);
				
				boardList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardList;
	}

}
