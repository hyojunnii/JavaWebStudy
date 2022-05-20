package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@DESKTOP-L3RA90V:1521:xe";
			Connection conn = DriverManager.getConnection(url, "C##KH", "KH");
			System.out.println(conn);
			
		} catch (ClassNotFoundException | SQLException e) {
		}
		
	}
}
