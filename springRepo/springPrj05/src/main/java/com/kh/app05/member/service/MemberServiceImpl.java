package com.kh.app05.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app05.member.dao.MemberDaoImpl;
import com.kh.app05.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDaoImpl dao;
	
	@Override
	public int join(MemberVo vo) {
		return dao.join(sst, vo);
	}

	@Override
	public MemberVo login(MemberVo vo) {
		return dao.login(sst, vo);
	}

	@Override
	public MemberVo edit(MemberVo vo) {
		int result = dao.edit(sst, vo);
		if(result == 1) {
			return dao.selectOneById(sst, vo.getId());
		} else {
			return null;
		}
	}

	@Override
	public int quit(int memberNo) {
		return 0;
	}

}
