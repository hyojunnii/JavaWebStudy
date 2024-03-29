package com.kh.app99.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app99.member.dao.MemberDao;
import com.kh.app99.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{
	
	private final SqlSessionTemplate sst;
	
	private final MemberDao dao;
	
	private final PasswordEncoder pwdEnc;
	
	@Autowired
	public MemberServiceImpl(SqlSessionTemplate sst, MemberDao dao, PasswordEncoder pwdEnc) {
		this.sst = sst;
		this.dao = dao;
		this.pwdEnc = pwdEnc;
	}

	//회원가입
	@Override
	public int insertMember(MemberVo vo) {
		vo.encodePwd(pwdEnc);
		
		return dao.insertOne(sst, vo);
	}

	//로그인
	@Override
	public MemberVo login(MemberVo vo) {
		
		MemberVo dbMember = dao.selectOneById(sst, vo);
		
		if(pwdEnc.matches(vo.getPwd(),dbMember.getPwd())) {
		//if(vo.getPwd().equals(dbMember.getPwd())) {
			return dbMember;
		} else {
			return null;
		}
	}

	//회원정보수정 (update, select)
	@Override
	public MemberVo edit(MemberVo vo) {
		
		vo.encodePwd(pwdEnc);
		
		int result = dao.updateOne(sst, vo);
		
		MemberVo updatedMember = null;
		if(result == 1) {
			updatedMember = dao.selectOneByNo(sst, vo);
		}
		
		return updatedMember;
	}

	//아이디 중복확인
	@Override
	public int checkDup(String memberId) {
		return dao.selectCountId(sst, memberId);
	}

	//회원목록조회
	@Override
	public List<MemberVo> selectList() {
		return dao.selectList(sst);
	}

}//class