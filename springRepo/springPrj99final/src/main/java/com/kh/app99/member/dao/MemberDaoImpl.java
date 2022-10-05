package com.kh.app99.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app99.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	//회원가입
	@Override
	public int insertOne(SqlSessionTemplate sst, MemberVo vo) {
		return sst.insert("memberMapper.join", vo);
	}

	//로그인
	@Override
	public MemberVo selectOneById(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("memberMapper.selectOneById", vo);
	}

	//회원정보수정
	@Override
	public int updateOne(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("memberMapper.updateOne", vo);
	}

	//회원조회
	@Override
	public MemberVo selectOneByNo(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("memberMapper.selectOneByNo", vo.getNo());
	}

	//아이디 중복확인
	@Override
	public int selectCountId(SqlSessionTemplate sst, String memberId) {
		return sst.selectOne("memberMapper.selectCountId", memberId);
	}

	
}
