package com.khj.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.khj.db.OracleDB;
import com.khj.member.Member;
import com.khj.util.MyUtil;

public class Board {
	
	// �Խñ� �ۼ�
	public void write() {
		
		//�ۼ��� != �α����� ����
		if(Member.loginUserNo == 0) {
			System.out.println("�α��� �� ������ ���� �� �� �ֽ��ϴ�.");
			return;
		}
		
		//�ȳ� ���� ���
		//�Է� �ޱ� (����, ����)
		System.out.println("===== �Խñ� �ۼ� =====");
		System.out.print("���� : ");
		String title = MyUtil.sc.nextLine();
		System.out.print("���� : ");
		String content = MyUtil.sc.nextLine();
		
		//��� ����
		//���� ���
		Connection conn = OracleDB.getOracleConnection();
		//INSERT ���� ������
		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER_NO, REGISTER_DATE, DELETE_YN)"
				+ "VALUES(BORAD_NO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 'N')";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Member.loginUserNo);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("�Խñ� ��� ���� !");
			} else {
				System.out.println("�Խñ� ��� ���� ..");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDB.close(conn);
			OracleDB.close(pstmt);
		}
				
	}

	// �Խñ� ��� ��ȸ
	public void showList() {
		System.out.println("===== �Խñ� ��� ��ȸ =====");
	
		//��� �Խñ� ��ȸ�ؼ� �����ֱ�
		
		//1. Ŀ�ؼ� �غ�
		Connection conn = OracleDB.getOracleConnection();
		
		//2. �����ۼ�
		String sql = "SELECT * FROM BOARD WHERE DELETE_YN = 'N' ORDER BY REGISTER_DATE DESC";
		
		//3. pstmt ���� (sql ����)
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//4. pstmt ����ǥ ä���
			//5. pstmt ���� (executeQuery)
			//6. ��� ��� (resultSet)
			ResultSet rs = pstmt.executeQuery();
			
			//7. ����� ���� ���� �ۼ�
			System.out.print("�۹�ȣ");
			System.out.print(" | ");
			System.out.print("�Խñ� ����");
			System.out.print(" | ");
			System.out.print("�ۼ��� ��ȣ");
			System.out.print(" | ");
			System.out.print("�Խñ� �ۼ���");
			System.out.println("\n--------------------------------------------------");
			
			while(rs.next()) {
				int no = rs.getInt("NO"); //�Խñ� ��ȣ
				String title = rs.getString("TITLE"); //�� ����
				int writerNo = rs.getInt("WRITER_NO"); //�ۼ��� ȸ�� ��ȣ
				Timestamp regDate = rs.getTimestamp("REGISTER_DATE");
				
				System.out.print(no);
				System.out.print(" | ");
				System.out.print(title);
				System.out.print(" | ");
				System.out.print(writerNo);
				System.out.print(" | ");
				System.out.print(regDate);
				System.out.print(" | ");
				System.out.println();
			
			}
			
//			while(rs.next()) {
//				for (int i = 0; i < array.length; i++) {
//					
//				}
//				System.out.println();
//				System.out.print(rs.getString(1) + " ");
//				System.out.print(rs.getString(2) + " ");
//				System.out.print(rs.getString(3) + " ");
//				System.out.print(rs.getString(4) + " ");
//				System.out.println(rs.getString(5) + " ");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// finally ������ �ڿ� ����
		
		showBoardDetail();
	}
	
	// �Խñ� �� ��ȸ
	public void showBoardDetail() {
		
		// �Խñ� ��ȣ (no) �ʿ���
		// ��¹� �߰�
		System.out.print("��ȸ�� �Խñ� ��ȣ �Է� : ");
		int no = MyUtil.scInt();
		
		
		Connection conn = OracleDB.getOracleConnection();
		
		String sql = "SELECT * FROM BOARD WHERE NO = ? AND DELETE_YN = 'N'";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				
				System.out.println("���� : " + title);
				System.out.println("���� : " + content);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ڿ��ݳ�
		}
	}
	
}//class
