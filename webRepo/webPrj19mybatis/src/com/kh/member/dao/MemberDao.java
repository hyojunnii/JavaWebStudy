package com.kh.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.vo.MemberVo;

public class MemberDao {

	//회원가입
	public int insert(SqlSession ss, MemberVo vo) {
		return ss.insert("memberMapper.join", vo);
	}

	//로그인
	public MemberVo login(SqlSession ss, MemberVo vo) {
		return ss.selectOne("memberMapper.login", vo);
	}
	
}//class
