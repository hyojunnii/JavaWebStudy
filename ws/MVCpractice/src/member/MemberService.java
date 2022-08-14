package member;

import java.sql.Connection;

import Util.JDBC;

public class MemberService {
	
	private Connection conn = JDBC.getConnection();

	public int join(MemberVo vo) {

		//비밀번호 유효성
		if(vo.getPwd().length() < 4) {
			//실패
			return -1;
		}
		
		//아이디 중복 : MemberDao
		int dupResult = new MemberDao().checkDup(conn, vo.getId());
		if(dupResult > 0) {
			//실패
			return -2;
		}
		
		//아이디 유효성
		if("admin".equals(vo.getId())) {
			//실패
			return -2;
		}
		
		//다 통과되면 insert : MemberDao
		int result = new MemberDao().join(conn, vo);
		
		//로직 처리 : 커밋, 롤백
		if(result == 1) {
			//commit
			JDBC.commit(conn);
			System.out.println("커밋");
		} else {
			//rollback
			JDBC.rollback(conn);
			System.out.println("롤백");
		}
		
		return result;
		
	}//join

}//class
