package com.kh.member.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.member.dao.MemberDao;

public class MemberService {

	public int join(String userId, String userPwd) {
		int result = 0;
		Connection conn = null;
		
		conn = JDBCTemplate.getConnection();
		
		result = new MemberDao().join(conn, userId, userPwd);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
