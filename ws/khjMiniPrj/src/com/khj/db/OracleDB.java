package com.khj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDB {
	
	public static Connection getOracleConnection() {
		
		//파일에다가 ip,port,url 정보 저장
		//파일에서 읽어들여서 연결
		//본인거 가지고 있고, 깃허브에 올리면 안됨(깃이그노어)
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "KH";
		
		Connection conn = null;
		
		try {
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, id, pwd);
	
		} catch (ClassNotFoundException | SQLException e) {
		System.out.println("커넥션 가져오기 실패");
	
		}

		return conn;
	
	}
	
	public static void close(Connection conn) {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void close(Statement stmt) {
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void close(ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
