package com.kh.member.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.kh.member.repository.MemberDao;
import com.kh.member.vo.MemberVo;

public class MemberService {
	
	private final MemberDao dao = new MemberDao();
	
	//회원가입
	public int join(MemberVo vo) {
		
		if("admin".equals(vo.getId())) {
			return -1;
		}
		
		if(vo.getId().length() < 4) {
			return -2;
		}
		
		if(vo.getPwd().length() < 4) {
			return -3;
		}
		
		if(vo.getPwd().equals(vo.getPwd2()) == false) {
			return -4;
		}
		
		if(vo.getName().length() < 2) {
			return -5;
		}
		
		int result = 0;
		Connection conn = getConnection();
		
		result = dao.join(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	//로그인
	public MemberVo login(MemberVo vo) {
		
		Connection conn = getConnection();
		MemberVo loginMember = null;
		
		loginMember = dao.login(conn, vo);
		
		close(conn);
		
		return loginMember;
	}

	public int edit(MemberVo vo) {
		
		int result = 0;
		Connection conn = getConnection();
		
		result = dao.edit(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int quit(String id, String name) {
		int result = 0;
		Connection conn = getConnection();
		
		result = dao.quit(conn, id, name);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
