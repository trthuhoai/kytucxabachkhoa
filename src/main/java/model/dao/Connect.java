package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
public class Connect {
	
	
	
	private static String host="node3168-trthuhoai.nl-dc1.jbasic.cloud";

	
	
//	private static String DB_URL = "jdbc:mysql://"+host+"/kytucxa";
	
	private static String DB_URL = "jdbc:mysql://localhost:3306/kytucxa";
	private static String USER_NAME = "root";
//	private static String PASSWORD = "NHMldk29281";
	private static String PASSWORD = "";
	public static Connection getConnection(String dbURL, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
	public Connection getConn() {
		Connection conn1=null;
		try {
			conn1 = Connect.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return conn1;

	}
}
