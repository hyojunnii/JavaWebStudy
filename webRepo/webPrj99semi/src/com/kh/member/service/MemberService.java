package com.kh.member.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*; //JDBCTemplate 사용
import com.kh.member.repository.MemberDao;
import com.kh.member.vo.MemberVo;

public class MemberService {
	
	//회원가입
	public int join(MemberVo vo) {
		
		//id 유효성 검사 (>=4)
		if(vo.getId().length() < 4) {
			return -1;
		}
		
		//pwd검사 (>=4)
		if(vo.getPwd().length() < 4) {
			return -2;
		}
		
		//pwd == pwd2 검사
		if(vo.getPwd().equals(vo.getPwd2()) == false) {
			return -3;
		}
		
		//아이디 중복 검사
//		MemberVo selectVo = new MemberDao().checkDup(vo);
//		if(selectVo != null) {
//			return -4;
//		}
		
		//vo를 db에 insert
		Connection conn = null;
		int result = 0;
		try {
			conn = getConnection();
			
			result = new MemberDao().join(vo, conn);
			
			if(result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

	//로그인
	public MemberVo login(MemberVo vo) {
		
		//SQL 실행 위한 Connection 준비
		Connection conn = null;
		MemberVo loginMember = null;
		try {
			conn = getConnection();
			
			loginMember = new MemberDao().login(vo, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		//SQL 실행결과 리턴
		return loginMember;
	}

	//회원정보변경
	public MemberVo edit(MemberVo vo) {
		// 비지니스 로직 (자바 || SQL)
		if(vo.getName().length() > 6) {
			System.out.println("한글 3글자, 영어 6글자");
			return null;
		}
		
		Connection conn = null;
		int result = 0;
		MemberVo updateVo = null;
		
		try {
			conn = getConnection();
			result = new MemberDao().edit(conn, vo);
			
			// 트랜잭션 처리 (커밋 || 롤백)
			if(result == 1) {
				commit(conn);
				// 다시 회원 조회
				updateVo = selectOneByNo(vo.getNo());
			} else {
				rollback(conn);
			}
		}catch(Exception e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return updateVo;
	}
	
	//회원정보조회 (회원번호)
	private MemberVo selectOneByNo(int no) {
		
		Connection conn = null;
		MemberVo vo = null;
		
		try {
			conn = getConnection();
			vo = new MemberDao().selectOneByNo(conn,no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return vo;
	}

	
	//회원탈퇴
	public int quit(MemberVo vo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = MemberDao.quit(conn, vo);
			
			if(result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

	//비밀번호변경
	public int changePwd(String memberId, String memberPwd, String memberPwdNew, String memberPwdNew2) {
		//비즈니스 로직
		if(memberPwdNew.equals(memberPwdNew2) == false) {
			System.out.println("신규 비밀번호가 일치하지 않음");
			return -1;
		}
		
		if(memberPwdNew.length() < 4) {
			System.out.println("비밀번호가 4자리 미만");
			return -2;
		}
		
		//DAO 호출
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = new MemberDao().changePwd(conn, memberId, memberPwd, memberPwdNew);
			
			if(result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}
	
}//class

