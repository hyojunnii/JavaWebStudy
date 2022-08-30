package com.kh.member.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.common.SqlTemplate.*;

import com.kh.member.dao.MemberDao;
import com.kh.member.vo.MemberVo;

public class MemberService {
	
	private MemberDao dao = new MemberDao();

	//회원가입
	public int insert(MemberVo vo) {
		
		SqlSession ss = getSqlSession();
		
		int result = dao.insert(ss, vo);
		
		if(result == 1) {
			ss.commit();
		}
		return result  ;
	}

	//로그인
	public MemberVo login(MemberVo vo) {
		
		SqlSession ss = getSqlSession();
		
		MemberVo loginMember = dao.login(ss, vo);
		
		return loginMember;
	}

}
