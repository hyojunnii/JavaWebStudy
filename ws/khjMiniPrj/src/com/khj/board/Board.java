package com.khj.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.khj.db.OracleDB;
import com.khj.member.Member;
import com.khj.util.MyUtil;

public class Board {
	
	// 게시글 작성
	public void write() {
		
		//작성자 != 로그인한 유저
		if(Member.loginUserNo == 0) {
			System.out.println("로그인 한 유저만 글을 쓸 수 있습니다.");
			return;
		}
		
		//안내 문구 출력
		//입력 받기 (제목, 내용)
		System.out.println("===== 게시글 작성 =====");
		System.out.print("제목 : ");
		String title = MyUtil.sc.nextLine();
		System.out.print("내용 : ");
		String content = MyUtil.sc.nextLine();
		
		//디비에 저장
		//연결 얻기
		Connection conn = OracleDB.getOracleConnection();
		//INSERT 쿼리 날리기
		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER_NO, REGISTER_DATE, DELETE_YN)"
				+ "VALUES(BORAD_NO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 'N')";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Member.loginUserNo);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("게시글 등록 성공 !");
			} else {
				System.out.println("게시글 등록 실패 ..");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDB.close(conn);
			OracleDB.close(pstmt);
		}
				
	}

	// 게시글 목록 조회
	public void showList() {
		System.out.println("===== 게시글 목록 조회 =====");
	
		//모든 게시글 조회해서 보여주기
		
		//1. 커넥션 준비
		Connection conn = OracleDB.getOracleConnection();
		
		//2. 쿼리작성
		String sql = "SELECT * FROM BOARD WHERE DELETE_YN = 'N' ORDER BY REGISTER_DATE DESC";
		
		//3. pstmt 생성 (sql 전달)
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//4. pstmt 물음표 채우기
			//5. pstmt 실행 (executeQuery)
			//6. 결과 얻기 (resultSet)
			ResultSet rs = pstmt.executeQuery();
			
			//7. 결과에 따른 로직 작성
			System.out.print("글번호");
			System.out.print(" | ");
			System.out.print("게시글 제목");
			System.out.print(" | ");
			System.out.print("작성자 번호");
			System.out.print(" | ");
			System.out.print("게시글 작성일");
			System.out.println("\n--------------------------------------------------");
			
			while(rs.next()) {
				int no = rs.getInt("NO"); //게시글 번호
				String title = rs.getString("TITLE"); //글 제목
				int writerNo = rs.getInt("WRITER_NO"); //작성자 회원 번호
				Timestamp regDate = rs.getTimestamp("REGISTER_DATE");
				
				System.out.print(no);
				System.out.print(" | ");
				System.out.print(title);
				System.out.print(" | ");
				System.out.print(writerNo);
				System.out.print(" | ");
				System.out.print(regDate);
				System.out.print(" | ");
				System.out.println();
			
			}
			
//			while(rs.next()) {
//				for (int i = 0; i < array.length; i++) {
//					
//				}
//				System.out.println();
//				System.out.print(rs.getString(1) + " ");
//				System.out.print(rs.getString(2) + " ");
//				System.out.print(rs.getString(3) + " ");
//				System.out.print(rs.getString(4) + " ");
//				System.out.println(rs.getString(5) + " ");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// finally 블럭에서 자원 해제
		
		showBoardDetail();
	}
	
	// 게시글 상세 조회
	public void showBoardDetail() {
		
		// 게시글 번호 (no) 필요함
		// 출력문 추가
		System.out.print("조회할 게시글 번호 입력 : ");
		int no = MyUtil.scInt();
		
		
		Connection conn = OracleDB.getOracleConnection();
		
		String sql = "SELECT * FROM BOARD WHERE NO = ? AND DELETE_YN = 'N'";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				
				System.out.println("제목 : " + title);
				System.out.println("내용 : " + content);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원반납
		}
	}
	
}//class
