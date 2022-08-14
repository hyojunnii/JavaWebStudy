package com.khj.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.khj.db.OracleDB;
import com.khj.util.MyUtil;

public class Member {
	
	public static int loginUserNo;
	
	//�α���
	public boolean login() {
		System.out.println("=====�α���=====");
		System.out.print("���̵� : ");
		String id = MyUtil.sc.nextLine();
		System.out.print("�н����� : ");
		String pwd = MyUtil.sc.nextLine();
		
		//��� ���� ���
		Connection conn = OracleDB.getOracleConnection();
		//�ش� ���̵� �´� �н����� ��񿡼� ��ȸ�ϱ�
		String sql = "SELECT NO, PWD FROM MEMBER WHERE UPPER(ID) = UPPER(?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbPwd = rs.getString("PWD");
				int no = rs.getInt("NO");
				if(dbPwd.equalsIgnoreCase(pwd)) {
					//�α��� ����
					loginUserNo = no;
					System.out.println("�α��� ����!");
					return true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("SQL ���� �߻�!");
		} finally {
			OracleDB.close(conn);
			OracleDB.close(pstmt);
			OracleDB.close(rs);
		}
		//��񿡼� ��ȸ�� �н����尡 ��ġ�ϴ��� Ȯ��
		
		System.out.println("�α��� ���� ..");
		return false;
	}
	
	//ȸ������
	/*
	 * ���̵�, ���, �г���
	 */
	public boolean join() {
		System.out.println("==== ȸ������=====");
		System.out.print("���̵� : ");
		String id = MyUtil.sc.nextLine();
		System.out.print("��й�ȣ : ");
		String pwd = MyUtil.sc.nextLine();
		System.out.print("�г��� : ");
		String nick = MyUtil.sc.nextLine();
			
		//��� ��ȿ�� �˻�
		if(pwd.length() < 4) {
			//ȸ������ ����
			System.out.println("����� 4���� �̻�");
			return false;
			
		}
		new OracleDB();
		//���̵� �ߺ� �˻�
		//1.��� ����
		Connection conn = OracleDB.getOracleConnection();
		//2.��ġ ���̵� ��ȸ
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt2 = null;
		try {
			String sql = "SELECT ID FROM MEMBER WHERE ID = ?";
//			Statement stmtDup = conn.createStatement();
//			ResultSet rs = stmtDup.executeQuery(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// ȸ������ ����
				System.out.println("���̵� �ߺ�!");
				return false;
			}
			
			//��� ������ ����
			//3-1 ���� ? ��� ����
			String sqlInsert 
				= "INSERT INTO MEMBER(NO,ID,PWD,NICK) "
						+ "VALUES(MEMBER_NO_SEQ.NEXTVAL,?,?,?)";
//			Statement stmtInsert = conn.createStatement();
//			int result = stmtInsert.executeUpdate(sqlInsert);
			pstmt2 = conn.prepareStatement(sqlInsert);
			pstmt2.setString(1, id);
			pstmt2.setString(2, pwd);
			pstmt2.setString(3, nick);
			int result = pstmt2.executeUpdate();
			
			if(result == 1) {
				System.out.println("ȸ�� ���� ����!");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDB.close(conn);
			OracleDB.close(pstmt);
			OracleDB.close(rs);
			OracleDB.close(pstmt2);
		}
		
		//db ����
		return false;
	}
}
