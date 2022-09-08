package com.kh.app02.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app02.member.dao.MemberDao;
import com.kh.app02.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao dao;
	
	@Override
	public int join(MemberVo vo) {
		//커넥션
		int result = dao.join(vo);
		return result;
	}

	@Override
	public MemberVo login(MemberVo vo) {
		//커넥션
		MemberVo loginMember = dao.login(vo);
		return loginMember;
	}

	@Override
	public MemberVo selectOneByNo(int memberNo) {
		return null;
	}

	@Override
	public int edit(MemberVo vo) {
		return 0;
	}

	@Override
	public int quit(int memberNo) {
		return 0;
	}

}
