package com.kh.mybatis.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.vo.MemberVo;

public class MemberDao {

	public int join(SqlSession ss, MemberVo vo) {
		return ss.insert("memberMapper.join", vo);
	}

	public MemberVo login(SqlSession ss, MemberVo vo) {
		return ss.selectOne("memberMapper.login", vo);
	}

}
