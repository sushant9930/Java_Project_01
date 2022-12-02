package com.utility;
import java.sql.*;

public class DBConnection {

	public static final String url="jdbc:mysql://localhost:3306/bookmyseat";
	public static final String username="root";
	public static final String password="Sushant@9930";
	static Connection DBConnection;
	
	
	public static Connection getConnection() {//throws ClassNotFoundException, SQLException {
	
		
		
		try {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		DBConnection=DriverManager.getConnection(url,username,password);
		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return DBConnection;
		
	}

}
