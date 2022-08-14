package member;

import java.sql.Connection;

import Util.JDBC;

public class MemberService {
	
	private Connection conn = JDBC.getConnection();

	public int join(MemberVo vo) {

		//��й�ȣ ��ȿ��
		if(vo.getPwd().length() < 4) {
			//����
			return -1;
		}
		
		//���̵� �ߺ� : MemberDao
		int dupResult = new MemberDao().checkDup(conn, vo.getId());
		if(dupResult > 0) {
			//����
			return -2;
		}
		
		//���̵� ��ȿ��
		if("admin".equals(vo.getId())) {
			//����
			return -2;
		}
		
		//�� ����Ǹ� insert : MemberDao
		int result = new MemberDao().join(conn, vo);
		
		//���� ó�� : Ŀ��, �ѹ�
		if(result == 1) {
			//commit
			JDBC.commit(conn);
			System.out.println("Ŀ��");
		} else {
			//rollback
			JDBC.rollback(conn);
			System.out.println("�ѹ�");
		}
		
		return result;
		
	}//join

}//class
