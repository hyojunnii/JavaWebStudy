package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mybatis.common.SqlTemplate.*;

import com.kh.mybatis.common.EncryptorInter;
import com.kh.mybatis.common.MyEncryptor;
import com.kh.mybatis.common.SecondEncryptor;
import com.kh.mybatis.member.dao.MemberDao;
import com.kh.mybatis.member.vo.MemberVo;

public class MemberService {
	
	/*
	 * public MemberService() { myEnc = x; }
	 */
	
	private MemberDao dao = new MemberDao();
	//private EncryptorInter myEnc;
	private final EncryptorInter myEnc = new MyEncryptor();

	//회원가입
	public int join(MemberVo vo) {
		//암호화
		String newPwd = myEnc.enc(vo.getPwd());
		vo.setPwd(newPwd);
		
		SqlSession ss = getSqlSession();
		
		int result = dao.join(ss, vo);
		
		if(result == 1) {
			ss.commit();
		}
		
		ss.close();
		
		return result;
	}
	
	//로그인
	public MemberVo login(MemberVo vo) {
		//암호화
		String newPwd = myEnc.enc(vo.getPwd());
		vo.setPwd(newPwd);
		
		SqlSession ss = getSqlSession();
		
		MemberVo loginMember = dao.login(ss, vo);
		
		ss.close();
		
		return loginMember;
	}

}//class
