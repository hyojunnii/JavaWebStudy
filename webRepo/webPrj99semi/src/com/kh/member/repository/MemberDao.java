package com.kh.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.vo.MemberVo;

public class MemberDao {

	//회원가입
	public int join(MemberVo vo, Connection conn) throws Exception {
		//insert
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//커넥션 준비
			
			//SQL 준비
			String sql = "INSERT INTO MEMBER(NO, ID, PWD, NAME, PHONE, EMAIL, ADDR, INTEREST) VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			
			//SQL 객체에 담고, sql 완성하기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getAddr());
			pstmt.setString(7, vo.getInterest());
			
			//실행 및 결과받기
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			//자원반납
			close(pstmt);
		}
		
		return result;
	}
	
	//로그인
	public MemberVo login(MemberVo vo, Connection conn) throws Exception{
		//Connection
		
		MemberVo loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//SQL
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'N'";
		
		try {
			//SQL 객체 담기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			//실행 및 결과저장
			rs = pstmt.executeQuery();
			
			//rs 객체로 만들기
			if(rs.next()) {
				int no = rs.getInt("NO");
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String addr = rs.getString("ADDR");
				String interest = rs.getString("INTEREST");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				
				loginMember = new MemberVo();
				loginMember.setNo(no);
				loginMember.setId(id);
				loginMember.setName(name);
				loginMember.setPhone(phone);
				loginMember.setEmail(email);
				loginMember.setAddr(addr);
				loginMember.setInterest(interest);
				loginMember.setEnrollDate(enrollDate);
				loginMember.setModifyDate(modifyDate);
			}
		} finally {
			//자원반납
			close(pstmt);
			close(rs);
		}
		
		//객체 리턴
		return loginMember;
	}

	//회원정보변경
	public int edit(Connection conn, MemberVo vo) throws Exception {
		// SQL실행 (전달 객체로)
		// DML쿼리 -> 추가작업 X
		
		String sql = "UPDATE MEMBER SET NAME = ?, EMAIL = ?, PHONE = ?, ADDR = ?, INTEREST = ?, MODIFY_DATE = SYSDATE WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getInterest());
			pstmt.setInt(6, vo.getNo());
			
			result = pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(pstmt);
		}
		
		// SQL실행결과 리턴
		return result;
	}

	//회원정보조회 (회원번호)
	public MemberVo selectOneByNo(Connection conn, int num) throws Exception {
		
		String sql = "SELECT * FROM MEMBER WHERE NO = ? AND STATUS = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("NO");
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String addr = rs.getString("ADDR");
				String interest = rs.getString("INTEREST");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				
				vo = new MemberVo();
				vo.setNo(no);
				vo.setId(id);
				vo.setName(name);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setAddr(addr);
				vo.setInterest(interest);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return vo;
	}

	
	//회원탈퇴
	public static int quit(Connection conn, MemberVo vo) throws Exception {
		
		String sql = "UPDATE MEMBER SET STATUS = 'Y', MODIFY_DATE = SYSDATE WHERE NO = ?";
	
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//비밀번호 변경
	public int changePwd(Connection conn, String memberId, String memberPwd, String memberPwdNew) throws Exception {
		
		String sql = "UPDATE MEMBER SET PWD = ? WHERE ID = ? AND PWD = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberPwdNew);
			pstmt.setString(2, memberId);
			pstmt.setString(3, memberPwd);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}//class
