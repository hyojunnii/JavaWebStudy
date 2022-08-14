package member;

import java.sql.Connection;

import util.JdbcTemplate;

public class MemberService {
	
	//1. 커넥션
	private Connection conn = JdbcTemplate.getConnection();
	
	//회원가입 서비스 로직
	public int join(MemberVo vo) {
		
		//비밀번호 유효성 (길이 4 이상인지)
		if(vo.getPwd().length() < 4) {
			// 회원가입 실패
			return -1;
		}
		
		//아이디 중복 검사
		int dupResult = new MemberDao().checkDup(conn, vo.getId());
		if(dupResult > 0) {
			return -2;
		}
		
		//아이디 유효성 검사
		if("admin".equals(vo.getId())) {
			// 회원가입 실패
			return -2;
		}
		
		//통과 (== DB에 insert)
		int result = new MemberDao().join(conn, vo);
	
		//결과에 따라 로직 처리
		if(result == 1) {
			//커밋
			JdbcTemplate.commit(conn);
			System.out.println("커밋 완료");
		} else {
			//롤백
			JdbcTemplate.rollback(conn);
			System.out.println("롤백 완료");
		}
		return result;
	}

}
