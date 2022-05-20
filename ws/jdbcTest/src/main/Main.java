package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		//연결 얻기
		/*
		 * 0. 드라이버 준비 - ojdbc.jar파일
		 * 1. 연결정보 준비 - id, pwd, ip, port, sid
		 * 2. 드라이버 등록 - Class.forName(~~~)
		 * 3. DriverManager를 이용해서, connection 얻기
		 */
		
		System.out.println("jbdc test ~~~ ");
		
		// DB와 연결 - id, pwd, ip, port, sid
		String id = "C##KH";
		String pwd = "KH";
		String ip = "DESKTOP-L3RA90V";
		String port = "1521";
		String sid = "xe";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// OracleDriver 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 접속(Connection) 얻기 (Driver 사용하기)
			String url = "jdbc:oracle:thin:@DESKTOP-L3RA90V:1521:xe";
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println(conn);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EMP");
			
			System.out.println(rs);
			
			while(rs.next()) {
				// rs.next() : 커서 아래로 이동, 데이터 존재시 true 반환
				int empNo = rs.getInt("EMPNO");
				String ename = rs.getString("ENAME");
					
				System.out.println(empNo + " / " + ename);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("클래스 못찾음..");
		} finally {
			//자원 정리
			try {conn.close();} catch (SQLException e) {}
			try {stmt.close();} catch (SQLException e) {}
			try {rs.close();} catch (SQLException e) {}
		}
	}

}//class
