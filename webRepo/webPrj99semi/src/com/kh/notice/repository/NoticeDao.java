package com.kh.notice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;
import com.kh.notice.vo.NoticeVo;

public class NoticeDao {
	
	//공지사항 목록 조회
	public ArrayList<NoticeVo> selectList(Connection conn) {
		
		String sql = "SELECT N.NO, N.TITLE, N.CONTENT, N.CNT, TO_CHAR(N.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLL_DATE, N.STATUS, M.NAME AS WRITER FROM NOTICE N JOIN MEMBER M ON N.WRITER = M.NO WHERE N.STATUS = 'N' ORDER BY N.NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<NoticeVo> voList = new ArrayList<NoticeVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String cnt = rs.getString("CNT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String status = rs.getString("STATUS");
				
				NoticeVo vo = new NoticeVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.setEnrollDate(enrollDate);
				vo.setStatus(status);
				
				voList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return voList;
	}//method

	//공지사항 작성
	public int insertNotice(Connection conn, NoticeVo vo) {
		
		String sql = "INSERT INTO NOTICE(NO, TITLE, CONTENT, WRITER) VALUES(SEQ_NOTICE_NO.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	//공지사항 조회수 증가
	public int increaseNotice(Connection conn, String num) {
		
		String sql = "UPDATE NOTICE SET CNT = CNT+1 WHERE NO = ? AND STATUS = 'N'";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	//공지사항 상세조회
	public NoticeVo selectOne(Connection conn, String num) {
		
		NoticeVo vo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT N.NO, N.TITLE, N.CONTENT, M.NAME AS WRITER, N.CNT, N.ENROLL_DATE, N.STATUS FROM NOTICE N JOIN MEMBER M ON N.WRITER = M.NO WHERE N.NO = ? AND N.STATUS = 'N'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String cnt = rs.getString("CNT");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				vo = new NoticeVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.setEnrollDate(enrollDate);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return vo;
	}
	
	//공지사항 삭제
	public int delete(Connection conn, String num) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE NOTICE SET STATUS='Y' WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		 
	}

	//공지사항 수정
	public int edit(Connection conn, NoticeVo vo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE NOTICE SET TITLE = ?, CONTENT = ? WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}//class
