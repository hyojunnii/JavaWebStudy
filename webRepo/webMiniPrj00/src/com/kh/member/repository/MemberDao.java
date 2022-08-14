package com.kh.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.vo.MemberVo;

public class MemberDao {

	//회원가입
	public int join(Connection conn, MemberVo vo) {
		
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NAME, NICK, EMAIL, PHONE, ADDR, COMM) VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getAddr());
			pstmt.setString(8, vo.getComment());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//로그인
	public MemberVo login(Connection conn, MemberVo vo) {
		
		String sql = "SELECT NO, ID, NAME, NICK, EMAIL, PHONE, ADDR, E_DATE, COMM FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new MemberVo();
				loginMember.setNo(rs.getInt("NO"));
				loginMember.setId(rs.getString("ID"));
				loginMember.setName(rs.getString("NAME"));
				loginMember.setNick(rs.getString("NICK"));
				loginMember.setEmail(rs.getString("EMAIL"));
				loginMember.setPhone(rs.getString("PHONE"));
				loginMember.setAddr(rs.getString("ADDR"));
				loginMember.seteDate(rs.getString("E_DATE"));
				loginMember.setComment(rs.getString("COMM"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginMember;
	}

	public int edit(Connection conn, MemberVo vo) {
		String sql = "UPDATE MEMBER SET EMAIL = ?, PHONE = ?, ADDR = ?, COMM = ? WHERE ID = ? AND NAME = ? AND STATUS = 'Y'";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getAddr());
			pstmt.setString(4, vo.getComment());
			pstmt.setString(5, vo.getId());
			pstmt.setString(6, vo.getName());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int quit(Connection conn, String id, String name) {
		String sql = "UPDATE MEMBER SET STATUS='N' WHERE ID = ? AND NAME = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
