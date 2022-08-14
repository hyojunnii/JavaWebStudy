package com.khj.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.khj.db.OracleDB;
import com.khj.util.MyUtil;

public class Member {
	
	public static int loginUserNo;
	
	//로그인
	public boolean login() {
		System.out.println("=====로그인=====");
		System.out.print("아이디 : ");
		String id = MyUtil.sc.nextLine();
		System.out.print("패스워드 : ");
		String pwd = MyUtil.sc.nextLine();
		
		//디비 연결 얻기
		Connection conn = OracleDB.getOracleConnection();
		//해당 아이디에 맞는 패스워드 디비에서 조회하기
		String sql = "SELECT NO, PWD FROM MEMBER WHERE UPPER(ID) = UPPER(?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbPwd = rs.getString("PWD");
				int no = rs.getInt("NO");
				if(dbPwd.equalsIgnoreCase(pwd)) {
					//로그인 성공
					loginUserNo = no;
					System.out.println("로그인 성공!");
					return true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 예외 발생!");
		} finally {
			OracleDB.close(conn);
			OracleDB.close(pstmt);
			OracleDB.close(rs);
		}
		//디비에서 조회한 패스워드가 일치하는지 확인
		
		System.out.println("로그인 실패 ..");
		return false;
	}
	
	//회원가입
	/*
	 * 아이디, 비번, 닉네임
	 */
	public boolean join() {
		System.out.println("==== 회원가입=====");
		System.out.print("아이디 : ");
		String id = MyUtil.sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = MyUtil.sc.nextLine();
		System.out.print("닉네임 : ");
		String nick = MyUtil.sc.nextLine();
			
		//비번 유효성 검사
		if(pwd.length() < 4) {
			//회원가입 실패
			System.out.println("비번은 4글자 이상");
			return false;
			
		}
		new OracleDB();
		//아이디 중복 검사
		//1.디비 접속
		Connection conn = OracleDB.getOracleConnection();
		//2.일치 아이디 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt2 = null;
		try {
			String sql = "SELECT ID FROM MEMBER WHERE ID = ?";
//			Statement stmtDup = conn.createStatement();
//			ResultSet rs = stmtDup.executeQuery(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 회원가입 실패
				System.out.println("아이디 중복!");
				return false;
			}
			
			//디비에 데이터 저장
			//3-1 성공 ? 디비 저장
			String sqlInsert 
				= "INSERT INTO MEMBER(NO,ID,PWD,NICK) "
						+ "VALUES(MEMBER_NO_SEQ.NEXTVAL,?,?,?)";
//			Statement stmtInsert = conn.createStatement();
//			int result = stmtInsert.executeUpdate(sqlInsert);
			pstmt2 = conn.prepareStatement(sqlInsert);
			pstmt2.setString(1, id);
			pstmt2.setString(2, pwd);
			pstmt2.setString(3, nick);
			int result = pstmt2.executeUpdate();
			
			if(result == 1) {
				System.out.println("회원 가입 성공!");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDB.close(conn);
			OracleDB.close(pstmt);
			OracleDB.close(rs);
			OracleDB.close(pstmt2);
		}
		
		//db 저장
		return false;
	}
}
