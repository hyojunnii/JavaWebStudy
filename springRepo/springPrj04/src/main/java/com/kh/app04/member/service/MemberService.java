package com.kh.app04.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app04.member.dao.MemberDao;
import com.kh.app04.member.vo.MemberVo;

@Service
public class MemberService {

	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;

	public int join(MemberVo vo) {
		int result = dao.join(sst, vo);
		
		return result;
	}

	public MemberVo login(MemberVo vo) {
		return dao.login(sst, vo);
	}

}
