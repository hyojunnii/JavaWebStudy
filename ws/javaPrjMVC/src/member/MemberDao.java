package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JdbcTemplate;

public class MemberDao {

	//회원가입 DB에 insert 처리
	public int join(Connection conn, MemberVo vo) {
		//1. 커넥션 (파라미터로 받음)
		
		//2. SQL
		String sql = "INSERT INTO MEMBER"
				+ "(NO, ID, PWD, NICK, PHONE, GENDER, ENROLL_DATE)"
				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, ?,?,?,?,?,SYSDATE)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		//3. PSTMT
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getGender());
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}//join

	public int checkDup(Connection conn, String id) {
		
		//커넥션 얻기 (파라미터)
		
		//SQL준비
		String sql = "SELECT COUNT(NO) FROM MEMBER WHERE ID = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("COUNT(NO)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(rs);
		}
		
		//실행 및 결과 얻기
		return result;
	}

}//class
