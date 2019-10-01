//package kopo02.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DBSingleton {
//	try {
//	private static DBSingleton DBs = new DBSingleton();}
//	catch(Exception e) {
//		
//	}
//	private static Connection conn;
//	private static Statement stmt;
//	
//	public static Connection getConn() {
//		return conn;
//	}
//
//	public static void setConn(Connection conn) {
//		DBSingleton.conn = conn;
//	}
//
//	public static Statement getStmt() {
//		return stmt;
//	}
//
//	public static void setStmt(Statement stmt) {
//		DBSingleton.stmt = stmt;
//	}
//
//	
//	
//	
//	
//	private DBSingleton() throws ClassNotFoundException, SQLException {
//		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//	
//		String address = "jdbc:mysql://192.168.56.102:3306/kopoctc";
//		String id = "root";
//		String pwd = "rlarldbs21";
//		conn = DriverManager.getConnection(address,id,pwd);
//		stmt = conn.createStatement();
//		
//	}
//	
//	
//	
//	public static DBSingleton getAccess() {
//		if(DBs==null) {
//			DBs = new DBSingleton();
//		}
//		
//		return DBs;
//		
//	}
//
//	public static void getClose() throws SQLException {
//		// TODO Auto-generated method stub
//		conn.close();
//		stmt.close();
//
//		
//	}
//	
//	
//}
