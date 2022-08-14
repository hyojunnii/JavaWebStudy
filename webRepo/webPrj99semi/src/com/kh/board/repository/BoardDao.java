package com.kh.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.attachment.vo.AttachmentVo;
import com.kh.board.vo.BoardVo;
import com.kh.category.vo.CategoryVo;
import com.kh.common.PageVo;

import static com.kh.common.JDBCTemplate.*;

public class BoardDao {

	//게시글 총 갯수 조회
	public int getCount(Connection conn) {
		
		String sql = "SELECT COUNT(NO) AS COUNT FROM BOARD WHERE STATUS = 'N' AND TYPE = 1";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	//게시글 목록 조회(현재 페이지 기준)
	public List<BoardVo> selectList(Connection conn, PageVo pageVo) {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.NO , B.TITLE , B.CONTENT , B.CNT , B.ENROLL_DATE , M.ID AS WRITER , C.CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO JOIN CATEGORY C USING(CATEGORY_NO) WHERE B.TYPE = 1 AND B.STATUS = 'N' ORDER BY B.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String cnt = rs.getString("CNT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String writer = rs.getString("WRITER");
				String categoryName = rs.getString("CATEGORY_NAME");
				
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setCnt(cnt);
				vo.setEnrollDate(enrollDate);
				vo.setWriter(writer);
				vo.setCategory(categoryName);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	//카테고리 정보(리스트) 조회
	public List<CategoryVo> selectCategoryList(Connection conn) {
		
		String sql = "SELECT CATEGORY_NO, CATEGORY_NAME FROM CATEGORY";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new CategoryVo(
						rs.getString("CATEGORY_NO")
						, rs.getString("CATEGORY_NAME")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	//게시글 작성 (board테이블)
	public int insertBoard(Connection conn, BoardVo bvo) {
		
		String sql = "INSERT INTO BOARD(NO, TYPE, CATEGORY_NO, TITLE, CONTENT, WRITER) VALUES(SEQ_BOARD_NO.NEXTVAL, 1, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getCategory());
			pstmt.setString(2, bvo.getTitle());
			pstmt.setString(3, bvo.getContent());
			pstmt.setString(4, bvo.getWriter());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//게시글 작성 (attachment테이블)
	public int insertAttachment(Connection conn, AttachmentVo avo) {
		
		String sql = "INSERT INTO ATTACHMENT(NO, REF_BNO, ORIGIN_NAME, CHANGE_NAME, FILE_PATH) VALUES(SEQ_ATTACHMENT_NO.NEXTVAL, SEQ_BOARD_NO.CURRVAL, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, avo.getOriginName());
			pstmt.setString(2, avo.getChangeName());
			pstmt.setString(3, avo.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
