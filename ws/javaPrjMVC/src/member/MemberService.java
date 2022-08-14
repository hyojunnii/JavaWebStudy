package member;

import java.sql.Connection;

import util.JdbcTemplate;

public class MemberService {
	
	//1. Ŀ�ؼ�
	private Connection conn = JdbcTemplate.getConnection();
	
	//ȸ������ ���� ����
	public int join(MemberVo vo) {
		
		//��й�ȣ ��ȿ�� (���� 4 �̻�����)
		if(vo.getPwd().length() < 4) {
			// ȸ������ ����
			return -1;
		}
		
		//���̵� �ߺ� �˻�
		int dupResult = new MemberDao().checkDup(conn, vo.getId());
		if(dupResult > 0) {
			return -2;
		}
		
		//���̵� ��ȿ�� �˻�
		if("admin".equals(vo.getId())) {
			// ȸ������ ����
			return -2;
		}
		
		//��� (== DB�� insert)
		int result = new MemberDao().join(conn, vo);
	
		//����� ���� ���� ó��
		if(result == 1) {
			//Ŀ��
			JdbcTemplate.commit(conn);
			System.out.println("Ŀ�� �Ϸ�");
		} else {
			//�ѹ�
			JdbcTemplate.rollback(conn);
			System.out.println("�ѹ� �Ϸ�");
		}
		return result;
	}

}
