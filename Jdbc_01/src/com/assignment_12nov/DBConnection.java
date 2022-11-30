package com.assignment_12nov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static final String url="jdbc:mysql://localhost:3306/wishtree";
	public static final String username="root";
	public static final String password="Sushant@9930";
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	
		
		
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection DBConnection=DriverManager.getConnection(url,username,password);
		return DBConnection;
		
	}

}
