package com.kh.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
   
   public static Connection getConnection() {
      Connection conn = null;
      try {
         //프로퍼티 객체에 load 해오면 key 값으로 꺼낼 수 잇음
//         Properties prop = new Properties();
//         String filePath = JDBCTemplate.class.getResource("/db/setup/data.properties").getPath();
//         prop.load(new FileInputStream(filePath));
//         
//         String driver = prop.getProperty("driver");
//         String url = prop.getProperty("url");
//         String id = prop.getProperty("dbId");
//         String pwd = prop.getProperty("dbPwd");
    	  
    	  String driver = "oracle.jdbc.driver.OracleDriver";
    	  String url = "jdbc:oracle:thin:@localhost:1521:xe";
    	  String id = "C##MYBATIS";
    	  String pwd = "MYBATIS";
         
         Class.forName(driver);
         
         conn = DriverManager.getConnection(url, id, pwd);
         conn.setAutoCommit(false);
      }catch(Exception e) {
         e.printStackTrace();
      }
      return conn;
   }
   
   public static void commit(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) conn.commit();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void rollback(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) conn.rollback();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void close(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void close(ResultSet rs) {
      try {
         if(rs != null && !rs.isClosed()) rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void close(Statement stmt) {
      try {
         if(stmt != null && !stmt.isClosed()) stmt.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}//class
