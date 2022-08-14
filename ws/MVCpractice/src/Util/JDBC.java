package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	
	//Ä¿³Ø¼Ç
	public static Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "KH";
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			conn.setAutoCommit(false);
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	//Close
	public static void close(Connection conn) {
		if(conn != null) { try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	}
	
	public static void close(Statement stmt) {
		if(stmt != null) {try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	}
	
	public static void close(ResultSet rs) {
		if(rs != null) {try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	}
	
	//Commit, Rollback
	public static void commit(Connection conn) {
		if(conn != null) {try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	}
	
	public static void rollback(Connection conn) {
		if(conn != null) {try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
	}
	
}
