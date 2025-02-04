package com.tap.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


	private static final String URL="jdbc:mysql://localhost:3306/tap_foods";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	 static  Connection con;
	public static final Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
	}

}
