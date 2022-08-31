package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mybatis.common.SqlTemplate.*;
import com.kh.mybatis.member.dao.MemberDao;
import com.kh.mybatis.member.vo.MemberVo;

public class MemberService {
	
	private final MemberDao dao = new MemberDao();

	//회원가입
	public int join(MemberVo vo) {
		
		SqlSession ss = getSqlSession();
		
		int result = dao.join(ss, vo);
		
		ss.commit();
		
		ss.close();
		
		return result;
	}

	//로그인
	public MemberVo login(MemberVo vo) {
		SqlSession ss = getSqlSession();
		
		MemberVo loginMember = dao.login(ss, vo);
		
		ss.close();
		
		return loginMember;
	}

}//class
