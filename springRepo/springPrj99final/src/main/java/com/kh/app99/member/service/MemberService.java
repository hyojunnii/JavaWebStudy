package com.kh.app99.member.service;

import com.kh.app99.member.vo.MemberVo;

public interface MemberService {
	
	//로그인
	MemberVo login(MemberVo vo);
	
	//회원가입
	int insertMember(MemberVo vo);

	//회원정보수정
	MemberVo edit(MemberVo vo);
	
	//정보조회
	
	//회원탈퇴

}
